package com.util;

import com.param.TimeParam;
import jxl.write.Label;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

//晚上加班
public class IsNight {
    public boolean judge(Label label) {
        if (label.getString().length() == 5) {
            System.out.println("打卡一次的单元格" + label.getString());
            return true;
        } else if (label.getString().length() == 10) {
            System.out.println("打卡两次的单元格" + label.getString());
            String hou5 = label.getString().substring(5, label.getString().length());
            System.out.println("后五个字符串为" + hou5);
            //定义一个比较date类型的大小判断值
            int intcompareto = 0;
            TimeParam timeParam = new TimeParam();
            //加班规定时间
            String nighttime = timeParam.getNightTime();
            //将string转换为时间
            SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
            Date offdate = new Date();
            Date nihgtdate = new Date();
            try {
                offdate = sdf.parse(hou5);
                nihgtdate = sdf.parse(nighttime);
                System.out.println("转换为下午打卡时间为" + offdate);
                intcompareto = offdate.compareTo(nihgtdate);
                System.out.println("该判断是否加班" + intcompareto);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            if(intcompareto>0){
                System.out.println("加班改颜色");
                return true;
            }


        }else if(label.getString().length() == 20){
            System.out.println("打卡四次的单元格" + label.getString());
            String hou5 = label.getString().substring(15, label.getString().length());
            System.out.println("后五个字符串为" + hou5);
            //定义一个比较date类型的大小判断值
            int intcompareto = 0;
            TimeParam timeParam = new TimeParam();
            //加班规定时间
            String nighttime = timeParam.getNightTime();
            //将string转换为时间
            SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
            Date offdate = new Date();
            Date nihgtdate = new Date();
            try {
                offdate = sdf.parse(hou5);
                nihgtdate = sdf.parse(nighttime);
                System.out.println("转换为下午打卡时间为" + offdate);
                intcompareto = offdate.compareTo(nihgtdate);
                System.out.println("该判断是否加班" + intcompareto);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            if(intcompareto>0){
                System.out.println("加班改颜色");
                return true;
            }



        }else if(label.getString().length() == 30){
            System.out.println("打卡六次的单元格" + label.getString());
            String hou5 = label.getString().substring(25, label.getString().length());
            System.out.println("后五个字符串为" + hou5);
            //定义一个比较date类型的大小判断值
            int intcompareto = 0;
            TimeParam timeParam = new TimeParam();
            //加班规定时间
            String nighttime = timeParam.getNightTime();
            //将string转换为时间
            SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
            Date offdate = new Date();
            Date nihgtdate = new Date();
            try {
                offdate = sdf.parse(hou5);
                nihgtdate = sdf.parse(nighttime);
                System.out.println("转换为下午打卡时间为" + offdate);
                intcompareto = offdate.compareTo(nihgtdate);
                System.out.println("该判断是否加班" + intcompareto);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            if(intcompareto>0){
                System.out.println("加班改颜色");
                return true;
            }

        }
        return false;
    }
}