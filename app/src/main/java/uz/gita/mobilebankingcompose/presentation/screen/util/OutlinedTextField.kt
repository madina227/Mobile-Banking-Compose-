package uz.gita.mobilebankingcompose.presentation.screen.util

import android.graphics.drawable.Icon
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.focus.FocusManager
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import okhttp3.internal.format
import uz.gita.mobilebankingcompose.R
import uz.gita.mobilebankingcompose.presentation.screen.signUp.SignUpContract
import uz.gita.mobilebankingcompose.ui.theme.MobileBankingComposeTheme
import uz.gita.mobilebankingcompose.util.DATE_MASK
import uz.gita.mobilebankingcompose.util.MaskVisualTransformation
import uz.gita.mobilebankingcompose.util.PHONE_NUMBER_MASK

/**
 * Created by Madina Agzamova
 * on 09,January,2023
 */

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CustomOutlinedTextField(
    value: String,
    label: String,
    eventDispatcher: (String) -> Unit,
    keyboardType: KeyboardType,
    imeAction: ImeAction = ImeAction.Next,
    visualTransformation: VisualTransformation = VisualTransformation.None,
    hasLeadingIcon: Boolean = false,
    hasTrailingIcon: Boolean = false,
    isError: Boolean = false,
    errorMsg: String = ""
) {

    val focusManager = LocalFocusManager.current
    var hasFocus by remember { mutableStateOf(false) }
    var isHiddenPassword by remember { mutableStateOf(false) }
//    var userInteracted by remember { mutableStateOf(false) }
    MobileBankingComposeTheme {
        Surface(
            modifier = Modifier
                .fillMaxWidth()
                .background(color = MaterialTheme.colorScheme.background)
//                .onFocusChanged {
//                    if (it.isFocused) userInteracted = true
//                }
        ) {
            OutlinedTextField(
                value = value,
                label = {
                    if (value.isEmpty() && !hasFocus) Text(
                        text = label, color = Color(0x4D101010)
                    )
                },
                onValueChange = eventDispatcher,
                modifier = Modifier
                    .clip(RoundedCornerShape(12.dp))
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp, vertical = 8.dp)
                    .onFocusChanged {
                        hasFocus = it.isFocused
                    },
                leadingIcon = if (hasLeadingIcon) leadingIconView else null,
                trailingIcon = if (hasTrailingIcon) trailingIconView({
                    isHiddenPassword = !isHiddenPassword
                }, isHiddenPassword) else null,

                singleLine = true,
                isError = hasFocus && isError,
                shape = RoundedCornerShape(12.dp),
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    unfocusedBorderColor = Color.Transparent,
                    focusedBorderColor = Color(56, 98, 248),
                    containerColor = if (hasFocus) Color.Transparent
                    else Color(244, 244, 244)
                ),
                keyboardOptions = KeyboardOptions(
                    keyboardType = keyboardType,
                    imeAction = imeAction
                ),
                keyboardActions = KeyboardActions(onNext = {
                    focusManager.moveFocus(
                        FocusDirection.Down
                    )
                },
                    onDone = { focusManager.clearFocus() }
                ),
                visualTransformation = if (!isHiddenPassword && keyboardType == KeyboardType.Password) {
                    PasswordVisualTransformation()
                } else visualTransformation,

                supportingText = if (isError) errorMessage(errorMsg) else null
            )
        }
    }

}


fun trailingIconView(onClick: () -> Unit, isHidden: Boolean) = @Composable {
//    var isHidden by remember { mutableStateOf(false) }
    IconButton(
        onClick = onClick
    ) {
        Icon(
            painter = painterResource(
                id =
                if (isHidden) R.drawable.ic_visibility_24
                else R.drawable.ic_visibility_off_24
            ),
            contentDescription = "visible",
            tint = Color.Black
        )
    }
}

val leadingIconView = @Composable {
    Text(" +998 ", modifier = Modifier.padding(start = 8.dp))
}

fun errorMessage(errorMsg: String) = @Composable {
    Text(errorMsg)
}


@Preview(showBackground = true)
@Composable
fun CustomOutlinedTextFieldPre() {
    val text: String = "b"
    CustomOutlinedTextField(
        value = text,
        "UserName",
        {},
        KeyboardType.Text,
        imeAction = ImeAction.Next,
        isError = text.length <= 3,
        errorMsg = "it is error msg"
    )
}