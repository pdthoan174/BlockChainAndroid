package com.lutech.aiart.extentionFunction

import android.app.Activity
import android.content.Context
import android.content.Intent
import androidx.fragment.app.Fragment

fun Activity.startActivityExtension(
    cls: Class<*>,
    finishCallingActivity: Boolean = true,
    block: (Intent.() -> Unit)? = null
){
    val intent = Intent(this, cls)
    block?.invoke(intent)
    startActivity(intent)
    if (finishCallingActivity) finish()
}

fun Fragment.startActivityFromFragment(
    context: Context,
    cls: Class<*>,
    block: (Intent.() -> Unit)? = null
){
//    val intent = Intent(mContext, SearchRingtoneActivity::class.java)
//    startActivity(intent)
    val intent = Intent(context, cls)
    block?.invoke(intent)
    startActivity(intent)
}

