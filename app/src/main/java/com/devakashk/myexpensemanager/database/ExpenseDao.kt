package com.devakashk.myexpensemanager.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.devakashk.myexpensemanager.entities.Expenses
import kotlinx.coroutines.flow.Flow

@Dao
interface ExpenseDao {

    @Insert
    suspend fun addExpense(expense: Expenses)

    @Update
    suspend fun updateExpense(expense: Expenses)

    @Delete
    suspend fun deleteExpense(expense: Expenses)

    @Query("SELECT * FROM expenses")
    fun getAllExpenses(): Flow<List<Expenses>>

    @Query("SELECT * FROM expenses WHERE categoryId = :categoryId")
    fun getAllExpensesByCategory(categoryId: Int): Flow<List<Expenses>>

    @Query("SELECT * FROM expenses WHERE addedDate = :addedDate")
    fun getAllExpensesByDate(addedDate: String): Flow<List<Expenses>>

    /*@Query("SELECT * FROM expenses where  date=(:addedDate) and date(:endDate)")
    fun getAllExpensesByDateRange(addedDate: String,endDate:String): LiveData<List<Expenses>>*/


}