/* 
Experiment 1 :
* Define a class to represent a bank account.Include the following members
* 1.Name of depositor
* 2.account number
* 3.account type
* 4.account balance
*/
class Account {
    String name;
    int accNo;
    String accType;
    int balance;
    void display() {
        System.out.println("Acc Name: " + name + "\nAcc No: " + accNo +
                "\nAccType : " + accType +
                "\nAccBalance : " + balance);
    }
    Account(String n, int no, String type, int bal) {
        name = n;
        accNo = no;
        accType = type;
        balance = bal;
    }
    void deposit(int amt) {
        System.out.println("Deposting Rs." + amt);
        balance = balance + amt;
        System.out.println("New Balance");
        showBalance();
    }
    void withdraw(int amt) {
        System.out.println("Withdrawing Rs." + amt);
        if (balance < amt) {
            System.out.println("Not Enough Money");
        } else {
            balance = balance - amt;
            System.out.println("New Balance");
            showBalance();
        }
    }
    void showBalance() {
        System.out.println("AccName : " + name + "\nAccBalance : " + balance);
    }
}
class Main {
    public static void main(String args[]) {
        Account a = new Account("user", 123456789, "savings", 1000);
        a.deposit(100);
        a.withdraw(400);
    }
}