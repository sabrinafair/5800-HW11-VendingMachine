import config.Config;
import handlers.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import state.VendingMachine;
import state.options.DispensingSnackState;
import state.options.WaitingForMoneyState;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class SnackTest {
    SnackDispenseHandler chain = new CokeHandler(new PepsiHandler(new CheetosHandler(new DoritosHandler(new KitKatHandler(new SnickersHandler(null))))));
    VendingMachine vm = new VendingMachine();
    private final PrintStream standardOut = System.out;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @BeforeEach
    public void setUp() {
        // Redirect System.out to our custom stream before each test
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @AfterEach
    public void tearDown() {
        // Always restore the original System.out after each test
        System.setOut(standardOut);
    }
    @Test
    public void testSnackSelectionIdleState() {
        vm.setDispenseHandler(chain);
        vm.selectSnack("Coke");
        String[] lines = outputStreamCaptor.toString().trim().split("\\R");
        String actual = lines[lines.length - 1];
        String expected = "Insert $1.75"; //selecting coke in idle state should display 'Insert $1.75'
        assertEquals(expected, actual);
    }

    @Test
    public void testInsertMoneyIdleState() {
        vm.setDispenseHandler(chain);
        vm.insertMoney(200);
        String[] lines = outputStreamCaptor.toString().trim().split("\\R");
        String actual = lines[lines.length - 1];
        String expected = "Please select snack first";
        assertEquals(expected, actual);
    }

    @Test
    public void testDispenseSnackIdleState() {
        vm.setDispenseHandler(chain);
        vm.dispenseSnack();
        String[] lines = outputStreamCaptor.toString().trim().split("\\R");
        String actual = lines[lines.length - 1];
        String expected = "Please select snack first";
        assertEquals(expected, actual);
    }

    @Test
    public void testSnackSelectionWaitingState() {
        vm.setDispenseHandler(chain);
        vm.setState(new WaitingForMoneyState());
        vm.selectSnack("Coke");
        String[] lines = outputStreamCaptor.toString().trim().split("\\R");
        String actual = lines[lines.length - 1];
        String expected = "Waiting money input";
        assertEquals(expected, actual);
    }

    @Test
    public void testInsertMoneyWaitingState() {
        vm.setDispenseHandler(chain);
        vm.setState(new WaitingForMoneyState());
        vm.insertMoney(200);
        String[] lines = outputStreamCaptor.toString().trim().split("\\R");
        String actual = lines[lines.length - 1];
        String expected = "Select a snack";
        assertEquals(expected, actual);
    }

    @Test
    public void testDispenseSnackWaitingState() {
        vm.setDispenseHandler(chain);
        vm.setState(new WaitingForMoneyState());
        vm.dispenseSnack();
        String[] lines = outputStreamCaptor.toString().trim().split("\\R");
        String actual = lines[lines.length - 1];
        String expected = "Select a snack";

        assertEquals(expected, actual);
    }

    @Test
    public void testSnackSelectionDispenseState() {
        vm.setDispenseHandler(chain);
        vm.setState(new DispensingSnackState());
        vm.dispenseSnack();
        String[] lines = outputStreamCaptor.toString().trim().split("\\R");
        String actual = lines[lines.length - 1];
        String expected = "Select a snack";
        assertEquals(expected, actual);
    }

    @Test
    public void testInsertMoneyDispenseState() {
        vm.setDispenseHandler(chain);
        vm.setState(new DispensingSnackState());
        vm.insertMoney(200);
        String[] lines = outputStreamCaptor.toString().trim().split("\\R");
        String actual = lines[lines.length - 1];
        String expected = "Select a snack";
        assertEquals(expected, actual);
    }

    @Test
    public void testDispenseSnackDispenseState() {
        vm.setDispenseHandler(chain);
        vm.setState(new DispensingSnackState());
        vm.dispenseSnack();
        String[] lines = outputStreamCaptor.toString().trim().split("\\R");
        String actual = lines[lines.length - 1];
        String expected = "Select a snack";

        assertEquals(expected, actual);
    }
}
