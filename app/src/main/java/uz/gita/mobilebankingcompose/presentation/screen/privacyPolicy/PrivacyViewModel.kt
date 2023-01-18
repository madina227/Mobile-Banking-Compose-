package uz.gita.mobilebankingcompose.presentation.screen.privacyPolicy

import uz.gita.mobilebankingcompose.util.AppViewModel

import uz.gita.mobilebankingcompose.presentation.screen.privacyPolicy.PrivacyViewModel.PrivacyIntent
import uz.gita.mobilebankingcompose.presentation.screen.privacyPolicy.PrivacyViewModel.PrivacyUIState

/**
 * Created by Madina Agzamova
 * on 17,January,2023
 **/

interface PrivacyViewModel :
    AppViewModel<PrivacyIntent, PrivacyUIState, Nothing> {

    sealed class PrivacyIntent {
        object OpenNextScreen : PrivacyIntent()
    }

    data class PrivacyUIState(
        val title: String
    )
}
