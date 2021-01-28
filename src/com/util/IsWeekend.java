package com.util;

import com.param.TimeParam;
import com.param.XlsParam;
import jxl.write.Label;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class IsWeekend {
    private TimeParam tp = new TimeParam();
    private XlsParam xlsParam = new XlsParam();

    public TimeParam getTp() {
        return tp;
    }

    public void setTp(TimeParam tp) {
        this.tp = tp;
    }

    public boolean judge(Label label, StringBuffer date, List<ChinaDate> dateList) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat(xlsParam.getYearMonthFormat());
        StringBuffer sbym = new StringBuffer(date.substring(xlsParam.getYearMonthBegin(),xlsParam.getYearMonthEnd()-2));
        String day = (label.getColumn()+1-xlsParam.getDataBeginColum())>9?(label.getColumn()+1-xlsParam.getDataBeginColum())+"":"0"+(label.getColumn()+1-xlsParam.getDataBeginColum());
        sbym.append(day);
        Date ymd = sdf.parse(sbym.toString());
        ChinaDate cd = new DateUtil().getTodayInfo(dateList,ymd);
        String context = label.getString();
        // 去除中文
        Pattern pat = Pattern.compile("[\u4e00-\u9fa5]");
        Matcher mat = pat.matcher(context);
        context = mat.replaceAll("");

        int conlength = context.length();
        String start = context.substring(0,5);
        String end = context.substring(conlength-5,conlength);
        String ontime = tp.getOnTime();
        String midtime = tp.getMidTime();
        String offtime = tp.getOffTime();
        String nighttime = tp.getNightTime();
        SimpleDateFormat timesdf = new SimpleDateFormat("HH:mm");
        Date startDate = timesdf.parse(start);
        Date endDate = timesdf.parse(end);
        Date ontimeDate = timesdf.parse(ontime);
        Date midtimeDate = timesdf.parse(midtime);
        Date offtimeDate = timesdf.parse(offtime);
        Date nighttimeDate = timesdf.parse(nighttime);
        if(cd.isSaturday() || cd.isSunday()){
            if(!cd.isWorkFlag()){
                if(cd.isSaturday()){
                    if((endDate.getTime()-offtimeDate.getTime())>=0){//星期六加班
                        return true;
                    }else if((endDate.getTime()-midtimeDate.getTime())<0){//星期六早退
                        return true;
                    }else if((startDate.getTime()-ontimeDate.getTime())>0){//星期六迟到
                        return true;
                    } else if ((endDate.getTime() - startDate.getTime() / 60000) <= 120) {//前后两次打卡在两小时之间
                        return true;
                    }else{
                        return false;
                    }
                }else{//星期天加班
                    return true;
                }
            }else{//周末正常上班
                if((endDate.getTime()-nighttimeDate.getTime())>=0){//加班
                    return true;
                }else if((endDate.getTime()-offtimeDate.getTime())<0){//早退
                    return true;
                }else if((startDate.getTime()-ontimeDate.getTime())>0){//迟到
                    return true;
                } else if ((endDate.getTime() - startDate.getTime() / 60000) <= 120) {//前后两次打卡在两小时之间
                    return true;
                }else{
                    return false;
                }
            }
        }else{//非周末
            if((endDate.getTime()-nighttimeDate.getTime())>=0){//加班
                return true;
            }else if((endDate.getTime()-offtimeDate.getTime())<0){//早退
                return true;
            }else if((startDate.getTime()-ontimeDate.getTime())>0){//迟到
                return true;
            } else if ((endDate.getTime() - startDate.getTime() / 60000) <= 120) {//前后两次打卡在两小时之间
                return true;
            }else{
                return false;
            }
        }
    }
}
