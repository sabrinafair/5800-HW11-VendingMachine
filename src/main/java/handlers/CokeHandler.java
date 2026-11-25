package handlers;

public class CokeHandler extends SnackDispenseHandler{

    public CokeHandler(SnackDispenseHandler next) {
        super(next);
    }

    @Override
    public String getSnackname() {
        return "Coke";
    }
}
