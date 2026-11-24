package state;

import state.options.IdleState;

public class VendingMachine {
//    Should reference state of Vending Machine and SnackDispenser plus hold all snacks.
private StateOfVendingMachine state;

    public VendingMachine() {
        state = new IdleState();
    }

    public void setState(StateOfVendingMachine state) {
        this.state = state;
    }

    public void change() {
        state.change(this);
    }
}
