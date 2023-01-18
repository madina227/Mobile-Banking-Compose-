package uz.gita.mobilebankingcompose.presentation.screen.util

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.focus.onFocusEvent
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.key.Key
import androidx.compose.ui.input.key.key
import androidx.compose.ui.input.key.onKeyEvent
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.core.text.isDigitsOnly
import uz.gita.mobilebankingcompose.ui.theme.MobileBankingComposeTheme

/**
 * Created by Madina Agzamova
 * on 11,January,2023
 **/

@OptIn(ExperimentalMaterial3Api::class, ExperimentalComposeUiApi::class)
@Composable
fun CustomVerifyOutlinedTextField(
    value: String,
    eventDispatcher: (String) -> Unit,
    imeAction: ImeAction = ImeAction.Next
) {
    MobileBankingComposeTheme {
        Surface(
            modifier = Modifier
                .width(60.dp)
                .background(color = MaterialTheme.colorScheme.background),
        ) {
            val focusManager = LocalFocusManager.current
            OutlinedTextField(
                value = value,
                onValueChange = eventDispatcher,
//                {
//                    if (it.length < 2 && it.isDigitsOnly()) {
//
//                    }
//                },
                modifier = Modifier
                    .clip(RoundedCornerShape(12.dp))
                    .padding(horizontal = 4.dp, vertical = 8.dp)
                    .onKeyEvent {
                        if (it.key == Key.Backspace) {
                            focusManager.moveFocus(focusDirection = FocusDirection.Left)
                        }
                        true
                    },
                singleLine = true,
                shape = RoundedCornerShape(12.dp),
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    containerColor = Color(244, 244, 244)
                ),
                textStyle = LocalTextStyle.current.copy(textAlign = TextAlign.Center),
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Number, imeAction = imeAction
                ),
                keyboardActions = KeyboardActions(onNext = {
                    focusManager.moveFocus(focusDirection = FocusDirection.Next)
                }, onDone = { focusManager.clearFocus() }),

                )
        }
    }
}

@Preview
@Composable
fun VerifyOutlinedTextPreview() {
    Row {
//        CustomVerifyOutlinedTextField("1")
//        CustomVerifyOutlinedTextField("1")
//        CustomVerifyOutlinedTextField("1")
//        CustomVerifyOutlinedTextField("1")
//        CustomVerifyOutlinedTextField("1")
//        CustomVerifyOutlinedTextField("1", imeAction = ImeAction.Done)
    }
}