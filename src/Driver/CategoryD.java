package Driver;

import transport.Bus;

import transport.Transport;

public class CategoryD extends Driver<Bus> {

    public CategoryD(String fullName, int drivingExperience, Transport car) {
        super(fullName, "D", drivingExperience, (Bus) car);
    }
}
