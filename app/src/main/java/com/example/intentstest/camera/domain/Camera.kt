package com.example.intentstest.camera.domain

import android.content.Context
import android.content.Intent
import android.provider.MediaStore

fun camera(context: Context) {
    val intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE).apply {
        putExtra("android.intent.extras.LENS_FACING_FRONT", 1)
        putExtra("android.intent.extras.CAMERA_FACING", 1)
        putExtra("android.intent.extra.USE_FRONT_CAMERA", true)
    }
    if (intent.resolveActivity(context.packageManager) != null) {
        context.startActivity(intent)
    }
}