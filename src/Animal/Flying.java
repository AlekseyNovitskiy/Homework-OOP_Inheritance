package Animal;

import java.util.ArrayList;
import java.util.Objects;

public class Flying extends Birds{               //Летающие

    private final String typeOfMovement; //не меняется в общем, если применять параметра во времени он может меняться


    public Flying(String name, int age, String livingEnvironment, String typeOfMovement) {
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

    public void toFly() {
        System.out.println("Летает.");
    }
    public void eat() {
        System.out.println("Питается рыбой.");

    }
    public void go() {
        System.out.println("Перемещается по воздуху");

    }

    public String toString() {
        return "Кличка " + getName() + ", количество лет: " + getAge() + ", проживает "
                + getLivingEnvironment()+", тип передвижения "+ getTypeOfMovement();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Flying)) return false;
        if (!super.equals(o)) return false;
        Flying flying = (Flying) o;
        return Objects.equals(typeOfMovement, flying.typeOfMovement);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), typeOfMovement);
    }

    public boolean checkFlying( ArrayList<Flying> flying)
    {
        if (flying.size()>0) {
            return flying.contains(this);
        }
        else return false;
    }
}
