package uz.gita.mobilebankingcompose.data.source.remote.dto.auth.response

import com.google.gson.annotations.SerializedName

data class SignInVerifyResponse(
    @SerializedName("refresh-token")
    val refreshToken: String,
    @SerializedName("access-token")
    val accessToken: String
)
