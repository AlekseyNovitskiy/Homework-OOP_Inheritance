package transport;

import java.util.concurrent.ThreadLocalRandom;

public class Bus extends Transport implements Competing{

    private TypeOfCapacity typeOfCapacity;
    public Bus(String brand, String model, double engineVolume, TypeOfCapacity typeCapacity) {
        super(brand, model, engineVolume);
        this.typeOfCapacity = typeCapacity;
    }
    public enum TypeOfCapacity {
        ESPECIALLY_SMALL(0, 10), SMALL(10, 25), AVERAGE(40, 50),
        BIG(60, 80), ESPECIALLY_BIG(100, 120);
        private final int from;
        private final int to;

        TypeOfCapacity(int from, int to) {
            this.from = from;
            this.to = to;
        }

        public int getFrom() {
            return from;
        }

        public int getTo() {
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
    @Override
    public void printType() {
        if (typeOfCapacity == null) {
            System.out.println("Данных недостаточно");
        }
        else {
            System.out.println("Тип вместимости авто: от" + typeOfCapacity.getFrom()+" до "+ typeOfCapacity.getTo());
        }
    }

    @Override
    public boolean service() {
        System.out.println("Автобус "+getBrand()+" "+getModel()+" в диагностике не требуется");
        return true;
    }

    public String toString() {
        return "Автобус " + getBrand() + " " + getModel() + ", объем двигателя — " + getEngineVolume() + " л.";
    }


    @Override
    public void pitStop() {
        System.out.println("Совершил пит-стоп "+getBrand() + " " + getModel()+" лучшее время мин: "+getBestLapTime()
                +", максимальная скорость "+getMaxSpeed()+ " км/ч");
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
