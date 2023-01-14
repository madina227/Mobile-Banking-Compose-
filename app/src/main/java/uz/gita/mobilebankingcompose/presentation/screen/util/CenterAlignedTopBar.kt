package uz.gita.mobilebankingcompose.presentation.screen.util

import android.graphics.drawable.Icon
import android.widget.ActionMenuView
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.captionBar
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import uz.gita.mobilebankingcompose.R
import uz.gita.mobilebankingcompose.ui.theme.MobileBankingComposeTheme

/**
 * Created by Madina Agzamova
 * on 10,January,2023
 **/

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CenterAlignedTopBar(
    title: String,
    hasBackIcon: Boolean = false,
    hasAlertIcon: Boolean = false
) {
    CenterAlignedTopAppBar(
        title = {
            Text(
                title,
                style = MaterialTheme.typography.headlineMedium
            )
        },
        navigationIcon = {
            if (hasBackIcon)
                navigationCustomIcon()
        },
        actions = {
            if (hasAlertIcon)  actionIconButton()
        }
    )
}

val navigationCustomIcon = @Composable {
    IconButton(
        onClick = { }
    ) {
        Icon(
            painter = painterResource(id = R.drawable.ic_back_ios_24),
            contentDescription = null,
            tint = Color.Black
        )
    }
}

val actionIconButton = @Composable {
    IconButton(
        onClick = { }
    ) {
        Icon(
            painter = painterResource(id = R.drawable.ic_notifications_none_24),
            contentDescription = null,
            tint = Color.Black
        )
    }
}


@Preview
@Composable
fun TopBarPreview() {
    CenterAlignedTopBar("TopBar", hasBackIcon = true, true)
}