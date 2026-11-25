package config;

import model.Snack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class Config {

    public static final List<Snack> REFILL_VENDING_MACHINE = new ArrayList<>(Arrays.asList(
            new Snack("Coke", 175, 5),
            new Snack("Pepsi", 175, 4),
            new Snack("Cheetos", 225, 6),
            new Snack("Doritos", 225, 2),
            new Snack("KitKat", 150, 7),
            new Snack("Snickers", 150, 3),
            new Snack("Sprite", 175, 5),
            new Snack("M&Ms", 150, 0),
            new Snack("Pretzels", 125, 4),
            new Snack("Skittles", 150, 6),
            new Snack("Trail Mix", 275, 1)
    ));
    public static final String EXAMPLE_MESSAGE2 = "This is an example message2";

}