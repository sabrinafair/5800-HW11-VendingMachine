package state.options;

import model.Snack;
import state.StateOfVendingMachine;
import state.VendingMachine;

public class IdleState extends StateOfVendingMachine {

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
        System.out.println("Please select snack first");
    }

    @Override
    public void dispenseSnack(VendingMachine vm) {
        System.out.println("Please select snack first");
    }
}
