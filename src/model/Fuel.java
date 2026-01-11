package model;

public class Fuel {

        private String fuelName;
        private double pricePerLiter;
        private double quantity;

        public Fuel(String fuelName, double pricePerLiter, double quantity) {
            this.fuelName = fuelName;
            this.pricePerLiter = pricePerLiter;
            this.quantity = quantity;
        }

        public String getFuelName() {
            return fuelName;
        }

        public void setFuelName(String fuelName) {
            this.fuelName = fuelName;
        }

        public double getPricePerLiter() {
            return pricePerLiter;
        }

        public void setPricePerLiter(double pricePerLiter) {
            if (pricePerLiter <= 0) {
                throw new IllegalArgumentException("Price must be positive");
            }
            this.pricePerLiter = pricePerLiter;
        }

        public double getQuantity() {
            return quantity;
        }

        public void setQuantity(double quantity) {
            this.quantity = quantity;
        }


}
