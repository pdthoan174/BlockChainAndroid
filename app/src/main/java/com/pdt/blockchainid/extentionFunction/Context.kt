package com.lutech.aiart.extentionFunction

import android.Manifest
import android.annotation.SuppressLint
import android.app.Dialog
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.net.Uri
import android.os.Build
import android.provider.Settings
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.google.android.material.bottomsheet.BottomSheetDialog

fun Context.getUrlFromDrawable(res: String): String {
    return "android.resource://$packageName/drawable/$res"
}

fun Context.isStoragePermissionGranted(): Boolean {
    return ContextCompat.checkSelfPermission(this,
        Manifest.permission.READ_EXTERNAL_STORAGE
    ) == PackageManager.PERMISSION_GRANTED
}

fun Context.isAudioPermissionGranted(): Boolean {
    return ContextCompat.checkSelfPermission(this,
        Manifest.permission.RECORD_AUDIO
    ) == PackageManager.PERMISSION_GRANTED
}

fun Context.isCameraPermissionGranted(): Boolean {
    return ContextCompat.checkSelfPermission(this,
        Manifest.permission.CAMERA
    ) == PackageManager.PERMISSION_GRANTED
}

@SuppressLint("ResourceType")
fun Context.onCreateDialog(dialog_update_version: Int, isCanceledOnTouchOutside: Boolean = true
): Dialog {
    val dialogRate = Dialog(this)
    dialogRate.setContentView(dialog_update_version)
    dialogRate.setCanceledOnTouchOutside(isCanceledOnTouchOutside)

//    dialogRate.window?.setBackgroundDrawableResource(R.layout.layout_dialog_rating_app)

    dialogRate.window!!.setLayout(
        ViewGroup.LayoutParams.WRAP_CONTENT,
        ViewGroup.LayoutParams.WRAP_CONTENT
    )

    dialogRate.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
    return dialogRate
}

//fun Context.onCreateBottomSheetDialog(
//    dialog_update_version: Int,
//    isCanceledOnTouchOutside: Boolean = true
//): Dialog {
//    val dialogRate = BottomSheetDialog(this, R.style.BottomSheetDialogStyle)
//    dialogRate.setContentView(dialog_update_version)
//    dialogRate.setCancelable(isCanceledOnTouchOutside)
//
//    dialogRate.window!!.setLayout(
//        ViewGroup.LayoutParams.MATCH_PARENT,
//        ViewGroup.LayoutParams.WRAP_CONTENT
//    )
//    dialogRate.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
//    return dialogRate
//}

fun Context.isNotificationPermissionGranted(): Boolean =
    if(Build.VERSION.SDK_INT < Build.VERSION_CODES.TIRAMISU){
        true
    }else{
        ContextCompat.checkSelfPermission(this, Manifest.permission.POST_NOTIFICATIONS) == PackageManager.PERMISSION_GRANTED
    }

fun Context.showNotice(msg: String)
        = Toast.makeText(this,msg, Toast.LENGTH_SHORT).show()

fun Context.showNotice(msg: Int)
        = Toast.makeText(this,msg, Toast.LENGTH_SHORT).show()