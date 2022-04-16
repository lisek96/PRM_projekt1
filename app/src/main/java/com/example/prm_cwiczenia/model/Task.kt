package com.example.prm_cwiczenia.model

import java.time.LocalDate
import java.util.*

data class Task(
    val name: String,
    val priority: TaskPriority,
    val deadLine: LocalDate,
    val progress: Int,
    val logoDrawableId: Int
) {

    enum class TaskPriority {
        LOW, MEDIUM, HIGH
    }
}