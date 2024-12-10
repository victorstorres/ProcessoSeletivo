package com.example.processo_seletivo.ui.componets.bottomSheet

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.BottomSheetScaffold
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.SheetValue
import androidx.compose.material3.rememberBottomSheetScaffoldState
import androidx.compose.material3.rememberStandardBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.processo_seletivo.ui.componets.selectDestineOrDriver.SelectDestineOrDriverScreen
import com.example.processo_seletivo.ui.maps.MapScreen
import com.example.processo_seletivo.ui.maps.MapState


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BottomSheetScreen(
    mapState: MapState,
    bottomSheetUiState: BottomSheetUiState,
    onChangeToDriver: () -> Unit = {},
    onChangeToDestination: () -> Unit = {},

    ) {
    val sheetState = rememberBottomSheetScaffoldState(
        bottomSheetState = rememberStandardBottomSheetState(
            initialValue = SheetValue.PartiallyExpanded
        )
    )
    BottomSheetScaffold(
        scaffoldState = sheetState,
        sheetContent = {
            SelectDestineOrDriverScreen(
                state = bottomSheetUiState,
                onChangeToDestination = onChangeToDestination,
                onChangeToDriver = onChangeToDriver
            )
        },
        sheetPeekHeight = 100.dp
    ) { paddingValues ->
        MapScreen(modifier = Modifier.padding(paddingValues), state = mapState)
    }
}





