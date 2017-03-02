package util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by jianqsun on 4/16/14.
 */
public class MyDate {
    public static void main(String[] args) throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat("MM/dd/yyyy");
        Date d = (Date)format.parse("05/07/2014");
        System.out.println(d.getTime() / 1000);

        SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
        Date dateNow = new Date();
        String dateStr = dateFormat.format(dateNow);
        System.out.println(dateStr);

        String text = "04/05/2014" ;
        System.out.println(text.matches("[01]\\d/[0-3]\\d/\\d{4}"));


        int dd = (int)Math.round(5/2.0);

        System.out.println(dd);

    }
}
