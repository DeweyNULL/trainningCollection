package LEETCODE;

import org.junit.Test;

/**
 * @program testCollections
 * @description: 回文子串
 * @author: xielinzhi
 * @create: 2020/04/23 16:36
 */

public class LeetCode647 {
    public int countSubstrings(String s) {
        if(s == null || s.length()<1) return 0;
        if(s.length() == 1) return 1;
        int len = s.length();

        //以一个字母字母为中心
        int num = 0;
        for (int i = 0; i < len; i++) {
            int left = i;
            int right = i;
            while(left>=0 && right<len && s.charAt(left) == s.charAt(right)){
                num++;
                left--;
                right++;
            }
        }

        //以二个字母字母为中心
        for (int i = 0; i < len; i++) {
            int left = i;
            int right = i+1;
            while(left>=0 && right<len && s.charAt(left) == s.charAt(right)){
                num++;
                left--;
                right++;
            }
        }
        return num;
    }

    //leetCode 5
    public String longestPalindrome(String s) {
        if(s == null || s.length()<=1) return s;
        int len = s.length();

        int maxLen = 0;
        String maxString = s;
        //以一个字母字母为中心

        for (int i = 0; i < len; i++) {
            int left = i;
            int right = i;
            int tempLen = 1;
            while(left>=0 && right<len && s.charAt(left) == s.charAt(right)){
                tempLen+=2;
                left--;
                right++;
            }
            if(tempLen>maxLen){
                maxLen = tempLen;
                maxString = s.substring(left+1,right);
            }
        }

        //以二个字母字母为中心
        for (int i = 0; i < len; i++) {
            int left = i;
            int right = i+1;
            int tempLen = 2;
            while(left>=0 && right<len && s.charAt(left) == s.charAt(right)){
                tempLen+=2;
                left--;
                right++;
            }
            if(tempLen>maxLen){
                maxLen = tempLen;
                maxString = s.substring(left+1,right);
            }
        }

        return maxString;
    }

    @Test
    public void testSubString(){
        System.out.println(longestPalindrome("cbba"));
    }
}
