package com.kire.effectivemobilepractice

import android.annotation.SuppressLint
import android.os.Bundle

import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.displayCutout
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.kire.ui.Dimens.HORIZONTAL_PAD_16

import com.kire.ui.theme.EffectiveMobileExtendedPracticeTheme
import com.kire.ui.theme.extendedColor

class MainActivity : ComponentActivity() {

    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            EffectiveMobileExtendedPracticeTheme {
                Scaffold(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(color = extendedColor.black)
                        .windowInsetsPadding(WindowInsets.displayCutout)
                        .padding(horizontal = HORIZONTAL_PAD_16)
                ) { _ ->
                    val navController = rememberNavController()

                    MainNavHost(navHostController = navController)
                }
            }
        }
    }
}