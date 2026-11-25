package state;

import config.Config;
import model.Snack;
import state.options.IdleState;

import java.util.List;

public class VendingMachine {
//    Should reference state of Vending Machine and SnackDispenser plus hold all snacks.
private StateOfVendingMachine state;
private List<Snack> allSnacks;
private Snack snackSelected;
private int moneyInput; //in cents


    public VendingMachine() {
        state = new IdleState();
        this.allSnacks = Config.REFILL_VENDING_MACHINE;
    }

    public void setState(StateOfVendingMachine state) {
        this.state = state;
    }

    public StateOfVendingMachine getState() {
        return this.state;
    }

    //state design pattern
    public void selectSnack(String snackname){
        state.selectSnack(this, snackname);
    }
    public void insertMoney(int money){
        state.insertMoney(this, money);
    }

    public void dispenseSnack(String snackname){
        state.dispenseSnack(this);
    }

    //chain of responsibility
    public void dispenseSnack(){

    }


    public void addSnack(Snack snack) {
        this.allSnacks.add(snack);
    }

    public void removeSnack(Snack snack) {
        this.allSnacks.add(snack);
    }

    public void refundExtra() {
        System.out.println("Collect any extra funds below");
        this.moneyInput = 0;
    }


    public Snack getSnack(String snackname) {
        for (Snack snack : this.allSnacks) {
            if (snack != null && snack.getName().equalsIgnoreCase(snackname)) {
                return snack; // Found it!
            }
        }
        return null;
    }

    public Snack getSnackSelected() {
        return snackSelected;
    }

    public void setSnackSelected(Snack snackSelected) {
        this.snackSelected = snackSelected;
    }

    public int getMoneyInput() {
        return moneyInput;
    }

    public void addMoneyInput(int money) {
        this.moneyInput += money;
    }

}
