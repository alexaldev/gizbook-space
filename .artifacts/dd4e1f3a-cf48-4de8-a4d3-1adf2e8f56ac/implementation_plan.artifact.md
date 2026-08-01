# Fix Unresolved reference 'kotlinOptions'

The project is using **Android Gradle Plugin (AGP) 9.3.1**, which introduces built-in Kotlin support and removes the `android.kotlinOptions` DSL block. This causes the sync error `Unresolved reference 'kotlinOptions'`.

## Proposed Changes

### Build Configuration

#### [MODIFY] [app/build.gradle.kts](file:///home/pesimatik/AndroidStudioProjects/AndroidTemplate/app/build.gradle.kts)
- Remove the `kotlinOptions` block inside the `android` extension.
- Ensure `compileOptions` remains configured with `JavaVersion.VERSION_17` to allow AGP to automatically sync the Kotlin JVM target.

## Verification Plan

### Manual Verification
- Perform a Gradle Sync to ensure the "Unresolved reference" error is resolved.
- Verify that the project builds successfully.
