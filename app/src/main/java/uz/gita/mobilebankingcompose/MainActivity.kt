package uz.gita.mobilebankingcompose

import android.os.Bundle
import android.view.Surface
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import uz.gita.mobilebankingcompose.presentation.screen.verify.VerifyScreen
//import uz.gita.mobilebankingcompose.presentation.screen.signUp.SignUpScreen
import uz.gita.mobilebankingcompose.ui.theme.MobileBankingComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MobileBankingComposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
//                    SignUpScreen()

                }
            }
        }
    }
}
