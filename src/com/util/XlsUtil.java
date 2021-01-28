package com.util;

import com.param.TimeParam;
import com.param.XlsParam;
import jxl.CellType;
import jxl.Sheet;
import jxl.Workbook;
import jxl.WorkbookSettings;
import jxl.format.UnderlineStyle;
import jxl.read.biff.BiffException;
import jxl.write.*;
import jxl.write.Label;
import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class XlsUtil {
    private XlsParam xlsParam = new XlsParam();

    public String isXls(File file) {
        if(file == null){
            return "no";
        }
        //文件被占用
        if(!file.renameTo(file)){
            return "use";
        }

        //xls文件
        int endindex = file.getAbsolutePath().indexOf(".");
        String endname = file.getAbsolutePath().substring(endindex);
        System.out.println("endname = " + endname);
        if(!".xls".equals(endname)){
            return "noxls";
        }
        InputStream is = null;
        Sheet sheet = null;
        try {
            is = new FileInputStream(file.getAbsolutePath());
            // jxl提供的Workbook类
            Workbook wb = Workbook.getWorkbook(is);
            sheet = wb.getSheet(xlsParam.getSheetName());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (BiffException e) {
            e.printStackTrace();
        }
        if(sheet == null){
            return "nokq";
        }

        return "yes";
    }


//    /**
//     * 遍历
//     * @param file
//     */
//    public void readExcel(File file) {
//        try {
//            // 创建输入流，读取Excel
//            InputStream is = new FileInputStream(file.getAbsolutePath());
//            // jxl提供的Workbook类
//            Workbook wb = Workbook.getWorkbook(is);
//            // Excel的页签数量
//            int sheet_size = wb.getNumberOfSheets();
//            Sheet sheet = wb.getSheet("考勤记录");
//            // 返回该页的总行数
//            System.out.println("sheet.getRows() = " + sheet.getRows());
//            String date = sheet.getCell(2, 2).getContents();
//            System.out.println("年："+date);
//            sheet.getCell(3, 2).getContents();
//            for (int i = 0; i < sheet.getRows(); i++) {
//                //返回该页的总列数
//                System.out.println("sheet.getColumns() = " + sheet.getColumns());
//                if(i>4 && i%2!=0){
//                    for (int j = 0; j < sheet.getColumns(); j++) {
//                        String cellinfo = sheet.getCell(j, i).getContents();
//                        System.out.println(cellinfo);
//                    }
//                }
//            }
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        } catch (BiffException e) {
//            e.printStackTrace();
//        }
//    }

    /**
     * 修改
     * @param file
     */
    public void update(File file) throws IOException {
        try{
            Workbook rw = Workbook.getWorkbook(file);
            WritableWorkbook wwb = Workbook.createWorkbook(file,rw);
            //这里其实执行的是一次copy操作,把文件先读到内存中,修改后再保存覆盖原来的文件来实现update操作
            WritableSheet sheet  = wwb.getSheet(xlsParam.getSheetName());
            //得到年月
            StringBuffer date = new StringBuffer(sheet.getCell(xlsParam.getYearMonthColumn(), xlsParam.getYearMonthRow()).getContents());
            SimpleDateFormat sdf = new SimpleDateFormat(xlsParam.getYearMonthFormat());
            SimpleDateFormat sdfy = new SimpleDateFormat("yyyy");
            SimpleDateFormat sdfm = new SimpleDateFormat("MM");
            String sbdate = date.substring(xlsParam.getYearMonthBegin(),xlsParam.getYearMonthEnd());
            Date d = null;
            try {
                d = sdf.parse(sbdate);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            List<ChinaDate> dateList = new DateUtil().getCurrentDateInfo(sdfy.format(d),sdfm.format(d));
            for (int i = 0; i < sheet.getRows(); i++) {
                if(i>=xlsParam.getDataBeginRow() && xlsParam.getDataOnRow(i)){
                    for (int j = xlsParam.getDataBeginColum(); j < sheet.getColumns(); j++) {
                        WritableCell wc = sheet.getWritableCell(j,i);
                        String c = wc.getContents().trim();
                        if("".equals(c) || !c.contains(":")){//没有打卡的空白部分
                            SimpleDateFormat sdf01 = new SimpleDateFormat(xlsParam.getYearMonthFormat());
                            StringBuffer sbym = new StringBuffer(date.substring(xlsParam.getYearMonthBegin(),xlsParam.getYearMonthEnd()-2));
                            String day = (wc.getColumn()+1-xlsParam.getDataBeginColum())>9?(wc.getColumn()+1-xlsParam.getDataBeginColum())+"":"0"+(wc.getColumn()+1-xlsParam.getDataBeginColum());
                            sbym.append(day);
                            Date ymd = sdf01.parse(sbym.toString());
                            ChinaDate cd = new DateUtil().getTodayInfo(dateList,ymd);
                            if(!cd.isVacation() && !cd.isSunday()){//非假期，非星期天
                                if(sheet.getWritableCell(j,xlsParam.getDateOnRow()).getContents() != ""){
                                    Label label = new Label(wc.getColumn(),wc.getRow(),wc.getContents(),getWritableCellFormat());
                                    sheet.addCell(label);
                                }
                            }else if(cd.isSunday() && cd.isWorkFlag()){//星期天上班日
                                if(sheet.getWritableCell(j,xlsParam.getDateOnRow()).getContents() != ""){
                                    Label label = new Label(wc.getColumn(),wc.getRow(),wc.getContents(),getWritableCellFormat());
                                    sheet.addCell(label);
                                }
                            }
                        }else if( wc.getType() == CellType.LABEL){//打卡部分
                            Label l = (Label)wc;
                            if(isHoliday(l,date,dateList) || isWeekend(l,date,dateList)){
                                Label label = new Label(l.getColumn(),l.getRow(),l.getContents(),getWritableCellFormat());
                                sheet.addCell(label);
                            }
                        }
                    }
                }
            }
            wwb.write();
            wwb.close();
        } catch (WriteException e) {
            e.printStackTrace();
        } catch (BiffException e) {
            e.printStackTrace();
        } catch (ParseException e) {
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

    /**
     * 周末
     * @param label
     * @return
     */
    public boolean isWeekend(Label label,StringBuffer date,List<ChinaDate> dateList){
        IsWeekend isWeekend = new IsWeekend();
        //TimeParam timeParam = new TimeParam();
        boolean falg = false;
        try {
            falg = isWeekend.judge(label,date,dateList);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return falg;
    }

    /**
     * 节假日
     * @param label
     * @return
     */
    public boolean isHoliday(Label label,StringBuffer date,List<ChinaDate> dateList){
        IsHoliday isHoliday = new IsHoliday();
        boolean falg = false;
        try {
            falg = isHoliday.judge(label,date,dateList);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return falg;
    }


}
