# [CS426] Exercise 02: Common Intents

Authors:
- 22125113 - Nguyen Quang Truong
- 22125043 - Khuong Nhan Kiet

## Demo
Watch our demo here: https://www.youtube.com/watch?v=n8djpTL7ISc

## Common Intents
There are 6 common intents corresponding to each of the buttons in our application.

### 1. `android.intent.action.SET_TIMER`
To invoke this intent, the app has to set the `SET_ALARM` permission via:

```xml
<uses-permission android:name="com.android.alarm.permission.SET_ALARM" />
```

The following function, used to invoke the intent, is located at `timer/domain/Timer.kt`:

```kt
fun startTimer(context: Context, message: String, seconds: Int) {
    val intent = Intent(AlarmClock.ACTION_SET_TIMER).apply {
        putExtra(AlarmClock.EXTRA_MESSAGE, message)
        putExtra(AlarmClock.EXTRA_LENGTH, seconds)
        putExtra(AlarmClock.EXTRA_SKIP_UI, true)
    }
    if (intent.resolveActivity(context.packageManager) != null) {
        context.startActivity(intent)
    }
}
```

### 2. `android.intent.action.VIEW`

The following function, used to invoke the intent, is located at `play/domain/Play.kt`:

```kt
fun playYoutube(context: Context, id: String) {
    val appIntent = Intent(Intent.ACTION_VIEW, Uri.parse("vnd.youtube:$id"))
    val webIntent = Intent(Intent.ACTION_VIEW, Uri.parse("http://www.youtube.com/watch?v=$id"))
    try {
        context.startActivity(appIntent)
    } catch (ex: ActivityNotFoundException) {
        context.startActivity(webIntent)
    }
}
```

### 3. `android.intent.action.WEB_SEARCH`

The following function, used to invoke the intent, is located at `websearch/domain/WebSearch.kt`:

```kt
fun searchWeb(context: Context, query: String) {
    val intent = Intent(Intent.ACTION_WEB_SEARCH).apply {
        putExtra(SearchManager.QUERY, query)
    }
    if (intent.resolveActivity(context.packageManager) != null) {
        context.startActivity(intent)
    }
}
```

### 4. `android.media.action.IMAGE_CAPTURE`

The following function, used to invoke the intent, is located at `camera/domain/Camera.kt`:

```kt
fun camera(context: Context) {
    val intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE).apply {
        // all of these attempt to open the front camera
        putExtra("android.intent.extras.LENS_FACING_FRONT", 1)
        putExtra("android.intent.extras.CAMERA_FACING", 1)
        putExtra("android.intent.extra.USE_FRONT_CAMERA", true)
    }
    if (intent.resolveActivity(context.packageManager) != null) {
        context.startActivity(intent)
    }
}
```

### 5. `android.intent.action.DIAL`
To invoke this intent, the app has to set the `CALL_PHONE` permission via:

```xml
<uses-feature android:name="android.hardware.telephony" android:required="false" />

<uses-permission android:name="android.permission.CALL_PHONE" />
```

The following function, used to invoke the intent, is located at `call/domain/Call.kt`:

```kt
fun dialPhoneNumber(context: Context, phoneNumber: String) {
    val intent = Intent(Intent.ACTION_DIAL).apply {
        data = Uri.parse("tel:$phoneNumber")
    }
    if (intent.resolveActivity(context.packageManager) != null) {
        context.startActivity(intent)
    }
}
```

### 6. `android.intent.action.SEND`

The following function, used to invoke the intent, is located at `sendto/domain/ComposeMail.kt`:

```kt
fun message(context: Context, content: String) {
    val intent = Intent(Intent.ACTION_SEND).apply {
        type = "text/plain"
        putExtra(Intent.EXTRA_TEXT, content)
    }
    if (intent.resolveActivity(context.packageManager) != null) {
        context.startActivity(intent)
    }
}
```
