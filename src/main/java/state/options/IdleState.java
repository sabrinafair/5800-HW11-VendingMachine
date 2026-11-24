package state.options;

import state.StateOfVendingMachine;
import state.VendingMachine;

public class IdleState extends StateOfVendingMachine {
    @Override
    public void change(VendingMachine vm) {
        System.out.println("Idle → Waiting for Money");
        vm.setState(new WaitingMoney());
    }
}
