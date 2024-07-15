package com.devakashk.myexpensemanager.respository

import androidx.lifecycle.LiveData
import com.devakashk.myexpensemanager.database.ExpenseDao
import com.devakashk.myexpensemanager.entities.Expenses
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.withContext
import javax.inject.Inject

class ExpenseRepository @Inject constructor(private  val expenseDao: ExpenseDao) {

      fun getAllExpenses(): Flow<List<Expenses>> =expenseDao.getAllExpenses()

    suspend fun addExpense(expenses: Expenses)= withContext(Dispatchers.IO){
        expenseDao.addExpense(expenses)
    }
}