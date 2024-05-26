package com.example.intentstest.websearch.domain

import android.app.SearchManager
import android.content.Context
import android.content.Intent

fun searchWeb(context: Context, query: String) {
    val intent = Intent(Intent.ACTION_WEB_SEARCH).apply {
        putExtra(SearchManager.QUERY, query)
    }
    if (intent.resolveActivity(context.packageManager) != null) {
        context.startActivity(intent)
    }
}