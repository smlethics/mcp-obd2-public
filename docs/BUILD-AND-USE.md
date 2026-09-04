# Build and use

## Requirements

- Android Studio with a current Android SDK
- JDK compatible with the Gradle/Android Gradle Plugin versions declared by the project
- Android device with Bluetooth support
- A compatible Bluetooth Classic ELM327 OBD-II adapter

## Build

1. Clone the repository.
2. Open the project in Android Studio.
3. Let Gradle synchronize dependencies.
4. Build the `debug` variant or run the app on an Android device.

GitHub Actions also runs unit tests and builds the debug application on repository changes.

## Use

1. Pair the ELM327 adapter from Android Bluetooth settings.
2. Connect the adapter to a vehicle you own or are authorized to diagnose.
3. Start the app and grant the Bluetooth permissions requested by Android.
4. Select the paired adapter and connect.
5. Run the available read-only diagnostic functions.

## Privacy

Diagnostic data is processed by the application for display/reporting. This public project does not require the author's private infrastructure or credentials.

## Important

OBD-II behavior varies by vehicle, ECU and adapter implementation. Use the software only where you are authorized to access the vehicle and never rely on it as the sole source for safety-critical decisions.
