package com.example.printingapp

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MyTask : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var dataList: ArrayList<TaskData>
    lateinit var taskNameList: Array<String>
    lateinit var taskGroupList: Array<String>
    lateinit var taskDeadlineList: Array<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_my_task)

        taskNameList = arrayOf(
            //masukin judul task
        )

        taskGroupList = arrayOf(
            //masukin  grup
        )

        taskDeadlineList = arrayOf(
            //masukin  deadline
        )

        recyclerView = findViewById(R.id.allTask)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.setHasFixedSize(true)

        dataList = arrayListOf<TaskData>()
        getData()

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    private fun getData(){
        for (i in taskNameList.indices){
            val dataTask = TaskData(taskNameList[i], taskGroupList[i], taskDeadlineList[i])
            dataList.add(dataTask)
        }
    }


}