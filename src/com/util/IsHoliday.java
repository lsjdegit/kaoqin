package com.util;

import jxl.write.Label;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class IsHoliday {

    public boolean judge(Label label,StringBuffer date,List<ChinaDate> dateList) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        StringBuffer sbym = new StringBuffer(date.substring(0,8));
        String day = (label.getColumn()+1)>9?(label.getColumn()+1)+"":"0"+(label.getColumn()+1)+"";
        sbym.append(day);
        Date ymd = sdf.parse(sbym.toString());
        ChinaDate cd = new DateUtil().getTodayInfo(dateList,ymd);
        if(cd.isVacation()){
            return true;
        }
        return false;
    }

}
