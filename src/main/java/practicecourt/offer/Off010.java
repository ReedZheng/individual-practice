package practicecourt.offer;

public class Off010 {

    public int Fibonacci(int n) {
        int a = 1;
        int b = 1;
        int current = 1;

        if (n < 2) {
            return n;
        }

        for (int i = 2; i < n; i++) {
            current = a + b;
            a = b;
            b = current;
        }
        return current;
    }
}
