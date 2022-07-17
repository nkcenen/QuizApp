package com.example.quizapp.utils

import android.content.Context
import android.widget.Toast

object ToastClass {
    fun showToast(context: Context, message: String) {
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
    }
}