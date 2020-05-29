package com.util;
import com.param.TimeParam;
import jxl.write.Label;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


//早退
public class IsEarly {

    public boolean judge(Label label,StringBuffer date){
        SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
       // ChineseCalendarUtils ccu=new ChineseCalendarUtils();
        String datime =label.getString();
        int num= datime.length();
        SimpleDateFormat formatter = new SimpleDateFormat("HH:mm");
        TimeParam tp=new TimeParam();
        String dahou= datime.substring(num-5,num);
        String zuihou= tp.getOffTime();
        Date dadate = null;
        Date zuidate =null;
//        String ssdate=datime.substring(num-5,num-3);
//        label.getContents();
//        int ri=   label.getColumn();
//        String riqi= String.valueOf(ri);
//        String year=date.substring(0,7);
//        String y=date.substring(0,4);
//        String m=date.substring(5,7);
//
//        String zong=null;
//        if(riqi.length()>1) {
//            zong = year + "-" + ri;
//
//        }else if(riqi.length()<=1){//如果为以一位就家个0
//            zong = year + "-0" + ri;
//
//        }
//        Date time=null;
//        try {
//            time=sdf2.parse(zong);
//        } catch (ParseException e) {
//            e.printStackTrace();
//        }
        //DateUtil du=new DateUtil();
        // List<ChinaDate> list= du.getCurrentDateInfo(y,m);
        //System.out.println(list.get(label.getColumn()).isSaturday());
//        if(!(list.get(label.getColumn()).isSaturday())) {


            //获取最晚时间
            String zuitime = tp.getOffTime();
            try {
                dadate = formatter.parse(dahou);
                zuidate = formatter.parse(zuitime);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            Long cha = zuidate.getTime() - dadate.getTime();
            Long fen = cha / 60000;
            if (fen > 0) {//早退
                return true;
            } else if (fen <= 0) {
                if (datime.length() == 10) {//满足下班时间2个时间段
                    String shan = datime.substring(0, 5);
                    String xia = datime.substring(datime.length() - 5, datime.length());
                    Date datea = null;
                    Date datwb = null;
                    try {
                        datea = formatter.parse(shan);
                        datwb = formatter.parse(xia);
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                    Long cha1 = datwb.getTime() - datea.getTime();
                    Long fen1 = cha1 / 60000;
                    if (fen1 < 10) {
                        return true;
                    }
                } else if (datime.length() == 15) {//满足下班时间3个时间段
                    String shan = datime.substring(0, 5);
                    String xia = datime.substring(datime.length() - 5, datime.length());
                    Date datea = null;
                    Date datwb = null;
                    try {
                        datea = formatter.parse(shan);
                        datwb = formatter.parse(xia);
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                    Long cha1 = datwb.getTime() - datea.getTime();
                    Long fen1 = cha1 / 60000;
                    if (fen1 < 10) {
                        return true;
                    }
                } else if (datime.length() == 20) {//满足下班时间4个时间段
                    String shan = datime.substring(0, 5);
                    String xia = datime.substring(datime.length() - 5, datime.length());
                    Date datea = null;
                    Date datwb = null;
                    try {
                        datea = formatter.parse(shan);
                        datwb = formatter.parse(xia);
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                    Long cha1 = datwb.getTime() - datea.getTime();
                    Long fen1 = cha1 / 60000;
                    if (fen1 < 10) {
                        return true;
                    }
                } else if (datime.length() == 25) {//满足下班时间5个时间段
                    String shan = datime.substring(0, 5);
                    String xia = datime.substring(datime.length() - 5, datime.length());
                    Date datea = null;
                    Date datwb = null;
                    try {
                        datea = formatter.parse(shan);
                        datwb = formatter.parse(xia);
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                    Long cha1 = datwb.getTime() - datea.getTime();
                    Long fen1 = cha1 / 60000;
                    if (fen1 < 10) {
                        return true;
                    }
                } else if (datime.length() == 30) {//满足下班时间6个时间段
                    String shan = datime.substring(0, 5);
                    String xia = datime.substring(datime.length() - 5, datime.length());
                    Date datea = null;
                    Date datwb = null;
                    try {
                        datea = formatter.parse(shan);
                        datwb = formatter.parse(xia);
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                    Long cha1 = datwb.getTime() - datea.getTime();
                    Long fen1 = cha1 / 60000;
                    if (fen1 < 10) {
                        return true;
                    }
                }
            }
//        if(fen<=-180){//加班
//            return true;
//        }


//        }


        return false;


    }

}
