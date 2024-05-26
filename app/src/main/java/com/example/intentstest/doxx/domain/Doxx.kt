package com.example.intentstest.doxx.domain

import android.content.Context
import android.content.Intent
import android.net.Uri

fun doxx(context: Context, geoLocation: Uri) {
    val intent = Intent(Intent.ACTION_VIEW).apply {
        data = geoLocation
    }
    if (intent.resolveActivity(context.packageManager) != null) {
        context.startActivity(intent)
    }
}