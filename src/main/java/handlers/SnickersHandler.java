package handlers;

public class SnickersHandler extends SnackDispenseHandler{

    public SnickersHandler(SnackDispenseHandler next) {
        super(next);
    }

    @Override
    public String getSnackname() {
        return "Snickers";
    }
}
