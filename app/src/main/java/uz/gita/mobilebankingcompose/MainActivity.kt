package uz.gita.mobilebankingcompose

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.LaunchedEffect
import cafe.adriel.voyager.navigator.CurrentScreen
import cafe.adriel.voyager.navigator.Navigator
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.collect
import uz.gita.mobilebankingcompose.navigation.AppNavigator
import uz.gita.mobilebankingcompose.presentation.screen.splash.SplashScreen
import uz.gita.mobilebankingcompose.ui.theme.MobileBankingComposeTheme
import javax.inject.Inject


@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    @Inject
    lateinit var appNavigator: AppNavigator

    @SuppressLint(
        "FlowOperatorInvokedInComposition",
        "CoroutineCreationDuringComposition"
    )
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MobileBankingComposeTheme {
                Log.d("TTT", "MainActivity is running")
                Navigator(SplashScreen()) { navigator ->
                    LaunchedEffect(key1 = navigator) {
                        appNavigator.navigationFlow
                            .onEach {
                                it(navigator)
                            }.collect()
                    }
                    CurrentScreen()
                }
            }
        }
    }
}
