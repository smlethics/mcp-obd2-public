package it.salvatoremichelelombardo.obd2reader;
import java.util.*;
public final class PidDecoder {
 private PidDecoder(){}
 public static PidReading decode(String command,String response){String c=command.replaceAll("\\s+","").toUpperCase(Locale.ROOT);String pid=c.substring(2,4);int[] b=bytes(response);int start=findPid(b,Integer.parseInt(pid,16));if(start<0)throw new IllegalArgumentException("PID response not found");int a=b[start+2],bb=start+3<b.length?b[start+3]:0;switch(pid){case"04":return new PidReading(pid,"Engine load",a*100.0/255.0,"%");case"05":return new PidReading(pid,"Coolant",a-40,"°C");case"0B":return new PidReading(pid,"Intake pressure",a,"kPa");case"0C":return new PidReading(pid,"RPM",(a*256+bb)/4.0,"rpm");case"0D":return new PidReading(pid,"Speed",a,"km/h");case"0F":return new PidReading(pid,"Intake air",a-40,"°C");case"10":return new PidReading(pid,"MAF",(a*256+bb)/100.0,"g/s");case"11":return new PidReading(pid,"Throttle",a*100.0/255.0,"%");case"2F":return new PidReading(pid,"Fuel level",a*100.0/255.0,"%");case"42":return new PidReading(pid,"Control voltage",(a*256+bb)/1000.0,"V");default:throw new IllegalArgumentException("Unsupported PID "+pid);} }
 private static int[] bytes(String s){String h=s.replaceAll("[^0-9A-Fa-f]","");if((h.length()&1)==1)throw new IllegalArgumentException("Malformed hex");int[]o=new int[h.length()/2];for(int i=0;i<o.length;i++)o[i]=Integer.parseInt(h.substring(i*2,i*2+2),16);return o;}
 private static int findPid(int[]b,int pid){for(int i=0;i+2<b.length;i++)if((b[i]==0x41||b[i]==0x42)&&b[i+1]==pid)return i;return-1;}
}
