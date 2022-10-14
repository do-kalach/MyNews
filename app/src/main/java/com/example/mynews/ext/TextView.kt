package com.example.mynews.ext

import android.widget.TextView

fun TextView.setVisible(visible: Boolean) {
    if (visible) {
        this.apply {
            animate()
                .translationY(0f)
                .alpha(1f)
                .duration = 1000L
        }
    } else
        this.apply {
            animate()
                .translationY(-100f)
                .alpha(0.5f)
                .duration = 1000L
        }
}