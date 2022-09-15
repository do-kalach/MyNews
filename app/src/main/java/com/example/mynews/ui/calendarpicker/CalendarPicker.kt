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
            val first = SimpleDateFormat("yyyy-MM-dd").format(Date(date.first))
            val second = SimpleDateFormat("yyyy-MM-dd").format(Date(date.second))
            getRangeDate(Pair(first, second))
        }

        datePicker.show(fragmentManager, tag)
    }

}