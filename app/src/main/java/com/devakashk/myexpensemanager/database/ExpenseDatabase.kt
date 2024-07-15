package com.devakashk.myexpensemanager.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.devakashk.myexpensemanager.entities.Category
import com.devakashk.myexpensemanager.entities.Expenses

@Database(entities = [Expenses::class,Category::class], version = 1,exportSchema = false)
abstract class ExpenseDatabase:RoomDatabase() {
abstract  fun getExpenseDao():ExpenseDao
}