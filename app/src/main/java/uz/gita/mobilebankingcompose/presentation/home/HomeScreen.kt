package uz.gita.mobilebankingcompose.presentation.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.AlignmentLine
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import uz.gita.mobilebankingcompose.R
import uz.gita.mobilebankingcompose.presentation.screen.util.CenterAlignedTopBar
import uz.gita.mobilebankingcompose.presentation.screen.util.FloatingActionButtonItem

/**
 * Created by Madina Agzamova
 * on 12,January,2023
 **/

class HomeScreen {
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreenContent() {
    Scaffold(topBar = {
        CenterAlignedTopBar(
            title = "Home",
            hasAlertIcon = true
        )
    }, bottomBar = {}) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(paddingValues)
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(160.dp)
                    .padding(16.dp)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.account),
                    contentDescription = null
                )
            }

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                FloatingActionButtonItem(
                    icon = painterResource(id = R.drawable.ic_card_24),
                    text = "Add card",
                    onClick = { }
                )
                FloatingActionButtonItem(
                    icon = painterResource(id = R.drawable.ic_baseline_credit_score_24),
                    text = "Pay",
                    onClick = { }
                )
                FloatingActionButtonItem(
                    icon = painterResource(id = R.drawable.ic_baseline_send_24),
                    text = "Send",
                    onClick = { }
                )
                FloatingActionButtonItem(
                    icon = painterResource(id = R.drawable.ic_dataset_24),
                    text = "More",
                    onClick = { }
                )
            }
        }

    }
}

@Preview
@Composable
fun HomeScreenPreview() {
    HomeScreenContent()
}