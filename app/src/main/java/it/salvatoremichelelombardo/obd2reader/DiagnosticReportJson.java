package it.salvatoremichelelombardo.obd2reader;
import java.util.*;
public final class DiagnosticReportJson {
 private DiagnosticReportJson(){}
 public static String serialize(String vin,Map<String,PidReading> readings,List<String> dtcs,String freezeFrame){StringBuilder s=new StringBuilder("{");field(s,"timestamp",new Date().toInstant().toString(),true);field(s,"vin",vin,true);s.append("\"readings\":{");int n=0;for(Map.Entry<String,PidReading>e:readings.entrySet()){if(n++>0)s.append(',');quote(s,e.getKey());s.append(":{");field(s,"label",e.getValue().getLabel(),true);s.append("\"value\":").append(e.getValue().getValue()).append(',');field(s,"unit",e.getValue().getUnit(),false);s.append('}');}s.append("},\"dtcs\":[");for(int i=0;i<dtcs.size();i++){if(i>0)s.append(',');quote(s,dtcs.get(i));}s.append("],");field(s,"freezeFrameRaw",freezeFrame,false);return s.append('}').toString();}
 private static void field(StringBuilder s,String k,String v,boolean comma){quote(s,k);s.append(':');quote(s,v==null?"":v);if(comma)s.append(',');}
 private static void quote(StringBuilder s,String v){s.append('"');for(char c:v.toCharArray()){if(c=='"'||c=='\\')s.append('\\');if(c=='\n')s.append("\\n");else if(c!='\r')s.append(c);}s.append('"');}
}
