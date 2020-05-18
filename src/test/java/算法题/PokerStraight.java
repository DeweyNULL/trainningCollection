package 算法题;

import org.junit.Test;


import java.util.*;

/**
 * @program springbootcachedemo
 * @description: 扑克牌顺子
 * LL今天心情特别好,因为他去买了一副扑克牌,
 * 发现里面居然有2个大王,2个小王(一副牌原本是54张^_^)...
 * 他随机从中抽出了5张牌,想测测自己的手气,看看能不能抽到顺子,
 * 如果抽到的话,他决定去买体育彩票,嘿嘿！！
 * “红心A,黑桃3,小王,大王,方片5”,“Oh My God!”不是顺子.....
 * LL不高兴了,他想了想,决定大\小 王可以看成任何数字,并且A看作1,J为11,Q为12,K为13。
 * 上面的5张牌就可以变成“1,2,3,4,5”(大小王分别看作2和4),“So Lucky!”。LL决定去买体育彩票啦。
 * 现在,要求你使用这幅牌模拟上面的过程,然后告诉我们LL的运气如何，
 * 如果牌能组成顺子就输出true，否则就输出false。为了方便起见,你可以认为大小王是0。
 * @author: xielinzhi
 * @create: 2019/05/05 10:07
 */

public class PokerStraight {

    public boolean isStraight( int numbers[]){
        boolean flag = true;
        Random rand = new Random();
        List<Integer> list = new ArrayList<Integer>();
        if(null==numbers){
            for (int i = 0; i < 5; i++) {
                int card = rand.nextInt(56)+1;
                while (card>13 && card<53){
                    card-=13;
                }

                if(list.contains(card)){
                    i--;
                    continue;
                }

                if (card>=53) card=0;
                list.add(card);
            }
        }else {
            for (int a:numbers) {
                list.add(a);
            }
        }
        Collections.sort(list);
        int a[] = new int[5];
        int i = 0;
        int lastnum = 0;
        for (int temp: list) {
            if(temp == 0){
                i++;
            }
            else {
                if(lastnum!=0 && temp - lastnum >(i+1)){

                        flag = false;
                }
                lastnum = temp;
            }
            System.out.println(temp);
        }
        return flag;
    }

    @Test
    public void testIsStraight(){
        //System.out.println(isStraight(null));
        int a[] ={0,0,0,5,0};
        System.out.println(isStraight(a));

    }
}
