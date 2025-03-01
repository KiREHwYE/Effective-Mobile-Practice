package com.kire.jobs.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.kire.jobs.domain.usecase.IJobsUseCases
import javax.inject.Inject

/**
 * Фабрика для создания JobsViewModel с его зависимостями
 *
 * @author Михаил Гонтарев (KiREHwYE)
 */
class JobsViewModelFactory @Inject constructor(
    private val jobsUseCases: IJobsUseCases
) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(JobsViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return JobsViewModel(jobsUseCases) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
