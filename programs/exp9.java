
/* 
Experiment 9 : 
* Develop a java program that implements a mulithreaded program that implements 3 threads.
* first thread generates a random number for every 1 second 
* and if the value is even second thread computes the square of the number and prints
* and if the value is odd the third thread will print the values of cube of the number .
*/
import java.util.Random;

class NumGen implements Runnable {
    public int rand;

    public void run() {
        for (int i = 0; i < 5; i++) {
            Random r = new Random();
            this.rand = r.nextInt(10);
            System.out.println("[Thread 1] : Generated Number -> " + this.rand);
            if (this.rand % 2 == 0) {
                System.out.println(String.format("%d is even\nStarting [Thread 2]", this.rand));
                EvenGen even = new EvenGen(this.rand);
                try {
                    Thread t = new Thread(even);
                    t.start();
                } catch (Exception err) {
                    System.out.println("[Thread 2] Raised Exception " + err);
                }
            } else {
                System.out.println(String.format("%d is odd\nStarting [Thread 3]", this.rand));
                OddGen odd = new OddGen(this.rand);
                try {
                    Thread t = new Thread(odd);
                    t.start();
                } catch (Exception err) {
                    System.out.println("[Thread 3] Raised Exception " + err);
                }

            }
            try {
                Thread.sleep(1000);
            } catch (Exception err) {
                System.out.println("[Thead 1] Sleep Exception " + err);
            }
        }
    }

}

class EvenGen implements Runnable {
    int val;

    EvenGen(int val) {
        this.val = val;
    }

    public void run() {
        System.out.println(String.format("[Thread 2] : Square of %d is -> %d\n", this.val, this.val * this.val));
    }
}

class OddGen implements Runnable {
    int val;

    OddGen(int val) {
        this.val = val;
    }

    public void run() {
        System.out.println(
                String.format("[Thread 3] : Cube of %d is -> %d\n", this.val, this.val * this.val * this.val));

    }
}

class Main {
    public static void main(String[] args) {
        NumGen num = new NumGen();
        Thread t = new Thread(num);
        t.start();
    }
}