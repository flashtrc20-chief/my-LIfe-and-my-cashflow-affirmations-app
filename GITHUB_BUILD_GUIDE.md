# 🚀 Build Your APK on GitHub Actions

Your GitHub workflow is ready! Follow these steps to build your APK in the cloud.

---

## Step 1: Create GitHub Account (If You Don't Have One)

1. Go to: **https://github.com/signup**
2. Enter email
3. Create password
4. Choose username (e.g., `your-name`)
5. Verify email
6. Done! ✅

---

## Step 2: Create a New Repository

1. **Log in to GitHub**: https://github.com/login
2. Click **+** (top right corner) → **New repository**
3. Fill in:
   - **Repository name**: `affirmations-app` (or any name)
   - **Description**: `Daily affirmations app with Firebase notifications`
   - **Public** or **Private** (choose what you prefer)
   - Check: ✅ **Add a README file**
4. Click **Create repository**

---

## Step 3: Upload Your Project Files

You have **two options:**

### Option A: Upload via GitHub Web Interface (Easiest)

1. **In your new repo**, click **Add file** → **Upload files**
2. **Drag and drop** your MLAMCFA folder contents:
   ```
   - app/
   - gradle/
   - .github/ (the workflow file - IMPORTANT!)
   - build.gradle.kts
   - settings.gradle.kts
   - README.md
   - .gitignore
   ```
3. Don't upload `build/` or `.gradle/` folders (too large)
4. Click **Commit changes**

### Option B: Upload via Git Command Line (Faster)

**On your computer, open PowerShell:**

```powershell
cd "C:\Users\MY COMPUTER\Desktop\MLAMCFA"

# Configure Git (first time only)
git config --global user.email "your-email@gmail.com"
git config --global user.name "Your Name"

# Initialize and push
git init
git add .
git branch -M main
git remote add origin https://github.com/YOUR-USERNAME/affirmations-app.git
git commit -m "Initial commit: Complete affirmations app"
git push -u origin main
```

**Note:** When prompted for password, use a **GitHub Personal Access Token**:
1. GitHub → Settings → Developer settings → Personal access tokens
2. Generate new token
3. Check: ✅ `repo` scope
4. Copy the token
5. Use as password when `git push` prompts

---

## Step 4: Watch GitHub Build Your APK

1. **Go to your repository** on GitHub
2. Click **Actions** tab
3. You should see a workflow running: "Build Android APK"
4. Watch the progress (takes 5-10 minutes)
5. When done, you'll see ✅ **green checkmark**

**What it's doing:**
- Setting up Java 17
- Running Gradle build
- Compiling your Kotlin code
- Creating APK
- Uploading artifact

---

## Step 5: Download Your APK

Once build succeeds:

### Method 1: Download from Artifacts (Easy)

1. **Go to Actions tab** in your repo
2. Click the latest successful build
3. Scroll down to **Artifacts**
4. Click **app-debug** to download
5. Extract the ZIP file
6. You have: `app-debug.apk` ✅

### Method 2: Download from Release (Alternative)

1. **Go to Releases** tab in your repo
2. Click latest release (auto-created by workflow)
3. Download `app-debug.apk`

---

## Step 6: Test Your APK

### Option A: Test on Physical Android Phone

**Requirements:**
- Android phone (API 24+)
- USB cable

**Steps:**
```
1. Enable USB Debugging on phone:
   Settings → About → Build Number (tap 7 times)
   Settings → Developer Options → Enable USB Debugging

2. Connect phone via USB

3. Copy app-debug.apk to phone Downloads folder

4. Open file manager on phone

5. Navigate to Downloads

6. Tap app-debug.apk → Install

7. App appears on home screen!
```

### Option B: Test on Appetize.io (Online Emulator)

**No installation needed!**

```
1. Go to: https://www.appetize.io/

2. Sign up (free)

3. Click "Upload App"

4. Select your app-debug.apk

5. Wait 1-2 minutes for processing

6. Click "Launch"

7. Test in browser! ✅
```

---

## Expected Build Output

### Successful Build
```
✅ Build successful
✅ APK created
✅ File: app-debug.apk
✅ Size: ~50-60 MB
✅ Ready to install!
```

### If Build Fails
- Check the build log (Details section)
- Common issues:
  - Missing google-services.json (check app/ folder)
  - Kotlin syntax error (check source files)
  - Dependency issue (usually resolves on retry)

**If it fails, push again:**
```powershell
git add .
git commit -m "Fix build issue"
git push
```

---

## Automatic Rebuilds

**Every time you push code:**
- GitHub automatically builds a new APK
- New artifact created
- Previous artifacts kept for 30 days

**Perfect for:**
- Testing changes
- Sharing with friends
- Play Store submission

---

## What You Now Have

✅ **GitHub repository** with your complete project  
✅ **GitHub Actions workflow** that builds APKs automatically  
✅ **APK artifacts** ready to download and test  
✅ **Release system** for versioning  

---

## Timeline

```
NOW:          Upload to GitHub (5 min)
THEN:         GitHub builds APK (5-10 min)
THEN:         Download APK (1 min)
THEN:         Test on phone or Appetize (5 min)
RESULT:       Working app! 🎉
```

---

## Quick Reference

| Step | Time | Action |
|------|------|--------|
| Create GitHub account | 2 min | Sign up at github.com |
| Create repository | 2 min | New repo on GitHub |
| Upload project | 5 min | Push files to GitHub |
| GitHub builds APK | 10 min | Automatic (watch Actions tab) |
| Download APK | 1 min | From Artifacts or Release |
| Install on phone | 5 min | Transfer & tap APK |
| Test app | 5 min | Use all features |

**Total time: ~30 minutes** ⏱️

---

## Troubleshooting

### "Build failed"
- Check Action details for error
- Most common: google-services.json missing
- Solution: Ensure it's in `app/` folder
- Push again and rebuild

### "APK not in artifacts"
- Wait for build to complete (green checkmark)
- Scroll down in build details
- Look for "Artifacts" section

### "Can't download from GitHub"
- Try again (sometimes slow)
- Try Release tab instead
- Check internet connection

### "APK won't install on phone"
- Enable "Unknown sources" in phone settings
- Ensure phone API is 24+
- Try different USB cable
- Restart phone

---

## Next Steps

1. ✅ Create GitHub account
2. ✅ Create repository  
3. ✅ Upload project (via web or git)
4. ✅ Wait for build to complete
5. ✅ Download APK
6. ✅ Test on phone or Appetize
7. ✅ Celebrate! 🎉

**Ready?** Let's go! 🚀
