package com.example.processo_seletivo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.rememberNavController
import com.example.processo_seletivo.navigation.ShopperNavHost
import com.example.processo_seletivo.ui.theme.ProcessoSeletivoTheme
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ProcessoSeletivoTheme {
                val navController = rememberNavController()
                ShopperNavHost(navController = navController)
            }
        }
    }
}

