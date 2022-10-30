package Animal;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Objects;

public class Amphibians extends Animals{    // Земноводные

    private String livingEnvironment;

    public Amphibians(String name, int age, String livingEnvironment) {
        super(name, age);
        setLivingEnvironment(livingEnvironment);
    }

    public String getLivingEnvironment() {
        return livingEnvironment;
    }

    public void setLivingEnvironment(String livingEnvironment) {
        if (livingEnvironment == null || livingEnvironment.isBlank()) {
            this.livingEnvironment = "информация не корректна";
        } else {
            this.livingEnvironment = livingEnvironment;
        }
    }

    public void hunting() {
        System.out.println("Охотятся подстерегая добычу");
    }
    public void eat() {
        System.out.println("Питается мелкими насекомыми.");

    }
    public void go() {
        System.out.println("Перемещаются как в воде так и по суше");

    }

    public String toString() {
        return "Кличка " + getName() + ", количество лет: " + getAge() + ", среда проживания "
                + getLivingEnvironment();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Amphibians)) return false;
        if (!super.equals(o)) return false;
        Amphibians that = (Amphibians) o;
        return Objects.equals(livingEnvironment, that.livingEnvironment);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), livingEnvironment);
    }

    public boolean checkAmphibians ( ArrayList<Amphibians> amphibians)
    {
        if (amphibians.size()>0) {
            return amphibians.contains(this);
        }
        else return false;
    }
}
