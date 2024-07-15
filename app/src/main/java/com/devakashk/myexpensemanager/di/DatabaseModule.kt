package com.devakashk.myexpensemanager.di

import android.app.Application
import androidx.room.Room
import com.devakashk.myexpensemanager.database.ExpenseDao
import com.devakashk.myexpensemanager.database.ExpenseDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    @Singleton
    fun providesDatabase(application: Application):ExpenseDatabase
    {
         return Room.databaseBuilder(application, ExpenseDatabase::class.java,"ExpenseDB")
             .fallbackToDestructiveMigration()
            .build()
    }

    @Provides
    @Singleton
    fun providesExpenseDao(expenseDatabase: ExpenseDatabase): ExpenseDao
    {
        return expenseDatabase.getExpenseDao()
    }

}