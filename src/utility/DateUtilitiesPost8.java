package utility;

import java.time.DateTimeException;
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
    public static ZonedDateTime getTimeInGMT(int offset)throws DateTimeException{
        ZonedDateTime zdt = null;
        try{
            if(offset > -18&&offset < +18){
                zdt= ZonedDateTime.now(ZoneOffset.ofHours(offset));
            }else if (offset > -64800 && offset < +64800){
                zdt= ZonedDateTime.now(ZoneOffset.ofTotalSeconds(offset));
                throw new DateTimeException(offset+" is to large an int for hours, assuming seconds");
            }else{
                throw new DateTimeException(offset +" is too large an int for seconds, using default of now.");
            }
        }catch(DateTimeException dte){
            throw new DateTimeException(dte.getMessage());
        }finally{
            if(zdt!=null){
                return zdt;
            }
        }
        return zdt;
        
    }
    
    public static void main(String[] args) {
        //try{
        System.out.println(DateUtilitiesPost8.getTimeInGMT(-64999));
//        }catch(DateTimeException dte){
//            System.out.println("caught one");
//        }
    }
}
