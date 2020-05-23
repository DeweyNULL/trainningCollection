package 面试算法题;

import java.util.HashMap;
import java.util.Map;

/**
 * @program testCollections
 * @description:
 *
 * 给定一个赎金信 (ransom) 字符串和一个杂志(magazine)字符串，判断第一个字符串 ransom 能不能由第二个字符串 magazines 里面的字符构成。如果可以构成，返回 true ；否则返回 false。
 *
 * (题目说明：为了不暴露赎金信字迹，要从杂志上搜索各个需要的字母，组成单词来表达意思。杂志字符串中的每个字符只能在赎金信字符串中使用一次。)
 *
 * @author: xielinzhi
 * @create: 2020/05/18 19:31
 */

public class Test2 {

    public boolean canConstruct(String ransomNote, String magazine) {

        if(magazine == null || ransomNote == null ) return  false;

        Map<Character,Integer> dic = new HashMap<>();

        for (int i = 0; i < magazine.length(); i++) {
            Character tempChar = magazine.charAt(i);
            if(dic.get(tempChar) == null){
                dic.put(tempChar,1);
            }else {
                dic.put(tempChar,dic.get(tempChar)+1);
            }
        }

        for (int i = 0; i < ransomNote.length(); i++) {
            Character tempChar = ransomNote.charAt(i);
            if(dic.get(tempChar) == null){
                 return false;
            }else {
                Integer times = dic.get(tempChar);
                if(times > 0){
                    dic.put(tempChar,times-1);
                }else {
                    return false;
                }
            }
        }

        return true;
    }

}
