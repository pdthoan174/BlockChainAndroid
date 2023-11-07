package com.lutech.aiart.extentionFunction

import android.app.Activity
import android.widget.Toast
import androidx.annotation.StringRes
import androidx.fragment.app.Fragment

fun Fragment.toast(message: String){
    Toast.makeText(requireContext(), message, Toast.LENGTH_SHORT).show()
}

fun Fragment.toast(@StringRes message: Int){
    Toast.makeText(requireContext(), message, Toast.LENGTH_SHORT).show()
}

fun Activity.toast(message: String){
    Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
}

fun Activity.toast(@StringRes message: Int){
    Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
}