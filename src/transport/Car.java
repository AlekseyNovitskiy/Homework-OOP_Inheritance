package transport;

import java.time.LocalDate;
import java.util.concurrent.ThreadLocalRandom;

public class Car extends Transport implements Competing{
    public Car(String brand, String model, double engineVolume) {
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




    /*

    private double engineVolume;
    private String transmission;
    private final String tipKuzovat;
    private String registrationNumber;
    private final int numberOfSeats;   // количество мест
    private boolean winterTires;
    private final Key key;
    private final Insurance insurance;



    public Car(String brand, String model, String productionCountry, String color,
               double engineVolume, int productionYear, String transmission, String tipKuzovat,
               String registrationNumber, int numberOfSeats, boolean winterTires, Key key,
               Insurance insurance,int maximumSpeed) {

        super(brand, model, productionYear, productionCountry, color, maximumSpeed);
        this.key = key;
        this.insurance = insurance;
        if (tipKuzovat == null || tipKuzovat.isBlank()) {
            this.tipKuzovat = "default";
        } else {
            this.tipKuzovat=tipKuzovat;
        }
        if (numberOfSeats == 0) {
            this.numberOfSeats = 2;
        } else {
            this.numberOfSeats = numberOfSeats;
        }
        setEngineVolume(engineVolume);
        setTransmission(transmission);
        setRegistrationNumber(registrationNumber);
        setWinterTires(winterTires);
    }

    public String toString() {
        if (isWinterTires()) {
            return getBrand() + " " + getModel() + ", цвет кузова — " + getColor() + ", год выпуска — "
                    + getProductionYear() + ", сборка в " + getProductionCountry() + ", объем двигателя — "
                    + getEngineVolume() + " л." + " коробка передач " + getTransmission() + " тип кузова "
                    + getTipKuzovat() + " регистрационный знак " + getRegistrationNumber() + " количество мест "
                    + getNumberOfSeats() + " резина зимняя." + " максимальная скорость "+ getMaximumSpeed();
        } else {
            return getBrand() + " " + getModel() + ", цвет кузова — " + getColor() + ", год выпуска — "
                    + getProductionYear() + ", сборка в " + getProductionCountry() + ", объем двигателя — "
                    + getEngineVolume() + " л." + " коробка передач " + getTransmission() + " тип кузова "
                    + getTipKuzovat() + " регистрационный знак " + getRegistrationNumber() + " количество мест "
                    + getNumberOfSeats() + " резина летняя." + " максимальная скорость "+ getMaximumSpeed();
        }
    }

    public String getTipKuzovat() {
        return tipKuzovat;
    }
    public int getNumberOfSeats() {
        return numberOfSeats;
    }
    public double getEngineVolume() {
        return engineVolume;
    }
    public void setEngineVolume(double engineVolume) {
        if (Double.compare(engineVolume, 0) == 0) {
            this.engineVolume = 1.5;
        } else {
            this.engineVolume = engineVolume;
        }
    }
    public String getTransmission() {

        return transmission;
    }
    public void setTransmission(String transmission) {
        if (transmission == null) {
            this.transmission = "default";
        } else {
            this.transmission = transmission;
        }
    }
    public String getRegistrationNumber() {
        return registrationNumber;
    }
    public boolean isWinterTires() {
        return winterTires;
    }
    public void setWinterTires(boolean winterTires) {
        this.winterTires = winterTires;
    }
    public boolean isCorrectRegistrationNumber(String registrationNumber) {
        char[] chars = registrationNumber.toCharArray();
        if (!Character.isAlphabetic(chars[0]) || !Character.isAlphabetic(chars[4]) || !Character.isAlphabetic(chars[5])) {
            return false;
        }
        if (!Character.isDigit(chars[1]) || !Character.isDigit(chars[2]) || !Character.isDigit(chars[3]) ||
                !Character.isDigit(chars[6]) || !Character.isDigit(chars[7]) || !Character.isDigit(chars[8])) {
            return false;
        }
        return true;
    }
    public void setRegistrationNumber(String registrationNumber) {
        if (registrationNumber == null || registrationNumber.length() != 9
                || isCorrectRegistrationNumber(registrationNumber)!=true) {
            this.registrationNumber = "default";
        } else {
            this.registrationNumber = registrationNumber;
        }
    }
    public  void setSeasonTires() {
        int currentMonth = LocalDate.now().getMonthValue();
        if (currentMonth <= 2 || currentMonth >= 12) {
            this.winterTires = true;
        } else {
            this.winterTires = false;
        }
    }

    @Override
    public void refill() {
        System.out.println("Можно заправлять бензином, дизелем на заправке или заряжать на специальных " +
                "электропарковках, если это электрокар.");

    }

    public static class Key {
        private final boolean remoteEngineStart;
        private final boolean keylessAccess;

        public Key(boolean remoteEngineStart, boolean keylessAccess) {
            this.remoteEngineStart = remoteEngineStart;
            this.keylessAccess = keylessAccess;
        }
        public boolean isRemoteEngineStart() {
            return remoteEngineStart;
        }
        public boolean isKeylessAccess() {
            return keylessAccess;
        }
    }
    public static class Insurance {
        private final LocalDate validUntil;
        private final float cost;
        private final String number;

        public Insurance(LocalDate validUntil, float cost, String number) {
            this.validUntil = validUntil != null ? validUntil : LocalDate.now().plusDays(10);
            this.cost = Math.max(cost, 1f);
            if (number == null) {
                this.number = "default";
            } else {
                this.number = number;
            }
            if (!this.isNumberValid()) {
                System.out.println("Номер страховки некорректный!");
            }
            if (!isInsuranceValid()) {
                System.out.println("Нужно срочно ехать оформлять новую страховку.");
            }
        }
        public boolean isNumberValid() {
            return number.length() == 9;
        }
        public boolean isInsuranceValid() {
            return LocalDate.now().isBefore(this.validUntil);
        }
    }

     */




}
