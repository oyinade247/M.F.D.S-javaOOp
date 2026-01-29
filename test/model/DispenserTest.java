package model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import java.util.List;

public class DispenserTest {

    @Test
    void testThatDispensserCanAddAndGetAvailableFuels() {
        Dispenser dispenser = new Dispenser();
        Fuel petrol = new Fuel("Petrol", 150, 100);
        Fuel diesel = new Fuel("Diesel", 200, 50);

        dispenser.addNewFuel(petrol);
        dispenser.addNewFuel(diesel);

        List<Fuel> fuels = dispenser.getAvailableFuels();
        assertEquals(2, fuels.size());
    }

    @Test
    void testThatDispenserCanUpdateFuelPrice() {
        Dispenser dispenser = new Dispenser();
        Fuel petrol = new Fuel("Petrol", 150, 100);

        dispenser.addNewFuel(petrol);
        dispenser.updateFuelPrice(petrol, 180);

        assertEquals(180, petrol.getPricePerLiter());
    }

    @Test
    void testThatDispenserCanRestockFuel() {
        Dispenser dispenser = new Dispenser();
        Fuel petrol = new Fuel("Petrol", 150, 100);

        dispenser.addNewFuel(petrol);
        dispenser.restockFuel("Petrol", 50);

        assertEquals(150, petrol.getQuantity());
    }

    @Test
    void testDispenserCanDispenseFuelByLiters() {
        Dispenser dispenser = new Dispenser();
        Fuel petrol = new Fuel("Petrol", 150, 100);

        dispenser.addNewFuel(petrol);
        Transaction transaction = dispenser.dispenseFuelByLiters("Petrol", 10);

        assertEquals("Petrol", transaction.getFuelName());
        assertEquals(10, transaction.getLiters());
        assertEquals(1500, transaction.getAmount());
        assertEquals(90, petrol.getQuantity());
    }

    @Test
    void testThatDispenserCanDispenseFuelByAmount() {
        Dispenser dispenser = new Dispenser();
        Fuel petrol = new Fuel("Petrol", 150, 100);

        dispenser.addNewFuel(petrol);
        Transaction transaction = dispenser.dispenseFuelByAmount("Petrol", 300);

        assertEquals("Petrol", transaction.getFuelName());
        assertEquals(2, transaction.getLiters());
        assertEquals(300, transaction.getAmount());
        assertEquals(98, petrol.getQuantity());
    }
}
