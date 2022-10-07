/*
Experiment 3 :
 * Write a class KSEB consumer with instance variables :
 * 1.consumer no
 * 2.Consumer name
 * 3.number fo units 
 * methods:
 * 1.calculateCharge() : to calculate & display the charge with name 
 * Electricity board charges the following rates to domestic users  to discourage the consumption of energy.
 * (i)      For first 100 units - 60 Paisa/unit
 * (ii)     For the next 200 units - 80 Paisa/unit
 * (iii)    Beyond 200 units -  90 Paisa/unit
 * All users are charged with a minimum of Rs.50.
 * If the total amount is more than Rs.300, 
 * then any additional subcharge fo 15% is added.
 */
class KsebConsumer {
    int coustomerNo, usedUnits;
    double charge;
    String consumerName;
    KsebConsumer(int cno, int units, String name) {
        coustomerNo = cno;
        usedUnits = units;
        charge = 0;
        consumerName = name;
    }
    double calculateCharge() {
        if (usedUnits > 300) {
            charge += .60 * 100;
            charge += .80 * 200;
            charge += ((usedUnits - 300) * .90);
        } else if (usedUnits <= 100) {
            charge = usedUnits * .60;
        } else {
            charge += 100 * .60;
            charge += (usedUnits - 100) * .80;
        }
        if (charge > 300) {
            charge += charge * 0.15;
        } else if (charge < 50) {
            charge = 50;
        }
        return charge;
    }
}
class Main {
    public static void main(String[] arg) {
        KsebConsumer kseb = new KsebConsumer(25045, 600, "user");
        System.out.println("name : " + kseb.consumerName +"\ncoustomer number :" 
        + kseb.coustomerNo +"\nNumber of units : " + kseb.usedUnits);
        System.out.println("total cost : " + kseb.calculateCharge() + "Rs");
    }
}