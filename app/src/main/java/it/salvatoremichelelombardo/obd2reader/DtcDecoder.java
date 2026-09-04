package it.salvatoremichelelombardo.obd2reader;
import java.util.*;
public final class DtcDecoder {
 private DtcDecoder(){}
 public static String decodePair(int a,int b){char system="PCBU".charAt((a>>6)&3);int d1=(a>>4)&3;return ""+system+d1+Integer.toHexString(a&15).toUpperCase(Locale.ROOT)+String.format(Locale.ROOT,"%02X",b);}
 public static List<String> decodeResponse(String response){String h=response.replaceAll("[^0-9A-Fa-f]","").toUpperCase(Locale.ROOT);int marker=-1;for(String m:new String[]{"43","47","4A"}){int x=h.indexOf(m);if(x>=0){marker=x;break;}}if(marker<0)return Collections.emptyList();h=h.substring(marker+2);List<String>out=new ArrayList<>();for(int i=0;i+3<h.length();i+=4){int a=Integer.parseInt(h.substring(i,i+2),16),b=Integer.parseInt(h.substring(i+2,i+4),16);if(a==0&&b==0)continue;out.add(decodePair(a,b));}return out;}
}
