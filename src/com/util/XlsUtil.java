package com.util;

import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

import java.io.*;

public class XlsUtil {
    // 去读Excel的方法readExcel，该方法的入口参数为一个File对象
    public void readExcel(File file) {
        try {
            // 创建输入流，读取Excel
            InputStream is = new FileInputStream(file.getAbsolutePath());
            // jxl提供的Workbook类
            Workbook wb = Workbook.getWorkbook(is);
            // Excel的页签数量
            int sheet_size = wb.getNumberOfSheets();
            Sheet sheet = wb.getSheet("考勤记录");
            // 返回该页的总行数
            System.out.println("sheet.getRows() = " + sheet.getRows());
            for (int i = 0; i < sheet.getRows(); i++) {
                //返回该页的总列数
                System.out.println("sheet.getColumns() = " + sheet.getColumns());
                if(i>4 && i%2!=0){
                    for (int j = 0; j < sheet.getColumns(); j++) {
                        String cellinfo = sheet.getCell(j, i).getContents();
                        System.out.println(cellinfo);
                    }
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (BiffException e) {
            e.printStackTrace();
        }
    }

    public void update(){

    }


}
