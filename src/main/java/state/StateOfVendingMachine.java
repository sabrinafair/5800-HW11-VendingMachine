package state;

public abstract class StateOfVendingMachine {
//    Represents the different states of the vending machine. What are all the things vending machine can do?
    public abstract void selectSnack(VendingMachine vm, String snackname);
    public abstract void insertMoney(VendingMachine vm, int money);
    public abstract void dispenseSnack(VendingMachine vm);
}
