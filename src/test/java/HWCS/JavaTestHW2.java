package HWCS;

import java.util.*;

/**
 * @program testCollections
 * @description:
 * @author: xielinzhi
 * @create: 2020/04/26 21:42
 */

public class JavaTestHW2 {

    public static int len = 0;
    public static int conut = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            String input = scanner.next();
            if(input == null || "".equals(input)){
                System.out.println(0);
                continue;
            }
            len = input.length();
            handleString(input,"");
            System.out.println(conut);
            conut = 0;
        }
    }

    public static void handleString(String rest,String out){
        if(rest == null || rest.length()<1) {
            conut++;
            return;
        }
        Map<Character,Integer> mark = new HashMap<>();
        for (int i = 0; i < rest.length(); i++) {
            if(mark.get(rest.charAt(i)) == null){
                out += rest.charAt(i);
                mark.put(rest.charAt(i),i);
                handleString(rest.substring(0,i)+rest.substring(i+1),out);
                out = out.substring(0,len-rest.length());
            }
        }
    }
}
