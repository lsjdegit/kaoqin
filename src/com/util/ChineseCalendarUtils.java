package com.util;



import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;


/**
 * @author  qyw
 * @description  日期日历工具类
 * @date Created in 21:01 2019/1/31
 **/
public class ChineseCalendarUtils {

    // 法律规定的放假日期
    // 此处写死了。需要定时入库再读库，政府每年都会在12月份左右公布，无法提前预知
    public List<String> lawHolidays   = Arrays.asList("2020-01-01", "2020-01-25",
            "2020-01-26", "2020-01-27", "2020-01-28", "2020-01-29", "2020-01-30",
            "2020-01-31", "2020-02-01", "2020-02-02", "2020-02-03", "2020-02-04", "2020-02-05", "2020-02-06",  "2020-04-05", "2020-04-06",
            "2020-04-04", "2020-05-01", "2020-05-02", "2020-05-03", "2020-05-04",
            "2020-05-05", "2020-06-25", "2020-06-26", "2020-06-27", "2020-10-01",
            "2020-10-02", "2020-10-03", "2020-10-04", "2020-10-05",
            "2020-10-06", "2020-10-07");
    // 由于放假需要额外工作的周末
    // private List<String> extraWorkdays = Arrays.asList("2020-02-11", "2020-02-24",
    //          "2020-04-08", "2020-04-28", "2020-09-29", "2020-09-30");

    /**
     * @author  qyw
     * @description  判断是否是法定假日
     * @date Created in 21:03 2019/1/31
     **/
    public boolean isLawHoliday(String calendar) throws Exception {
        ChineseCalendarUtils.isValidDate(calendar);
        if (lawHolidays.contains(calendar)) {
            return true;
        }
        return false;
    }

    /**
     * @author  qyw
     * @description  判断是否是周末
     * @date Created in 21:03 2019/1/31
     **/
    public boolean isWeekends(String calendar) throws Exception {
        ChineseCalendarUtils.isValidDate(calendar);
        // 先将字符串类型的日期转换为Calendar类型
        SimpleDateFormat sdf  = new SimpleDateFormat("yyyy-MM-dd");
        Date             date = sdf.parse(calendar);
        Calendar         ca   = Calendar.getInstance();
        ca.setTime(date);
        if (ca.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY
                || ca.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY) {
            return true;
        }
        return false;
    }

    /**
     * @author  qyw
     * @description  判断是否是需要额外补班的周末
     * @date Created in 21:06 2019/1/31
     **/
//    public boolean isExtraWorkday(String calendar) throws Exception {
//        ChineseCalendarUtils.isValidDate(calendar);
//        if (extraWorkdays.contains(calendar)) {
//            return true;
//        }
//        return false;
//    }

    /**
     * @author  qyw
     * @description  判断是否是休息日（包含法定节假日和不需要补班的周末）
     * @date Created in 21:06 2019/1/31
     **/
//    public boolean isHoliday(String calendar) throws Exception {
//        ChineseCalendarUtils.isValidDate(calendar);
//        // 首先法定节假日必定是休息日
//        if (this.isLawHoliday(calendar)) {
//            return true;
//        }
//        // 排除法定节假日外的非周末必定是工作日
//        if (!this.isWeekends(calendar)) {
//            return false;
//        }
//        // 所有周末中只有非补班的才是休息日
//        if (this.isExtraWorkday(calendar)) {
//            return false;
//        }
//        return true;
//    }

    /**
     * @author  qyw
     * @description  校验字符串是否为指定的日期格式,含逻辑严格校验,2007/02/30返回false
     * @date Created in 21:06 2019/1/31
     **/
    public static boolean isValidDate(String str) {
        boolean convertSuccess = true;
        // 指定日期格式为四位年/两位月份/两位日期，注意yyyy-MM-dd区分大小写；
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        try {
            // 设置lenient为false.
            // 否则SimpleDateFormat会比较宽松地验证日期，比如2007/02/29会被接受，并转换成2007/03/01
            format.setLenient(false);
            format.parse(str);
        } catch (ParseException e) {
            convertSuccess = false;
        }
        return convertSuccess;
    }


    public static void main(String[] args) throws Exception {
        String calendar = "2020-10-03";
        ChineseCalendarUtils cc       = new ChineseCalendarUtils();
        System.out.println("输入的calendar是否是指定要求的格式:"+ ChineseCalendarUtils.isValidDate(calendar));
        System.out.println("是否是法定节假日：" + cc.isLawHoliday(calendar));
        System.out.println("是否是周末：" + cc.isWeekends(calendar));
        // System.out.println("是否是需要额外补班的周末：" + cc.isExtraWorkday(calendar));
        // System.out.println("是否是休息日：" + cc.isHoliday(calendar));
        if(cc.isValidDate(calendar)){
            //是法定节假日的判断
            if(cc.isLawHoliday(calendar)){
                System.out.println("是法定节假");
            }
            if(cc.isWeekends(calendar)){
                System.out.println("是周末");

            }

        }
    }
}


