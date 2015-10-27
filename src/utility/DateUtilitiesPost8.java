package utility;

import java.time.DateTimeException;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 *
 * @author zsummers
 */
public class DateUtilitiesPost8 {
    /**
     * This default version of the method will return a ZonedDateTime of now, at GMT-0
     * @return ZonedDateTime instantiated to now, in Greenwich, London, England
     */
    public static ZonedDateTime getTimeInGMT(){
        ZonedDateTime zdt;
        zdt= ZonedDateTime.now(ZoneId.of("GMT"));
        
        return zdt;
    }
    /**
     * This version of the method will return a ZonedDateTime in the time zone at the number of hours input from GMT
     * @param offset any number from -18 to +18 is acceptable
     * @return returns a ZonedDateTime of now, in the you chose
     * @throws DateTimeException if the input int is more than 18 away from 0, DateTimeException will be thrown with message "(input) is too large an int for hours."
     */
    public static ZonedDateTime getTimeInGMT(int offset)throws DateTimeException{
        ZonedDateTime zdt = null;
        try{
            if(offset > -18&&offset < +18){
                zdt= ZonedDateTime.now(ZoneOffset.ofHours(offset));
            }else if (offset > -64800 && offset < +64800){
                zdt= ZonedDateTime.now(ZoneOffset.ofTotalSeconds(offset));
                throw new DateTimeException(offset+" is to large an int for hours.");
            }else{
                zdt = ZonedDateTime.now();
                throw new DateTimeException(offset +" is too large an int for seconds.");
            }
        }catch(DateTimeException dte){
            throw new DateTimeException(dte.getMessage());
        }//finally{
//            if(zdt!=null){
//                return zdt;
//            }
//        }
        return zdt;
        
    }
    /**
     * This method will return the time of day as a String in hr:mn:sc.mil
     * @return String holding time of day in hours:Minutes:Seconds.Milliseconds
     */
    public static String timeOfDay(){
        String now;
        
        LocalDateTime day = LocalDateTime.now();
        now = day.format(DateTimeFormatter.ISO_TIME);
        
        return now;
    }
    
    public static void main(String[] args) {
        //try{
        //System.out.println(DateUtilitiesPost8.getTimeInGMT(-19));
        System.out.println(DateUtilitiesPost8.timeOfDay());
//        }catch(DateTimeException dte){
//            System.out.println("caught one");
//        }
    }
}
