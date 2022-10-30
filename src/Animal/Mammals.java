package Animal;

import java.util.ArrayList;
import java.util.Objects;

public class Mammals extends Animals { // Млекопитающие
    private String livingEnvironment;//Могут менять место жительства (зоопарк, дикая природа, под присмотром)
    private int movementSpeed;



    public Mammals(String name, int age, String livingEnvironment, int movementSpeed) {
        super(name, age);
        setLivingEnvironment(livingEnvironment);
        setMovementSpeed(movementSpeed);
    }

    public String getLivingEnvironment() {
        return livingEnvironment;
    }

    public int getMovementSpeed() {
        return movementSpeed;
    }
    public void setLivingEnvironment(String livingEnvironment) {
        if (livingEnvironment == null || livingEnvironment.isBlank()) {
            this.livingEnvironment = "информация не корректна";
        } else {
            this.livingEnvironment = livingEnvironment;
        }
    }
    public void setMovementSpeed(int movementSpeed) {
        if (movementSpeed == 0) {
            this.movementSpeed = 5;
        } else {
            this.movementSpeed = movementSpeed;;
        }
    }

    public void walk() {
        System.out.println("по суше");

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Mammals)) return false;
        if (!super.equals(o)) return false;
        Mammals mammals = (Mammals) o;
        return movementSpeed == mammals.movementSpeed && Objects.equals(livingEnvironment, mammals.livingEnvironment);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), livingEnvironment, movementSpeed);
    }

    public boolean checkMammals ( ArrayList<Mammals> mammals)
    {
        if (mammals.size()>0) {
            return mammals.contains(this);
        }
        else return false;
    }
}
