package handlers;

public class KitKatHandler extends SnackDispenseHandler{

    public KitKatHandler(SnackDispenseHandler next) {
        super(next);
    }

    @Override
    public String getSnackname() {
        return "KitKat";
    }
}
