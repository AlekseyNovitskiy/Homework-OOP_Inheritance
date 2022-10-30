package Driver;

import transport.Cargo;
import transport.Transport;

public class CategoryC extends Driver<Cargo>{
    public CategoryC(String fullName, int drivingExperience, Transport car) throws IllegalAccessException {
        super(fullName, "C", drivingExperience, (Cargo) car);
    }
}
