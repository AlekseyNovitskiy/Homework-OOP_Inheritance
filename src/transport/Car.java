package transport;

import java.sql.SQLOutput;
import java.time.LocalDate;
import java.util.concurrent.ThreadLocalRandom;

public class Car extends Transport implements Competing{

    private  TypeCommand typeOfBody;
    public enum TypeCommand  {
        SEDAN("Седан"),HATCHBACK("Хетчбек"),COUPE("Купе"),
        UNIVERSAL("Универсал"),SUV("Внедорожник"),CROSSOVER("Кроссовер"),
        PICKUP_TRUCK("Пикап"),VAN("Фургон"),MINIVAN("Минивэн");
        private String body;

        TypeCommand(String body) {
            setBody(body);
        }

        public String getBody() {
            return body;
        }

        public void setBody(String body) {
            this.body = body;
        }

    }

    public Car(String brand, String model, double engineVolume, TypeCommand typeCommand) {
        super(brand, model, engineVolume);
        this.typeOfBody = typeCommand;
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
        if (typeOfBody == null) {

            System.out.println("Данных недостаточно");
        }
        else {
            System.out.println("Тип кузова авто: " + typeOfBody);
        }
    }

    @Override
    public boolean service() {
        return Math.random()>0.7;
    }

    public String toString() {
        return getBrand() + " " + getModel() + ", объем двигателя — " + getEngineVolume() + " л.";


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
