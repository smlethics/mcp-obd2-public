package it.salvatoremichelelombardo.obd2reader;
import java.io.IOException;
public interface Elm327Transport { void connect() throws IOException; String exchange(String command,long timeoutMs) throws IOException; void close(); boolean isConnected(); }
