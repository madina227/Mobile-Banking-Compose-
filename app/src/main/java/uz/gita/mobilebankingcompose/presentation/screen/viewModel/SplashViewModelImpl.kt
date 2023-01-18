package uz.gita.mobilebankingcompose.presentation.screen.viewModel

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import org.orbitmvi.orbit.Container
import org.orbitmvi.orbit.syntax.simple.intent
import org.orbitmvi.orbit.viewmodel.container
import uz.gita.mobilebankingcompose.di.domain.repo.AuthRepository
import uz.gita.mobilebankingcompose.navigation.NavigationHandler
import uz.gita.mobilebankingcompose.presentation.screen.privacyPolicy.PrivacyPolicyScreen
import uz.gita.mobilebankingcompose.presentation.screen.signUp.SignUpScreen
import uz.gita.mobilebankingcompose.presentation.screen.splash.SplashViewModel
import javax.inject.Inject
import uz.gita.mobilebankingcompose.presentation.screen.splash.SplashViewModel.SplashIntent
import uz.gita.mobilebankingcompose.presentation.screen.splash.SplashViewModel.SplashUIState

@HiltViewModel
class SplashViewModelImpl @Inject constructor(
    private val repository: AuthRepository,
    private val navigator: NavigationHandler
) : SplashViewModel, ViewModel() {

    override fun onEventDispatcher(intent: SplashViewModel.SplashIntent) =
        intent {
            when (intent) {
                SplashIntent.OpenNextScreen -> {
                    delay(1500)
                    if (repository.isAgreeWithPrivacy()) {
                        navigator.navigationTo(SignUpScreen())
                    } else {
                        navigator.navigationTo(PrivacyPolicyScreen())
                    }
                }
            }
        }

    override val container: Container<SplashUIState, Nothing> =
        container(SplashUIState("SplashScreen"))


}