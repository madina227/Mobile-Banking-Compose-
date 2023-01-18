package uz.gita.mobilebankingcompose.presentation.screen.signUp

import android.annotation.SuppressLint
import android.util.Log
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.selection.selectable
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.androidx.AndroidScreen
import cafe.adriel.voyager.hilt.getViewModel
import uz.gita.mobilebankingcompose.R
import uz.gita.mobilebankingcompose.data.source.remote.dto.auth.request.SignUpRequest
import uz.gita.mobilebankingcompose.presentation.screen.util.CenterAlignedTopBar
import uz.gita.mobilebankingcompose.presentation.screen.util.SignItem
import uz.gita.mobilebankingcompose.presentation.screen.util.SubmitButton
import uz.gita.mobilebankingcompose.presentation.screen.viewModel.SignUpViewModelImpl
import uz.gita.mobilebankingcompose.util.DATE_MASK
import uz.gita.mobilebankingcompose.util.MaskVisualTransformation
import uz.gita.mobilebankingcompose.util.PHONE_NUMBER_MASK
import java.text.SimpleDateFormat
import java.util.*
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
    var isEnabled by remember { mutableStateOf(false) }
    var firstName by remember { mutableStateOf("") }
    var lastName by remember { mutableStateOf("") }
    var dateOfBirth by remember { mutableStateOf("") }
    var phoneNumber by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    val genderOptions = listOf("Male", "Female")
    val (selectedOption, onOptionSelected) = remember {
        mutableStateOf(genderOptions[0])
    }

    SideEffect {
        isEnabled = firstName.length > 3 && lastName.length > 3
                && password.length > 6 && phoneNumber.length == 9
    }
    SideEffect {
         fun stringToLong(date: String): String {
            val f = SimpleDateFormat("dd/MM/yyyy")
            val d: Date = f.parse(date) as Date
            return d.time.toString()
        }
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
                    value = firstName,
                    eventDispatcher = {
                        firstName = it
                    },
                    label = stringResource(id = R.string.sign_up),
                    isError = firstName.length <= 3,
                    errorMsg = "firstname must be 3 or more characters",
                    keyboardType = KeyboardType.Text
                )
                SignItem(
                    value = lastName,
                    eventDispatcher = {
                        lastName = it
                    },
                    label = stringResource(
                        id = R.string.last_name
                    ),
                    isError = lastName.length <= 3,
                    errorMsg = "lastname must be 3 or more characters"
                )
                SignItem(
                    value = dateOfBirth,
                    eventDispatcher = {
                        dateOfBirth = it
                    },
                    label = stringResource(id = R.string.date_of_birth),
                    isError = dateOfBirth.length != 8,
                    errorMsg = "wrong date format",
                    keyboardType = KeyboardType.Number,
                    visualTransformation = MaskVisualTransformation(DATE_MASK)
                )
                SignItem(
                    value = phoneNumber,
                    eventDispatcher = { phoneNumber = it },
                    label = stringResource(id = R.string.phone_number),
                    isError = phoneNumber.length != 9,
                    errorMsg = "wrong phone number",
                    keyboardType = KeyboardType.Phone,
                    visualTransformation = MaskVisualTransformation(
                        PHONE_NUMBER_MASK
                    ),
                    hasLeadingIcon = true
                )
                SignItem(
                    value = password,
                    eventDispatcher = { password = it },
                    label = stringResource(id = R.string.password),
                    isError = password.length <= 6,
                    errorMsg = "first name must be 6 or more characters",
                    keyboardType = KeyboardType.Password,
                    hasTrailingIcon = true,
                    imeAction = ImeAction.Done
                )
                Text(
                    text = stringResource(id = R.string.gender),
                    Modifier.padding(horizontal = 24.dp)
                )
                RadioGroupGender(
                    genderOptions,
                    selectedOption,
                    onOptionSelected
                )
            }
            val request = SignUpRequest(
                phoneNumber,
                password,
                firstName,
                lastName,
                dateOfBirth,
                selectedOption
            )
            SubmitButton(

                onClick = {
                    eventDispatcher.invoke(
                        SignUpContract.Intent.SignUp(
                            request
                        )
                    )
                    Log.d("FFF", "screen ${request.bornDate}")
                },

                isEnabled = isEnabled,
                text = "Submit"

            )
        }
    })
}




@Composable
fun RadioGroupGender(
    genderOptions: List<String>,
    selectedOption: String,
    onOptionSelected: (String) -> Unit
) {

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