package com.example.printingapp

// we are making list for each task

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName ="task")
data class TaskData(
    @PrimaryKey(autoGenerate = true)
    var title:String,
    var description: String,
    var category:String,
    var deadline:Long,
    var isFinished : Int = 0,
    var id:Long = 0
)

