package 设计模式.结构型.享元模式;

import java.util.HashMap;
import java.util.Map;

/**
 * @program testCollections
 * @description: 享元模式
 * 享元模式（英语：Flyweight Pattern）是一种软件设计模式。它使用共享物件，用来尽可能减少内存使用量以及分享资讯给尽可能多的相似物件；
 * 它适合用于当大量物件只是重复因而导致无法令人接受的使用大量内存。通常物件中的部分状态是可以分享。
 * 常见做法是把它们放在外部数据结构，当需要使用时再将它们传递给享元。
 * @author: xielinzhi
 * @create: 2020/05/18 15:05
 */

public class
FlyWeightPattern {
}


abstract class AbstractHero {

    protected final String name;//英雄名称

    protected final String[] skills = new String[4];//每个英雄都有四个技能

    public AbstractHero() {
        super();
        this.name = getName();
        initSkills();
        checkSkills();
    }

    private void checkSkills(){
        for (int i = 0; i < skills.length; i++) {
            if (skills[i] == null) {
                throw new NullPointerException();
            }
        }
    }

    //释放技能
    public void release(int index){
        if (index < 0) {
            index = 0;
        }else if (index > 3) {
            index = 3;
        }
        System.out.println(name + "释放" + skills[index]);
    }

    //物理攻击
    public void commonAttack(){
        System.out.println(name + "进行物理攻击");
    }

    public abstract String getName();

    public abstract void initSkills();

}


//用于组合英雄内部状态和外部状态的类，假设称为角色
 class Role {

    private AbstractHero hero;//角色选择的英雄

    //我们把血量和魔法量这两个外部状态从英雄里剥离出来，放到外部的角色类中
    private long hp;

    private long mp;

    public Role(AbstractHero hero) {
        super();
        this.hero = hero;
    }

    //释放技能
    public void release(int index){
        hero.release(index);
    }

    //物理攻击
    public void commonAttack(){
        hero.commonAttack();
    }

    public long getHp() {
        return hp;
    }

    public void setHp(long hp) {
        this.hp = hp;
    }

    public long getMp() {
        return mp;
    }

    public void setMp(long mp) {
        this.mp = mp;
    }

}

 class HeroManager {

    private static HeroManager heroManager = new HeroManager();

    private Map<String, AbstractHero> heroMap;

    private HeroManager(){
        heroMap = new HashMap<String, AbstractHero>();
    }

    public static HeroManager getInstance(){
        return heroManager;
    }

    //该方法提供共享功能
    public AbstractHero getHero(String name){
        AbstractHero hero = heroMap.get(name);
        if (hero == null) {
            if (name.equals("恶魔巫师")) {
                hero = new Lion();
            }else if (name.equals("影魔")) {
                hero = new SF();
            }
            heroMap.put(name, hero);
        }
        return hero;
    }
}

class Lion extends AbstractHero{

    public String getName() {
        return "恶魔巫师";
    }

    public void initSkills() {
        skills[0] = "穿刺";
        skills[1] = "妖术";
        skills[2] = "法力汲取";
        skills[3] = "死亡一指";
    }

}

class SF extends AbstractHero{

    public String getName() {
        return "影魔";
    }

    public void initSkills() {
        skills[0] = "毁灭阴影";
        skills[1] = "支配死灵";
        skills[2] = "魔王降临";
        skills[3] = "魂之挽歌";
    }

}
