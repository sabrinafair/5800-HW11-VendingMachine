package handlers;

public class CheetosHandler extends SnackDispenseHandler{

    public CheetosHandler(SnackDispenseHandler next) {
        super(next);
    }

    @Override
    public String getSnackname() {
        return "Cheetos";
    }
}
