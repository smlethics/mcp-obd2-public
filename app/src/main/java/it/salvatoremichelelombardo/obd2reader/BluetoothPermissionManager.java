package it.salvatoremichelelombardo.obd2reader;
import java.util.*;
public final class BluetoothPermissionManager { private BluetoothPermissionManager(){} public static List<String> requiredRuntimePermissions(int sdk){ return sdk>=31?Collections.singletonList("android.permission.BLUETOOTH_CONNECT"):Collections.emptyList(); } }
