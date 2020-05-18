package 基础;

import org.junit.Test;

import java.math.BigDecimal;
import java.security.SecureRandom;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

/**
 * @program testCollections
 * @description:
 * @author: xielinzhi
 * @create: 2019/07/26 16:24
 */

public class MathTest {
    @Test
    public void testMath(){

      // long a = Math.round(12.5);
       // System.out.println(a);

        int a = 1000;
        int b = 323;
        int c = 1500;
        double d = (float)(a-b)/c;
        System.out.println(d);
    }

    @Test
    public void testException(){
        try{
            int a[] = {1,2,3};
            Integer temp = null;
            System.out.println(a[5]);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Test
    public void testMath1(){
        long a = 10;
        long b = 13;
        BigDecimal c = new BigDecimal(a).divide(new BigDecimal(b),2,BigDecimal.ROUND_DOWN);
        System.out.println((double)a/b);
        a = 9;
        BigDecimal d = new BigDecimal(a).divide(new BigDecimal(b),2,BigDecimal.ROUND_DOWN);
        System.out.println(c);
        System.out.println(d);
        System.out.println(d.toString());
        System.out.println(c.compareTo(d));
    }

    @Test
    public void testTrans(){
        String temp = "-0.9";
        Double tempNum  = Double.valueOf(temp);
        System.out.println(tempNum);
    }

    @Test
    public void dateMath() throws Exception{
        long now = System.currentTimeMillis();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        long target = sdf.parse("20190816").getTime();
        long day = (target-now)/(24*60*60*1000);
        BigDecimal days =new BigDecimal(target-now);
        BigDecimal pd = new BigDecimal("86400000");
        System.out.println(days.divide(pd,2,BigDecimal.ROUND_FLOOR).toString());
    }

    @Test
    public void stringTest(){
        String temp = "大于等于5" , temp2 = "大于6";
        int x = 1;
        if(x==1){
            System.out.println(1);
        }else if(x==1){
            System.out.println(2);
        }
    }

    @Test
    public void testRandom(){
       SecureRandom random = new SecureRandom();
       Random rnd = new Random();
        System.out.println(new Date().getTime());
        System.out.println(new Random(new Date().getTime()).nextInt());
        System.out.println(new Random(new Date().getTime()).nextInt());
        System.out.println(new Random(new Date().getTime()).nextInt());
        System.out.println(new Random(new Date().getTime()).nextInt());
        System.out.println(new Random(new Date().getTime()).nextInt());
        System.out.println(new Random(new Date().getTime()).nextInt());
        System.out.println(new Random(new Date().getTime()).nextInt());
        System.out.println(new Random(new Date().getTime()).nextInt());
        System.out.println(new Random(new Date().getTime()).nextInt());
        System.out.println(new Random(new Date().getTime()).nextInt());
    }

    @Test
    public void testBD(){
        BigDecimal month = new BigDecimal(-3).divide(new BigDecimal(12),2,BigDecimal.ROUND_DOWN);
        BigDecimal year = new BigDecimal(2).add(month);
        System.out.println(year);
    }

    @Test
    public void digui(){

    }




}
