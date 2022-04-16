package com.example.prm_cwiczenia.adapter

import android.os.Looper
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.os.HandlerCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.prm_cwiczenia.databinding.TaskRecyclerviewitemBinding
import com.example.prm_cwiczenia.model.Task

class TaskAdapter() : RecyclerView.Adapter<TaskViewHolder>() {
    private val handler = HandlerCompat.createAsync(Looper.getMainLooper())
    private var tasks = mutableListOf<Task>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskViewHolder {
        val binding = TaskRecyclerviewitemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return TaskViewHolder(binding).also { holder ->
            binding.root.setOnClickListener({ remove(holder.layoutPosition)})
        }
    }

    override fun onBindViewHolder(holder: TaskViewHolder, position: Int) {
        holder.bind(tasks[position])
    }

    override fun getItemCount(): Int = tasks.size

    fun add(task: Task){
        tasks.add(task)
        notifyItemInserted(tasks.size - 1)
    }

    fun remove(position: Int){
        if(position>= 0 && position < tasks.size){
            tasks.removeAt(position)
            notifyItemRemoved(position)
        }
    }
}