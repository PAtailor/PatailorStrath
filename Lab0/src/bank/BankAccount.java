package bank;

public class BankAccount implements Bank{
private float balance;
private String OwnerName;

public void deposit(float amount) {float dep = balance + amount;}

public void withdraw(float amount) {float withdraw = balance - amount;}

@Override public float getBalance() {return balance;}

}
