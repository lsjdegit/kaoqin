package com.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.DomNodeList;
import com.gargoylesoftware.htmlunit.html.HtmlElement;
import com.gargoylesoftware.htmlunit.html.HtmlPage;


public class DateUtil {

    private String latestVocationName="";

    public String getLatestVocationName() {
        return latestVocationName;
    }

    public void setLatestVocationName(String latestVocationName) {
        this.latestVocationName = latestVocationName;
    }

    public String getVocationName(DomNodeList<HtmlElement> htmlElements, String date) throws ParseException{
        String rst = "";
        boolean pastTimeFlag = false;
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
        Date paramDate = dateFormat.parse(date);
        if(new Date().getTime() >= paramDate.getTime()){
            pastTimeFlag = true;
        }
        for(int i = 0; i < htmlElements.size(); i++){
            HtmlElement element = htmlElements.get(i);
            if(element.getAttribute("class").indexOf("vacation")!=-1){
                boolean hitFlag = false;
                String voationName = "";
                for(; i < htmlElements.size(); i++){
                    HtmlElement elementTmp = htmlElements.get(i);
                    String liDate = elementTmp.getAttribute("date");
                    List<HtmlElement> lunar = elementTmp.getElementsByAttribute("span", "class", "lunar");
                    String lanarText = lunar.get(0).asText();
                    if(lanarText.equals("元旦")){
                        voationName = "元旦";
                    }else if(lanarText.equals("除夕")||lanarText.equals("春节")){
                        voationName = "春节";
                    }else if(lanarText.equals("清明")){
                        voationName = "清明";
                    }else if(lanarText.equals("国际劳动节")){
                        voationName = "国际劳动节";
                    }else if(lanarText.equals("端午节")){
                        voationName = "端午节";
                    }else if(lanarText.equals("中秋节")){
                        voationName = "中秋节";
                    }else if(lanarText.equals("国庆节")){
                        voationName = "国庆节";
                    }
                    if(liDate.equals(date)){
                        hitFlag = true;
                    }
                    if(elementTmp.getAttribute("class").indexOf("vacation")==-1){
                        break;
                    }
                }
                if(hitFlag == true && !voationName.equals("")){
                    rst = voationName;
                    break;
                }
            }else{
                continue;
            }
        }
        //if first step fail(rarely), get from the latest Vocation name
        DateUtil dateUtil = new DateUtil();
        if(rst.equals("")){
            System.out.println("warning: fail to get vocation name from html page.");
            rst = dateUtil.getLatestVocationName();
        }else if(pastTimeFlag == true){
        //更新《当前时间，且最近一次的可见的假期名
            dateUtil.setLatestVocationName(rst);
        }
        return rst;
    }

    public List<ChinaDate> getCurrentDateInfo(String year,String month){
        Integer yearInt = Integer.parseInt(year);
        Integer monthInt = Integer.parseInt(month);
        year = yearInt.toString();
        month = monthInt.toString();
        WebClient webClient = null;
        List<ChinaDate> dateList = null;
        try{
            DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
            dateList = new ArrayList<ChinaDate>();
            webClient = new WebClient();
            HtmlPage page = webClient.getPage("https://hao.360.com/rili/");
            //最大等待60秒
            for(int k = 0; k < 60; k++){
                if(!page.getElementById("M-dates").asText().equals("")) break;
                Thread.sleep(1000);
            }
            //睡了8秒，等待页面加载完成
            //Thread.sleep(8000);

            //选择指定年份
            DomNodeList<HtmlElement> years =  page.getElementById("M-controls").getFirstElementChild().getFirstElementChild().getElementsByTagName("li");
            DomNodeList<HtmlElement> y =  page.getElementById("M-controls").getFirstElementChild().getFirstElementChild().getElementsByTagName("i");
            y.get(0).click();
            for(HtmlElement yea : years){
                if(yea.getTextContent().equals(year+"年")){
                    page = yea.click();
                }
            }
            //选择指定月份
            DomNodeList<HtmlElement> monthsElements =  page.getElementById("M-controls").getFirstElementChild().getElementsByTagName("div");
            DomNodeList<HtmlElement> months = monthsElements.get(3).getElementsByTagName("li");
            DomNodeList<HtmlElement> m =  page.getElementById("M-controls").getFirstElementChild().getFirstElementChild().getNextElementSibling().getElementsByTagName("i");
            m.get(0).click();
            for(HtmlElement mon : months){
                if(mon.getTextContent().equals(month+"月")){
                    page = mon.click();
                }
            }
            DomNodeList<HtmlElement> htmlElements = page.getElementById("M-dates").getElementsByTagName("li");
            //System.out.println(htmlElements.size());
            for(HtmlElement element : htmlElements){
                ChinaDate chinaDate = new ChinaDate();
                List<HtmlElement> lunar = element.getElementsByAttribute("span", "class", "lunar");
                List<HtmlElement> solar = element.getElementsByAttribute("div", "class", "solar");
                chinaDate.setLunar(lunar.get(0).asText());
                chinaDate.setSolar(solar.get(0).asText());
                chinaDate.setSolarDate(dateFormat.parse(element.getAttribute("date")));
                if(element.getAttribute("class").indexOf("vacation")!=-1){
                    chinaDate.setVacation(true);
                    chinaDate.setVacationName(this.getVocationName(htmlElements, element.getAttribute("date")));
                }
                if(element.getAttribute("class").indexOf("weekend")!=-1 &&
                        element.getAttribute("class").indexOf("last")==-1){
                    chinaDate.setSaturday(true);
                }
                if(element.getAttribute("class").indexOf("last weekend")!=-1){
                    chinaDate.setSunday(true);
                }
                if(element.getAttribute("class").indexOf("work")!=-1){
                    chinaDate.setWorkFlag(true);
                }else if(chinaDate.isSaturday() == false &&
                        chinaDate.isSunday() == false &&
                        chinaDate.isVacation() == false ){
                    chinaDate.setWorkFlag(true);
                }else{
                    chinaDate.setWorkFlag(false);
                }
                dateList.add(chinaDate);
            }
            webClient.close();
        }catch(Exception e){
            e.printStackTrace();
            System.out.println("get date from http://hao.360.cn/rili/ error~");
        }
        return dateList;
    }

    public ChinaDate getTodayInfo(List<ChinaDate> dateList,Date date){
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
        for(ChinaDate d: dateList){
            if(dateFormat.format(d.getSolarDate()).equals(dateFormat.format(date))){
                return d;
            }
        }
        return new ChinaDate();
    }

//    public static void main(String[] args) throws FailingHttpStatusCodeException, MalformedURLException, IOException, InterruptedException, ParseException {
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//        SimpleDateFormat sdfy = new SimpleDateFormat("yyyy");
//        SimpleDateFormat sdfm = new SimpleDateFormat("MM");
//        Date d = sdf.parse("2020-09-06");
//        List<ChinaDate> dateList = new DateUtil().getCurrentDateInfo(sdfy.format(d),sdfm.format(d));
//        ChinaDate cd = new DateUtil().getTodayInfo(dateList,d);
//        System.out.println("cd.isSaturday() = " + cd.isSunday());
//        System.out.println("本月详情：");
//        for(ChinaDate date: dateList){
//            System.out.println(sdf.format(date.getSolarDate()) + " " + date.isSunday());
//        }
//    }


}
