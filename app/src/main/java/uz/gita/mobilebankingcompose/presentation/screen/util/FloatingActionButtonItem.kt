package uz.gita.mobilebankingcompose.presentation.screen.util

import android.graphics.drawable.Icon
import android.graphics.drawable.shapes.Shape
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.FloatingActionButtonDefaults
import androidx.compose.material3.Shapes
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import uz.gita.mobilebankingcompose.R

/**
 * Created by Madina Agzamova
 * on 13,January,2023
 **/

@Composable
fun FloatingActionButtonItem(
    icon: Painter,
    text: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        FloatingActionButton(
            onClick = onClick,
            shape = FloatingActionButtonDefaults.largeShape,
            modifier = modifier
        ) {
            Image(painter = icon, contentDescription = null)
        }
        Text(text = text)
    }
}

@Preview(showBackground = true)
@Composable
fun FloatingPreview() {
    FloatingActionButtonItem(
        icon = painterResource(id = R.drawable.ic_card_24),
        text = "Add",
        {}
    )
}