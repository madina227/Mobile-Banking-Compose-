package uz.gita.mobilebankingcompose.data.source.local

import android.content.Context
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Created by Madina Agzamova
 * on 09,January,2023
 */

@Singleton
class SharedPref @Inject constructor(@ApplicationContext private val context: Context) {
    private val sharedPreferences = context.getSharedPreferences("Local_shp", Context.MODE_PRIVATE)
    private val editor = sharedPreferences.edit()

    var tempToken: String
        get() = sharedPreferences.getString("tempToken", "")!!
        set(value) = editor.putString("tempToken", value).apply()

    var accessToken: String
        get() = sharedPreferences.getString("accessToken", "")!!
        set(value) = editor.putString("accessToken", value).apply()

    var refreshToken: String
        get() = sharedPreferences.getString("refreshToken", "")!!
        set(value) = editor.putString("refreshToken", value).apply()
}