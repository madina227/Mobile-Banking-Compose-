package uz.gita.mobilebankingcompose.data.source.remote.dto.auth.request

import com.google.gson.annotations.SerializedName

data class UpdateTokenRequest(
    @SerializedName("refresh-token")
    val refreshToken: String
)
