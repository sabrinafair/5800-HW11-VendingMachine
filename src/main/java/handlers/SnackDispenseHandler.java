package handlers;

import model.Snack;
import state.VendingMachine;

public abstract class SnackDispenseHandler {
//    Represents the chain of responsibility for dispensing different types of snacks. Handlers should have a reference to the next handler. Cycle through snacks until the proper one is dispensed.
    private final SnackDispenseHandler next;

    public SnackDispenseHandler(SnackDispenseHandler next) {
        this.next = next;
    }

    public abstract String getSnackname();

    public boolean handle(VendingMachine vm, String snackname ){
        if(getSnackname().equals(snackname)){
            Snack snack = vm.getSnack(snackname);

            if(snack == null || snack.getQuantity() <= 0){
                System.out.println(getSnackname() + " is out of stock");
                return false;
            }
            System.out.println("Dispensing " + getSnackname());
            snack.setQuantity(snack.getQuantity() - 1);
            return true;
        }

        if(next != null) return next.handle(vm, snackname);

        System.out.println("No handler was found for " + snackname);
        return false;
    }

}
