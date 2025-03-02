package com.kire.effectivemobilepractice

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.navigation.compose.rememberNavController
import com.kire.jobs.di.DaggerJobsComponent
import com.kire.jobs.presentation.viewmodel.JobsViewModel
import com.kire.network.di.DaggerNetworkComponent
import com.kire.ui.theme.EffectiveMobileExtendedPracticeTheme
import com.kire.ui.ui_component.BaseLayout

class MainActivity : ComponentActivity() {

    private val jobsViewModel: JobsViewModel by viewModels {
        val networkComponent = DaggerNetworkComponent.create()

        val jobsComponent = DaggerJobsComponent.builder()
            .networkComponent(networkComponent)
            .build()

        jobsComponent.provideJobsViewModelFactory()
    }

    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        enableEdgeToEdge()
        setContent {
            EffectiveMobileExtendedPracticeTheme {

                BaseLayout {
                    val navController = rememberNavController()

                    MainNavHost(
                        navHostController = navController,
                        jobsViewModel = jobsViewModel
                    )
                }
            }
        }
    }
}