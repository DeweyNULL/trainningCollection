package 日期;

import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @program testCollections
 * @description: 日期格式校验
 * @author: xielinzhi
 * @create: 2019/10/21 11:22
 */

public class DateFormat {

    private static final String dateFormat = "YYYY-MM-DD";

    @Test
    public void testDate(){
        System.out.println(isDate("1995-07-32"));
        System.out.println(isDate("1995-07-30"));
        System.out.println(isDate("1995-17-30"));
        System.out.println(isDate("1995-24-30"));
        System.out.println(isDate("1995-7-30"));
        System.out.println(isDate("1995-7-3"));
        System.out.println(isDate("1995-07-3"));
        System.out.println(isDate("567-07-30"));
    }

    boolean isDate(String date ){
        boolean isDate = true;

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(dateFormat);
        try {
            simpleDateFormat.parse(date);
        }catch (Exception e){
            e.printStackTrace();
            // logger.error("空指针或者格式错误",e);
            return false;
        }
        String[] ymd = date.split("-");

        if(ymd.length==3){
            int day = Integer.parseInt(ymd[2]);
            int month = Integer.parseInt(ymd[1]);
            switch (month){
                case 1:
                case 3:
                case 5:
                case 7:
                case 8:
                case 10:
                case 12:
                    if(day<0 || day>31){
                        isDate = false;
                    }
                    break;
                case 2:
                    int year = Integer.parseInt(ymd[0]);
                    if(year % 4 == 0 && year % 100 !=0){
                        if(day<0 || day>29){
                            isDate = false;
                        }
                    }else {
                        if(day<0 || day>28){
                            isDate = false;
                        }
                    }
                    break;
                case 4:
                case 6:
                case 9:
                case 11:
                    if(day<0 || day>30){
                        isDate = false;
                    }
                    break;
                default:
                    isDate = false;
                    break;
            }
        }
        return isDate;
    }


    @Test
    public void testInt(){
        String days = "01";
        System.out.println(Integer.parseInt(days));
    }

    @Test
    public void testYMD() throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String date = "2019-7-121 2:2:2";


        Date temp = sdf.parse(date);
        System.out.printf(sdf.format(temp));
    }
}

/**
 * 输入日期 并进行验证格式是否正确
 */
class FDate {

    public static void main(String[] args) {
        System.out.println(validate("2018-6-3 20:00:00"));
    }

    /**
     * 检查是否是闰年
     *
     * @param year
     * @return
     */
    public static boolean run(int year) {
        if (year % 4 == 0 && year % 100 != 0 || year % 400 == 0) {// 是闰年
            return true;
        } else {
            return false;
        }
    }

    public static boolean validate(String dateStr) {
        String[] data ;
        boolean flag = true; // 若不符合规则将值改为false
        String year = "[0-9]{4}";// 年
        String month = "[0-9]||0[0-9]||1[12]";// 月
        String day = "[0-9]||[0-2][0-9]||3[01]";// 天
        int YEAR = 0;
        String str = dateStr;// 输入的字符串
        //年月日校验
        data = str.split(" ")[0].split("[-/.+]");
        // 最基本的检查格式 begin
        if (!data[0].matches(year)) {
            flag = false;
        }
        if (!data[1].matches(month)) {
            flag = false;
        }
        if (!data[2].matches(day)) {
            flag = false;
        }
        // end
        YEAR = Integer.valueOf(data[0]);
        boolean run = run(YEAR);// run 为true是闰年否则是 非闰年
        if (run) {// 闰年
            if (data[1].matches("0[2]||2")) {// 这里是闰年的2月
                if (!data[2].matches("0[1-9]||[1-9]||1[0-9]||2[0-9]")) {
                    flag = false;
                }
            }
        } else {// 非闰年
            if (data[1].matches("0[2]||2")) {// 这里是平年的2月
                if (!data[2].matches("0[1-9]||[1-9]||1[0-9]||2[0-8]")) {
                    flag = false;
                }
            }
        }

        // 下面判断除了2月份的大小月天数
        if (data[1].matches("0[13578]||[13578]||1[02]")) {// 这里是大月
            if (!data[2].matches("0[1-9]||[1-9]||[12][0-9]||3[01]")) {
                flag = false;
            }
        } else if (data[1].matches("0[469]||[469]||11")) {// 这里是小月
            if (!data[2].matches("0[1-9]||[1-9]||[12][0-9]||30")) {
                flag = false;
            }
        }
        return flag;
    }

}