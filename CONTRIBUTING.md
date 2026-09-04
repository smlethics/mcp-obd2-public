# Contributing

Keep all vehicle interaction read-only. Every new OBD command must be explicitly classified and unit-tested before transport support is added. Run `gradle testDebugUnitTest assembleDebug` before a pull request. Never commit real VINs, identifiers, credentials, private vehicle captures, local paths or private infrastructure references.
