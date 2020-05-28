package com.util;

import com.param.TimeParam;
import jxl.CellType;
import jxl.Sheet;
import jxl.Workbook;
import jxl.format.UnderlineStyle;
import jxl.read.biff.BiffException;
import jxl.write.*;
import jxl.write.Label;
import java.io.*;

public class XlsUtil {
    private TimeParam timeParam = new TimeParam();


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
            String date = sheet.getCell(2, 2).getContents();
            System.out.println("年："+date);
            sheet.getCell(3, 2).getContents();
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

    public void update(File file){
        try{
            Workbook rw = Workbook.getWorkbook(file);
            WritableWorkbook wwb = Workbook.createWorkbook(file,rw);
            //这里其实执行的是一次copy操作,把文件先读到内存中,修改后再保存覆盖原来的文件来实现update操作
            WritableSheet sheet  = wwb.getSheet("考勤记录");
            for (int i = 0; i < sheet.getRows(); i++) {
                if(i>4 && i%2!=0){
                    for (int j = 0; j < sheet.getColumns(); j++) {
                        WritableCell wc = sheet.getWritableCell(j,i);
                        if( wc.getType() == CellType.LABEL){
                            Label l = (Label)wc;
                            if(isLate(l) ){
                                Label label = new Label(l.getColumn(),l.getRow(),l.getContents(),getWritableCellFormat());
                                sheet.addCell(label);
                            }
                        }
                    }
                }
            }
            wwb.write();
            wwb.close();
        }
        catch(IOException e){
            e.printStackTrace();
        }
        catch(WriteException e){
            e.printStackTrace();
        }
        catch(BiffException e){
            e.printStackTrace();
        }
    }

    //单元格格式
    public WritableCellFormat getWritableCellFormat(){
        //设置字体;
        WritableFont font = new WritableFont(WritableFont.ARIAL,8,WritableFont.NO_BOLD,false, UnderlineStyle.NO_UNDERLINE,Colour.RED);
        WritableCellFormat cellFormat = new WritableCellFormat(font);
        //颜色
        try {
            cellFormat.setBackground(Colour.YELLOW);
            //设置边框;
            cellFormat.setBorder(Border.ALL, BorderLineStyle.THIN);
            //设置自动换行;
            cellFormat.setWrap(true);
            //设置文字居中对齐方式;
            cellFormat.setAlignment(Alignment.CENTRE);
            //设置垂直居中;
            cellFormat.setVerticalAlignment(VerticalAlignment.CENTRE);
        } catch (WriteException e) {
            e.printStackTrace();
        }
        return cellFormat;
    }

    public boolean isLate(Label label){

        return false;
    }


}
