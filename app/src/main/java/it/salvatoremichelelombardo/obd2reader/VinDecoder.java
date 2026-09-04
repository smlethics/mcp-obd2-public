package it.salvatoremichelelombardo.obd2reader;
import java.util.*;
public final class VinDecoder {
 private VinDecoder(){}
 public static String decodeAscii(String hex){String h=hex.replaceAll("[^0-9A-Fa-f]","");StringBuilder s=new StringBuilder();for(int i=0;i+1<h.length();i+=2){int v=Integer.parseInt(h.substring(i,i+2),16);if(v>=32&&v<=126)s.append((char)v);}return s.toString();}
 public static String decodeMode09(String response){StringBuilder payload=new StringBuilder();for(String line:response.split("\\n")){String h=line.replaceAll("[^0-9A-Fa-f]","").toUpperCase(Locale.ROOT);int p=h.indexOf("4902");if(p>=0){String after=h.substring(p+4);if(after.length()>=2)after=after.substring(2);payload.append(after);}}String vin=decodeAscii(payload.toString());return vin.length()>17?vin.substring(0,17):vin;}
}
