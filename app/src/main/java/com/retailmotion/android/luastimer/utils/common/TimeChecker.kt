package com.retailmotion.android.luastimer.utils.common

import java.util.*

object TimeChecker {

    const val TAG = "TimeChecker"

    fun checkCurrentTime(): Boolean {

        val startOfDay = Calendar.getInstance()
        startOfDay.set(Calendar.HOUR_OF_DAY, 0)
        startOfDay.set(Calendar.MINUTE, 0)
        startOfDay.set(Calendar.SECOND, 0)

        val midOfDay = Calendar.getInstance()
        midOfDay.set(Calendar.HOUR_OF_DAY, 12)
        midOfDay.set(Calendar.MINUTE, 1)
        midOfDay.set(Calendar.SECOND, 59)

        val timeOfDay = Calendar.getInstance()

        return timeOfDay.between(startOfDay, midOfDay)

    }

    private fun Calendar.between(first: Calendar, second: Calendar): Boolean {
        return after(first) && before(second)

    }


}
