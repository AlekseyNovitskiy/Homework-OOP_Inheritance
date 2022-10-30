package Driver;

import transport.Car;
import transport.Transport;

public class CategoryB extends Driver<Car>{

    public CategoryB(String fullName, int drivingExperience, Transport car) throws IllegalAccessException {
        super(fullName, "B", drivingExperience, (Car) car);
    }
}
