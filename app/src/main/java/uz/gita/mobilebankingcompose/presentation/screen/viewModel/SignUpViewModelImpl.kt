package uz.gita.mobilebankingcompose.presentation.screen.viewModel

import android.annotation.SuppressLint
import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import uz.gita.mobilebankingcompose.data.source.remote.dto.auth.request.SignUpRequest
import uz.gita.mobilebankingcompose.di.domain.repo.AuthRepository
import uz.gita.mobilebankingcompose.navigation.NavigationHandler
import uz.gita.mobilebankingcompose.presentation.screen.signUp.SignUpContract
import uz.gita.mobilebankingcompose.presentation.screen.verify.UiState
import uz.gita.mobilebankingcompose.presentation.screen.verify.VerifyScreen
import uz.gita.mobilebankingcompose.util.ResultData
import uz.gita.mobilebankingcompose.util.mLog
import java.text.SimpleDateFormat
import java.util.*
import javax.inject.Inject


@HiltViewModel
class SignUpViewModelImpl @Inject constructor(
    private val authRepository: AuthRepository,
    private val navigator: NavigationHandler
) : SignUpContract.SignUpViewModel, ViewModel() {
    override val uiState = MutableStateFlow(SignUpContract.UiState())


    override fun onEventDispatcher(intent: SignUpContract.Intent) {
        when (intent) {
            is SignUpContract.Intent.SignUp -> {
                viewModelScope.launch {


                    val request = intent.signUpRequest.copy(
                        bornDate = stringToLong(intent.signUpRequest.bornDate),
                        phone = "+998${intent.signUpRequest.phone}",
                        gender = if (intent.signUpRequest.gender=="Male") "0" else "1"
                    )
                    Log.d("FFF", "viewModel ${intent.signUpRequest.bornDate}")
                    Log.d("FFF", "viewModel2 ${request.bornDate}")
                    authRepository.signUp(request).collectLatest {
                        when (it) {
                            is ResultData.Error -> {}
                            is ResultData.Message -> {}
                            is ResultData.Success -> {
                                navigator.navigationTo(VerifyScreen())
                            }
                        }
                    }
                }
            }
        }
    }

//    private fun reduce(block: (oldState: SignUpContract.UiState) -> SignUpContract.UiState) {
//        val old = uiState.value
//        uiState.value = block(old)
//    }


    @SuppressLint("SimpleDateFormat")
    private fun stringToLong(date: String): String {
        val f = SimpleDateFormat("ddMMyyyy")

        val d: Date = f.parse(date) as Date
        return d.time.toString()
    }
}