package uz.gita.mobilebankingcompose.util

import android.util.Log
import androidx.viewbinding.BuildConfig


fun mLog(message: String, tag: String = "ZZZ") {
    if (BuildConfig.DEBUG) {
        Log.d(tag, message)
    }
}