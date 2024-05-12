package com.example.taskminder

import android.content.Context
import android.content.Intent
import android.text.Layout
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class TasksAdaptor(private var tasks: List<Task>, context: Context):
    RecyclerView.Adapter<TasksAdaptor.TaskViewHolder>() {
     class TaskViewHolder(itemView:View): RecyclerView.ViewHolder(itemView) {
         val titleTextView: TextView = itemView.findViewById(R.id.titleTextView)
         val updateButton: ImageView = itemView.findViewById(R.id.updatesavebutton)
     }
    override fun onCreateViewHolder(parent:ViewGroup,ViewType: Int):TaskViewHolder{
        val view= LayoutInflater.from(parent.context).inflate(R.layout.task_item, parent,false)
        return TaskViewHolder(view)
    }

    override fun getItemCount(): Int=tasks.size



    override fun onBindViewHolder(holder: TaskViewHolder, position: Int) {
        val task= tasks[position]
        holder.titleTextView.text=task.title

        holder.updateButton.setOnClickListener{
            val intent = Intent(holder.itemView.context, UpdateActivity::class.java).apply{
               putExtra("task_id", task.id)
            }
            holder.itemView.context.startActivity(intent)
        }
    }
    fun refreshData(newTasks: List<Task>) {
        tasks = newTasks
        notifyDataSetChanged()

    }
}