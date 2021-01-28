package com.util;

import com.param.XlsParam;
import jxl.write.Label;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class IsHoliday {
    private XlsParam xlsParam = new XlsParam();

    public boolean judge(Label label,StringBuffer date,List<ChinaDate> dateList) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat(xlsParam.getYearMonthFormat());
        StringBuffer sbym = new StringBuffer(date.substring(xlsParam.getYearMonthBegin(),xlsParam.getYearMonthEnd()-2));
        String day = (label.getColumn()+1-xlsParam.getDataBeginColum())>9?(label.getColumn()+1-xlsParam.getDataBeginColum())+"":"0"+(label.getColumn()+1-xlsParam.getDataBeginColum());
        sbym.append(day);
        Date ymd = sdf.parse(sbym.toString());
        ChinaDate cd = new DateUtil().getTodayInfo(dateList,ymd);
        if(cd.isVacation()){
            return true;
        }
        return false;
    }

}
