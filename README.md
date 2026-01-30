# Affirmations App - Android

A native Android app that delivers daily affirmations through timed notifications, with multiple collections and one-time purchase model.

## Features

- **Daily Affirmations**: Get affirmation reminders throughout the day
- **Timed Notifications**: Receive notifications every 20-30 minutes during daytime (8 AM - 9 PM)
- **Multiple Collections**: Access different affirmation categories
- **Firebase Backend**: Cloud-based content management
- **One-time Purchase**: Buy once, access all content
- **Monthly Updates**: New affirmations released the first week of each month

## Tech Stack

- **Language**: Kotlin
- **UI**: Jetpack Compose
- **Backend**: Firebase (Firestore, Auth, Storage)
- **Notifications**: Android AlarmManager + BroadcastReceiver
- **Build**: Gradle KTS

## Project Structure

```
app/
├── src/main/
│   ├── java/com/affirmations/app/
│   │   ├── MainActivity.kt
│   │   ├── AffirmationsApplication.kt
│   │   ├── screens/
│   │   │   └── HomeScreen.kt
│   │   ├── notifications/
│   │   │   ├── NotificationScheduler.kt
│   │   │   └── AffirmationReceiver.kt
│   │   ├── data/
│   │   │   └── FirebaseRepository.kt
│   │   └── ui/theme/
│   │       └── Theme.kt
│   ├── AndroidManifest.xml
│   └── res/
├── build.gradle.kts
```

## Setup Instructions

### Prerequisites

- Android Studio 2023.1 or higher
- JDK 11+
- Android SDK 24+

### Firebase Setup

1. Create a Firebase project at [firebase.google.com](https://firebase.google.com)
2. Add Android app to your Firebase project
3. Download `google-services.json` and place it in `app/` directory
4. Enable:
   - Firestore Database
   - Firebase Authentication
   - Firebase Cloud Storage

### Building

```bash
# Clone/open project in Android Studio
# Build the project
./gradlew build

# Run on emulator or device
./gradlew installDebug
```

## Firebase Firestore Structure

```
collections/
├── {collectionId}
│   ├── name: string
│   ├── description: string
│   ├── releasedDate: timestamp
│   └── affirmations: array

daily_affirmations/
├── today
│   ├── title: string
│   ├── paragraphs: array[string]
│   └── order: number
```

## Content Management

### Uploading New Collections

1. Format your PDF affirmations into JSON structure
2. Upload to Firebase Firestore via Firebase Console or admin SDK
3. App automatically syncs new content

### Monthly Releases

Schedule releases for the first week of each month through Firebase Console or automated scripts.

## Notification System

- **First Notification**: 8:00 AM - "Have you affirmed today?"
- **Subsequent Notifications**: Every 30 minutes until 9:00 PM
- **Smart Scheduling**: Uses AlarmManager with `setAndAllowWhileIdle()` for reliability
- **Respects DND**: Honors device Do Not Disturb settings

## Next Steps

1. **Set up Firebase**: Configure Firestore and upload your affirmation content
2. **Customize UI**: Update colors and branding in `Theme.kt`
3. **Add Payment Integration**: Implement Google Play Billing for one-time purchase
4. **Test Notifications**: Test on Android emulator or real device
5. **Deploy to Play Store**: Prepare app signing and store listing

## Notes

- App requires Android 7.0+ (API 24)
- Notifications require Android 13+ permission request
- Content is stored in Firestore, keeping app size minimal
- Monthly updates sync automatically when user opens app

---

**Version**: 1.0.0
**Last Updated**: January 2026
