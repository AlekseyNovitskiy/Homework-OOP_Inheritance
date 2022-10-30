package Animal;

import java.util.ArrayList;
import java.util.Objects;

public class Herbivores extends Mammals {    //Травоядные

    private final String typeOfFood;


    public Herbivores(String name, int age, String livingEnvironment, int movementSpeed, String typeOfFood) {
        super(name, age, livingEnvironment, movementSpeed);
        if (typeOfFood == null || typeOfFood.isBlank()) {
            this.typeOfFood = "информация не корректна";
        } else {
            this.typeOfFood = typeOfFood;
        }

    }

    public String getTypeOfFood() {
        return typeOfFood;
    }
    public void graze() {      //Пастись
        System.out.println("Пастится на пастбищах.");
    }
    public void eat() {
        System.out.println("Питается травой.");

    }
    public void go() {
        System.out.println("Перемещается по суше");

    }

    public String toString() {
        return "Кличка " + getName() + ", количество лет: " + getAge() + ", проживает на "
                + getLivingEnvironment()+", скорость перемещения "+ getMovementSpeed()+" км/ч"+", "+getTypeOfFood();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Herbivores)) return false;
        if (!super.equals(o)) return false;
        Herbivores that = (Herbivores) o;
        return Objects.equals(typeOfFood, that.typeOfFood);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), typeOfFood);
    }

    public boolean checkHerbivores ( ArrayList<Herbivores> herbivores)
    {
        if (herbivores.size()>0) {
            return herbivores.contains(this);
        }
        else return false;
    }
}
