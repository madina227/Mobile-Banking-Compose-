package uz.gita.mobilebankingcompose.presentation.screen.util

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import uz.gita.mobilebankingcompose.presentation.screen.signUp.SignUpContract

/**
 * Created by Madina Agzamova
 * on 12,January,2023
 **/


@Composable
fun SignItem(
    value: String,
    eventDispatcher: (String) -> Unit,
    label: String,
    keyboardType: KeyboardType = KeyboardType.Text,
    visualTransformation: VisualTransformation = VisualTransformation.None,
    imeAction: ImeAction = ImeAction.Next,
    hasTrailingIcon: Boolean = false,
    hasLeadingIcon: Boolean = false,
    isError: Boolean = false,
    errorMsg: String = ""
) {
    Text(
        text = label, Modifier.padding(horizontal = 24.dp)
    )
    CustomOutlinedTextField(
        value = value,
        eventDispatcher = eventDispatcher,
        label = label,
        keyboardType = keyboardType,
        visualTransformation = visualTransformation,
        hasLeadingIcon = hasLeadingIcon,
        hasTrailingIcon = hasTrailingIcon,
        imeAction = imeAction,
        isError = isError,
        errorMsg = errorMsg
    )
}