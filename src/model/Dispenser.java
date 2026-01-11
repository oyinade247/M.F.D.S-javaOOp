package model;

import java.util.ArrayList;
import java.util.List;
public class Dispenser {
        private List<Fuel> fuels = new ArrayList<>();
        private List<Transaction> transactions = new ArrayList<>();

        public void addNewFuel(Fuel fuel) {
            fuels.add(fuel);
        }

        public List<Fuel> getAvailableFuels() {
            return fuels;
        }

        public void updateFuelPrice(Fuel fuel, double price) {
            for (Fuel fuel1 : fuels) {
                if (fuel1.getFuelName().equals(fuel.getFuelName())) {
                    fuel1.setPricePerLiter(price);
                    return;
                }
            }
        }

        public void restockFuel(String fuelName, double quantity) {
            for (Fuel fuel1 : fuels) {
                if (fuel1.getFuelName().equals(fuelName)) {
                    fuel1.setQuantity(fuel1.getQuantity() + quantity);
                    return;
                }
            }
        }

        public Transaction dispenseFuelByLiters(String fuelName, double liters) {
            if (liters < 1 || liters > 50) {
                throw new IllegalArgumentException("Liters must be between 1 and 50");
            }

            for (Fuel fuel1 : fuels) {
                if (fuel1.getFuelName().equals(fuelName)) {
                    if (fuel1.getQuantity() < liters) {
                        throw new IllegalArgumentException("Fuel is not enough");
                    }
                    fuel1.setQuantity(fuel1.getQuantity() - liters);
                    double amount = liters * fuel1.getPricePerLiter();

                    Transaction transaction = new Transaction(fuelName, liters, amount);
                    transactions.add(transaction);
                    return transaction;
                }
            }
            throw new IllegalArgumentException("Fuel not found");
        }

        public Transaction dispenseFuelByAmount(String fuelName, double amount) {
            for (Fuel fuel1 : fuels) {
                if (fuel1.getFuelName().equals(fuelName)) {
                    if (amount < fuel1.getPricePerLiter()) {
                        throw new IllegalArgumentException("Amount is not enough");
                    }
                    double liters = amount / fuel1.getPricePerLiter();
                    if (liters > fuel1.getQuantity()) {
                        throw new IllegalArgumentException("Not enough fuel");
                    }
                    fuel1.setQuantity(fuel1.getQuantity() - liters);
                    Transaction transaction = new Transaction(fuelName, liters, amount);
                    transactions.add(transaction);
                    return transaction;
                }
            }
            throw new IllegalArgumentException("Fuel not found");
        }

        public Transaction generateReceipt(String fuelName, double liters, double amount) {
            return new Transaction(fuelName, liters, amount);
        }

        public List<Transaction> getTransactions() {
            return transactions;
        }


}
