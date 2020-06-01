package com.util;

import com.param.TimeParam;
import jxl.write.Label;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

//迟到
public class IsLate {

    public boolean judge(Label label) {


        if (label.getString().length() == 5) {
            return true;
        } else if (label.getString().length() == 10) {
            int colum = label.getColumn();
            String qian5 = label.getString().substring(0, 5);
            String hou5 = label.getString().substring(5, label.getString().length());
            //将string转换为时间
            SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
            Date date = new Date();
            Date nightdate = new Date();
            Date ondate = new Date();
            Date offdate = new Date();
            //获取上班下班规定时间
            TimeParam timeParam = new TimeParam();
            //上班规定时间
            String ontime = timeParam.getOnTime();
            //下班规定时间
            String offtime = timeParam.getOffTime();
            int intcompareto = 0;
            int intcomparetotwo = 0;
            try {
                date = sdf.parse(qian5);
                nightdate = sdf.parse(hou5);
                ondate = sdf.parse(ontime);
                offdate = sdf.parse(offtime);
                intcomparetotwo = nightdate.compareTo(offdate);
                intcompareto = date.compareTo(ondate);
            } catch (ParseException e) {
                e.printStackTrace();
            }

            //两次打卡一样显示颜色
            if (qian5 == hou5) {
                return true;
            } else if (((nightdate.getTime() - date.getTime() / 60000) <= 120)) {
                return true;
                //迟到或者忘记早上打卡 显示颜色
            } else if (intcompareto > 0) {
                return true;
                //判断了该打卡早上第一次打卡在8：30之前 并且第二次打卡在17：30之后
            } else if (intcompareto < 0 || intcomparetotwo > 0) {
                return false;
            }


        } else if (label.getString().length() == 15) {
            String qian5 = label.getString().substring(0, 5);
            String hou5 = label.getString().substring(10, label.getString().length());
            //将string转换为时间
            SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
            Date date = new Date();
            Date nightdate = new Date();
            Date ondate = new Date();
            Date offdate = new Date();
            //获取上班下班规定时间
            TimeParam timeParam = new TimeParam();
            //上班规定时间
            String ontime = timeParam.getOnTime();
            //下班规定时间
            String offtime = timeParam.getOffTime();
            int intcompareto = 0;
            int intcomparetotwo = 0;
            try {
                date = sdf.parse(qian5);
                nightdate = sdf.parse(hou5);
                ondate = sdf.parse(ontime);
                offdate = sdf.parse(offtime);
                intcomparetotwo = nightdate.compareTo(offdate);
                intcompareto = date.compareTo(ondate);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            //两次打卡一样显示颜色
            if (qian5 == hou5) {
                return true;
            }
            //迟到或者忘记早上打卡 显示颜色
            else if (intcompareto > 0) {
                return true;
                //判断了该打卡早上第一次打卡在8：30之前 并且第二次打卡在17：30之后
            } else if (((nightdate.getTime() - date.getTime() / 60000) <= 120)) {
            return true;
            //迟到或者忘记早上打卡 显示颜色
        }

            else {
                return false;
            }


        } else if (label.getString().length() == 20) {
            String qian5 = label.getString().substring(0, 5);
            String hou5 = label.getString().substring(15, label.getString().length());
            //将string转换为时间
            SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
            Date date = new Date();
            Date nightdate = new Date();
            Date ondate = new Date();
            Date offdate = new Date();
            //获取上班下班规定时间
            TimeParam timeParam = new TimeParam();
            //上班规定时间
            String ontime = timeParam.getOnTime();
            //下班规定时间
            String offtime = timeParam.getOffTime();
            int intcompareto = 0;
            int intcomparetotwo = 0;
            try {
                date = sdf.parse(qian5);
                nightdate = sdf.parse(hou5);
                ondate = sdf.parse(ontime);
                offdate = sdf.parse(offtime);
                intcomparetotwo = nightdate.compareTo(offdate);
                intcompareto = date.compareTo(ondate);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            //两次打卡一样显示颜色
            if (qian5 == hou5) {
                return true;
            }
            //迟到或者忘记早上打卡 显示颜色
            else if (intcompareto > 0) {
                return true;
                //判断了该打卡早上第一次打卡在8：30之前 并且第二次打卡在17：30之后
            } else if (((nightdate.getTime() - date.getTime() / 60000) <= 120)) {
            return true;
            //迟到或者忘记早上打卡 显示颜色
        } else {
                return false;
            }


        } else if (label.getString().length() == 25) {
            String qian5 = label.getString().substring(0, 5);
            String hou5 = label.getString().substring(20, label.getString().length());
            //将string转换为时间
            SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
            Date date = new Date();
            Date nightdate = new Date();
            Date ondate = new Date();
            Date offdate = new Date();
            //获取上班下班规定时间
            TimeParam timeParam = new TimeParam();
            //上班规定时间
            String ontime = timeParam.getOnTime();
            //下班规定时间
            String offtime = timeParam.getOffTime();
            int intcompareto = 0;
            int intcomparetotwo = 0;
            try {
                date = sdf.parse(qian5);
                nightdate = sdf.parse(hou5);
                ondate = sdf.parse(ontime);
                offdate = sdf.parse(offtime);
                intcomparetotwo = nightdate.compareTo(offdate);
                intcompareto = date.compareTo(ondate);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            //两次打卡一样显示颜色
            if (qian5 == hou5) {
                return true;
            }
            //迟到或者忘记早上打卡 显示颜色
            else if (intcompareto > 0) {
                return true;
                //判断了该打卡早上第一次打卡在8：30之前 并且第二次打卡在17：30之后
            } else if (((nightdate.getTime() - date.getTime() / 60000) <= 120)) {
            return true;
            //迟到或者忘记早上打卡 显示颜色
        } else {
                return false;
            }

        } else if (label.getString().length() == 30) {
            String qian5 = label.getString().substring(0, 5);
            String hou5 = label.getString().substring(25, label.getString().length());
            //将string转换为时间
            SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
            Date date = new Date();
            Date nightdate = new Date();
            Date ondate = new Date();
            Date offdate = new Date();
            //获取上班下班规定时间
            TimeParam timeParam = new TimeParam();
            //上班规定时间
            String ontime = timeParam.getOnTime();
            //下班规定时间
            String offtime = timeParam.getOffTime();
            int intcompareto = 0;
            int intcomparetotwo = 0;
            try {
                date = sdf.parse(qian5);
                nightdate = sdf.parse(hou5);
                ondate = sdf.parse(ontime);
                offdate = sdf.parse(offtime);
                intcomparetotwo = nightdate.compareTo(offdate);
                intcompareto = date.compareTo(ondate);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            //两次打卡一样显示颜色
            if (qian5 == hou5) {
                return true;
            }else if (((nightdate.getTime() - date.getTime() / 60000) <= 120)) {
                return true;
                //迟到或者忘记早上打卡 显示颜色
            }
            //迟到或者忘记早上打卡 显示颜色
            else if (intcompareto > 0) {
                return true;
                //判断了该打卡早上第一次打卡在8：30之前 并且第二次打卡在17：30之后
            } else {
                return false;
            }

        }else if (label.getString().length() == 35) {
            String qian5 = label.getString().substring(0, 5);
            String hou5 = label.getString().substring(30, label.getString().length());
            //将string转换为时间
            SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
            Date date = new Date();
            Date nightdate = new Date();
            Date ondate = new Date();
            Date offdate = new Date();
            //获取上班下班规定时间
            TimeParam timeParam = new TimeParam();
            //上班规定时间
            String ontime = timeParam.getOnTime();
            //下班规定时间
            String offtime = timeParam.getOffTime();
            int intcompareto = 0;
            int intcomparetotwo = 0;
            try {
                date = sdf.parse(qian5);
                nightdate = sdf.parse(hou5);
                ondate = sdf.parse(ontime);
                offdate = sdf.parse(offtime);
                intcomparetotwo = nightdate.compareTo(offdate);
                intcompareto = date.compareTo(ondate);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            //两次打卡一样显示颜色
            if (qian5 == hou5) {
                return true;
            }else if (((nightdate.getTime() - date.getTime() / 60000) <= 120)) {
                return true;
                //迟到或者忘记早上打卡 显示颜色
            }
            //迟到或者忘记早上打卡 显示颜色
            else if (intcompareto > 0) {
                return true;
                //判断了该打卡早上第一次打卡在8：30之前 并且第二次打卡在17：30之后
            } else {
                return false;
            }

        }else if (label.getString().length() == 40) {
            String qian5 = label.getString().substring(0, 5);
            String hou5 = label.getString().substring(35, label.getString().length());
            //将string转换为时间
            SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
            Date date = new Date();
            Date nightdate = new Date();
            Date ondate = new Date();
            Date offdate = new Date();
            //获取上班下班规定时间
            TimeParam timeParam = new TimeParam();
            //上班规定时间
            String ontime = timeParam.getOnTime();
            //下班规定时间
            String offtime = timeParam.getOffTime();
            int intcompareto = 0;
            int intcomparetotwo = 0;
            try {
                date = sdf.parse(qian5);
                nightdate = sdf.parse(hou5);
                ondate = sdf.parse(ontime);
                offdate = sdf.parse(offtime);
                intcomparetotwo = nightdate.compareTo(offdate);
                intcompareto = date.compareTo(ondate);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            //两次打卡一样显示颜色
            if (qian5 == hou5) {
                return true;
            }else if (((nightdate.getTime() - date.getTime() / 60000) <= 120)) {
                return true;
                //迟到或者忘记早上打卡 显示颜色
            }
            //迟到或者忘记早上打卡 显示颜色
            else if (intcompareto > 0) {
                return true;
                //判断了该打卡早上第一次打卡在8：30之前 并且第二次打卡在17：30之后
            } else {
                return false;
            }

        }

        return false;
    }


}
