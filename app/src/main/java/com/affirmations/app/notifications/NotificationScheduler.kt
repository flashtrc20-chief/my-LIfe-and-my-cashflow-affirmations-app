package com.affirmations.app.notifications

import android.app.AlarmManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.os.SystemClock
import java.util.*

class NotificationScheduler(private val context: Context) {

    fun scheduleNotifications() {
        val alarmManager = context.getSystemService(Context.ALARM_SERVICE) as AlarmManager
        
        // Schedule notifications at 8 AM
        scheduleDailyNotification(alarmManager, 8, 0)
        
        // Schedule interval notifications every 30 minutes during daytime (8 AM - 9 PM)
        for (hour in 8..20) {
            for (minute in 0..30 step 30) {
                if (hour == 8 && minute == 0) continue // Skip first one, already scheduled
                scheduleDailyNotification(alarmManager, hour, minute)
            }
        }
    }

    private fun scheduleDailyNotification(
        alarmManager: AlarmManager,
        hour: Int,
        minute: Int
    ) {
        val calendar = Calendar.getInstance().apply {
            set(Calendar.HOUR_OF_DAY, hour)
            set(Calendar.MINUTE, minute)
            set(Calendar.SECOND, 0)
        }

        // If the time has already passed today, schedule for tomorrow
        if (calendar.timeInMillis <= System.currentTimeMillis()) {
            calendar.add(Calendar.DAY_OF_MONTH, 1)
        }

        val intent = Intent(context, AffirmationReceiver::class.java)
        val pendingIntent = PendingIntent.getBroadcast(
            context,
            (hour * 100 + minute).toInt(),
            intent,
            PendingIntent.FLAG_UPDATE_CURRENT or PendingIntent.FLAG_IMMUTABLE
        )

        try {
            alarmManager.setAndAllowWhileIdle(
                AlarmManager.RTC_WAKEUP,
                calendar.timeInMillis,
                pendingIntent
            )
        } catch (e: SecurityException) {
            e.printStackTrace()
        }
    }

    fun cancelAllNotifications() {
        val alarmManager = context.getSystemService(Context.ALARM_SERVICE) as AlarmManager
        for (hour in 8..20) {
            for (minute in 0..30 step 30) {
                val intent = Intent(context, AffirmationReceiver::class.java)
                val pendingIntent = PendingIntent.getBroadcast(
                    context,
                    (hour * 100 + minute).toInt(),
                    intent,
                    PendingIntent.FLAG_UPDATE_CURRENT or PendingIntent.FLAG_IMMUTABLE
                )
                alarmManager.cancel(pendingIntent)
            }
        }
    }
}
