@file:OptIn(ExperimentalMaterial3Api::class, ExperimentalMaterial3Api::class)

package com.example.intentstest

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import com.example.intentstest.call.domain.dialPhoneNumber
import com.example.intentstest.camera.domain.camera
import com.example.intentstest.play.domain.playYoutube
import com.example.intentstest.sendto.domain.message
import com.example.intentstest.timer.domain.startTimer
import com.example.intentstest.websearch.domain.searchWeb

@Composable
fun IntentsTestTopAppBar() {
    TopAppBar(
        title = { Text("mobye app") },
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = MaterialTheme.colorScheme.primaryContainer,
            titleContentColor = MaterialTheme.colorScheme.primary,
        )
    )
}

@Composable
fun IntentsTestApp() {
    Scaffold (
        topBar = { IntentsTestTopAppBar() }
    ) { innerPadding ->
        Column (
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxHeight()
                .fillMaxWidth()
        ) {
            val modifier = Modifier.fillMaxWidth(0.75f)
            val context = LocalContext.current
            Button(
                onClick = { startTimer(context, "lmfaooo", 5) },
                modifier = modifier
            ) {
                Text(text = "set a timer in 5s for no reason ⁉️")
            }
            Button(
                onClick = { playYoutube(context, "so_7WcDkjxs") },
                modifier = modifier
            ) {
                Text(text = "wake up ⏰")
            }
            Button(
                onClick = { searchWeb(context, "say gex") },
                modifier = modifier
            ) {
                Text(text = "say what? 👨🏾‍❤️‍💋‍👨🏾")
            }
            Button(
                onClick = { camera(context) },
                modifier = modifier
            ) {
                Text(text = "find the ugly bitches 🫵")
            }
            Button(
                onClick = { dialPhoneNumber(context, "1900561282") },
                modifier = modifier
            ) {
                Text(text = "phone chi tho ngoc 🐰")
            }
            Button(
                onClick = {
                    message(context, "ilysmmmmm")
                },
                modifier = modifier
            ) {
                Text(text = "send love 💌")
            }
        }
    }
}
