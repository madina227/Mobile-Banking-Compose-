package uz.gita.mobilebankingcompose.presentation.screen.signIn

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.androidx.AndroidScreen
import uz.gita.mobilebankingcompose.R
import uz.gita.mobilebankingcompose.presentation.screen.signUp.SignUpContract
import uz.gita.mobilebankingcompose.presentation.screen.util.CenterAlignedTopBar
import uz.gita.mobilebankingcompose.presentation.screen.util.SignItem
import uz.gita.mobilebankingcompose.presentation.screen.util.SubmitButton
import uz.gita.mobilebankingcompose.util.MaskVisualTransformation
import uz.gita.mobilebankingcompose.util.PHONE_NUMBER_MASK

/**
 * Created by Madina Agzamova
 * on 12,January,2023
 **/

class SignInScreen : AndroidScreen() {

    @Composable
    override fun Content() {
        TODO("Not yet implemented")
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SignInScreenContent(
    uiState: SignUpContract.UiState,
    eventDispatcher: (SignUpContract.Intent) -> Unit
) {
    var isEnabled by remember { mutableStateOf(false) }

    SideEffect {
        isEnabled = uiState.password.length > 6 && uiState.phone.length != 9
    }

    Scaffold(
        topBar = { CenterAlignedTopBar(title = "Sign in") },
        content = { paddingValues ->
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(paddingValues)
            ) {
                Spacer(modifier = Modifier.height(16.dp))
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(1f)
                ) {
                    SignItem(
                        value = uiState.phone,
                        eventDispatcher = {},
                        label = stringResource(id = R.string.phone_number),
                        isError = uiState.phone.length == 9,
                        errorMsg = "wrong phone number",
                        keyboardType = KeyboardType.Phone,
                        visualTransformation = MaskVisualTransformation(
                            PHONE_NUMBER_MASK
                        ),
                        hasLeadingIcon = true
                    )
                    SignItem(
                        value = uiState.password,
                        eventDispatcher = {  },
                        label = stringResource(id = R.string.password),
                        isError = uiState.password.length >= 6,
                        errorMsg = "first name must be 6 or more characters",
                        keyboardType = KeyboardType.Password,
                        hasTrailingIcon = true,
                        imeAction = ImeAction.Done
                    )

                    Text(
                        text = "Forgot password!",
                        modifier = Modifier
                            .padding(16.dp)
                            .clickable {

                            },
                        color = Color(63, 81, 181, 255),
                    )
                }
                SubmitButton(
                    onClick = { /*TODO*/ },
                    isEnabled = isEnabled,
                    text = "Enter"
                )
            }
        })
}