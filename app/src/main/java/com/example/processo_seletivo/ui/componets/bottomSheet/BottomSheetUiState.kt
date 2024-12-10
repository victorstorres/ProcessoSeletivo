package com.example.processo_seletivo.ui.componets.bottomSheet

data class BottomSheetUiState (
    val initLocation: String = "",
    val destination: String = "",
    val onChangedInitLocation: (String) -> Unit = {},
    val onChangedDestination: (String) -> Unit = {},
    val destineOrDrive: Boolean = true,
    )
