package transport;

public class Train extends Transport {
    private float theCostOfTheTrip;  //Цена поездки
    private float travelTime;  //Время поездки
    private String departureStation;  //Название станции отбытия
    private String finalStop;  //Конечная остановка
    private int numberOfWagons;  //Количество вагонов

    public Train(String brand, String model, double engineVolume) {
        super(brand, model, engineVolume);
    }

    @Override
    public void startMovement() {

    }

    @Override
    public void stopMovement() {

    }


    /*

    public Train(String brand, String model, int productionYear, String productionCountry, int maximumSpeed,
                 String departureStation,String finalStop,float theCostOfTheTrip,int numberOfWagons) {
        super(brand, model, productionYear, productionCountry, maximumSpeed);
        setTheCostOfTheTrip(theCostOfTheTrip);
        setTravelTime(travelTime);
        setDepartureStation(departureStation);
        setFinalStop(finalStop);
        setNumberOfWagons(numberOfWagons);
    }

    public String toString() {
        return "Поезд " + getBrand() + ", модель " + getModel() + ", год выпуска — " + getProductionYear()
                + ", сборка в " + getProductionCountry() + " скорость передвижения "+ getMaximumSpeed()+" км/ч,"
                +" отходит от "+ getDepartureStation()+" и следует до станции "+ getFinalStop()
                +". Цена поездки - "+getTheCostOfTheTrip()+" рублей, в поезде "+getNumberOfWagons()+ " вагонов.";
    }

    public float getTheCostOfTheTrip() {
        return theCostOfTheTrip;
    }

    public void setTheCostOfTheTrip(float theCostOfTheTrip) {
        if (theCostOfTheTrip == 0) {
            this.theCostOfTheTrip = 1000;
        } else {
            this.theCostOfTheTrip = theCostOfTheTrip;
        }
    }

    public float getTravelTime() {
        return travelTime;
    }

    public void setTravelTime(float travelTime) {
        if (travelTime == 0) {
            this.travelTime = 2.0f;
        } else {
            this.travelTime = travelTime;
        }
    }

    public String getDepartureStation() {
        return departureStation;
    }

    public void setDepartureStation(String departureStation) {
        if (departureStation == null || departureStation.isBlank()) {
            this.departureStation = "default";
        } else {
            this.departureStation = departureStation;
        }
    }

    public String getFinalStop() {
        return finalStop;
    }

    public void setFinalStop(String finalStop) {
        if (finalStop == null || finalStop.isBlank()) {
            this.finalStop = "default";
        } else {
            this.finalStop = finalStop;
        }
    }

    public int getNumberOfWagons() {
        return numberOfWagons;
    }

    public void setNumberOfWagons(int numberOfWagons) {

        if (numberOfWagons == 0) {
            this.numberOfWagons = 11;
        } else {
            this.numberOfWagons = numberOfWagons;
        }
    }

    @Override
    public void refill() {
        System.out.println("Нужно заправлять дизелем.");
    }

     */
}
