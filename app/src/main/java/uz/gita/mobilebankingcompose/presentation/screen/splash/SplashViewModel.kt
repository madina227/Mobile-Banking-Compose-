package uz.gita.mobilebankingcompose.presentation.screen.splash

import uz.gita.mobilebankingcompose.util.AppViewModel
import uz.gita.mobilebankingcompose.presentation.screen.splash.SplashViewModel.SplashIntent
import uz.gita.mobilebankingcompose.presentation.screen.splash.SplashViewModel.SplashUIState

/**
 * Created by Madina Agzamova
 * on 17,January,2023
 **/

interface SplashViewModel : AppViewModel<SplashIntent, SplashUIState, Nothing> {

    sealed class SplashIntent {
        object OpenNextScreen : SplashIntent()
    }

    data class SplashUIState(
        val title: String
    )
}