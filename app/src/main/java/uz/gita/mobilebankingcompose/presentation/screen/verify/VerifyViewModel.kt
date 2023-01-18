package uz.gita.mobilebankingcompose.presentation.screen.verify

import kotlinx.coroutines.flow.StateFlow
import uz.gita.mobilebankingcompose.data.source.remote.dto.auth.request.SignUpRequest
import uz.gita.mobilebankingcompose.presentation.screen.signUp.SignUpContract

/**
 * Created by Madina Agzamova
 * on 10,January,2023
 **/

interface VerifyViewModel {
    val uiState: StateFlow<UiState>

    fun onEventDispatcher(intent: SignUpContract.Intent)
}

sealed interface Intent {
    class Verify(val code: String) : Intent
}

data class UiState(
    val code: String = "",
)