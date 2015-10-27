package utility;

import java.time.DateTimeException;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

/**
 *This is a utility class for processing dates, and times in the new Java 8+ API
 * It contains methods for parsing dates out of string, formatting dates to strings, and doing math on dates
 * @author zsummers
 */
public class DateUtilitiesPost8 {
    /**
     * this constructor exists to remove the default one
     */
    private DateUtilitiesPost8(){
    }
    
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
    /**
     * This version of the timeOfDay method will return the time of day of the input LocalDateTime
     * @param ldt a LocalDateTime input to have it's time extracted.
     * @return String in the format of hours:Minutes:Seconds.Milliseconds
     */
    public static String timeOfDay(LocalDateTime ldt){
        String now = ldt.format(DateTimeFormatter.ISO_TIME);
        
        return now;
    }
    /**has
     * This method attempts to parse a LocalDateTime from an input string in a format DateTimeFormatter.ISO_DATE_TIME
     * @param in String input of ISO_DATE_TIME
     * @return returns LocalDateTime of the DATE_TIME extracted
     * @throws IllegalArgumentException if the input isn't an ISO_DATE_TIME
     */
    public static LocalDateTime toLocalDateTime(String in)throws IllegalArgumentException{
        LocalDateTime back= null;
        //LocalDate temp = null
        try{
            back = LocalDateTime.parse(in, DateTimeFormatter.ISO_DATE_TIME);
        }catch(Exception e){
//            try{
//                back = LocalDateTime.parse(in, DateTimeFormatter.ISO_TIME);
//            }catch(Exception e2){
//                try{
//                    back = LocalDateTime.parse(in, DateTimeFormatter.ISO_DATE);
//                }catch(Exception e3){
                    //try{
                    //    back = LocalDateTime.parse(in, DateTimeFormatter.ISO_INSTANT);
                    //}catch(Exception e4){
                        throw new IllegalArgumentException(e.getMessage());
                    //}  
                //}
            //}
        }
        return back;
    }
    
//    public static void main(String[] args) {
//        //try{
//        //System.out.println(DateUtilitiesPost8.getTimeInGMT(-19));
//        System.out.println(DateUtilitiesPost8.timeOfDay());
//        //System.out.println(DateUtilitiesPost8.toLocalDateTime());
//        LocalDateTime ldt = LocalDateTime.now();
//        DateTimeFormatter format = DateTimeFormatter.ISO_DATE;
//        System.out.println(format.toFormat());
//        System.out.println(DateUtilitiesPost8.toLocalDateTime(ldt.format(format)));
////        }catch(DateTimeException dte){
////            System.out.println("caught one");
////        }
//    }
}
