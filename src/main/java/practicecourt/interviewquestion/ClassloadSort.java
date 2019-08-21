package practicecourt.interviewquestion;

/**
 * 坑爹的面试题
 */
public class ClassloadSort {

    public static void main(String[] args) {
        Singleton.getInstance();
        System.out.println("Singleton value1:" + Singleton.value1);
        System.out.println("Singleton value2:" + Singleton.value2);

        Singleton2.getInstance2();
        System.out.println("Singleton2 value1:" + Singleton2.value1);
        System.out.println("Singleton2 value2:" + Singleton2.value2);
    }
}

class Singleton {
    static {
        System.out.println(Singleton.value1 + "\t" + Singleton.value2 + "\t" + Singleton.singleton);
    }
    private static Singleton singleton = new Singleton();
    public static int value1 = 5;
    public static int value2 = 3;

    private Singleton() {
        value1++;
        System.out.println("Singleton:value1 = " + value1);
        value2++;
        System.out.println("Singleton:value2 = " + value2);
    }

    public static Singleton getInstance() {
        return singleton;
    }

    // int count = 10;

    {
        System.out.println("count = " + value1);
    }
}

class Singleton2 {
    static {
        System.out.println(Singleton2.value1 + "\t" + Singleton2.value2 + "\t" + Singleton2.singleton2);
    }

    public static int value1 = 5;
    public static int value2 = 3;
    private static Singleton2 singleton2 = new Singleton2();

    // int count = 20;
    {
        System.out.println("count = " + value1);
    }

    private Singleton2() {
        value1++;
        System.out.println("Singleton2:value1 = " + value1);
        value2++;
        System.out.println("Singleton2:value2 = " + value2);
    }

    public static Singleton2 getInstance2() {
        return singleton2;
    }
}


