import java.util.Scanner;

class Fib {
    static public int fib_rec(int n) {
        if (n < 2) {
            return n;
        }
        return fib_rec(n - 1) + fib_rec(n - 2);
    }

    static public int fib_iter(int n) {
        if (n < 2) {
            return n;
        } else {
            int a, b, temp;
            a = temp = 0;
            b = 1;
            for (int i = 2; i <= n; i++) {
                temp = a;
                a = b;
                b = temp + a;
            }
            return b;
        }
    }

    public static void main(String args[]) {
        Scanner s = new Scanner(System.in);
        int x = s.nextInt();
        int rec = Fib.fib_rec(x);
        System.out.println("Recursive solution : " + rec);
        int iter = Fib.fib_iter(x);
        System.out.println("Iterative solution : " + iter);
        s.close();
    }
}
