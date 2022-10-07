/* 
Experiment : 6
 * Develop a java program to read and print student data using inheritance
 * Class Person : name,age,gender
 * Class Student inherits Person : mark1,mark2,mark3.
 * Compute the total mark and grade
 */
class Person {
    String name;
    int age;
    String gender;
    Person(String name, int age, String gender) {
        this.name = name;
        this.age = age;
        this.gender = gender;
    }
}
class Student extends Person {
    int mark1;
    int mark2;
    int mark3;
    Student(String name, int age, String gender, int m1, int m2, int m3) {
        super(name, age, gender);
        mark1 = m1;
        mark2 = m2;
        mark3 = m3;
    }
    void calculate() {
        int total = mark1 + mark2 + mark3;
        float per = (float) total / 300;
        if (per > .9) {
            System.out.println("Grade for total mark " + total + " is A");
        } else if (per > .8) {
            System.out.println("Grade for total mark " + total + " is B");
        } else if (per > .7) {
            System.out.println("Grade for total mark " + total + " is C");
        } else if (per > .6) {
            System.out.println("Grade for total mark " + total + " is D");
        } else if (per >= .5) {
            System.out.println("Grade for total mark " + total + " is E");
        } else {
            System.out.println("Grade for total mark " + total + " is F");
        }
    }
}
class Main {
    public static void main(String[] args) {
        Student te = new Student("user", 25, "female", 80, 80, 80);
        te.calculate();
    }
}