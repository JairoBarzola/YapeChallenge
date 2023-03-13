package com.jairbarzola.yapechallenge.main

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.rememberNavController
import com.jairbarzola.yapechallenge.designsystem.YapeChallengeTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            YapeChallengeTheme {
                MainNavHost(navHostController = rememberNavController())
            }
        }
    }
}