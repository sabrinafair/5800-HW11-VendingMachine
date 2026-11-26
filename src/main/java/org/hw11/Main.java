package org.hw11;

import handlers.*;
import state.VendingMachine;

public class Main {
    public static void main(String[] args) {
        SnackDispenseHandler chain = new CokeHandler(new PepsiHandler(new CheetosHandler(new DoritosHandler(new KitKatHandler(new SnickersHandler(null))))));

        VendingMachine vm = new VendingMachine();
        vm.setDispenseHandler(chain);

        //test selecting coke and dispensing
        System.out.println("USER SELECTING SNACK");
        vm.selectSnack("Coke");
        System.out.println("USER INSERTING $2");
        vm.insertMoney(200);

        //testing getting snickers when there are none
        System.out.println("USER SELECTING SNACK");
        vm.selectSnack("Snickers");
        System.out.println("USER INSERTING $2");
        vm.insertMoney(200);

    }
}