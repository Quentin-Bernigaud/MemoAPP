package com.android.example.recyclerview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_task.view.*
import kotlin.properties.Delegates

class TasksAdapter() : RecyclerView.Adapter<TasksAdapter.TaskViewHolder>() {
    var tasks: List<Task> by Delegates.observable(emptyList()) {
            _, _, _ -> notifyDataSetChanged()
    }
    var onDeleteClickListener: (Task) -> Unit = {}
    var onEditClickListener: (Task) -> Unit = {}
    override fun getItemCount(): Int {
        return tasks.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_task, parent, false)
        return TaskViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: TaskViewHolder, position: Int) {
        holder.bind(tasks[position])
    }

    inner class TaskViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(task: Task) {
            itemView.task_title.text = task.title
            itemView.task_description.text = task.description
            itemView.delete_button.setOnClickListener {
                onDeleteClickListener.invoke(task)
            }
            itemView.edit_button.setOnClickListener {
                onEditClickListener.invoke(task)
            }
        }
    }
}
