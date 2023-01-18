package uz.gita.mobilebankingcompose.di.domain.repo

import kotlinx.coroutines.flow.Flow
import uz.gita.mobilebankingcompose.data.source.remote.dto.auth.request.SignUpRequest
import uz.gita.mobilebankingcompose.data.source.remote.dto.auth.request.SignUpVerifyRequest
import uz.gita.mobilebankingcompose.util.ResultData

/**
 * Created by Madina Agzamova
 * on 09,January,2023
 */
interface AuthRepository {
    fun isAgreeWithPrivacy(): Boolean
    fun disablePrivacy()
    fun signUp(signUpRequest: SignUpRequest): Flow<ResultData<Unit>>
    fun signUpVerify(signUpRequestVerifyRequest: SignUpVerifyRequest): Flow<ResultData<Unit>>
}