package transport;

import java.util.concurrent.ThreadLocalRandom;

public class Cargo extends Transport implements Competing {

    public Cargo(String brand, String model, double engineVolume) {
        super(brand, model, engineVolume);
    }

    @Override
    public void startMovement() {
        System.out.println("Старт "+getBrand()+" "+getModel()+", объем двигателя — " + getEngineVolume() + " л.");
    }

    @Override
    public void stopMovement() {
        System.out.println("Финиш "+getBrand()+" "+getModel()+", объем двигателя — " + getEngineVolume() + " л.");

    }

    public String toString() {
        return getBrand() + " " + getModel() + ", объем двигателя — " + getEngineVolume() + " л.";
    }

    @Override
    public void pitStop() {
        System.out.println("Совершил пит-стоп "+getBrand() + " " + getModel()+" лучшее время мин: "+getBestLapTime()+", максимальная скорость "+getMaxSpeed()+ " км/ч");
    }

    @Override
    public int getBestLapTime() {
        return ThreadLocalRandom.current().nextInt(1,600);
    }

    @Override
    public int getMaxSpeed() {
        return ThreadLocalRandom.current().nextInt(1,300);
    }
}
