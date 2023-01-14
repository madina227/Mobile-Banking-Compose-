package uz.gita.mobilebankingcompose.data.source.remote.dto.auth.request

data class SignUpVerifyRequest(
    val token: String,
    val code: String
)
