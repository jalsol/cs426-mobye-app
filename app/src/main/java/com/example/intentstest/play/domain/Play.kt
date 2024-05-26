package com.example.intentstest.play.domain

import android.content.ActivityNotFoundException
import android.content.Context
import android.content.Intent
import android.net.Uri


fun playYoutube(context: Context, id: String) {
    val appIntent = Intent(Intent.ACTION_VIEW, Uri.parse("vnd.youtube:$id"))
    val webIntent = Intent(Intent.ACTION_VIEW, Uri.parse("http://www.youtube.com/watch?v=$id"))
    try {
        context.startActivity(appIntent)
    } catch (ex: ActivityNotFoundException) {
        context.startActivity(webIntent)
    }
}