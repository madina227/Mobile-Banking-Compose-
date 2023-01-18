package uz.gita.mobilebankingcompose.presentation.screen.util

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.selection.selectable
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

/**
 * Created by Madina Agzamova
 * on 18,January,2023
 **/


@Composable
fun RadioGroupGender(
    listOptions: List<String>,
    selectedOption: String,
    onOptionSelected: (String) -> Unit
) {

    Row {
        listOptions.forEach { text ->
            Row(
                modifier = Modifier
                    .selectable(
                        selected = text == selectedOption,
                        onClick = { onOptionSelected(text) }),
                verticalAlignment = Alignment.CenterVertically
            ) {
                RadioButton(
                    modifier = Modifier.padding(8.dp),
                    selected = (text == selectedOption),
                    onClick = { onOptionSelected(text) })
                Text(
                    text = text, modifier = Modifier.padding(8.dp),
                )
            }

        }
    }
}
