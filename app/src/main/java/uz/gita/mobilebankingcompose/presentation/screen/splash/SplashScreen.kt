package uz.gita.mobilebankingcompose.presentation.screen.splash

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import cafe.adriel.voyager.androidx.AndroidScreen
import cafe.adriel.voyager.core.model.rememberScreenModel
import cafe.adriel.voyager.hilt.getViewModel
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.animateLottieCompositionAsState
import com.airbnb.lottie.compose.rememberLottieComposition
import dagger.hilt.android.AndroidEntryPoint
import org.orbitmvi.orbit.compose.collectAsState
import uz.gita.mobilebankingcompose.R
import uz.gita.mobilebankingcompose.presentation.screen.viewModel.SplashViewModelImpl
import uz.gita.mobilebankingcompose.presentation.screen.splash.SplashViewModel.SplashUIState
import uz.gita.mobilebankingcompose.presentation.screen.splash.SplashViewModel.SplashIntent

/**
 * Created by Madina Agzamova
 * on 12,January,2023
 **/


class SplashScreen() : AndroidScreen() {
    @Composable
    override fun Content() {
        Log.d("TTT", "Splash is running")
        val viewModel: SplashViewModel = getViewModel<SplashViewModelImpl>()
        val uiState = viewModel.collectAsState().value
        SplashScreenContent(uiState, viewModel::onEventDispatcher)

    }

    @Composable
    fun SplashScreenContent(
        uiState: SplashUIState,
        onEventDispatcher: (SplashIntent) -> Unit
    ) {
        LaunchedEffect(key1 = true) {
            onEventDispatcher(SplashIntent.OpenNextScreen)
        }
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(MaterialTheme.colorScheme.primary)
        ) {
            val composition by rememberLottieComposition(
                LottieCompositionSpec.RawRes(
                    R.raw.bank
                )
            )
            val logoAnimationState =
                animateLottieCompositionAsState(composition = composition)
            LottieAnimation(
                composition = composition,
                progress = { logoAnimationState.progress }
            )
//            if (logoAnimationState.isAtEnd && logoAnimationState.isPlaying) {
//
//            }
        }
    }


    @Preview
    @Composable
    fun SplashPreview() {
        SplashScreen()
    }
}