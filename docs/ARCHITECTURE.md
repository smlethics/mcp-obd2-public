# Architecture

## Scope

This repository is the standalone public edition of the Android OBD-II reader. It is intentionally independent from private dashboards, infrastructure and repositories.

## Components

- `MainActivity` — Android UI and user-driven diagnostic flow.
- `BluetoothElm327Transport` — Bluetooth Classic transport for compatible ELM327 adapters.
- `Elm327Session` / `Elm327ResponseParser` — session setup and response normalization.
- `PidDecoder` / `PidReading` — decoding of supported live-data PIDs.
- `DtcDecoder` — decoding of diagnostic trouble-code responses.
- `VinDecoder` — VIN response decoding.
- `DiagnosticReportJson` — local export of diagnostic information.
- `ObdCommandPolicy` — safety boundary for the commands exposed by this public application.

## Safety model

The public edition is read-only by design. It focuses on standard diagnostic queries and does not provide ECU coding, flashing, calibration changes, immobilizer operations or arbitrary command execution.

## Data flow

Android device → paired Bluetooth ELM327 adapter → vehicle OBD-II diagnostic interface → response parser → decoder → on-device UI/report.

No private backend is required by this public edition.

## Configuration

Do not commit local Android SDK paths, credentials, signing keys or environment files. The repository `.gitignore` excludes common sensitive/local artifacts.
