import Driver.CategoryB;
import Driver.CategoryC;
import Driver.CategoryD;
import Driver.Driver;
import transport.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class Main {

    public static void main(String[] args) throws IllegalAccessException {
        // Задание 1
        System.out.println(" Задание 1");

        Mechanic<Car> nikolay = new Mechanic<>("Николай", "Иванович", "АвтоСервис");
        Mechanic<Cargo> ivanov = new Mechanic<>("Иванов", "Васильевич", "Грузовик Сервис");
        Mechanic<Bus> maksim = new Mechanic<>("Максим", "Суворов", "Busfor");
        Sponsor shell = new Sponsor("Шелл", 3000000);
        Sponsor pirelli = new Sponsor("Pirelli", 2100000);

        Car lada = new Car("Lada", "Granta", 1.7, Car.TypeCommand.SEDAN);
        lada.addDriver(new CategoryB("Иванов И.И.", 6, lada));
        lada.addMechanic(nikolay);
        lada.addSponsor(shell,pirelli);

        Car audi = new Car("Audi", "A8 50 L TDI quattro", 3.0, Car.TypeCommand.COUPE);
        audi.addDriver(new CategoryB("Иванов И.И.", 6, audi));
        audi.addMechanic(nikolay);
        audi.addSponsor(shell,pirelli, pirelli); //Специально сделали повтор для проверки

        Car bmw = new Car("BMW", "Z8", 3.0, Car.TypeCommand.CROSSOVER);
        bmw.addDriver(new CategoryB("Иванов И.И.", 6, bmw));
        bmw.addMechanic(nikolay);
        bmw.addSponsor(shell,pirelli);


        Car kia = new Car("Kia", "Sportage 4-го поколения", 2.4, Car.TypeCommand.SEDAN);
        kia.addDriver(new CategoryB("Иванов И.И.", 6, kia));
        kia.addMechanic(nikolay);
        kia.addSponsor(shell,pirelli);

        Car hyundai = new Car("Hyundai", "Avante", 1.6, Car.TypeCommand.SEDAN);
        hyundai.addDriver(new CategoryB("Иванов И.И.", 6, hyundai));
        hyundai.addMechanic(nikolay);
        hyundai.addSponsor(shell,pirelli);


        Bus kia1 = new Bus("Kia", "Granbird", 9.5, Bus.TypeOfCapacity.BIG);
        kia1.addDriver(new CategoryD("Максим Н.И.", 15, kia1));
        kia1.addMechanic(maksim);
        kia1.addSponsor(pirelli);

        Bus yutong = new Bus("Yutong ", "ZK6122H9", 8.9, Bus.TypeOfCapacity.AVERAGE);
        yutong.addDriver(new CategoryD("Максим Н.И.", 15, yutong));
        yutong.addMechanic(maksim);
        yutong.addSponsor(pirelli);

        Bus ankai = new Bus("ANKAI ", "GK39", 6.5, Bus.TypeOfCapacity.SMALL);
        ankai.addDriver(new CategoryD("Максим Н.И.", 15, ankai));
        ankai.addMechanic(maksim);
        ankai.addSponsor(pirelli);

        Bus mercedes = new Bus("Mercedes-Benz", "Tourismo", 14, Bus.TypeOfCapacity.ESPECIALLY_BIG);
        mercedes.addDriver(new CategoryD("Максим Н.И.", 15, mercedes));
        mercedes.addMechanic(maksim);
        mercedes.addSponsor(pirelli);


        Cargo faw = new Cargo("FAW", "J6 CA3250", 11.1, Cargo.LoadCapacity.N1);
        faw.addDriver(new CategoryC("Николай И.Т.", 15, faw));
        faw.addMechanic(ivanov);
        faw.addSponsor(shell);

        Cargo iveco = new Cargo("IVECO", "Stralis", 15.7, Cargo.LoadCapacity.N2);
        iveco.addDriver(new CategoryC("Николай И.Т.", 15, iveco));
        iveco.addMechanic(ivanov);
        iveco.addSponsor(shell);

        Cargo man = new Cargo("MAN", "TGS", 10.5, Cargo.LoadCapacity.N3);
        man.addDriver(new CategoryC("Николай И.Т.", 15, man));
        man.addMechanic(ivanov);
        man.addSponsor(shell);

        Cargo international = new Cargo("International", "4000 Series", 7.6, Cargo.LoadCapacity.N2);
        international.addDriver(new CategoryC("Николай И.Т.", 15, international));
        international.addMechanic(ivanov);
        international.addSponsor(shell);

        Set<Transport>  newTransports = new HashSet<>(); //Коллекция авто без повторов
        List<Transport> transports = List.of(
            lada, audi, bmw, kia, hyundai,
            kia1, yutong, ankai, mercedes,
            faw, iveco, man, international, international);// Для удобного добавления авто в коллекцию Set (тут есть повторы)



        ServiceStation serviceStation = new ServiceStation();
        serviceStation.addCar(lada);
        serviceStation.addCar(audi);
        serviceStation.addCar(bmw);
        serviceStation.addCar(kia);
        serviceStation.addCar(hyundai);

        serviceStation.addCargo(faw);
        serviceStation.addCargo(iveco);
        serviceStation.addCargo(man);
        serviceStation.addCargo(international);

        serviceStation.service();
        serviceStation.service();
        serviceStation.service();
        serviceStation.service();
        serviceStation.service();
        serviceStation.service();
        serviceStation.service();
        serviceStation.service();
        serviceStation.service();

        for (Transport transport : transports)
        {
            addTransport(transport,newTransports);
        }

        for (Transport transport : newTransports) {
            printInfo(transport);
        }
    }

    public static void addTransport(Transport transport, Set<Transport> transports)
    {
        try {
            transports.add(transport);
        }
        catch (IllegalArgumentException e) {
            System.out.println("Обнаружен дубликат. Будет проигнорирован");
        }
    }
    private static void printInfo(Transport transport) {
        System.out.println("Информация по автомобилю " + transport.getBrand() + " " + transport.getModel());
        System.out.println("Водитель: ");
        for (Driver<?> driver : transport.getDrivers()) {
            System.out.println(driver.getFullName());
        }
        System.out.println("Спонсоры: ");
        for (Sponsor sponsor : transport.getSponsors()) {
            System.out.println(sponsor.getName());
        }
        System.out.println("Механик: ");
        for (Mechanic<?> mechanic : transport.getMechanics()) {
            System.out.println(mechanic.getName()+ " "+ mechanic.getSurname()+ " из "+ mechanic.getCompany());
        }
        System.out.println();
    }
    private static void service(Transport... transports) {
        for (Transport transport : transports) {
            serviceTransport(transport);
        }
    }
    private static void serviceTransport(Transport transports) {
        try {
            if (!transports.service()) {
                throw new RuntimeException("Автомобиль " + transports.getBrand() + " "
                        + transports.getModel() + " не прошел диагностику");
            }
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }
    }
}


