package uz.gita.mobilebankingcompose.presentation.screen.privacyPolicy

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.ScrollableState
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.androidx.AndroidScreen
import uz.gita.mobilebankingcompose.R
import uz.gita.mobilebankingcompose.presentation.screen.util.CenterAlignedTopBar
import uz.gita.mobilebankingcompose.presentation.screen.util.SubmitButton

/**
 * Created by Madina Agzamova
 * on 12,January,2023
 **/

class PrivacyPolicyScreen : AndroidScreen() {
    @Composable
    override fun Content() {
        TODO("Not yet implemented")
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PrivacyPolicyScreenContent() {
    val scroll = rememberScrollState()
    var isAgree by remember { mutableStateOf(false) }
    Scaffold(topBar = {
        CenterAlignedTopBar(title = "Privacy policy")
    }) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(paddingValues)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.gita_bank),
                    contentDescription = "Gita bank",
                    modifier = Modifier
                        .size(height = 40.dp, width = 200.dp)
                        .padding(horizontal = 16.dp)
                        .background(Color.Black),
                )
                Text(
                    text = stringResource(R.string.service_privacy_policy),
                    Modifier.padding(16.dp)
                )
                Text(
                    text = stringResource(R.string.lorem_ipsum),
                    modifier = Modifier
                        .padding(horizontal = 16.dp, vertical = 4.dp)
                        .verticalScroll(scroll),
                    textAlign = TextAlign.Justify
                )
            }
            Row(
                modifier = Modifier.padding(horizontal = 4.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {
                RadioButton(
                    selected = isAgree,
                    onClick = { isAgree = !isAgree })
                Text(text = "I agree with all terms")
            }
            SubmitButton(
                onClick = { /*TODO*/ }, isEnabled = isAgree, text = "Enter"
            )
        }

    }
}

@Preview
@Composable
fun PrivacyPreview() {
    PrivacyPolicyScreenContent()
}