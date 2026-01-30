package com.affirmations.app

import android.app.Application
import com.affirmations.app.notifications.NotificationScheduler
import com.google.firebase.FirebaseApp

class AffirmationsApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        
        // Initialize Firebase
        FirebaseApp.initializeApp(this)
        
        // Schedule notifications
        val scheduler = NotificationScheduler(this)
        scheduler.scheduleNotifications()
    }
}
