package uz.gita.mobilebankingcompose.presentation.screen.signUp

import android.annotation.SuppressLint
import android.widget.RadioGroup
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.material3.*
import androidx.compose.material3.MaterialTheme.typography
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.androidx.AndroidScreen
import cafe.adriel.voyager.hilt.getViewModel
import uz.gita.mobilebankingcompose.R
import uz.gita.mobilebankingcompose.presentation.screen.util.CenterAlignedTopBar
import uz.gita.mobilebankingcompose.presentation.screen.util.CustomOutlinedTextField
import uz.gita.mobilebankingcompose.presentation.screen.util.SignItem
import uz.gita.mobilebankingcompose.presentation.screen.util.SubmitButton
import uz.gita.mobilebankingcompose.presentation.screen.viewModel.SignUpViewModelImpl
import uz.gita.mobilebankingcompose.util.DATE_MASK
import uz.gita.mobilebankingcompose.util.MaskVisualTransformation
import uz.gita.mobilebankingcompose.util.PHONE_NUMBER_MASK
import kotlin.text.Typography
import androidx.compose.material3.Text as Text

/**
 * Created by Madina Agzamova
 * on 09,January,2023
 */

class SignUpScreen : AndroidScreen() {
    @Composable
    override fun Content() {
        val viewModel: SignUpContract.SignUpViewModel =
            getViewModel<SignUpViewModelImpl>()
        val uiState = viewModel.uiState.collectAsState().value

        SignUpScreenContent(uiState, viewModel::onEventDispatcher)
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SignUpScreenContent(
    uiState: SignUpContract.UiState,
    eventDispatcher: (SignUpContract.Intent) -> Unit
) {
//    CustomOutlinedTextField(uiState.firstName, eventDispatcher = eventDispatcher, label = "")
//    var isEmpty by remember { mutableStateOf(true) }
    var isEnabled by remember { mutableStateOf(false) }

    SideEffect {
        isEnabled = uiState.firstName.length > 3 && uiState.lastName.length > 3
                && uiState.password.length > 6 && uiState.phone.length != 9
    }

    Scaffold(topBar = {
        CenterAlignedTopBar(
            title = stringResource(id = R.string.sign_up),
        )
    }, content = { padding ->
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(padding)
        ) {
            Spacer(modifier = Modifier.height(16.dp))
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f)
            ) {
                SignItem(
                    value = uiState.firstName,
                    eventDispatcher = eventDispatcher,
                    label = stringResource(id = R.string.sign_up),
                    isError = uiState.firstName.length >= 3,
                    errorMsg = "firstname must be 3 or more characters"
                )
                SignItem(
                    value = uiState.lastName,
                    eventDispatcher = eventDispatcher,
                    label = stringResource(
                        id = R.string.last_name
                    ),
                    isError = uiState.lastName.length >= 3,
                    errorMsg = "lastname must be 3 or more characters"
                )
                SignItem(
                    value = uiState.dateOfBirth,
                    eventDispatcher = eventDispatcher,
                    label = stringResource(id = R.string.date_of_birth),
                    isError = uiState.dateOfBirth.length == 8,
                    errorMsg = "wrong date format",
                    keyboardType = KeyboardType.Number,
                    visualTransformation = MaskVisualTransformation(DATE_MASK)
                )
                SignItem(
                    value = uiState.phone,
                    eventDispatcher = eventDispatcher,
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
                    eventDispatcher = eventDispatcher,
                    label = stringResource(id = R.string.password),
                    isError = uiState.password.length >= 6,
                    errorMsg = "first name must be 6 or more characters",
                    keyboardType = KeyboardType.Password,
                    hasTrailingIcon = true,
                    imeAction = ImeAction.Done
                )
                Text(
                    text = stringResource(id = R.string.gender),
                    Modifier.padding(horizontal = 24.dp)
                )
                RadioGroupGender()
            }

            SubmitButton(
                onClick = { /*TODO*/ },
                isEnabled = isEnabled,
                text = "Submit"
            )
        }
    })
}


@Composable
fun RadioGroupGender() {
    val genderOptions = listOf("Male", "Female")
    val (selectedOption, onOptionSelected) = remember {
        mutableStateOf(genderOptions[0])
    }
    Row {
        genderOptions.forEach { text ->
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


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
@Preview
fun SignUpScreenPreview(
) {
    MaterialTheme {
        SignUpScreenContent(uiState = SignUpContract.UiState(
            "",
            "",
            "",
            "",
            ""
        ),
            eventDispatcher = {})

//        RadioGroupGender()
    }
}