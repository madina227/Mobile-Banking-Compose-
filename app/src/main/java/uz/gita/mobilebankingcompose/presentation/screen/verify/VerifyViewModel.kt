package uz.gita.mobilebankingcompose.presentation.screen.verify

import kotlinx.coroutines.flow.StateFlow
import uz.gita.mobilebankingcompose.presentation.screen.signUp.SignUpContract

/**
 * Created by Madina Agzamova
 * on 10,January,2023
 **/

interface VerifyViewModel {
    val uiState: StateFlow<UiState>

    fun onEventDispatcher(intent: SignUpContract.Intent)
}

data class UiState(
    val code: String = "",
)