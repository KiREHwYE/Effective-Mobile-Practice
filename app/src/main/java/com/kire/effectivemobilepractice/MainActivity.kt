package com.kire.effectivemobilepractice

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.displayCutout
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.kire.jobs.di.DaggerJobsComponent
import com.kire.jobs.presentation.JobsViewModel
import com.kire.network.di.DaggerNetworkComponent
import com.kire.ui.Dimens.HORIZONTAL_PAD_16
import com.kire.ui.Dimens.VERTICAL_PAD_16
import com.kire.ui.theme.EffectiveMobileExtendedPracticeTheme
import com.kire.ui.theme.extendedColor

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
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(color = extendedColor.black)
                        .windowInsetsPadding(WindowInsets.displayCutout)
                        .padding(
                            horizontal = HORIZONTAL_PAD_16,
                            vertical = VERTICAL_PAD_16
                        )
                ) {
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