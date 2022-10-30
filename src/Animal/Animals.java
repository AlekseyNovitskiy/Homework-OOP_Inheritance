package Animal;

import java.util.Objects;

public class Animals {          //Животные
    private String name; //может поменяться
    private int age; //меняется со временем


    public Animals(String name, int age) {
        setName(name);
        setAge(age);
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        if (name == null || name.isBlank()) {
            this.name = "информация не корректна";
        } else {
            this.name = name;
        }
    }
    public int getAge() {
        return age;
    }

    public void setAge (int age) {
        if (age < 0 ) {
            this.age = -1;
        } else {
            this.age = age;
        }
    }
    public void eat() {
        System.out.println("не указано");
    }
    public void sleep() {
        System.out.println("Спит");

    }
    public void go() {
        System.out.println("не указано");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Animals animals = (Animals) o;
        return age == animals.age && Objects.equals(name, animals.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }
}
