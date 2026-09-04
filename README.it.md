# SML OBD2 Bluetooth Reader per Android

Applicazione Android Java pubblica e autonoma per diagnosi **esclusivamente in lettura** tramite adattatori ELM327 Bluetooth Classic già associati.

## Funzioni
Telemetria OBD-II standard, RPM, velocità, temperature, pressione aspirazione, MAF, carico, throttle, livello carburante e tensione modulo quando supportati; freeze frame; DTC memorizzati/pending/permanenti; VIN; esportazione JSON.

## Protezione della centralina
La policy comandi è una allowlist. Sono bloccati prima del trasporto: Mode 04, Mode 08, UDS security/write, coding, flashing, immobilizer, attuatori e comandi raw arbitrari.

## Compilazione
JDK 17 + Android SDK 36 + Gradle 9.6: `gradle testDebugUnitTest assembleDebug`. APK: `app/build/outputs/apk/debug/app-debug.apk`.

Il repository pubblico non contiene configurazioni della dashboard privata, credenziali, percorsi locali o infrastruttura privata.
