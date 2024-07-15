package com.devakashk.myexpensemanager.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import com.devakashk.myexpensemanager.ExpenseViewModel
import com.devakashk.myexpensemanager.entities.Expenses

@Composable
fun ExpensePage(viewModel: ExpenseViewModel) {
    Column {
        val expenseAmount = remember { mutableStateOf("") }
        TextField(value = expenseAmount.value, onValueChange = {
            expenseAmount.value = it
        })

        ElevatedButton(onClick = {
            viewModel.addExpense(Expenses(0, expenseAmount.value, "100", 1, "2024-01-01"))

        }) {
            Text("Add expense")
        }

        LazyColumn {
            items(viewModel.response.value.size) { index ->
                Text(text = viewModel.response.value[index].name)
            }
        }


    }
}