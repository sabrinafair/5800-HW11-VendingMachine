package state.options;

import model.Snack;
import state.StateOfVendingMachine;
import state.VendingMachine;

public class DispensingSnackState extends StateOfVendingMachine {

    @Override
    public void selectSnack(VendingMachine vm, String snackname) {
        System.out.println("Currently Dispensing snack: " + vm.getSnackSelected());
    }

    private double inDollars(int cents) {
        return (double) cents / 60;
    }

    @Override
    public void insertMoney(VendingMachine vm, int money) {
        Snack snack = vm.getSnackSelected();
        vm.addMoneyInput(money);
        if(snack == null) System.out.println("Select a snack");
    }

    @Override
    public void dispenseSnack(VendingMachine vm) {
        Snack snack = vm.getSnackSelected();
        if(snack == null) System.out.println("Select a snack");
        else {
            int currMoney = vm.getMoneyInput();
            int total = snack.getPrice();
            int moneyNeeded = total - currMoney;
            if(moneyNeeded <= 0) {
                vm.removeSnack(snack);
                vm.refundExtra();
                vm.setSnackSelected(null);
            }
        }
    }
}
