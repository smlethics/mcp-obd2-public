package it.salvatoremichelelombardo.obd2reader;
import java.util.*;
public final class ObdCommandPolicy {
    private static final Set<String> SAFE_AT=new HashSet<>(Arrays.asList("ATZ","ATE0","ATL0","ATS0","ATH0","ATSP0","ATI","ATDP","ATRV"));
    private ObdCommandPolicy(){}
    public static boolean isAllowed(String command){ if(command==null)return false; String c=command.replaceAll("\\s+","").toUpperCase(Locale.ROOT); if(SAFE_AT.contains(c))return true; if(!c.matches("[0-9A-F]+"))return false; if(c.equals("03")||c.equals("07")||c.equals("0A"))return true; if(c.startsWith("01"))return c.length()==4; if(c.startsWith("02"))return c.length()==4||c.length()==6; if(c.startsWith("09"))return c.length()==4; return false; }
}
