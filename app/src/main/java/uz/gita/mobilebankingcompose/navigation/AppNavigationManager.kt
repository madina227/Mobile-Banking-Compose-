package uz.gita.mobilebankingcompose.navigation

import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.Navigator
import kotlinx.coroutines.flow.MutableSharedFlow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class AppNavigationManager @Inject constructor() : AppNavigator,
    NavigationHandler {
    override val navigationFlow = MutableSharedFlow<Navigator.() -> Unit>()

    private suspend fun navigate(block: Navigator.() -> Unit) {
        navigationFlow.emit(block)
    }

    override suspend fun back() = navigate { pop() }
    override suspend fun navigationTo(screen: Screen) = navigate { push(screen)}
}

