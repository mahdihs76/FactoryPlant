package utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

/**
 * Created by mahdihs76 on 10/9/18.
 */
public class Utils {

    public static String toDateFormat(long timeStamp){
        Date date = new Date(timeStamp);
        DateFormat formatter = new SimpleDateFormat("HH:mm:ss.SSS");
        formatter.setTimeZone(TimeZone.getTimeZone("UTC"));
        return formatter.format(date);
    }

    public static long generateId(){
        return System.currentTimeMillis();
    }
}
