package it.salvatoremichelelombardo.obd2reader;
import android.bluetooth.*; import java.io.*; import java.nio.charset.StandardCharsets; import java.util.UUID;
public final class BluetoothElm327Transport implements Elm327Transport {
 private static final UUID SPP=UUID.fromString("00001101-0000-1000-8000-00805F9B34FB"); private final BluetoothDevice device; private BluetoothSocket socket; private InputStream in; private OutputStream out;
 public BluetoothElm327Transport(BluetoothDevice device){this.device=device;}
 public void connect() throws IOException {try{socket=device.createRfcommSocketToServiceRecord(SPP);socket.connect();in=socket.getInputStream();out=socket.getOutputStream();}catch(SecurityException e){throw new IOException("Bluetooth permission denied",e);}}
 public String exchange(String command,long timeoutMs)throws IOException{if(!isConnected())throw new IOException("Not connected");out.write((command+"\r").getBytes(StandardCharsets.US_ASCII));out.flush();long end=System.currentTimeMillis()+timeoutMs;StringBuilder s=new StringBuilder();while(System.currentTimeMillis()<end){while(in.available()>0){int c=in.read();if(c<0)break;s.append((char)c);if(c=='>')return s.toString();}try{Thread.sleep(20);}catch(InterruptedException e){Thread.currentThread().interrupt();throw new IOException("Interrupted",e);}}throw new IOException("ELM327 timeout");}
 public boolean isConnected(){return socket!=null&&socket.isConnected();}
 public void close(){try{if(socket!=null)socket.close();}catch(IOException ignored){}socket=null;in=null;out=null;}
}
