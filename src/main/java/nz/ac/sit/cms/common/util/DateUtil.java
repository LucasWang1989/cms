package nz.ac.sit.cms.common.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class DateUtil {
    /**
     * @return HHmmss format
     */
    static public String getTime() {
        SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHHmmss");
        return format.format(new Date()).substring(8, 14);
    }

    static public String getDate() {
        SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
        return format.format(new Date());
    }

    public static String getDateTime(String dateTime) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
        try {
            Date myDate = dateFormat.parse(dateTime);
            DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            return df.format(myDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String getDateTime2() {
        SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHHmmss");
        return format.format(new Date());
    }

    public static void main(String[] args){

        System.out.println(getDateTime("20221023000000"));
//        System.out.println(getDate());

    }

}
