package com.devakashk.myexpensemanager.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Expenses(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val name: String,
    val amount: String,
    val categoryId:Int,
    val addedDate:String
)