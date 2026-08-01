# Walkthrough - SDK 37 Upgrade and Dependency Updates

I have upgraded the project to target **Android 17 (SDK 37)** and updated core dependencies to their latest stable versions.

## Changes Made

### Version Catalog
- **[libs.versions.toml](file:///home/pesimatik/AndroidStudioProjects/AndroidTemplate/gradle/libs.versions.toml)**: Updated versions for compatibility with SDK 37:
    - `agp = "9.3.1"`
    - `kotlin = "2.4.10"`
    - `coreKtx = "1.19.0"`
    - `lifecycle = "2.11.0"`
    - `composeBom = "2026.06.01"`
    - `koin = "4.2.2"`
    - `mockk = "1.14.11"`
    - `junit5 = "6.1.2"`

### App Module Configuration
- **[app/build.gradle.kts](file:///home/pesimatik/AndroidStudioProjects/AndroidTemplate/app/build.gradle.kts)**:
    - Set `compileSdk = 37` and `targetSdk = 37`.
    - Upgraded `sourceCompatibility` and `targetCompatibility` to **Java 17**.
    - Cleaned up plugins and dependencies to match the new version catalog.

### Root Build Configuration
- **[build.gradle.kts](file:///home/pesimatik/AndroidStudioProjects/AndroidTemplate/build.gradle.kts)**:
    - Simplified the `plugins` block to avoid redundancy with AGP 9.0+ built-in Kotlin support.

## Verification Results

### Gradle Sync
- **Status**: Successful in the IDE.
- **SDK Target**: Android 17 (API 37).
- **Toolchain**: Java 17.

> [!IMPORTANT]
> The project is now configured to target the latest Android APIs. If you encounter any runtime issues related to Android 17 behavior changes, I recommend using the **Android SDK Upgrade Assistant** in Android Studio.
