import Animal.*;
import transport.Bus;
import transport.Car;
import transport.Train;

import java.time.LocalDate;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        // ООП. Урок 3
        System.out.println("ООП. Урок 3 Задание 1.1");

        Car.Key ghost = new Car.Key(true, false);
        LocalDate oldDate = LocalDate.of(2021, 12, 31);
        Car.Insurance delayDate = new Car.Insurance(oldDate, 5057.6F, "KG000689H");
        LocalDate normalDate = LocalDate.of(2023, 12, 31);
        Car.Insurance futureDate = new Car.Insurance(normalDate, 5678.6F, "LO5649589J");

        Car lada = new Car(null, "Granta", "России", "желтый",
                1.7, 2015, "Механика", "седан",
                "р524кр799", 5, true, ghost, delayDate, 220);
        Car audi = new Car("Audi", null, "Германии",
                "черный ", 3.0, 2020, "Автомат", "седан",
                "х873нн799", 0, true, ghost, futureDate, 180);
        Car bmw = new Car("BMW", "Z8", null, "черный",
                3.0, 2021, null, null,
                "552455799", 4, false, ghost, futureDate, 0);
        Car kia = new Car("Kia", "Sportage 4-го поколения", "Южной Корее",
                null, 2.0, 0, null, "внедорожник",
                "р645кр79", 5, false, ghost, delayDate, 150);
        Car hyundai = new Car("Hyundai", "Avante", "Южной Корее",
                "оранжевый", 0, 2016, "Механика", "седан",
                null, 5, true, ghost, delayDate, 0);

        System.out.println(lada);
        System.out.println(audi);
        System.out.println(bmw);
        System.out.println(kia);
        System.out.println(hyundai);

        // ООП. Урок 3
        System.out.println("ООП. Урок 3 Задание 1.2");

        Train swallow = new Train("Ласточка", "B-901", 2011, "России",
                301, "Белорусского вокзала", "Минск-Пассажирский",
                3500, 11);
        Train leningrad = new Train("Ленинград", "D-125", 2019, "России",
                270, "Ленинградского вокзала", "Ленинград-Пассажирский",
                1700, 8);

        System.out.println(swallow);
        System.out.println(leningrad);

        // ООП. Урок 3
        System.out.println("ООП. Урок 3 Задание 1.3");

        Bus kia1 = new Bus("Kia", "Granbird", 2002, "Республике Корея",
                200);
        Bus yutong = new Bus("Yutong ", "ZK6122H9", 2018, "Китае",
                220);
        Bus ankai = new Bus("ANKAI ", "GK39", 2017, "Китае",
                150);

        System.out.println(kia1);
        System.out.println(yutong);
        System.out.println(ankai);


        // ООП. Урок 3
        System.out.println("ООП. Урок 3 Задание 2");

        kia.refill();
        hyundai.refill();

        swallow.refill();
        leningrad.refill();

        yutong.refill();
        ankai.refill();


        // ООП. Урок 3
        System.out.println("ООП. Урок 3 Задание 3");

        //Земноводные
        ArrayList<Amphibians> listAmphibians = new ArrayList<Amphibians>();

        Amphibians frog = new Amphibians("Лягушка", 1, "у водоемов или рек");
        System.out.println(frog);
        frog.eat();
        frog.go();
        frog.hunting();
        frog.sleep();
        if(!frog.checkAmphibians(listAmphibians))
            listAmphibians.add(frog);

        Amphibians snake = new Amphibians("Уж", 2, "у водоемов или рек");
        System.out.println(snake);
        snake.eat();
        snake.go();
        snake.hunting();
        snake.sleep();
        if(!snake.checkAmphibians(listAmphibians))
            listAmphibians.add(snake);
        //Млекопитающие
        //Травоядные

        ArrayList<Herbivores> listHerbivores = new ArrayList<Herbivores>();
        ArrayList<Predators> listPredators = new ArrayList<Predators>();
        Herbivores gazelle = new Herbivores("Газель", 6, "лугах, равнинах", 10,
                "питаются травой");
        System.out.println(gazelle);
        gazelle.eat();
        gazelle.go();
        gazelle.graze();
        gazelle.walk();
        gazelle.sleep();
        if(!gazelle.checkHerbivores(listHerbivores))
            listHerbivores.add(gazelle);

        Herbivores giraffe = new Herbivores("Жираф", 8, "саваннах", 5,
                "питаются листьями деревьем и травой");
        System.out.println(giraffe);
        giraffe.eat();
        giraffe.go();
        giraffe.graze();
        giraffe.walk();
        giraffe.sleep();
        if(!giraffe.checkHerbivores(listHerbivores))
            listHerbivores.add(giraffe);

        Herbivores horse = new Herbivores("Лошадь", 11, "лугах, равнинах", 9,
                "питаются травой");
        System.out.println(horse);
        horse.eat();
        horse.go();
        horse.graze();
        horse.walk();
        horse.sleep();
        if(!horse.checkHerbivores(listHerbivores))
            listHerbivores.add(horse);

        //Хищники
        Predators hyena = new Predators("Гиена", 7, "саваннах", 14,
                "питается мясом.");
        System.out.println(hyena);
        hyena.eat();
        hyena.go();
        hyena.hunt();
        hyena.walk();
        hyena.sleep();
        if(!hyena.checkPredators(listPredators))
            listPredators.add(hyena);

        Predators tiger = new Predators("Тигр", 15, "саваннах, равнинах", 12,
                "питается мясом.");
        System.out.println(tiger);
        tiger.eat();
        tiger.go();
        tiger.hunt();
        tiger.walk();
        tiger.sleep();
        if(!tiger.checkPredators(listPredators))
            listPredators.add(tiger);

        Predators bear = new Predators("Медведь", 18, "лесах", 5,
                "питается мясом, рыбой.");
        System.out.println(bear);
        bear.eat();
        bear.go();
        bear.hunt();
        bear.walk();
        bear.sleep();
        if(!bear.checkPredators(listPredators))
            listPredators.add(bear);

        // Птицы
        //Нелетающие
        ArrayList<Flightless> listFlightless = new ArrayList<Flightless>();
        ArrayList<Flying> listFlying = new ArrayList<Flying>();

        Flightless peacock = new Flightless("Павлин", 4, "суше", "по земле");
        System.out.println(peacock);
        peacock.eat();
        peacock.go();
        peacock.walk();
        peacock.hunting();
        peacock.sleep();
        if(!peacock.checkFlightless(listFlightless))
            listFlightless.add(peacock);

        Flightless penguin = new Flightless("Пингвин", 6, "суше и воде", "по земле и в воде");
        System.out.println(penguin);
        penguin.eat();
        penguin.go();
        penguin.walk();
        penguin.hunting();
        penguin.sleep();
        if(!penguin.checkFlightless(listFlightless))
            listFlightless.add(penguin);

        Flightless dodo = new Flightless("Птица Додо", 7, "суше", "по земле");
        System.out.println(dodo);
        dodo.eat();
        dodo.go();
        dodo.walk();
        dodo.hunting();
        dodo.sleep();
        if(!dodo.checkFlightless(listFlightless))
            listFlightless.add(dodo);

        //Летающие
        Flying seagull = new Flying("Чайка", 5, "у водоемов", " по воздуху");
        System.out.println(seagull);
        seagull.eat();
        seagull.go();
        seagull.toFly();
        seagull.hunting();
        seagull.sleep();
        if(!seagull.checkFlying(listFlying))
            listFlying.add(seagull);

        Flying albatross = new Flying("Альбатрос", 5, "у водоемов", " по воздуху");
        System.out.println(albatross);
        albatross.eat();
        albatross.go();
        albatross.toFly();
        albatross.hunting();
        albatross.sleep();
        if(!albatross.checkFlying(listFlying))
            listFlying.add(albatross);

        Flying falcon = new Flying("Сокол", 5, "у водоемов", " по воздуху");
        System.out.println(falcon);
        falcon.eat();
        falcon.go();
        falcon.toFly();
        falcon.hunting();
        falcon.sleep();
        if(!falcon.checkFlying(listFlying))
            listFlying.add(falcon);

    }

}