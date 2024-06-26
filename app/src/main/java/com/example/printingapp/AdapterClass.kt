package com.example.printingapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class AdapterClass(private val dataList: ArrayList<TaskData>):
    RecyclerView.Adapter<AdapterClass.ViewHolderClass>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderClass {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.task_layout,parent,false)
        return ViewHolderClass(itemView)
    }

    override fun onBindViewHolder(holder: ViewHolderClass, position: Int) {
        val currentItem = dataList[position]
        holder.rvTaskName.text = currentItem.title
        holder.rvTaskGroup.text = currentItem.category
        holder.rvTaskDeadline.text = currentItem.deadline.toString()

    }

    override fun getItemCount(): Int {
        return dataList.size
    }


    class ViewHolderClass(itemView: View): RecyclerView.ViewHolder(itemView){
        val rvTaskName:TextView = itemView.findViewById(R.id.taskName)
        val rvTaskDeadline:TextView  = itemView.findViewById(R.id.taskDeadline)
        val rvTaskGroup:TextView  = itemView.findViewById(R.id.taskGroup)
    }

}



