package Animal;

import java.util.ArrayList;
import java.util.Objects;

public class Predators extends Mammals {      //Хищники

    private String typeOfFood;

    public Predators(String name, int age, String livingEnvironment, int movementSpeed, String typeOfFood) {
        super(name, age, livingEnvironment, movementSpeed);
        setTypeOfFood(typeOfFood);
    }
    public String getTypeOfFood() {
        return typeOfFood;
    }

    public void setTypeOfFood(String typeOfFood) {
        if (typeOfFood == null || typeOfFood.isBlank()) {
            this.typeOfFood = "информация не корректна";
        } else {
            this.typeOfFood = typeOfFood;
        }
    }
    public void hunt() {      //Охотится
        System.out.println("Охотится на травоядных или более мелких хищников.");
    }
    public void eat() {
        System.out.println("Питается мясом.");

    }
    public void go() {
        System.out.println("Перемещается по суше");

    }

    public String toString() {
        return "Кличка " + getName() + ", количество лет: " + getAge() + ", проживает в "
                + getLivingEnvironment()+", скорость перемещения "+ getMovementSpeed()+" км/ч"+", "+getTypeOfFood();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Predators)) return false;
        if (!super.equals(o)) return false;
        Predators predators = (Predators) o;
        return Objects.equals(typeOfFood, predators.typeOfFood);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), typeOfFood);
    }

    public boolean checkPredators ( ArrayList<Predators> predators)
    {
        if (predators.size()>0) {
            return predators.contains(this);
        }
        else return false;
    }
}
