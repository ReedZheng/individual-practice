package practicecourt.interviewquestion;

/**
 * @Description: 父子类加载顺序
 * @Author: reed
 */
public class LoadSequence {
    public static void main(String[] args) {
        Father bcb = new Child();
        bcb.msg();
    }
}

class Child extends Father {
    static {
        System.out.println("这里是子类的静态代码块");
    }

    Other o = new Other();

    {
        System.out.println("这里是子类的普通代码块");
    }

    public Child() {
        System.out.println("这里是子类的构造方法");
    }

    public static void msg2() {
        System.out.println("这里是子类的静态方法");
    }

    @Override
    public void msg() {
        System.out.println("这里是子类的普通方法");
    }
}

class Father {

    static {
        System.out.println("这里是父类的静态代码块");
    }

    Other2 o2 = new Other2();

    {
        System.out.println("这里是父类的普通代码块");
    }

    public Father() {
        System.out.println("这里是父类的构造方法");
    }

    public static void msg2() {
        System.out.println("这里是父类的静态方法");
    }

    public void msg() {
        System.out.println("这里是父类的普通方法");
    }
}

class Other {
    Other() {
        System.out.println("初始化子类的属性值");
    }
}

class Other2 {
    Other2() {
        System.out.println("初始化父类的属性值");
    }
}
