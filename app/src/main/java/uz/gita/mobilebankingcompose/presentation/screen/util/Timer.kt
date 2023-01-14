package uz.gita.mobilebankingcompose.presentation.screen.util

import androidx.compose.runtime.Composable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.onSizeChanged
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.IntSize
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.delay


/**
 * Created by Madina Agzamova
 * on 11,January,2023
 **/

@Composable
fun Timer(
    totalTime: Long = 59,
    modifier: Modifier = Modifier,
    isTimeRunning: Boolean = false
) {
    var size by remember {
        mutableStateOf(IntSize.Zero)
    }
    var currentTime by remember {
        mutableStateOf(totalTime)
    }
    var isTimerRunning by remember {
        mutableStateOf(isTimeRunning)
    }

    LaunchedEffect(key1 = Unit) {
        if (isTimerRunning){
            (59 downTo 0).forEach {
                delay(1000)
                currentTime = it.toLong()
            }
        }
//        if (currentTime > 0 && isTimerRunning) {
//            delay(100L)
//            currentTime -= 100L
//            value = currentTime / totalTime.toFloat()
//        }


        if (currentTime < 1) isTimerRunning = !isTimerRunning
    }


    Box(
        contentAlignment = Alignment.Center,
        modifier = modifier
            .onSizeChanged {
                size = it
            }
    ) {
        Text(
            text = if (currentTime > 10) ("00 : $currentTime")
            else ("00 : 0$currentTime"),
            fontSize = 22.sp,
            color = Color.Black
        )
    }
}

@Preview
@Composable
fun MyTimerPreview() {
    Surface(
        modifier = Modifier.fillMaxSize()
    ) {
        Box(
            contentAlignment = Alignment.Center
        ) {
            Timer(isTimeRunning = true)
        }
    }
}