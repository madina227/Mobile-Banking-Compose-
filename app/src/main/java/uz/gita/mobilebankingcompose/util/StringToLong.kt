package uz.gita.mobilebankingcompose.util

import java.text.SimpleDateFormat
import java.util.*

/**
 * Created by Madina Agzamova
 * on 18,January,2023
 **/

private fun stringToLong(date: String): String {
    val f = SimpleDateFormat("dd/MM/yyyy")
    val d: Date = f.parse(date) as Date
    return d.time.toString()
}