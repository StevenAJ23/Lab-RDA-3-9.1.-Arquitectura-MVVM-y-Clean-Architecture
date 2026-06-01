package com.example.programacionmovil.domain.usecase

import com.example.programacionmovil.domain.model.AcademicTask
import com.example.programacionmovil.domain.repository.AcademicTaskRepository
import kotlinx.coroutines.flow.Flow

class GetTasksUseCase(private val repository: AcademicTaskRepository) {
    operator fun invoke(): Flow<List<AcademicTask>> {
        return repository.getTasksStream()
    }
}
