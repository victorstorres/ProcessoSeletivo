package com.example.processo_seletivo.permission

import android.Manifest
import android.content.pm.PackageManager
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.platform.LocalContext
import androidx.core.content.ContextCompat


@Composable
fun LocationPermissionRequest(
    onPermissionGranted: @Composable () -> Unit, // Composables passados como parâmetro
    onPermissionDenied: @Composable () -> Unit // Outra ação caso a permissão seja negada
) {
    val context = LocalContext.current
    var isPermissionGranted by remember { mutableStateOf(false) } // Estado para a permissão

    val permissionRequestLauncher = rememberLauncherForActivityResult(
        ActivityResultContracts.RequestPermission()
    ) { isGranted ->
        isPermissionGranted = isGranted // Atualiza o estado da permissão
    }

    LaunchedEffect(Unit) {
        val permissionStatus = ContextCompat.checkSelfPermission(
            context,
            Manifest.permission.ACCESS_FINE_LOCATION
        )
        if (permissionStatus == PackageManager.PERMISSION_GRANTED) {
            isPermissionGranted = true // Já tem permissão
        } else {
            permissionRequestLauncher.launch(Manifest.permission.ACCESS_FINE_LOCATION)
        }
    }

    if (isPermissionGranted) {
        onPermissionGranted()
    } else {
        onPermissionDenied()
    }
}
