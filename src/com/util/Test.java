package com.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Test {
    public static void main(String[] args) {
        SimpleDateFormat sdf2 = new SimpleDateFormat("yyyyMMdd");
        String httpArg = sdf2.format(new Date());
        System.out.println("httpArg = " + httpArg);
//        String result = IsHoliday.request(httpArg);
//        System.out.println("result = " + result);
    }
}
