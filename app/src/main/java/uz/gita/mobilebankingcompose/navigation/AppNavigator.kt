package uz.gita.mobilebankingcompose.navigation

import cafe.adriel.voyager.navigator.Navigator
import kotlinx.coroutines.flow.Flow

interface AppNavigator {
    val navigationFlow: Flow<Navigator.() -> Unit>
}