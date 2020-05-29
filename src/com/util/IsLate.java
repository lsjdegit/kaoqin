package com.util;

import com.param.TimeParam;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import jxl.write.Label;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

//迟到
public class IsLate {

    public boolean judge(Label label){


        if(label.getString().length()==5){
            System.out.println("打卡一次的修改颜色"+label.getString());
            return true;
        }else if(label.getString().length()==10){
           int colum=label.getColumn();
            System.out.println("列");




            System.out.println("打卡两次的单元格"+label.getString());
            String qian5= label.getString().substring(0,5);
            String hou5= label.getString().substring(5,label.getString().length());
            System.out.println("前五个字符串为"+qian5);
            System.out.println("后五个字符串为"+hou5);
            //将string转换为时间
            SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
            Date date = new Date();
            Date nightdate = new Date();
            Date ondate = new Date();
            Date offdate = new Date();
            //获取上班下班规定时间
            TimeParam timeParam = new TimeParam();
            //上班规定时间
             String ontime= timeParam.getOnTime();
             //下班规定时间
             String offtime= timeParam.getOffTime();
            int intcompareto = 0;
            int intcomparetotwo = 0;
            try {
                date = sdf.parse(qian5);
                nightdate=sdf.parse(hou5);
                ondate = sdf.parse(ontime);
                offdate = sdf.parse(offtime);
                System.out.println("转换的早上打卡时间为:"+date);
                intcomparetotwo=nightdate.compareTo(offdate);
                System.out.println("转换为下午打卡时间为"+nightdate);
                System.out.println("该判断是否早退"+intcomparetotwo);


                 intcompareto=date.compareTo(ondate);
                System.out.println("该判断是否迟到"+intcompareto);
            } catch (ParseException e) {
                e.printStackTrace();
            }

            //两次打卡一样显示颜色
            if(qian5==hou5){
                return true;
            }
            //迟到或者忘记早上打卡 显示颜色
          else if(intcompareto>0){
                System.out.println("迟到、忘记早上打卡"+intcompareto);
                return true;
                //判断了该打卡早上第一次打卡在8：30之前 并且第二次打卡在17：30之后
            }else if(intcompareto<0||intcomparetotwo>0){
              return  true;
            }


        }else if(label.getString().length()==15){
            System.out.println("打卡三次的单元格"+label.getString());
            String qian5= label.getString().substring(0,5);
            String hou5= label.getString().substring(10,label.getString().length());
            System.out.println("前五个字符串为"+qian5);
            System.out.println("后五个字符串为"+hou5);
            //将string转换为时间
            SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
            Date date = new Date();
            Date nightdate = new Date();
            Date ondate = new Date();
            Date offdate = new Date();
            //获取上班下班规定时间
            TimeParam timeParam = new TimeParam();
            //上班规定时间
            String ontime= timeParam.getOnTime();
            //下班规定时间
            String offtime= timeParam.getOffTime();
            int intcompareto = 0;
            int intcomparetotwo = 0;
            try {
                date = sdf.parse(qian5);
                nightdate=sdf.parse(hou5);
                ondate = sdf.parse(ontime);
                offdate = sdf.parse(offtime);
                System.out.println("转换的早上打卡时间为:"+date);
                System.out.println("转换为下午打卡时间为"+nightdate);
                intcomparetotwo=nightdate.compareTo(offdate);

                System.out.println("该判断是否早退"+intcomparetotwo);


                intcompareto=date.compareTo(ondate);
                System.out.println("该判断是否迟到"+intcompareto);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            //两次打卡一样显示颜色
            if(qian5==hou5){
                return true;
            }
            //迟到或者忘记早上打卡 显示颜色
            else if(intcompareto>0){
                System.out.println("迟到、忘记早上打卡显示颜色"+intcompareto);
                return true;
                //判断了该打卡早上第一次打卡在8：30之前 并且第二次打卡在17：30之后
            }else{
                return  false;
            }



        }else if(label.getString().length()==20){
            System.out.println("打卡四次的单元格"+label.getString());
            String qian5= label.getString().substring(0,5);
            String hou5= label.getString().substring(15,label.getString().length());
            System.out.println("前五个字符串为"+qian5);
            System.out.println("后五个字符串为"+hou5);
            //将string转换为时间
            SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
            Date date = new Date();
            Date nightdate = new Date();
            Date ondate = new Date();
            Date offdate = new Date();
            //获取上班下班规定时间
            TimeParam timeParam = new TimeParam();
            //上班规定时间
            String ontime= timeParam.getOnTime();
            //下班规定时间
            String offtime= timeParam.getOffTime();
            int intcompareto = 0;
            int intcomparetotwo = 0;
            try {
                date = sdf.parse(qian5);
                nightdate=sdf.parse(hou5);
                ondate = sdf.parse(ontime);
                offdate = sdf.parse(offtime);
                System.out.println("转换的早上打卡时间为:"+date);
                System.out.println("转换为下午打卡时间为"+nightdate);
                intcomparetotwo=nightdate.compareTo(offdate);

                System.out.println("该判断是否早退"+intcomparetotwo);


                intcompareto=date.compareTo(ondate);
                System.out.println("该判断是否迟到"+intcompareto);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            //两次打卡一样显示颜色
            if(qian5==hou5){
                return true;
            }
            //迟到或者忘记早上打卡 显示颜色
            else if(intcompareto>0){
                System.out.println("20迟到、忘记早上打卡显示颜色"+intcompareto);
                return true;
                //判断了该打卡早上第一次打卡在8：30之前 并且第二次打卡在17：30之后
            }else{
                return  false;
            }




        }else if(label.getString().length()==25){
            System.out.println("打卡五次的单元格"+label.getString());
            String qian5= label.getString().substring(0,5);
            String hou5= label.getString().substring(20,label.getString().length());
            System.out.println("25前五个字符串为"+qian5);
            System.out.println("25后五个字符串为"+hou5);
            //将string转换为时间
            SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
            Date date = new Date();
            Date nightdate = new Date();
            Date ondate = new Date();
            Date offdate = new Date();
            //获取上班下班规定时间
            TimeParam timeParam = new TimeParam();
            //上班规定时间
            String ontime= timeParam.getOnTime();
            //下班规定时间
            String offtime= timeParam.getOffTime();
            int intcompareto = 0;
            int intcomparetotwo = 0;
            try {
                date = sdf.parse(qian5);
                nightdate=sdf.parse(hou5);
                ondate = sdf.parse(ontime);
                offdate = sdf.parse(offtime);
                System.out.println("转换的早上打卡时间为:"+date);
                System.out.println("转换为下午打卡时间为"+nightdate);
                intcomparetotwo=nightdate.compareTo(offdate);

                System.out.println("该判断是否早退"+intcomparetotwo);


                intcompareto=date.compareTo(ondate);
                System.out.println("该判断是否迟到"+intcompareto);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            //两次打卡一样显示颜色
            if(qian5==hou5){
                return true;
            }
            //迟到或者忘记早上打卡 显示颜色
            else if(intcompareto>0){
                System.out.println("25迟到、忘记早上打卡显示颜色"+intcompareto);
                return true;
                //判断了该打卡早上第一次打卡在8：30之前 并且第二次打卡在17：30之后
            }else{
                return  false;
            }

        }else if(label.getString().length()==30){
            System.out.println("打卡六次的单元格"+label.getString());
            String qian5= label.getString().substring(0,5);
            String hou5= label.getString().substring(25,label.getString().length());
            System.out.println("30前五个字符串为"+qian5);
            System.out.println("30后五个字符串为"+hou5);
            //将string转换为时间
            SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
            Date date = new Date();
            Date nightdate = new Date();
            Date ondate = new Date();
            Date offdate = new Date();
            //获取上班下班规定时间
            TimeParam timeParam = new TimeParam();
            //上班规定时间
            String ontime= timeParam.getOnTime();
            //下班规定时间
            String offtime= timeParam.getOffTime();
            int intcompareto = 0;
            int intcomparetotwo = 0;
            try {
                date = sdf.parse(qian5);
                nightdate=sdf.parse(hou5);
                ondate = sdf.parse(ontime);
                offdate = sdf.parse(offtime);
                System.out.println("转换的早上打卡时间为:"+date);
                System.out.println("转换为下午打卡时间为"+nightdate);
                intcomparetotwo=nightdate.compareTo(offdate);

                System.out.println("该判断是否早退"+intcomparetotwo);


                intcompareto=date.compareTo(ondate);
                System.out.println("该判断是否迟到"+intcompareto);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            //两次打卡一样显示颜色
            if(qian5==hou5){
                return true;
            }
            //迟到或者忘记早上打卡 显示颜色
            else if(intcompareto>0){
                System.out.println("30迟到、忘记早上打卡显示颜色"+intcompareto);
                return true;
                //判断了该打卡早上第一次打卡在8：30之前 并且第二次打卡在17：30之后
            }else{
                return  false;
            }

        }

        return false;
    }


}
