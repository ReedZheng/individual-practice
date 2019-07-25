package practicecourt.offer;

import org.junit.Test;

public class Off023Test {

    @Test
    public void test() {
        Off023 off023 = new Off023();
        // "PSH3","MIN","PSH4","MIN","PSH2","MIN","PSH3","MIN","POP","MIN","POP","MIN","POP","MIN","PSH0","MIN"
        off023.push(3);
        System.out.print(off023.min() + " ");
        off023.push(4);
        System.out.print(off023.min() + " ");
        off023.push(2);
        System.out.print(off023.min() + " ");
        off023.push(3);
        System.out.print(off023.min() + " ");
        off023.pop();
        System.out.print(off023.min() + " ");
        off023.pop();
        System.out.print(off023.min() + " ");
        off023.pop();
        System.out.print(off023.min() + " ");
        off023.push(0);
        System.out.print(off023.min() + " ");
    }
}