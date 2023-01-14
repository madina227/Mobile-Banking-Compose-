package uz.gita.mobilebankingcompose.data.source.remote.dto.service

import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST
import uz.gita.mobilebankingcompose.data.source.remote.dto.auth.request.*
import uz.gita.mobilebankingcompose.data.source.remote.dto.auth.response.*

/**
 * Created by Madina Agzamova
 * on 09,January,2023
 */
interface AuthApi {

    @POST("auth/sign-up")
    suspend fun signUp(
        @Body signUpRequest: SignUpRequest
    ): Response<SignUpResponse>

    @POST("auth/sign-up/verify")
    suspend fun signUpVerify(
        @Body signUpVerifyRequest: SignUpVerifyRequest
    ): Response<SignUpVerifyResponse>

    @POST("auth/sign-in")
    suspend fun signIn(
        @Body signInRequest: SignInRequest
    ): Response<SignInResponse>

    @POST("auth/sign-in/verify")
    suspend fun signInVerify(
        @Body signInVerifyRequest: SignInVerifyRequest
    ): Response<SignInVerifyResponse>

    @POST("update-token")
    suspend fun updateToken(
        @Body updateTokenRequest: UpdateTokenRequest
    ): Response<UpdateTokenResponse>
}