# SML OBD2 Bluetooth Reader Public — Specifica canonica

**Repository:** `smlethics/mcp-obd2-public`  
**Visibilità:** PUBLIC  
**Data:** 2026-09-05

## Obiettivo

Applicazione Android Java pubblica e standalone per diagnostica OBD-II standard read-only tramite adattatore Bluetooth Classic ELM327 compatibile.

## Architettura

- Android/Java.
- Bluetooth Classic RFCOMM/SPP.
- inizializzazione conservativa dell'adattatore.
- parser per PID, freeze frame, DTC e VIN standard.
- condivisione snapshot diagnostico JSON.

## Funzioni

- Mode 01 dati live standard;
- Mode 02 freeze-frame;
- Mode 03 DTC memorizzati;
- Mode 07 DTC pending;
- Mode 0A DTC permanenti;
- Mode 09 VIN;
- export snapshot JSON.

## Sicurezza by design

La command layer rifiuta Mode 04 clear DTC, Mode 08 actuator control, UDS SecurityAccess, ECU coding/flashing, immobilizer operations e comandi raw arbitrari. L'uso è limitato a veicoli propri o esplicitamente autorizzati.

## Igiene del repository pubblico

- nessuna integrazione con dashboard/infrastruttura privata;
- nessun path macchina locale;
- nessuna credenziale o token;
- `local.properties` e configurazioni SDK locali fuori dal versionamento.

## Criteri di verifica

1. unit test verdi;
2. build APK riuscita;
3. diagnostica standard read-only funzionante con ELM327 Classic supportato;
4. comandi vietati rifiutati prima del trasporto;
5. snapshot JSON condivisibile;
6. repository pubblico privo di riferimenti privati o secret.

## Fonti della specifica

Specifica derivata esclusivamente dalla documentazione pubblica del repository. Non contiene dettagli recuperati dalle chat private.
