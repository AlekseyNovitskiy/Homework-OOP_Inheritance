package Driver;

import transport.Transport;

public abstract class Driver< T extends Transport> {


    public final String fullName;
    private String category;
    public int drivingExperience;
    public T car;

    public Driver(String fullName, String category, int drivingExperience, T car) throws IllegalAccessException {
        this.fullName = fullName;
        setCategory(category);
        this.drivingExperience = drivingExperience;
        this.car = car;
    }

    public void startMovement() {
        System.out.println("Водитель "+getFullName()+" начал движение");
        this.car.startMovement();
    }

    public void stopMovement() {
        System.out.println("Водитель "+getFullName()+" закончил движение");
        this.car.stopMovement();

    }

    public void refill() {
        System.out.println("Водитель "+ getFullName()+ " заправляет машину "+
                this.car.getBrand()+" " +this.car.getModel());

    }
    public String getFullName() {
        return fullName;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        if (category == null)
        {
            throw new IllegalArgumentException("Необходимо указать категорию прав");
        }
        this.category = category;
    }

    public int getDrivingExperience() {
        return drivingExperience;
    }

    @Override
    public String toString() {
        return "Водитель " + getFullName() + " управляет автомобилем " + this.car.getBrand() +" "+
                this.car.getModel() + " и будет участвовать в заезде.";
    }
}
