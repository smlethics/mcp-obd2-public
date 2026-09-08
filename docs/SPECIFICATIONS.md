# SML OBD2 Bluetooth Reader — Public Specifications

## 1. Scope

Standalone public Android Java application for read-only standard OBD-II diagnostics through a paired Bluetooth Classic ELM327-compatible adapter.

This specification is derived only from material already public in this repository.

## 2. Supported transport

- Android Java;
- Bluetooth Classic RFCOMM/SPP;
- paired ELM327-compatible adapters;
- conservative adapter initialization;
- BLE-only and Wi-Fi adapters are outside the v1 scope.

## 3. Supported diagnostics

Read-only allowlisted operations:

- Mode 01 live data;
- Mode 02 freeze-frame;
- Mode 03 stored DTC;
- Mode 07 pending DTC;
- Mode 0A permanent DTC;
- Mode 09 VIN;
- JSON diagnostic snapshot sharing.

## 4. Safety boundary

The command layer must reject before Bluetooth transport:

- Mode 04 clear DTC;
- Mode 08 actuator control;
- UDS SecurityAccess;
- ECU coding/flashing;
- immobilizer operations;
- arbitrary raw commands.

Use is limited to vehicles the operator owns or is explicitly authorized to diagnose.

## 5. Data integrity

- unsupported PIDs must not be fabricated;
- malformed/incomplete adapter responses must be handled explicitly;
- DTC/VIN parsing must preserve original meaning;
- errors must be surfaced rather than replaced with simulated data.

## 6. Privacy and repository hygiene

The public repository must remain standalone and must not contain:

- private dashboard/infrastructure references;
- local machine paths;
- credentials or tokens;
- private configuration;
- `local.properties` or local SDK secrets;
- user vehicle data.

## 7. Build criteria

Publicly documented baseline:

- JDK 17;
- Android SDK 36;
- Gradle 9.6;
- `gradle testDebugUnitTest assembleDebug`.

## 8. Completion criteria

1. unit tests pass;
2. debug APK builds;
3. bonded Classic Bluetooth adapter selection works;
4. read-only OBD-II operations work on authorized hardware;
5. blocked commands are rejected before transport;
6. JSON snapshot can be shared;
7. repository remains free of private/internal data.

## 9. Documentation source

The public README and public source tree are authoritative. No private SML chat/project data is used by this specification.
