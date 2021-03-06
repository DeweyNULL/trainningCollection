package 设计模式.行为型.命令模式;

/**
 * @program testCollections
 * @description: 命令模式
 * 在软件系统中，“行为请求者”与“行为实现者”通常呈现一种“紧耦合”。
 * 但在某些场合，比如要对行为进行“记录、撤销/重做、事务”等处理，这种无法抵御变化的紧耦合是不合适的。
 * 在这种情况下，如何将“行为请求者”与“行为实现者”解耦？将一组行为抽象为对象，实现二者之间的松耦合。这就是命令模式（Command Pattern）
 * @author: xielinzhi
 * @create: 2020/05/18 19:19
 */

public class CommandMode {
}

interface Task {

    void handle();

}

