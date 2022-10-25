import Driver.CategoryB;
import Driver.CategoryC;
import Driver.CategoryD;
import transport.Bus;
import transport.Car;
import transport.Cargo;
import transport.Transport;


public class Main {

    public static void main(String[] args) throws IllegalAccessException {
        // ООП. Урок 4
        System.out.println("ООП. Урок 4 Задание 1");

        Car lada = new Car("Lada", "Granta", 1.7, Car.TypeCommand.SEDAN);
        Car audi = new Car("Audi", "A8 50 L TDI quattro", 3.0, Car.TypeCommand.COUPE);
        Car bmw = new Car("BMW", "Z8", 3.0, Car.TypeCommand.CROSSOVER);
        Car kia = new Car("Kia", "Sportage 4-го поколения", 2.4, Car.TypeCommand.SEDAN);
        Car hyundai = new Car("Hyundai", "Avante", 1.6, Car.TypeCommand.SEDAN);


        System.out.println(lada);
        System.out.println(audi);
        System.out.println(bmw);
        System.out.println(kia);
        System.out.println(hyundai);
        lada.startMovement();
        lada.stopMovement();
        lada.pitStop();
        audi.startMovement();
        audi.stopMovement();
        audi.pitStop();
        bmw.startMovement();
        bmw.stopMovement();
        bmw.pitStop();
        kia.startMovement();
        kia.stopMovement();
        kia.pitStop();
        hyundai.startMovement();
        hyundai.stopMovement();
        hyundai.pitStop();


        System.out.println("Автобусы");

        Bus kia1 = new Bus("Kia", "Granbird", 9.5, Bus.TypeOfCapacity.BIG);
        Bus yutong = new Bus("Yutong ", "ZK6122H9", 8.9, Bus.TypeOfCapacity.AVERAGE);
        Bus ankai = new Bus("ANKAI ", "GK39", 6.5, Bus.TypeOfCapacity.SMALL);
        Bus mercedes = new Bus("Mercedes-Benz", "Tourismo", 14, Bus.TypeOfCapacity.ESPECIALLY_BIG);

        System.out.println(kia1);
        System.out.println(yutong);
        System.out.println(ankai);
        System.out.println(mercedes);
        kia1.startMovement();
        kia1.stopMovement();
        kia1.startMovement();
        kia1.stopMovement();
        kia1.pitStop();
        yutong.startMovement();
        yutong.stopMovement();
        yutong.pitStop();
        ankai.startMovement();
        ankai.stopMovement();
        ankai.pitStop();
        mercedes.startMovement();
        mercedes.stopMovement();
        mercedes.pitStop();

        System.out.println("Грузовые");

        Cargo faw = new Cargo("FAW", "J6 CA3250", 11.1, Cargo.LoadCapacity.N1);
        Cargo iveco = new Cargo("IVECO", "Stralis", 15.7, Cargo.LoadCapacity.N2);
        Cargo man = new Cargo("MAN", "TGS", 10.5, Cargo.LoadCapacity.N3);
        Cargo international = new Cargo("International", "4000 Series", 7.6, Cargo.LoadCapacity.N2);


        System.out.println(faw);
        System.out.println(iveco);
        System.out.println(man);
        System.out.println(international);
        faw.startMovement();
        faw.stopMovement();
        faw.startMovement();
        faw.stopMovement();
        faw.pitStop();
        iveco.startMovement();
        iveco.stopMovement();
        iveco.pitStop();
        man.startMovement();
        man.stopMovement();
        man.pitStop();
        international.startMovement();
        international.stopMovement();
        international.pitStop();


        service(
                lada, audi, bmw, kia, hyundai,
                kia1, yutong, ankai, mercedes,
                faw, iveco, man, international
        );

        CategoryB categoryB = new CategoryB("Иванов И.И.", 6, lada);
        System.out.println(categoryB);
        CategoryC categoryC = new CategoryC("Николай И.Т.", 15, faw);
        System.out.println(categoryC);
        CategoryD categoryD = new CategoryD("Максим Н.И.", 15, ankai);
        System.out.println(categoryD);

        categoryB.startMovement();
        categoryB.refill();
        categoryB.stopMovement();
        audi.printType();
        faw.printType();
        ankai.printType();

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


