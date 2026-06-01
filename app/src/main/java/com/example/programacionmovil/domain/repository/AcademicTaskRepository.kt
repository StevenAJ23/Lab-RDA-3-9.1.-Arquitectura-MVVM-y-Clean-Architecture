package com.example.programacionmovil.domain.repository

import com.example.programacionmovil.domain.model.AcademicTask
import kotlinx.coroutines.flow.Flow

interface AcademicTaskRepository {
    fun getTasksStream(): Flow<List<AcademicTask>>
    suspend fun addTask(title: String)
    suspend fun toggleTaskCompletion(taskId: String)
}
