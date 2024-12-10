package com.example.processo_seletivo.ui.componets.selectDestineOrDriver

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.processo_seletivo.ui.componets.bottomSheet.BottomSheetUiState
import com.example.processo_seletivo.ui.theme.ButtonColor


@Composable
fun SelectDestineOrDriverScreen(
    state: BottomSheetUiState,
    onChangeToDriver: () -> Unit = {},
    onChangeToDestination: () -> Unit = {},
) {
    if (state.destineOrDrive) {
        Column(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth()
        ) {
            Text(
                text = "Selecione o destino",
                style = TextStyle(
                    fontWeight = FontWeight.Bold,
                    fontSize = 20.sp
                )
            )
            Spacer(modifier = Modifier.height(8.dp))
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.fillMaxWidth()
            ) {
                CustomTextFields(state)
            }
            Spacer(modifier = Modifier.height(16.dp))
            Button(
                colors = ButtonDefaults.buttonColors(
                    containerColor = ButtonColor
                ),
                onClick = {
                    onChangeToDriver()
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(60.dp),

                ) {

                Text("Confirmar", modifier = Modifier.align(Alignment.CenterVertically))
                Icon(
                    modifier = Modifier.padding(start = 10.dp),
                    imageVector = Icons.Default.ArrowForward,
                    contentDescription = "ArrowButton",
                )
            }
        }
    } else {
        Column {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {

                IconButton(onClick = onChangeToDestination) {
                    Icon(imageVector = Icons.Default.ArrowBack, contentDescription = "ArrowBack")
                }
                Text(
                    "Selecione o motorista", style = TextStyle(
                        fontWeight = FontWeight.Bold,
                        fontSize = 20.sp
                    )
                )

            }
            Column(modifier = Modifier.padding(16.dp)) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text("Total: R$ 0,00")
                    Button(
                        colors = ButtonDefaults.buttonColors(
                            containerColor = ButtonColor
                        ),
                        onClick = {

                        }
                    ) {
                        Text("Começe a viagem")
                    }
                }

            }
        }

    }
}


@Composable
private fun CustomTextFields(
    state: BottomSheetUiState = BottomSheetUiState()
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        OutlinedTextField(
            value = state.initLocation,
            onValueChange = state.onChangedInitLocation,
            label = { Text("Inicío") },
            leadingIcon = {
                Icon(
                    imageVector = Icons.Default.Home,
                    contentDescription = "Start Icon",
                    tint = Color.Blue
                )
            },
            colors = TextFieldDefaults.colors(
                unfocusedContainerColor = Color.Transparent,
                focusedContainerColor = Color.Transparent,
            ),
            modifier = Modifier.fillMaxWidth()
        )

        OutlinedTextField(
            value = state.destination,
            onValueChange = state.onChangedDestination,

            label = { Text("Destino") },
            leadingIcon = {
                Icon(
                    imageVector = Icons.Default.LocationOn,
                    contentDescription = "Destination Icon",
                    tint = Color.Red
                )
            },
            colors = TextFieldDefaults.colors(
                unfocusedContainerColor = Color.Transparent,
                focusedContainerColor = Color.Transparent,
                ),
            modifier = Modifier.fillMaxWidth()
        )
    }
}
