# Bump targetSdk to 37 and update dependencies

The user wants to upgrade the project to target Android 17 (API level 37) and perform all necessary updates to libraries and build configuration.

## User Review Required

> [!IMPORTANT]
> - Bumping `targetSdk` to 37 (Android 17) requires using the latest Android Studio and AGP.
> - I am upgrading `compileOptions` and `kotlinOptions` to Java 17, which is the recommended version for modern Android development.
> - Some libraries are being updated to their latest stable versions to ensure compatibility with higher API levels.

## Proposed Changes

### Build Configuration

#### [MODIFY] [libs.versions.toml](file:///home/pesimatik/AndroidStudioProjects/AndroidTemplate/gradle/libs.versions.toml)
- Update `agp` to `9.3.1`.
- Update `kotlin` to `2.4.10`.
- Update `coreKtx` to `1.19.0`.
- Update `activityKtx` to `1.13.0`.
- Update `lifecycleViewModel` and `lifecycleLiveData` to `2.11.0`.
- Update `composeBom` to `2026.06.01`.
- Update `koin` to `4.2.2`.

#### [MODIFY] [app/build.gradle.kts](file:///home/pesimatik/AndroidStudioProjects/AndroidTemplate/app/build.gradle.kts)
- Set `compileSdk = 37`.
- Set `targetSdk = 37`.
- Update `sourceCompatibility`, `targetCompatibility` to `JavaVersion.VERSION_17`.
- Add `kotlinOptions { jvmTarget = "17" }`.

## Verification Plan

### Automated Tests
- Run Gradle Sync to ensure all dependencies are resolved.
- Run `./gradlew assembleDebug` to verify the project builds with the new SDK.

### Manual Verification
- Verify the `build.gradle.kts` files reflect the new SDK and Java versions.
