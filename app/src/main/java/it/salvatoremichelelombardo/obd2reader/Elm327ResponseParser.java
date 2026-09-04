package it.salvatoremichelelombardo.obd2reader;
import java.util.*;
public final class Elm327ResponseParser {
 private Elm327ResponseParser(){}
 public static String normalize(String raw){ if(raw==null)return ""; String cleaned=raw.replace(">","").replace('\n','\r').toUpperCase(Locale.ROOT); StringBuilder out=new StringBuilder(); for(String p:cleaned.split("\\r+")){String line=p.trim().replaceAll("\\s+"," "); if(line.isEmpty()||line.equals("SEARCHING...")||line.matches("AT[A-Z0-9]+")||line.matches("0[12379A][0-9A-F]{0,4}"))continue; if(out.length()>0)out.append('\n');out.append(line);} return out.toString(); }
}
