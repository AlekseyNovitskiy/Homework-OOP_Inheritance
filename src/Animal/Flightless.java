package Animal;

import java.util.ArrayList;
import java.util.Objects;

public class Flightless extends Birds {           //Нелетающие

    private final String typeOfMovement;

    public Flightless(String name, int age, String livingEnvironment, String typeOfMovement) {
        super(name, age, livingEnvironment);

        if (typeOfMovement == null || typeOfMovement.isBlank()) {
            this.typeOfMovement = "информация не корректна";
        } else {
            this.typeOfMovement = typeOfMovement;
        }
    }

    public String getTypeOfMovement() {
        return typeOfMovement;
    }

    public void walk() {
        System.out.println("Ходят");
    }
    public void eat() {
        System.out.println("Питается рыбой или травой/зерном");

    }
    public void go() {
        System.out.println("Перемещается по суше");

    }

    public String toString() {
        return "Кличка " + getName() + ", количество лет: " + getAge() + ", проживает на "
                + getLivingEnvironment()+", тип передвижения "+ getTypeOfMovement();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Flightless)) return false;
        if (!super.equals(o)) return false;
        Flightless that = (Flightless) o;
        return Objects.equals(typeOfMovement, that.typeOfMovement);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), typeOfMovement);
    }

    public boolean checkFlightless ( ArrayList<Flightless> flightless)
    {
        if (flightless.size()>0) {
            return flightless.contains(this);
        }
        else return false;
    }
}
