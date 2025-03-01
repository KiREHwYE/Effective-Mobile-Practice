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
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier

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
                ) { _ ->

                }
            }
        }
    }
}