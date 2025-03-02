package com.kire.effectivemobilepractice

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.Menu
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.kire.favourites.di.DaggerFavoriteComponent
import com.kire.favourites.presentation.viewmodel.FavoriteViewModel
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

    private val favoriteViewModel: FavoriteViewModel by viewModels {
        val networkComponent = DaggerNetworkComponent.create()

        val favoriteComponent = DaggerFavoriteComponent.builder()
            .networkComponent(networkComponent)
            .build()

        favoriteComponent.provideFavoriteViewModelFactory()
    }

    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        enableEdgeToEdge()
        setContent {
            EffectiveMobileExtendedPracticeTheme {

                val navController = rememberNavController()

                val vacancies by jobsViewModel.vacancies.collectAsStateWithLifecycle()

                val favoriteCount by remember {
                    derivedStateOf {
                        vacancies.count { it.isFavorite == true }
                    }
                }

                /** Текущий route */
                val currentRoute = navController.currentBackStackEntryAsState().value?.destination?.route

                BaseLayout(
                    bottomMenu = {
                        if (MenuDestinations.entries.any { it.route == currentRoute })
                            BottomMenu(
                                currentRoute = currentRoute,
                                navController = navController,
                                favoriteCount = favoriteCount
                            )
                    }
                ) {

                    MainNavHost(
                        navHostController = navController,
                        jobsViewModel = jobsViewModel,
                        favoriteViewModel = favoriteViewModel
                    )
                }
            }
        }
    }
}