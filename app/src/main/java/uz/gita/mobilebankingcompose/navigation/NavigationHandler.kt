package uz.gita.mobilebankingcompose.navigation

import cafe.adriel.voyager.core.screen.Screen


interface NavigationHandler {
    suspend fun back()
    suspend fun navigationTo(screen: Screen)
}

