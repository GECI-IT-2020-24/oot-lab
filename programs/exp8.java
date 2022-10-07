
/* 
Experiment 8 : 
 * Develop a java application that executes two threads.One thread displays "Hello" 
 * in every 1000 ms and other displays "World" in every 3000ms.
 * Create threads by extending the thread class.
 */
import java.lang.Thread;

class Thread1 extends Thread {
    public void run() {
        try {
            for (int i = 0; i < 5; i++) {
                System.out.println("Hello");
                sleep(1000);
            }
        } catch (Exception e) {
            System.out.println("pgm stops");
        }
    }
}

class Thread2 extends Thread {
    public void run() {
        try {
            for (int i = 0; i < 5; i++) {
                System.out.println("World");
                sleep(2000);
            }
        } catch (Exception e) {
            System.out.println("pgm stops");
        }
    }
}

class Main {
    public static void main(String arg[]) {
        Thread1 t1 = new Thread1();
        Thread2 t2 = new Thread2();
        t1.start();
        t2.start();
    }

}