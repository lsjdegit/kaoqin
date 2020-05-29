package com.util;

import com.param.TimeParam;
import jxl.write.Label;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

//早退
public class IsEarly {

    public boolean judge(Label label,StringBuffer date){
        String datime =label.getString();
        int num= datime.length();
        SimpleDateFormat formatter = new SimpleDateFormat("HH:mm");
        TimeParam tp=new TimeParam();
        String dahou= datime.substring(num-5,num);
        String zuihou= tp.getOffTime();
        String liuhou= "12:00";

        Date dadate = null;
        Date zuidate =null;
        String ssdate=datime.substring(num-5,num-3);
//        if(ssdate.equals("12")||ssdate.equals("13")||ssdate.equals("14")){//上午最后打卡时间
//            Date sdadate = null;
//            Date szuidate =null;
//            try {
//
//                sdadate = formatter.parse(dahou);
//                System.out.println("上打卡时间"+dahou);
//                szuidate = formatter.parse(liuhou);
//                System.out.println("上最后时间"+liuhou);
//            } catch (ParseException e) {
//                e.printStackTrace();
//            }
//            Long scha=szuidate.getTime()-sdadate.getTime();
//            System.out.println("上差"+scha);
//            Long sfen=scha/60000;
//            System.out.println("上总"+sfen);
//            if(sfen<=0){
//                return false;
//            }
//        }

        //获取最晚时间
        String zuitime= tp.getOffTime();
        try {
            dadate = formatter.parse(dahou);
            System.out.println("打卡时间"+dadate);
            zuidate = formatter.parse(zuitime);
            System.out.println("最后时间"+zuihou);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Long cha=zuidate.getTime()-dadate.getTime();
        System.out.println("差"+cha);
        Long fen=cha/60000;
        System.out.println("总"+fen);
        if(fen>0){//早退
            return true;
        }
        if(fen<=-180){//加班
            return true;
        }

        return false;
    }
}
