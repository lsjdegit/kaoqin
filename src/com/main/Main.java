package com.main;

import com.util.XlsUtil;

import java.io.File;

public class Main {
    public static void main(String[] args) {
        XlsUtil obj = new XlsUtil();
        // Excel路径
        File file = new File("D:\\text\\4月份考勤(1).xls");
        obj.readExcel(file);
    }
}
