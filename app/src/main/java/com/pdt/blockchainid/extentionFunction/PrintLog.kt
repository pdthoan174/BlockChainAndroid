package com.lutech.aiart.extentionFunction

import android.util.Log

fun Any?.printToLog(tag: String = "DEBUG_LOG"){
    Log.d(tag, toString())
}
