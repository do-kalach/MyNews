package com.example.mynews.ui.calendarpicker

import android.util.Pair
import androidx.fragment.app.FragmentManager
import com.example.mynews.R
import com.google.android.material.datepicker.MaterialDatePicker
import java.text.SimpleDateFormat
import java.util.*

class CalendarPicker {

    operator fun invoke(
        fragmentManager: FragmentManager,
        tag: String,
        getRangeDate: (Pair<String, String>) -> Unit
    ) {

        val datePicker = MaterialDatePicker.Builder
            .dateRangePicker()
            .setInputMode(MaterialDatePicker.INPUT_MODE_CALENDAR)
            .setTheme(R.style.AppTheme)
            .setTitleText("Set range")
            .setPositiveButtonText("Ok")
            .setNegativeButtonText("Cancel")
            .build()

        datePicker.addOnPositiveButtonClickListener { date ->
            val first = date.first.toDateString()
            val second = date.second.toDateString()
            getRangeDate(Pair(first, second))
        }

        datePicker.show(fragmentManager, tag)
    }

}

fun Long.toDateString(dateFormat: String = "yyyy-MM-dd"): String {
    return SimpleDateFormat(dateFormat).format(Date(this))
}