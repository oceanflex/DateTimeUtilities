package student.lab;

import java.time.LocalDate;

/**
 *
 * @author zsummers
 */
public class DateUtilites {
    
    public LocalDate dateFromStringMonthDayYear(String in){
        LocalDate back;
        String[] monthDayYear = new String[3];
        if(in.indexOf('/')!=-1&&in.indexOf('/')!=in.lastIndexOf('/')){
            monthDayYear[0] = in.substring(0, in.indexOf('/'));
            monthDayYear[1] = in.substring(in.indexOf('/')+1, in.lastIndexOf('/'));
            monthDayYear[2] = in.substring(in.lastIndexOf('/')+1, in.length());
        }else if(in.indexOf('.')!=-1&&in.indexOf('.')!=in.lastIndexOf('.')){
            monthDayYear[0] = in.substring(0, in.indexOf('.'));
            monthDayYear[1] = in.substring(in.indexOf('.')+1, in.lastIndexOf('.'));
            monthDayYear[2] = in.substring(in.lastIndexOf('.')+1, in.length());
        }else if(in.indexOf(' ')!=-1&&in.indexOf(' ')!=in.lastIndexOf(' ')){
            monthDayYear[0] = in.substring(0, in.indexOf(' '));
            monthDayYear[1] = in.substring(in.indexOf(' ')+1, in.lastIndexOf(' '));
            monthDayYear[2] = in.substring(in.lastIndexOf(' ')+1, in.length());
        }else if(in.indexOf(',')!=-1&&in.indexOf(',')!=in.lastIndexOf(',')){
            monthDayYear[0] = in.substring(0, in.indexOf(','));
            monthDayYear[1] = in.substring(in.indexOf(',')+1, in.lastIndexOf(','));
            monthDayYear[2] = in.substring(in.lastIndexOf(',')+1, in.length());
        }else{
            monthDayYear[0] = null;
        }
        
        if(monthDayYear[0] !=null){
            back = LocalDate.parse(monthDayYear[2]+"-"+monthDayYear[0]+"-"+monthDayYear[1]);
        }else{
            back = null;
        }
        
        
        return back;
    }
}
