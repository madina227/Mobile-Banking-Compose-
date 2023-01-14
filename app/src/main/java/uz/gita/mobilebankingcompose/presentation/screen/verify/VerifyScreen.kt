package uz.gita.mobilebankingcompose.presentation.screen.verify

import androidx.compose.foundation.layout.*
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.androidx.AndroidScreen
import uz.gita.mobilebankingcompose.presentation.screen.util.CenterAlignedTopBar
import uz.gita.mobilebankingcompose.presentation.screen.util.CustomVerifyOutlinedTextField
import uz.gita.mobilebankingcompose.presentation.screen.util.SubmitButton
import uz.gita.mobilebankingcompose.presentation.screen.util.Timer

/**
 * Created by Madina Agzamova
 * on 10,January,2023
 **/

//chala qogani viewModel bilan ulash, uistatedan kevotgan malumotlaga kora button enable yoki enablemasligini tekshirish

class VerifyScreen : AndroidScreen() {

    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    override fun Content() {
        Scaffold(topBar = {
            CenterAlignedTopBar(title = "Confirmation", hasBackIcon = true)
        }, content = { paddingValues ->
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
                    repeat(6) { index ->
                        if (index < 5) CustomVerifyOutlinedTextField("1")
                        else CustomVerifyOutlinedTextField(
                            "2",
                            imeAction = ImeAction.Done
                        )
                    }
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