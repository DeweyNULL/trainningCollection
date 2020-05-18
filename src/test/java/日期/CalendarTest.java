package 日期;

import org.junit.Test;
import org.springframework.util.StringUtils;

import java.security.SecureRandom;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

/**
 * @program springbootcachedemo
 * @description: 日期测试
 * @author: xielinzhi
 * @create: 2019/06/13 16:40
 */

public class CalendarTest {

    //@Test
    public void testYMDH() throws Exception{
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String date = sdf.format(new Date());
        Date temp = sdf.parse("2019-06-12");
        date = sdf.format(temp);
        System.out.println(date);

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(temp);
        System.out.println(sdf.format(calendar.getTime()));
        calendar.add(Calendar.HOUR,-1);
        date = sdf.format(calendar.getTime());
        System.out.println(date);
    }

    public <T> List<List<T>> splitList(final List<T> list, final int commitSize) {
        final List<List<T>> splistList = new ArrayList<List<T>>();
        final int range = commitSize;
        if (list.size() < range) {
            splistList.add(list);
        }
        final int size = list.size();
        final int num = size % range == 0 ? size / range : (size / range) + 1;
        for (int j = 0; j < num; j++) {
            final int beg = range * j;
            int end = range * j + range;
            if ((j + 1) == num) {
                end = size;
            }
            splistList.add(list.subList(beg, end));
        }
        return splistList;
    }

    @Test
    public void testSplitList(){
        List<String> StringList = new ArrayList<>();
        for (Integer i = 0; i < 1 ; i++) {
            StringList.add(i.toString());
        }
        List<List<String>> subLists = splitList( StringList,500);
        System.out.println(subLists.size());

    }

    @Test
    public void randomMac4Qemu() {
        String SEPARATOR_OF_MAC = ":";
        Random random = new Random();
        String[] mac = {
                String.format("%02x", 0x52),
                String.format("%02x", 0x54),
                String.format("%02x", 0x00),
                String.format("%02x", random.nextInt(0xff)),
                String.format("%02x", random.nextInt(0xff)),
                String.format("%02x", random.nextInt(0xff))
        };

        String randomMac = String.join(SEPARATOR_OF_MAC, mac);
        System.out.println(randomMac);

    }

    @Test
    public void testMap(){
        Map<String,String> bizCodeMap = new HashMap<>();
        bizCodeMap.put("1","111");
        bizCodeMap.put("2","123123");
        String[] keys = bizCodeMap.keySet().toArray(new String[0]);
        Random random = new Random();
        System.out.println(keys[random.nextInt(keys.length)]);
    }


    @Test
    public void testYMDHMS() throws Exception{
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String date = "1029-13-1";
        try {
            Date date1 = sdf.parse(date);
            System.out.println(date1);
            System.out.println(sdf.format(date1));
        }catch (Exception e){
            System.out.println("格式转换错误");
        }
    }

    Date randomDate(String begin ,String end) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        Date date = null;
        try {
            Date start = sdf.parse(begin);
            Date last = sdf.parse(end);
            long rtn = start.getTime() + (long) (Math.random() * (last.getTime() - start.getTime()));
            date = new Date(rtn);
        }catch (Exception e){
            e.printStackTrace();
        }
        return date;
    }

    @Test
    public void testD() throws Exception{
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        String today = sdf.format(new Date());
        calendar.setTime(sdf.parse(today));
        System.out.println(calendar.getTime().toString());
        //System.out.println(calendar.getTime().getTime());
        //calendar.add(Calendar.DAY_OF_MONTH, -1);

    }

    @Test
    public void testParam(){
        excute(1);
        excute();
    }

    void excute(int... param){
        if (param.length>0){
            System.out.println(param);
        }
    }

    //校验日期格式
    @Test
    public void checkDate(){
        String checkValue = "2008-09-11 14:17:1";
        DateFormat dateFormat = new SimpleDateFormat("yyyyMMdd HH:mm:ss");
        Date d = null;
        if(checkValue != null && !checkValue.equals(""))
        {
            if(checkValue.split("/").length > 1)
            {
                dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
            }
            if (checkValue.split("-").length > 1)
            {
                dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            }
        }else
        {
            return;
        }
        try
        {
            d = dateFormat.parse(checkValue);
            System.out.println(d);
        }
        catch(Exception e)
        {
            System.out.println("格式错误");
            return;
        }
        String eL= "^((\\d{2}(([02468][048])|([13579][26]))[\\-\\/\\s]?((((0?[13578])|(1[02]))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(3[01])))|(((0?[469])|(11))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(30)))|(0?2[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])))))|(\\d{2}(([02468][1235679])|([13579][01345789]))[\\-\\/\\s]?((((0?[13578])|(1[02]))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(3[01])))|(((0?[469])|(11))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(30)))|(0?2[\\-\\/\\s]?((0?[1-9])|(1[0-9])|(2[0-8]))))))(\\s(((0?[0-9])|([1-2][0-9]))\\:([0-5]?[0-9])((\\s)|(\\:([0-5]?[0-9])))))?$";
        Pattern p = Pattern.compile(eL);
        Matcher m = p.matcher(checkValue);
        boolean b = m.matches();
        if(b)
        {

            System.out.println("格式正确");
        }
        else
        {
            System.out.println("格式错误");
        }
    }

    @Test
    public void testDate123() throws  Exception{
        Date now = new Date();

        String checkValue = "2008-09-11 16:17:11";
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date lastTime = dateFormat.parse(checkValue);

        Long days = (now.getTime() - lastTime.getTime())/(1000*3600*24);
        System.out.println( days);
        System.out.println( dateFormat.format(now));
    }


    @Test
    public void testList(){
        List<String> test = new ArrayList<>();
        for (Integer i = 0; i < 1000; i++) {
            test.add(i.toString());
        }
        SecureRandom random = new SecureRandom();
        for(int i=0;i<test.size();i++){
            Integer j = random.nextInt(1000);
            if(test.contains(j.toString())){
                test.remove(i);
                i--;
                System.out.println(j);
            }
        }
        System.out.println(test.size());
    }

    public void testStream(){
        Map<String, String> headersConfig = new HashMap<>();
        List<List<String>> headers = headersConfig.values().stream()
                .map(Collections::singletonList)
                .collect(Collectors.toList());
    }

    @Test
    public void testLists(){
        List<Integer> total = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            if(i%2==0){
                total.add(i);
            }else {
                List<Integer> temp = new ArrayList<>();
                if(i == 3){
                    temp.add(i);
                }
                total.addAll(temp);
            }
        }
        for (Integer temp: total) {
            System.out.println(temp);
        }
    }
}
