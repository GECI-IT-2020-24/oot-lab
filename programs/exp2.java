/*
Experiment 2 :
 * Create a class Student with instance variables : 
 * 1.Name
 * 2.Age
 * 3.Gender
 * Student inherit from Person Mark1,Mark2,Mark3
 * and methods to : 
 * 1.Calculate Average Mark
 * 2.Display name, Rollno and Average Marks
 */
class Student {
    String name;
    int rollNo;
    int mark1;
    int mark2;
    int mark3;

    Student(String n, int rno, int m1, int m2, int m3) {
        name = n;
        rollNo = rno;
        mark1 = m1;
        mark2 = m2;
        mark3 = m3;
    }

    float avgMark() {
        return (mark1 + mark2 + mark3) / 3;
    }

    void display() {
        System.out.println("Name : " + name + "\nRollno : "
                + rollNo + "\nAverage Mark : " + avgMark());
    }
}

class Main {
    public static void main(String args[]) {
        Student s = new Student("user", 12, 34, 56, 45);
        s.display();
    }
}