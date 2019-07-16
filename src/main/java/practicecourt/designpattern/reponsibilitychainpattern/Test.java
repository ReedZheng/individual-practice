package practicecourt.designpattern.reponsibilitychainpattern;

/**
 * https://www.cnblogs.com/java-my-life/archive/2012/05/28/2516865.html
 * https://blog.csdn.net/u012810020/article/details/71194853 https://blog.csdn.net/jason0539/article/details/45091639#commentBox
 * https://www.jianshu.com/p/d65eeeed6754 https://my.oschina.net/u/3136594/blog/1556479
 */
public class Test {

    public static void main(String[] args) {
        Node n3 = new ConcreteNode3(null);
        Node n2 = new ConcreteNode2(n3);
        Node n1 = new ConcreteNode1(n2);

        n1.handle(340);
    }
}
