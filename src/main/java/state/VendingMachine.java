package state;

import config.Config;
import handlers.SnackDispenseHandler;
import model.Snack;
import state.options.IdleState;

import java.util.List;

public class VendingMachine {
//    Should reference state of Vending Machine and SnackDispenser plus hold all snacks.
private StateOfVendingMachine state;
private SnackDispenseHandler dispenseHandler;
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

    public void dispenseSnack(){
        state.dispenseSnack(this);
    }
    //chain of responsibility
    public SnackDispenseHandler getDispenseHandler() {
        return dispenseHandler;
    }

    public void setDispenseHandler(SnackDispenseHandler dispenseHandler) {
        this.dispenseHandler = dispenseHandler;
    }

    public boolean chainDispense() {
        if(this.dispenseHandler == null || snackSelected == null) return false;

        return dispenseHandler.handle(this, snackSelected.getName());
    }


    public void addSnack(Snack snack) {
        this.allSnacks.add(snack);
    }

    public void removeSnack(Snack snack) {
        if(snack != null && snack.getQuantity() > 0){
            snack.setQuantity(snack.getQuantity() - 1);
            if(snack.getQuantity() == 0) this.allSnacks.remove(snack);
        }
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
