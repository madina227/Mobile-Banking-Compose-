package uz.gita.mobilebankingcompose.data.repository

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import uz.gita.mobilebankingcompose.data.source.local.SharedPref
import uz.gita.mobilebankingcompose.data.source.remote.dto.auth.request.SignUpRequest
import uz.gita.mobilebankingcompose.data.source.remote.dto.auth.request.SignUpVerifyRequest
import uz.gita.mobilebankingcompose.data.source.remote.dto.service.AuthApi
import uz.gita.mobilebankingcompose.di.domain.repo.AuthRepository
import uz.gita.mobilebankingcompose.util.ResultData
import uz.gita.mobilebankingcompose.util.mLog
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Created by Madina Agzamova
 * on 09,January,2023
 */

@Singleton
class AuthRepositoryImpl @Inject constructor(
    private val authApi: AuthApi,
    private val sharedPref: SharedPref
) : AuthRepository {

    override fun isAgreeWithPrivacy(): Boolean = sharedPref.isAgreeWithPrivacy

    override fun disablePrivacy() {
        sharedPref.isAgreeWithPrivacy = true
    }


    override fun signUp(signUpRequest: SignUpRequest): Flow<ResultData<Unit>> =
        flow<ResultData<Unit>> {
            val response = authApi.signUp(signUpRequest)
            if (response.isSuccessful) {
                response.body()?.let {
                    sharedPref.tempToken = it.token
                    emit(ResultData.Success(Unit))
                }
            }
        }.catch { error ->
            error.message?.let {
                mLog("Failure ${error.cause}")
                mLog("message ${error.message}")
                mLog("Failure ${error.cause}")
            }
        }.flowOn(Dispatchers.IO)

    override fun signUpVerify(signUpRequestVerifyRequest: SignUpVerifyRequest): Flow<ResultData<Unit>> =
        flow<ResultData<Unit>> {
            val response = authApi.signUpVerify(signUpRequestVerifyRequest)

            if (response.isSuccessful) {
                response.body()?.let {
                    mLog("From AuthRepo inside signUpVerify -- accessToken = ${it.accessToken}")
                    mLog("From AuthRepo inside signUpVerify -- refreshToken = ${it.refreshToken}")

                    sharedPref.accessToken = it.accessToken
                    sharedPref.refreshToken = it.refreshToken
                }
            }
        }
}