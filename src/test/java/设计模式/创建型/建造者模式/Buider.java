package 设计模式.创建型.建造者模式;

/**
 * @program testCollections
 * @description: 建造者模式
 * @author: xielinzhi
 * @create: 2020/04/28 13:48
 */

/**
 *
 */

interface DoppelgangerBuilder {

    public void createDoppelganger(String name);

    public void buildBody();

    public void buildHead();

    public void buildLeftArm();

    public void buildLeftHand();

    public void buildRightArm();

    public void buildRightHand();

    public void buildLeftLeg();

    public void buildLeftFoot();

    public void buildRightLeg();

    public void buildRightFoot();

    public Doppelganger getDoppelganger();

}


//灵魂类，指挥者
 class Soul {
    public Doppelganger createDoppelganger(DoppelgangerBuilder doppelgangerBuilder,String name){
        doppelgangerBuilder.createDoppelganger(name);
        doppelgangerBuilder.buildBody();
        doppelgangerBuilder.buildHead();
        doppelgangerBuilder.buildLeftArm();
        doppelgangerBuilder.buildLeftHand();
        doppelgangerBuilder.buildRightArm();
        doppelgangerBuilder.buildRightHand();
        doppelgangerBuilder.buildLeftLeg();
        doppelgangerBuilder.buildLeftFoot();
        doppelgangerBuilder.buildRightLeg();
        doppelgangerBuilder.buildRightFoot();
        return doppelgangerBuilder.getDoppelganger();
    }
}

//具体实现类
 class ThinBuilder implements DoppelgangerBuilder{

    private Doppelganger doppelganger;

    public void createDoppelganger(String name){
        doppelganger = new Doppelganger(name);
    }

    public Doppelganger getDoppelganger(){
        try {
            return doppelganger;
        }finally{
            doppelganger = null;
        }
    }

    public void buildBody() {
        System.out.println("设置" + doppelganger.getName() + "的瘦瘦的身体");
        doppelganger.setBody("瘦瘦的身体");
    }

    public void buildHead() {
        System.out.println("设置" + doppelganger.getName() + "的小小的头");
        doppelganger.setHead("小小的头");
    }

    public void buildLeftArm() {
        System.out.println("设置" + doppelganger.getName() + "的瘦瘦的左胳膊");
        doppelganger.setLeftArm("瘦瘦的左胳膊");
    }

    public void buildLeftHand() {
        System.out.println("设置" + doppelganger.getName() + "的瘦瘦的左手");
        doppelganger.setLeftHand("瘦瘦的左手");
    }

    public void buildRightArm() {
        System.out.println("设置" + doppelganger.getName() + "的瘦瘦的右胳膊");
        doppelganger.setRightArm("瘦瘦的右胳膊");
    }

    public void buildRightHand() {
        System.out.println("设置" + doppelganger.getName() + "的瘦瘦的右手");
        doppelganger.setRightHand("瘦瘦的右手");
    }

    public void buildLeftLeg() {
        System.out.println("设置" + doppelganger.getName() + "的瘦瘦的左腿");
        doppelganger.setLeftLeg("瘦瘦的左腿");
    }

    public void buildLeftFoot() {
        System.out.println("设置" + doppelganger.getName() + "的小小的左脚");
        doppelganger.setLeftFoot("小小的左脚");
    }

    public void buildRightLeg() {
        System.out.println("设置" + doppelganger.getName() + "的瘦瘦的右腿");
        doppelganger.setRightLeg("瘦瘦的右腿");
    }

    public void buildRightFoot() {
        System.out.println("设置" + doppelganger.getName() + "的小小的右脚");
        doppelganger.setRightFoot("小小的右脚");
    }
}


public class Buider {


}
