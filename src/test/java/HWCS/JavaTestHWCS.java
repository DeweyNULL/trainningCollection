package HWCS;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.Scanner;

/**
 * @program testCollections
 * @description:
 * @author: xielinzhi
 * @create: 2020/04/26 20:43
 */

public class JavaTestHWCS {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            String intput = scanner.next();
            Integer n = Integer.valueOf(intput);
            if(n == 0) {
                System.out.println(0);
                continue;
            }
            int numsOfTwo = n/2;
            int numsOfOne = 0;
            int methods = 0;
            if(n%2 == 1){
                numsOfOne++;
            }
            while (numsOfTwo>=0){
                methods+=intC(numsOfTwo+numsOfOne,numsOfTwo);
                numsOfTwo--;
                numsOfOne+=2;
            }
            System.out.println(methods);
        }
    }

    @Test
    public void testC(){
    }

    public static long intC(long all,long part){
        if(part == 0 || all == part) return 1;
        long tempall = 1;
        for (long i = 1; i <= all; i++) {
            if(i>part){
                tempall = tempall * i / (i-part);
            }
        }
        return tempall;
    }
    @Test
    public void testFeb(){
        System.out.println(testn(123));
    }

    public static BigDecimal testn(long n){
        if(n == 1) return BigDecimal.valueOf(1);
        if(n == 2) return  BigDecimal.valueOf(2);
        return testn(n-1).add(testn(n-2));
    }
}
