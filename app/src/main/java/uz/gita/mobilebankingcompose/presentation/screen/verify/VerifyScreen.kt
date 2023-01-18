package uz.gita.mobilebankingcompose.presentation.screen.verify

import SmsCodeView
import android.util.Log
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.androidx.AndroidScreen
import uz.gita.mobilebankingcompose.presentation.screen.util.*

/**
 * Created by Madina Agzamova
 * on 10,January,2023
 **/

//chala qogani viewModel bilan ulash, uistatedan kevotgan malumotlaga kora button enable yoki enablemasligini tekshirish

class VerifyScreen : AndroidScreen() {

    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    override fun Content() {
        ScreenVerifyContent()
        /*
        Scaffold(topBar = {
            CenterAlignedTopBar(title = "Confirmation", hasBackIcon = true)
        }, content =
        { paddingValues ->
            Column {
                var isEnabled by remember { mutableStateOf(false) }
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(paddingValues)
                        .weight(1f)
                ) {
                    repeat(6) { index ->
                        if (index < 6) CustomVerifyOutlinedTextField("1")
                        else CustomVerifyOutlinedTextField(
                            "2",
                            imeAction = ImeAction.Done
                        )
                        if (index == 6) isEnabled = true
                    }
                }
                SubmitButton(
                    onClick = { /*TODO*/ },
                    isEnabled = isEnabled,
                    text = "Submit"
                )
            }

        })

         */
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ScreenVerifyContent() {
    Scaffold(topBar = {
        CenterAlignedTopBar(title = "Confirmation", hasBackIcon = true)
    }, content = { paddingValues ->
        Column {
            var verifyCode by remember { mutableStateOf("") }
            var isEnabled by remember { mutableStateOf(false) }

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(text = "Code is sending...")
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(paddingValues),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center
                ) {
                    SmsCodeView(
                        smsCodeLength = 6,
                        textFieldColors = TextFieldDefaults.textFieldColors(),
                        textStyle = TextStyle(),
                        smsFulled = {
                            verifyCode = it
                        }
                    )
                    Log.d("VVV", verifyCode)
                    SideEffect {
                        if (verifyCode.length > 5) isEnabled = true
                    }

                    /*
                    repeat(6) { index ->
                        if (index < 5) CustomVerifyOutlinedTextField(
                            verifyCode[index].toString(),
                            eventDispatcher = {
                                verifyCode = it
                            }
                        )
                        else CustomVerifyOutlinedTextField(
                            verifyCode[index].toString(),
                            imeAction = ImeAction.Done,
                            eventDispatcher = {
                                verifyCode = it
                            }
                        )
                    }*/
                }
                Text(text = "request in", Modifier.padding(16.dp))
                Timer(isTimeRunning = true)
            }
            SubmitButton(
                onClick = { /*TODO*/ },
                isEnabled = isEnabled,
                text = "Submit"
            )
        }

    })
}

@Preview
@Composable
fun VerifyScreenPreview() {
    ScreenVerifyContent()
}