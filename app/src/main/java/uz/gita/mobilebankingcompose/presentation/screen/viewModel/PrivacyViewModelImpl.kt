package uz.gita.mobilebankingcompose.presentation.screen.viewModel

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import org.orbitmvi.orbit.Container
import org.orbitmvi.orbit.syntax.simple.intent
import org.orbitmvi.orbit.viewmodel.container
import uz.gita.mobilebankingcompose.di.domain.repo.AuthRepository
import uz.gita.mobilebankingcompose.navigation.NavigationHandler
import uz.gita.mobilebankingcompose.presentation.screen.privacyPolicy.PrivacyViewModel
import uz.gita.mobilebankingcompose.presentation.screen.privacyPolicy.PrivacyViewModel.PrivacyUIState
import uz.gita.mobilebankingcompose.presentation.screen.privacyPolicy.PrivacyViewModel.PrivacyIntent
import uz.gita.mobilebankingcompose.presentation.screen.signUp.SignUpScreen
import javax.inject.Inject

@HiltViewModel
class PrivacyViewModelImpl @Inject constructor(
    private val repository: AuthRepository,
    private val navigator: NavigationHandler
) : PrivacyViewModel, ViewModel() {

    override val container: Container<PrivacyUIState, Nothing> =
        container(PrivacyUIState("PrivacyScreen"))

    override fun onEventDispatcher(intent: PrivacyIntent) =
        intent {
            when (intent) {
                PrivacyIntent.OpenNextScreen -> {
                    repository.disablePrivacy()
                    navigator.navigationTo(SignUpScreen())
                }
            }
        }
}