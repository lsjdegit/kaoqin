package com.util;

import com.param.TimeParam;
import jxl.write.Label;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

//迟到
public class IsLate {

    public boolean judge(Label label){
        if(label.getString().length()==5){
            System.out.println("打卡一次的单元格"+label.getString());
            return true;
        }else if(label.getString().length()==10){
            System.out.println("打卡两次的单元格"+label.getString());
            String qian5= label.getString().substring(0,5);
            String hou5= label.getString().substring(5,label.getString().length());
            System.out.println("前五个字符串为"+qian5);
            System.out.println("后五个字符串为"+hou5);
            //将string转换为时间
            SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
            Date date = new Date();
            Date ondate = new Date();
            Date offdate = new Date();
            //获取上班下班规定时间
            TimeParam timeParam = new TimeParam();
            //上班规定时间
             String ontime= timeParam.getOnTime();
             //下班规定时间
             String offtime= timeParam.getOffTime();
            int intcompareto = 0;
            try {
                date = sdf.parse(qian5);
                ondate = sdf.parse(ontime);
                offdate = sdf.parse(offtime);
                System.out.println("转换的早上打卡时间为:"+date);

                 intcompareto=date.compareTo(ondate);
                System.out.println("该迟到了"+intcompareto);
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
            }

        }

        return false;
    }


}
