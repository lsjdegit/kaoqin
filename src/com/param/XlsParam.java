package com.param;


public class XlsParam {
//    private String sheetName = "考勤记录";
//    private Integer yearMonthRow = 3;//年月所在单元格行坐标 i
//    private Integer yearMonthColumn = 3;//年月所在单元格列坐标
//    private String yearMonthFormat = "yyyy-MM-dd";//年月格式
//    private Integer yearMonthBegin = 0;//年月截取开始
//    private Integer yearMonthEnd = 10;//年月截取结束
//    private Integer dataBeginRow = 6;//数据开始行
//    private Integer dataBeginColum = 1;//数据开始列
//    private Boolean dataOnRow;//数据所在行
//    private Integer dateOnRow = 4;//日期所在行

    private String sheetName = "打卡时间";
    private Integer yearMonthRow = 1;//年月所在单元格行坐标 i
    private Integer yearMonthColumn = 1;//年月所在单元格列坐标
    private String yearMonthFormat = "yyyy-MM-dd";//年月格式
    private Integer yearMonthBegin = 11;//年月截取开始
    private Integer yearMonthEnd = 21;//年月截取结束
    private Integer dataBeginRow = 4;//数据开始行
    private Integer dataBeginColum = 6;//数据开始列
    private Boolean dataOnRow;//数据所在行
    private Integer dateOnRow = 3;//日期所在行

    public String getSheetName() {
        return sheetName;
    }

    public void setSheetName(String sheetName) {
        this.sheetName = sheetName;
    }

    public Integer getYearMonthRow() {
        return yearMonthRow-1;
    }

    public void setYearMonthRow(Integer yearMonthRow) {
        this.yearMonthRow = yearMonthRow;
    }

    public Integer getYearMonthColumn() {
        return yearMonthColumn-1;
    }

    public void setYearMonthColumn(Integer yearMonthColumn) {
        this.yearMonthColumn = yearMonthColumn;
    }

    public String getYearMonthFormat() {
        return yearMonthFormat;
    }

    public void setYearMonthFormat(String yearMonthFormat) {
        this.yearMonthFormat = yearMonthFormat;
    }

    public Integer getYearMonthBegin() {
        return yearMonthBegin;
    }

    public void setYearMonthBegin(Integer yearMonthBegin) {
        this.yearMonthBegin = yearMonthBegin;
    }

    public Integer getYearMonthEnd() {
        return yearMonthEnd;
    }

    public void setYearMonthEnd(Integer yearMonthEnd) {
        this.yearMonthEnd = yearMonthEnd;
    }

    public Integer getDataBeginRow() {
        return dataBeginRow-1;
    }

    public void setDataBeginRow(Integer dataBeginRow) {
        this.dataBeginRow = dataBeginRow;
    }

    public Integer getDataBeginColum() {
        return dataBeginColum;
    }
//    public Integer getDataBeginColum() {
//        return dataBeginColum-1;
//    }

    public void setDataBeginColum(Integer dataBeginColum) {
        this.dataBeginColum = dataBeginColum;
    }

    public Boolean getDataOnRow(int i) {
        /*if(dataBeginRow%2 != 0){
            dataOnRow = i%2==0?true:false;

        }else{
            dataOnRow = i%2==0?false:true;
        }*/
        dataOnRow = true;
        return dataOnRow;
    }

    public Integer getDateOnRow() {
        return dateOnRow-1;
    }

    public void setDateOnRow(Integer dateOnRow) {
        this.dateOnRow = dateOnRow;
    }
}
