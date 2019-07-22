package practicecourt.designpattern.builderpattern.patternnotwithdirector;

public class Test1 {

    public static void main(String[] args) {
        Computer asd = MyBuilder.newInstance().buildPartA("asd").buildPartB("asd-B").buildPartC("asd-C").build();
        System.out.println(asd);
    }
}
