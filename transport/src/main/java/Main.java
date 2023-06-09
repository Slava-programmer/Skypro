import Transport.Bus;
import Transport.Car;
import Transport.Train;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        Car lada1 = new Car("Lada", "Granta",
                1.5f, "Белый",
                2021, "Россия",
                "МККП", "Универсал",
                "е777кх77", 5, "Зимние", 150);
        Car bmwNull = new Car("BMW", "X3",
                0, null,
                0, null,
                "АККП", null,
                "х013см150", 5, null, 240);
        Car hyundai1 = new Car("Hyundai", "Accent",
                0.6f, "жёлтый",
                2004, "South Korea",
                "МККП", "Седан",
                "х013с1050", 5, "Зимние", 180);

        System.out.println(lada1);
        System.out.println(bmwNull);
        System.out.println(hyundai1);

        lada1.changeTyres();
        System.out.println("\n\033[92m       У Лады сменили колёса.\n" +
                "  ||  ".repeat(6) + "\n" + "  \\/  ".repeat(6) + "\033[0m\n" + lada1);

        lada1.setInsurance(lada1.insureCar(LocalDate.of(2015, 5, 21), 15_000, "958855005"));
        hyundai1.setInsurance(hyundai1.insureCar(LocalDate.of(2023, 10, 1), 7_000, "075565461"));

//        hyundai1.setRegistrationNumber(lada1.setRegistrationNumberManually());
        System.out.println(hyundai1);

        lada1.checkPoliceValidData();
        bmwNull.checkPoliceValidData();
        hyundai1.checkPoliceValidData();
        //Работаем с поездами и автобусами.

        Train train1 = new Train("Ласточка", 2018, "Россия",
                310, 3500,
                6, "Москва", "Санкт-Петербург", 8);
        Train train2 = new Train("ВЭЛ2000", 1991, "Россия",
                120, 1700,
                48, "Москва", "Воркута", 16);

        Bus bus1 = new Bus("VW","T3",1989,"Germany",
                "Синий", 120, "Пассажирский",8);
        Bus bus2 = new Bus("РАФ","2405",1991,"Латвия",
                "Красно-белый", 140, "Скорая помощь",4);

        System.out.println(train1);
        System.out.println(train2);

        System.out.println(bus1);
        System.out.println(bus2);


        System.out.println("\n"+"=".repeat(100)+"\nТеперь заправим всю технику");

        System.out.println(lada1.isFullTank());
        lada1.refill();
        System.out.println("После заправки "+ lada1.isFullTank());
        System.out.println(train1.isFullTank());
        train1.refill();
        System.out.println(train1.isFullTank());
        bus1.refill();
        System.out.println(bus1.isFullTank());


    }
}
