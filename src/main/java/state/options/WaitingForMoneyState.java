package state.options;

import model.Snack;
import state.StateOfVendingMachine;
import state.VendingMachine;

public class WaitingForMoneyState extends StateOfVendingMachine {

    @Override
    public void selectSnack(VendingMachine vm, String snackname) {
        Snack snack = vm.getSnack(snackname);

        if(snack == null) System.out.println("Snack not available");
        else {
            vm.setSnackSelected(snack);
            vm.setState(new WaitingForMoneyState());

            System.out.println("Insert $" + this.inDollars(snack.getPrice()));
        }
    }

    private double inDollars(int cents) {
        return cents / 100.0;
    }

    @Override
    public void insertMoney(VendingMachine vm, int money) {
        Snack snack = vm.getSnackSelected();
        vm.addMoneyInput(money);
        if(snack == null) System.out.println("Select a snack");
        else {
            if(vm.getMoneyInput() >= snack.getPrice()) {
                vm.setState(new DispensingSnackState());
                vm.dispenseSnack();
            }
        }
    }

    @Override
    public void dispenseSnack(VendingMachine vm) {
        Snack snack = vm.getSnackSelected();
        if(snack == null) System.out.println("Select a snack");
        else {
            int currMoney = vm.getMoneyInput();
            int total = snack.getPrice();
            int moneyNeeded = total - currMoney;
            System.out.println("Please insert $" + inDollars(moneyNeeded));
        }
    }
}
