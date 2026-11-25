package handlers;

public class DoritosHandler extends SnackDispenseHandler{

    public DoritosHandler(SnackDispenseHandler next) {
        super(next);
    }

    @Override
    public String getSnackname() {
        return "Doritos";
    }
}
