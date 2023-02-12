package com.example.eggboilder

import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import androidx.core.app.NotificationCompat

private const val CHANNEL_ID = "BOILED_CHANNEL_ID"
private const val CHANNEL_NAME = "BOILED"

fun createNotification(context: Context, title: String, message: String) {
    val notificationManager =
        context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

    val channel = NotificationChannel(CHANNEL_ID, CHANNEL_NAME, NotificationManager.IMPORTANCE_HIGH)
    notificationManager.createNotificationChannel(channel)

    val builder = NotificationCompat.Builder(context, CHANNEL_ID)
        .setSmallIcon(R.drawable.egg)
        .setContentTitle(title)
        .setContentText(message)
        .setPriority(NotificationCompat.PRIORITY_MAX)

    notificationManager.notify(0, builder.build())
}
