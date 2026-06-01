package com.example.programacionmovil

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.programacionmovil.data.repository.InMemoryTaskRepository
import com.example.programacionmovil.domain.usecase.AddTaskUseCase
import com.example.programacionmovil.domain.usecase.GetTasksUseCase
import com.example.programacionmovil.ui.presentation.tasks.AcademicTaskApp
import com.example.programacionmovil.ui.presentation.tasks.AcademicTaskViewModel
import com.example.programacionmovil.ui.theme.ProgramacionMovilTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        // 1. Orquestación manual de dependencias de infraestructura y negocio
        val repository = InMemoryTaskRepository()
        val getTasksUseCase = GetTasksUseCase(repository)
        val addTaskUseCase = AddTaskUseCase(repository)

        // 2. Creación del ViewModel inyectando sus colaboradores requeridos
        val viewModel = AcademicTaskViewModel(getTasksUseCase, addTaskUseCase, repository)

        // 3. Renderización de la vista declarativa limpia
        setContent {
            ProgramacionMovilTheme {
                AcademicTaskApp(viewModel = viewModel)
            }
        }
    }
}
