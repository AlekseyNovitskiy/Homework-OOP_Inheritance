package transport;

public class Bus extends Transport{
    public Bus(String brand, String model, int productionYear, String productionCountry, int maximumSpeed) {
        super(brand, model, productionYear, productionCountry, maximumSpeed);
    }

    @Override
    public void refill() {
        System.out.println("Можно заправлять бензином или дизелем на заправке.");
    }

    public String toString() {
        return "Автобус " + getBrand() + " " + getModel() + ", год выпуска — " + getProductionYear()
                + ", сборка в " + getProductionCountry() + ", максимальная скорость " + getMaximumSpeed() + " км/ч.";
    }
}
