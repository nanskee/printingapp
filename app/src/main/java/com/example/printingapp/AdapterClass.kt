package com.example.printingapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class AdapterClass(private val dataList: ArrayList<TaskData>): RecyclerView.Adapter<AdapterClass.ViewHolderClass>{

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderClass {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.)
    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: ViewHolderClass, position: Int) {
        TODO("Not yet implemented")
    }

    class ViewHolderClass(itemView: View): RecyclerView.ViewHolder(itemView){
        val rvTaskName:TextView = itemView.findViewById(R.id.taskName)
        val rvTaskDeadline:TextView  = itemView.findViewById(R.id.taskDeadline)
        val rvTaskCategory:TextView  = itemView.findViewById(R.id.taskCategory)
    }

}