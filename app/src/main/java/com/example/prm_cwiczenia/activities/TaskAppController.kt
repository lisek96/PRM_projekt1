package com.example.prm_cwiczenia.activities

import android.opengl.Visibility
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.fragment.app.FragmentManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.prm_cwiczenia.R
import com.example.prm_cwiczenia.adapter.TaskAdapter
import com.example.prm_cwiczenia.databinding.TaskListViewBinding
import com.example.prm_cwiczenia.fragments.TaskDetail
import com.example.prm_cwiczenia.model.Task
import java.time.LocalDate
import java.time.LocalDate.of

class MainActivityTaskManager : AppCompatActivity() {

    private val binding by lazy { TaskListViewBinding.inflate(layoutInflater)}
    private val taskAdapter by lazy { TaskAdapter(onClickListener = { View -> openDetails()}) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.recyclerView.apply{
            adapter = taskAdapter
            layoutManager = LinearLayoutManager(this@MainActivityTaskManager)
        }


        (1..2).forEach{
            taskAdapter.add(Task("Projekt PRM", Task.TaskPriority.HIGH,
                of(2022, 5, 3), 55, R.drawable.pjwstk
            ))
        }
        (1..2).forEach{
            taskAdapter.add(Task("Projekt PRM", Task.TaskPriority.HIGH,
                of(2022, 5, 3), 55, R.drawable.work
            ))
        }
        (1..2).forEach{
            taskAdapter.add(Task("Projekt PRM", Task.TaskPriority.HIGH,
                of(2022, 5, 3), 55, R.drawable.doctor
            ))
        }


    }

    fun openDetails(){
    }
}