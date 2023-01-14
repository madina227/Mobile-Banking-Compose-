package uz.gita.mobilebankingcompose.presentation.screen.util

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

/**
 * Created by Madina Agzamova
 * on 10,January,2023
 **/

@Composable
fun SubmitButton(onClick: () -> Unit, isEnabled: Boolean, text: String) {
    MaterialTheme {
        Surface(
            modifier = Modifier
                .fillMaxWidth()
                .background(color = MaterialTheme.colorScheme.background)
        ) {
            Button(
                onClick = onClick,
                shape = RoundedCornerShape(12.dp),
                colors = ButtonDefaults.outlinedButtonColors(
                    disabledContainerColor = Color(211, 211, 211, 255),
                    containerColor = Color(56, 98, 248)
                ), enabled = isEnabled,
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxWidth()
                    .height(56.dp)
            ) {
                Text(text = text)
            }
        }

    }
}