package uz.gita.mobilebankingcompose.data.source.local

import android.content.Context
import dagger.hilt.android.qualifiers.ApplicationContext
import uz.gita.mobilebankingcompose.util.SharedPreferenceHelper
import javax.inject.Inject

class LocalStorage @Inject constructor(
    @ApplicationContext context: Context
) : SharedPreferenceHelper(context) {
    var isFirstLaunch: Boolean by booleans(true)
    var token: String by strings()
}