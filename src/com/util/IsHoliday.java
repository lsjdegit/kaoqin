package com.util;

import jxl.write.Label;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class IsHoliday {




    public boolean judge(Label label,StringBuffer date) throws ParseException {
        String day = (label.getColumn()+1)+"";
        System.out.println("day = " + day);
        if(day.length()<2){
            day = "0"+day;
        }
        StringBuffer httpArg = new StringBuffer(date.substring(0,8)+day);
        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
        Date d = sdf1.parse(httpArg.toString());
        SimpleDateFormat sdf2 = new SimpleDateFormat("yyyyMMdd");
        httpArg = new StringBuffer(sdf2.format(d));
        System.out.println("httpArg = " + httpArg);

        return false;
    }
}
