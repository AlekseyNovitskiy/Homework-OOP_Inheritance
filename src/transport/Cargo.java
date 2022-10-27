package transport;

import java.util.concurrent.ThreadLocalRandom;

public class Cargo extends Transport implements Competing {

    private LoadCapacity typeOfLoadCapacity;
    public Cargo(String brand, String model, double engineVolume,LoadCapacity loadCapacity) {
        super(brand, model, engineVolume);
        this.typeOfLoadCapacity=loadCapacity;
    }
    public enum LoadCapacity  {
        N1(0D,3.5),N2(3.5,12D),N3(12D,null);


        private final Double from;
        private final Double to;

        LoadCapacity(Double from, Double to) {
            this.from = from;
            this.to = to;
        }

        public Double getFrom() {
            return from;
        }

        public Double getTo() {
            return to;
        }
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
        System.out.println("Совершил пит-стоп "+getBrand() + " " + getModel()+" лучшее время мин: "
                +getBestLapTime()+", максимальная скорость "+getMaxSpeed()+ " км/ч");
    }

    @Override
    public int getBestLapTime() {
        return ThreadLocalRandom.current().nextInt(1,600);
    }

    @Override
    public int getMaxSpeed() {
        return ThreadLocalRandom.current().nextInt(1,300);
    }

    @Override
    public void printType() {
        if (typeOfLoadCapacity == null) {
            System.out.println("Данных недостаточно");
        }
        else {
            String from = typeOfLoadCapacity.getFrom() == null ? "" : "от " + typeOfLoadCapacity.getFrom()+ " ";
            String to = typeOfLoadCapacity.getTo() == null ? "" : "до " + typeOfLoadCapacity.getTo();
            System.out.println("Тип грузоподъемности авто: " + from+ to);
        }
    }

    @Override
    public boolean service() {
        return Math.random()>0.75;
    }

    @Override
    public void repair() {
        System.out.println("Грузовик "+getBrand()+" "+getModel()+" починен!");
    }
}
