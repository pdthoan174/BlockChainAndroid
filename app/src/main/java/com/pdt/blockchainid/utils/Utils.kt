package com.pdt.blockchainid.utils

import android.animation.Animator
import android.animation.ObjectAnimator
import android.app.Activity
import android.content.ActivityNotFoundException
import android.content.Context
import android.content.Intent
import android.content.res.Configuration
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.drawable.BitmapDrawable
import android.net.ConnectivityManager
import android.net.NetworkInfo
import android.net.Uri
import android.os.Handler
import android.util.Log
import android.view.View
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.ImageView
import com.pdt.blockchainid.R
import java.io.File
import java.io.FileOutputStream
import java.io.IOException
import java.util.Locale

object Utils {

    //animation move  left to right and repeat
    fun setIsRating(context: Context) {
        val sharePef = context.getSharedPreferences(Constants.APP_NAME, Activity.MODE_PRIVATE)
        val editor = sharePef.edit()
        editor.putBoolean(Constants.KEY_IS_RATING, true)
        editor.apply()
    }

    fun goToCHPlay(context: Context) {
        val appPackageName: String =
            context.packageName // getPackageName() from Context or Activity object
        try {
            context.startActivity(
                Intent(
                    Intent.ACTION_VIEW,
                    Uri.parse("market://details?id=$appPackageName")
                )
            )
        } catch (anfe: ActivityNotFoundException) {
            context.startActivity(
                Intent(
                    Intent.ACTION_VIEW,
                    Uri.parse("https://play.google.com/store/apps/details?id=$appPackageName")
                )
            )
        }
    }



    fun getIOSCountryData(context: Context): String {
        val sharePef = context.getSharedPreferences(Constants.APP_NAME, Activity.MODE_PRIVATE)
        return sharePef.getString(Constants.KEY_LANG, "en").toString()
    }

    fun setIOSCountryData(lang: String, context: Context) {
        val sharePef = context.getSharedPreferences(Constants.APP_NAME, Activity.MODE_PRIVATE)
        val editor = sharePef.edit()
        editor.putString(Constants.KEY_LANG, lang)
        editor.apply()
    }

    fun setLanguageForApp(context: Context) {
        val languageToLoad = getIOSCountryData(context)
        val locale: Locale = if (languageToLoad == "not-set") {
            Locale.getDefault()
        } else {
            Locale(languageToLoad)
        }
        Locale.setDefault(locale)
        val config = Configuration()
        config.locale = locale
        context.resources.updateConfiguration(
            config,
            context.resources.displayMetrics
        )
    }

    fun isGetLanguage(context: Context): Boolean {
        val sharePef = context.getSharedPreferences(Constants.APP_NAME, Activity.MODE_PRIVATE)
        return sharePef.getBoolean(Constants.IS_SET_LANG, false)
    }

    fun isSetLanguage(context: Context) {
        val sharePef = context.getSharedPreferences(Constants.APP_NAME, Activity.MODE_PRIVATE)
        val editor = sharePef.edit()
        editor.putBoolean(Constants.IS_SET_LANG, true)
        editor.apply()
    }

    fun getBitmapFromImageView(imageView: ImageView): Bitmap? {
        val drawable = imageView.drawable
        if (drawable is BitmapDrawable) {
            return drawable.bitmap
        }
        return null
    }

    fun setCurrentFlag(flag: Int, context: Context) {
        val sharePef = context.getSharedPreferences(Constants.APP_NAME, Activity.MODE_PRIVATE)
        val editor = sharePef.edit()
        editor.putInt(Constants.KEY_FLAG, flag)
        editor.apply()
    }

    fun getImageDimensions(context: Context, imageUri: Uri): Pair<Int, Int>? {
        try {
            val inputStream = context.contentResolver.openInputStream(imageUri)

            // Decode the input stream to get the image dimensions without loading the full image into memory
            val options = BitmapFactory.Options().apply {
                inJustDecodeBounds = true // This prevents loading the full image into memory
            }
            BitmapFactory.decodeStream(inputStream, null, options)

            // Close the input stream
            inputStream?.close()

            // Retrieve the image dimensions from the options
            val width = options.outWidth
            val height = options.outHeight

            // Return the width and height as a Pair
            return Pair(width, height)
        } catch (e: Exception) {
            e.printStackTrace()
            return null
        }
    }

    fun saveImageToCache(context: Context, imageUri: Uri): Uri? {
        try {
            // Open an input stream to read the image from the URI
            val inputStream = context.contentResolver.openInputStream(imageUri)

            // Generate a unique file name for the cached image (e.g., using a timestamp)
            val fileName = "cached_image_${System.currentTimeMillis()}.jpg"

            // Define the cache directory
            val cacheDir = context.cacheDir

            // Create a File object in the cache directory
            val outputFile = File(cacheDir, fileName)

            // Create an output stream to write the image to the cache directory
            val outputStream = FileOutputStream(outputFile)

            // Set up a buffer to read/write the data in chunks
            val buffer = ByteArray(1024)
            var bytesRead: Int

            // Copy the image data from the input stream to the cache directory
            while (inputStream?.read(buffer).also { bytesRead = it!! } != -1) {
                outputStream.write(buffer, 0, bytesRead)
            }

            // Close the streams
            inputStream?.close()
            outputStream.close()

            // Return the URI of the saved image in the cache directory
            return Uri.fromFile(outputFile)
        } catch (e: IOException) {
            e.printStackTrace()
            return null
        }
    }
}