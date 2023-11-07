package com.pdt.blockchainid.extentionFunction

import android.app.Dialog
import android.content.ActivityNotFoundException
import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.net.Uri
import android.os.Build
import android.provider.Settings
import android.view.Gravity
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.pdt.blockchainid.utils.Constants



fun AppCompatActivity.gotoPolicyLink(){
    try {
        val uri = Uri.parse(Constants.PRIVACY_LINK) // missing 'http://' will cause crashed
        startActivity(Intent(Intent.ACTION_VIEW, uri))
    } catch (e: ActivityNotFoundException) {
        e.printStackTrace()
    }
}
val EditText.textString
    get() = this.text.toString().trim()

//fun AppCompatActivity.requestNotificationPermission(){
//    ActivityCompat.requestPermissions(this, arrayOf(Manifest.permission.POST_NOTIFICATIONS),  Constants.NOTIFICATION_REQUEST_CODE)
//}
//
//
//fun AppCompatActivity.requestStoragePermission(){
//    ActivityCompat.requestPermissions(
//        this,
//        arrayOf(Manifest.permission.READ_EXTERNAL_STORAGE),
//        Constants.STORAGE_REQUEST_CODE)
//}
//
//fun AppCompatActivity.requestCameraPermission(){
//    ActivityCompat.requestPermissions(
//        this,
//        arrayOf(Manifest.permission.CAMERA),
//        Constants.CAMERA_REQUEST_CODE)
//}

fun AppCompatActivity.onCreateNetworkDialog(
    applicationContext: Context?,
    dialog_update_version: Int,
    isCanceledOnTouchOutside: Boolean = false
): Dialog {
    val dialogRate = Dialog(applicationContext!!)
    dialogRate.setContentView(dialog_update_version)
    dialogRate.setCancelable(isCanceledOnTouchOutside)
    dialogRate.window!!.setLayout(
        ViewGroup.LayoutParams.MATCH_PARENT,
        ViewGroup.LayoutParams.WRAP_CONTENT
    )
    dialogRate.window!!.setGravity(Gravity.CENTER.or(Gravity.CENTER_VERTICAL))
    dialogRate.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))

    return dialogRate
}

fun AppCompatActivity.isOverlayPermissionGranted(): Boolean{
    return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
        Settings.canDrawOverlays(this)
    } else {
        true
    }
}

//fun AppCompatActivity.requestAudioPermission(){
//    ActivityCompat.requestPermissions(
//        this,
//        arrayOf(Manifest.permission.RECORD_AUDIO), Constants.AUDIO_REQUEST_CODE)
//}
//
//fun Fragment.requestAudioPermission(){
//    ActivityCompat.requestPermissions(
//        requireActivity(),
//        arrayOf(Manifest.permission.RECORD_AUDIO), Constants.AUDIO_REQUEST_CODE)
//}
//
//fun Fragment.requestStoragePermission(){
//    ActivityCompat.requestPermissions(
//        requireActivity(),
//        arrayOf(Manifest.permission.READ_EXTERNAL_STORAGE), Constants.STORAGE_REQUEST_CODE)
//}

fun AppCompatActivity.hideBottomNavigationBar(){
    window.decorView.systemUiVisibility = (View.SYSTEM_UI_FLAG_LAYOUT_STABLE
            or View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
            or View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
            or View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
            or View.SYSTEM_UI_FLAG_FULLSCREEN
            or View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY)

    val decorView = window.decorView
    decorView.setOnSystemUiVisibilityChangeListener { visibility ->
        // Note that system bars will only be "visible" if none of the
        // LOW_PROFILE, HIDE_NAVIGATION, or FULLSCREEN flags are set.
        if (visibility and View.SYSTEM_UI_FLAG_FULLSCREEN == 0) {
            // TODO: The system bars are visible. Make any desired
            // adjustments to your UI, such as showing the action bar or
            // other navigational controls.
            window.decorView.systemUiVisibility = (View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                    or View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                    or View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                    or View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                    or View.SYSTEM_UI_FLAG_FULLSCREEN
                    or View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY)
        } else {
            // TODO: The system bars are NOT visible. Make any desired
            // adjustments to your UI, such as hiding the action bar or
            // other navigational controls.
        }
    }
}

