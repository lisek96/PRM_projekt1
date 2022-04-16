package com.example.prm_cwiczenia

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.prm_cwiczenia.adapter.TaskAdapter
import com.example.prm_cwiczenia.databinding.ActivityMainTaskManagerBinding
import com.example.prm_cwiczenia.model.Task
import java.sql.Date
import java.time.LocalDate

class MainActivityTaskManager : AppCompatActivity() {

    private val binding by lazy { ActivityMainTaskManagerBinding.inflate(layoutInflater)}
    private val taskAdapter by lazy { TaskAdapter() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.recyclerView.apply{
            adapter = taskAdapter
            layoutManager = LinearLayoutManager(this@MainActivityTaskManager)
        }

        (1..2).forEach{
            taskAdapter.add(Task("Projekt PRM", Task.TaskPriority.HIGH,
                LocalDate.of(2022, 5, 3), 55, R.drawable.pjwstk))
        }
        (1..2).forEach{
            taskAdapter.add(Task("Projekt PRM", Task.TaskPriority.HIGH,
                LocalDate.of(2022, 5, 3), 55, R.drawable.work))
        }
        (1..2).forEach{
            taskAdapter.add(Task("Projekt PRM", Task.TaskPriority.HIGH,
                LocalDate.of(2022, 5, 3), 55, R.drawable.doctor))
        }


    }
}