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
            return true;
        } else if (label.getString().length() == 10) {
            String hou5 = label.getString().substring(5, label.getString().length());
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
                intcompareto = offdate.compareTo(nihgtdate);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            if (intcompareto > 0) {
                return true;
            }


        } else if (label.getString().length() == 15) {
            String hou5 = label.getString().substring(10, label.getString().length());
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
                intcompareto = offdate.compareTo(nihgtdate);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            if (intcompareto > 0) {
                return true;
            }


        } else if (label.getString().length() == 20) {
            String hou5 = label.getString().substring(15, label.getString().length());
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
                intcompareto = offdate.compareTo(nihgtdate);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            if (intcompareto > 0) {
                return true;
            }
        } else if (label.getString().length() == 25) {
            String hou5 = label.getString().substring(20, label.getString().length());
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
                intcompareto = offdate.compareTo(nihgtdate);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            if (intcompareto > 0) {
                return true;
            }
        } else if (label.getString().length() == 30) {
            String hou5 = label.getString().substring(25, label.getString().length());
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
                intcompareto = offdate.compareTo(nihgtdate);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            if (intcompareto > 0) {
                return true;
            }

        }else if (label.getString().length() == 35) {
            String hou5 = label.getString().substring(30, label.getString().length());
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
                intcompareto = offdate.compareTo(nihgtdate);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            if (intcompareto > 0) {
                return true;
            }

        }else if (label.getString().length() == 40) {
            String hou5 = label.getString().substring(35, label.getString().length());
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
                intcompareto = offdate.compareTo(nihgtdate);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            if (intcompareto > 0) {
                return true;
            }

        }

        return false;
    }
}