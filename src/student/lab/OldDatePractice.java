package student.lab;

import java.text.SimpleDateFormat;
import java.util.Calendar;
//import java.util.Date;

/**
 *
 * @author zsummers
 */
public class OldDatePractice {
    
    
    public static void main(String[] args) {
        Calendar date = Calendar.getInstance();
        Calendar date2 = Calendar.getInstance();
        date2.add(Calendar.DATE, 30);
        boolean isAfter = date.after(date2);
        System.out.println(isAfter);
        
        
        
        //Calendar start = Calendar.getInstance();
       // Calendar end = Calendar.getInstance();
        //Date end;
        //end.set(2015,Calendar.OCTOBER,23);
        //long startTime = start.getTimeInMillis();
        //long endTime = end.getTimeInMillis();
        //long diffInHrs = (endTime - startTime)/1000/60/60;
        
        //System.out.println(diffInHrs);
        
        
        //Date date1 = new Date();
      //  System.out.println(date1);
        SimpleDateFormat sdf = new SimpleDateFormat(" MM/dd/yyy HH:mm a");
        String formattedDate = sdf.format(date.getTime());
        System.out.println(formattedDate);
       // System.out.println(formattedDate);
       // 
       // Calendar date2 = new GregorianCalendar();
       // formattedDate=sdf.format(date2.getTime());
        //System.out.println(date2);
        //System.out.println(formattedDate);
    }
}
