
/* 
Experiment 10 : 
* Develop a java program that implements a Stack that raises Exceptions 
* in case of Errors and with push,pop & display functionalities.
*/
import java.lang.Exception;
import java.util.Scanner;

class UnderflowException extends Exception {
    public UnderflowException(String str) {
        super(str);
    }
}

class Stack extends Exception {
    int size = 10;
    int top = 0;
    int array[] = new int[size];

    void push(int no) {
        try {
            this.array[top] = no;
            this.top++;
        } catch (ArrayIndexOutOfBoundsException e1) {
            System.out.println("\tArray is full :)");
            top--;
        }
    }

    void pop() {
        try {
            this.top--;
            if (this.top < 0) {
                throw new UnderflowException("array underflow");
            }
        } catch (UnderflowException uf) {
            System.out.println("\tarray empty Underflow :)");
            top++;
        }
    }

    void display() {
        for (int i = this.top - 1; i >= 0; i--) {
            System.out.println("\t" + this.array[i]);
        }
    }
}

class Main {
    static int choice;

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            Stack stack = new Stack(10);
            do {
                System.out.println("Menu : \n 1.push \n 2.pop \n 3.display : ");
                choice = sc.nextInt();
                switch (choice) {
                    case 1:
                        stack.push(sc.nextInt());
                        break;
                    case 2:
                        stack.pop();
                        break;
                    case 3:
                        stack.display();
                        break;
                    case 0:
                        System.out.println("EXITING .......");
                        break;
                    default:
                        System.out.println("invalid choice !");
                        break;
                }
            } while (choice != 0);
        }
    }
}
