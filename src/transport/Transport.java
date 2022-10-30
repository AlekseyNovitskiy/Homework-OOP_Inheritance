package transport;

import Driver.Driver;

import java.sql.SQLOutput;
import java.util.*;

public abstract class Transport {
    private final String brand;
    private final String model;
    private final double engineVolume;
    private final Set<Driver> drivers = new HashSet<Driver>();
    private final Set<Mechanic> mechanics = new HashSet<Mechanic>();
    private final Set<Sponsor> sponsors  = new HashSet<Sponsor>();


    public  Transport(String brand, String model,double engineVolume) {
        if (brand == null || brand.isBlank()) {
            this.brand = "default";
        } else {
            this.brand = brand;
        }
        if (model == null || model.isBlank()) {
            this.model = "default";
        } else {
            this.model = model;
        }
        if (Double.compare(engineVolume, 0) == 0) {
            this.engineVolume = 1.5;
        } else {
            this.engineVolume = engineVolume;
        }
    }
    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }
    public double getEngineVolume() {
        return engineVolume;
    }

    public void addDriver(Driver<?>... drivers) {
        for (Driver currentDriver : drivers) {
            try {
                this.drivers.add(currentDriver);
            }
            catch (IllegalArgumentException e) {
                System.out.println("Обнаружен дубликат водителя. Будет проигноирован.");
            }
           // if (this.drivers.contains(currentDriver)) {
           //     System.out.println("Обнаружен дубликат водителя. Будет проигноирован.");
           // } else {
          //      this.drivers.add(currentDriver);
          //  }
        }
    }
    public void addMechanic(Mechanic<?>... mechanics) {
        for (Mechanic currentMechanic : mechanics) {
            try {
                this.mechanics.add(currentMechanic);
            } catch (IllegalArgumentException e) {
                System.out.println("Обнаружен дубликат механика. Будет проигноирован.");
            }
            // this.mechanics.addAll(Arrays.asList(mechanics));
        }
    }
    public void addSponsor(Sponsor... sponsors) {
            for (Sponsor currentSponsor : sponsors) {
                try {
                    this.sponsors.add(currentSponsor);
                }
                catch (IllegalArgumentException e) {
                    System.out.println("Обнаружен дубликат спонсора. Будет проигноирован.");
                }
        }
        //this.sponsors.addAll(Arrays.asList(sponsors));
    }

    public Set<Driver> getDrivers() {
        return drivers;
    }

    public Set<Mechanic> getMechanics() {
        return mechanics;
    }

    public Set<Sponsor> getSponsors() {
        return sponsors;
    }

    public abstract void startMovement();
    public abstract void stopMovement();

    public abstract void printType();

    public abstract boolean service();

    public abstract void repair();


}


