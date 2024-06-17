package com.example.printingapp

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface ToDoDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertTask(taskData: TaskData): Long

    @Query("SELECT * FROM task WHERE isFinished == 0")
    suspend fun getTask():LiveData<List<TaskData>>

    @Query("UPDATE task SET isFinished = 1 WHERE id=:uid")
    suspend fun finishTask(uid: Long)

    @Query("DELETE FROM task WHERE id=:uid")
    suspend fun deleteTask(uid: Long)

}
