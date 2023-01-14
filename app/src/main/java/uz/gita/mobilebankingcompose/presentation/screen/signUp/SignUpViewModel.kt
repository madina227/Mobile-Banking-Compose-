package uz.gita.mobilebankingcompose.presentation.screen.signUp

import kotlinx.coroutines.flow.StateFlow
import uz.gita.mobilebankingcompose.data.source.remote.dto.auth.request.SignUpRequest


interface SignUpContract {
    interface SignUpViewModel {
        val uiState: StateFlow<UiState>

        fun onEventDispatcher(intent: Intent)
    }

    sealed interface Intent {
        class FirstName(val name: String) : Intent
        class SignUp(val signUpRequest: SignUpRequest) : Intent
    }

    data class UiState(
        val firstName: String = "",
        val lastName: String = "",
        val dateOfBirth: String = "",
        val phone: String = "",
        val password: String = "",
        val gender: String = "0"
    )
}