package model;

import java.util.List;

public class FuelAttendant {
    private String attendantName;
    private Dispenser dispenser;

    public FuelAttendant(String attendantName, Dispenser dispenser) {
        this.attendantName = attendantName;
        this.dispenser = dispenser;
    }

    public void addNewFuel(Fuel fuel) {
        dispenser.addNewFuel(fuel);
    }

    public void updateFuelPrice(Fuel fuel, double price) {
        dispenser.updateFuelPrice(fuel, price);
    }

    public void restockFuel(String fuelName, double quantity) {
        dispenser.restockFuel(fuelName, quantity);
    }

    public Transaction dispenseFuelByLiters(String fuelName, double liters) {
        return dispenser.dispenseFuelByLiters(fuelName, liters);
    }

    public Transaction dispenseFuelByAmount(String fuelName, double amount) {
        return dispenser.dispenseFuelByAmount(fuelName, amount);
    }

    public Transaction generateReceipt(String fuelName, double liters, double amount) {
        return dispenser.generateReceipt(fuelName, liters, amount);
    }

    public List<Fuel> getAvailableFuels() {
        return dispenser.getAvailableFuels();
    }
}

