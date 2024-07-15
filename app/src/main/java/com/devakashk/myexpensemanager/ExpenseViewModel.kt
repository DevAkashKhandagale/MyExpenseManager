package com.devakashk.myexpensemanager

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.devakashk.myexpensemanager.entities.Expenses
import com.devakashk.myexpensemanager.respository.ExpenseRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ExpenseViewModel @Inject constructor(private val repository: ExpenseRepository) : ViewModel() {


    init {
        getAllExpenses()
    }

     val response: MutableState<List<Expenses>> = mutableStateOf(listOf())

     private fun getAllExpenses()=viewModelScope.launch {
         repository.getAllExpenses().catch {

         }.collect{
             response.value=it
         }
     }

     fun addExpense(expenses: Expenses) =viewModelScope.launch {
        repository.addExpense(expenses)
     }



}