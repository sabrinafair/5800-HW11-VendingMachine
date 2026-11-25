package handlers;

public class PepsiHandler extends SnackDispenseHandler{

    public PepsiHandler(SnackDispenseHandler next) {
        super(next);
    }

    @Override
    public String getSnackname() {
        return "Pepsi";
    }
}
