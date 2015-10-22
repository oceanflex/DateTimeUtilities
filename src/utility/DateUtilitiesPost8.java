package utility;

import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;

/**
 *
 * @author zsummers
 */
public class DateUtilitiesPost8 {
    /**
     * This default version of the method will return a ZonedDateTime of now, at GMT-0
     * @return 
     */
    public static ZonedDateTime getTimeInGMT(){
        ZonedDateTime zdt;
        zdt= ZonedDateTime.now(ZoneId.of("GMT"));
        
        return zdt;
    }
    /*
    
    */
    public static ZonedDateTime getTimeInGMT(int offset){
        ZonedDateTime zdt;
        zdt= ZonedDateTime.now(ZoneId.ofOffset("GMT", ZoneOffset.ofHours(offset)));
        
        return zdt;
    }
    
    public static void main(String[] args) {
        System.out.println(DateUtilitiesPost8.getTimeInGMT(-5));
    }
}
