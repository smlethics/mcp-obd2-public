# SML OBD2 Bluetooth Reader for Android

Public, standalone Java Android application for **read-only** standard OBD-II diagnostics through a paired Bluetooth ELM327-compatible adapter.

## Features
- Select a bonded Bluetooth Classic ELM327 adapter and connect over RFCOMM/SPP.
- Conservative adapter initialization (`ATZ`, echo/linefeed/spaces off, headers off, auto protocol).
- Standard Mode 01 live data: load, coolant, intake pressure, RPM, speed, intake temperature, MAF, throttle, fuel level and module voltage where supported.
- Mode 02 freeze-frame query.
- Mode 03 stored, Mode 07 pending and Mode 0A permanent DTC reads.
- Mode 09 VIN retrieval.
- JSON diagnostic snapshot sharing.

## Safety by design
The command layer is an allowlist. Mode 04 (clear DTC), Mode 08 actuator control, UDS security access, ECU coding/flashing, immobilizer operations and arbitrary raw commands are rejected before Bluetooth transport. Use only on vehicles you own or are authorized to diagnose.

## Build
JDK 17 + Android SDK 36 + Gradle 9.6: `gradle testDebugUnitTest assembleDebug`.
APK: `app/build/outputs/apk/debug/app-debug.apk`.

## Public-source hygiene
This repository is intentionally standalone. It contains no private dashboard integration, local machine paths, credentials, tokens or private infrastructure configuration. Local Android SDK configuration belongs in `local.properties` and must never be committed.

## Adapter notes
Classic Bluetooth ELM327-compatible adapters using the standard SPP UUID are supported. BLE-only/Wi-Fi adapters are not supported in v1.

Copyright © 2026 Salvatore Michele Lombardo. Released under the MIT License.
