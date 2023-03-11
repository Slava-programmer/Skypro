package Transport;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

@Getter
@Setter
public class Car {

    private String brand;
    private String model;
    float engineCapacity;
    String color;
    private int releaseDate;
    private String countryOfOrigin;

    //new fields
    String gearbox;
    private String bodyType;
    String registrationNumber;
    private int numberOfSeats;
    String tireType;
    Insurance insurance;

    public Car(String brand, String model, float engineCapacity, String color, int releaseDate, String countryOfOrigin,
               String gearbox, String bodyType, String registrationNumber, int numberOfSeats, String tireType) {

        if (brand == null || brand.isEmpty()) {
            brand = "default";
        }
        if (model == null || model.isEmpty()) {
            model = "default";
        }
        if (countryOfOrigin == null || countryOfOrigin.isEmpty()) {
            countryOfOrigin = "default";
        }
        if (engineCapacity == 0) {
            engineCapacity = 1.5F;
        }
        if (color == null || color.isEmpty()) {
            color = "белый";
        }
        if (releaseDate == 0) {
            releaseDate = 2000;
        }
        if (gearbox == null || gearbox.isEmpty()) {
            gearbox = "АККП";
        }
        if (bodyType == null || bodyType.isEmpty()) {
            bodyType = "Седан";
        }
        if (numberOfSeats == 0) {
            numberOfSeats = 5;
        }
        if (registrationNumber == null || registrationNumber.isEmpty()) {
            registrationNumber = "x000xx00";
        } else if (!registrationNumber.matches("([а-я]\\d{3}[а-я]{2}\\d{2,3})")) {
            registrationNumber = "некорректный ввод";
        }
        if (tireType == null || tireType.isEmpty()) {
            tireType = "Летние";
        }
        this.brand = brand;
        this.model = model;
        this.engineCapacity = engineCapacity;
        this.color = color;
        this.releaseDate = releaseDate;
        this.countryOfOrigin = countryOfOrigin;
        this.gearbox = gearbox;
        this.bodyType = bodyType;
        this.registrationNumber = registrationNumber;
        this.tireType = tireType;
        this.numberOfSeats = numberOfSeats;

    }
    public String getInsuranceNumber() {
        return insurance.numberPolice;
    }

    public int getInsuranceCost() {
        return insurance.costPolice;
    }

    public String getInsuranceValidDate() {
        return insurance.validityPeriod.format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
    }

    @Override
    public String toString() {
        return "\n" + brand + " " + model + ", год выпуска " + releaseDate + " страна производства " + countryOfOrigin +
                ", цвет " + color + "\nобъём двигателя " + engineCapacity +
                ", коробка передач " + gearbox + ", тип кузова " + bodyType + ", количество мест " + numberOfSeats +
                "\nгосномер " + registrationNumber + ", шины " + tireType + "\n" + "=".repeat(84);
    }


    public String setRegistrationNumberManually() {
        Scanner scanner = new Scanner(System.in);
        String tmpNumber = " ";
        while (!tmpNumber.matches("([а-я]\\d{3}[а-я]{2}\\d{2,3})")) {
            System.out.println("Введённый номер а/м некорректный. Введите номер в формате х000хх000");
            tmpNumber = scanner.nextLine();
        }
        return tmpNumber;
    }

    public void checkPoliceValidData() {
        if (insurance == null) {
            System.out.println(brand + " " + model + " - " + "машина не застрахована, хотите приобресть страховочку недорого?");
        } else if (LocalDate.now().isAfter(insurance.validityPeriod)) {
            System.out.println("\033[91mСтраховка (гос.номер " + registrationNumber + ", полис № " + insurance.numberPolice + ") просрочена!\033[0m");
        } else {
            System.out.println(brand + " " + model + " - " + "Страховка действительна до " + insurance.validityPeriod.format(DateTimeFormatter.ofPattern("dd.MM.yyyyг.")));
        }
    }


    public void changeTyres() {
        if (tireType.equals("Летние")) {
            tireType = "Зимние";
        } else tireType = "Летние";
    }

    private class Key {
        private boolean remoteStartEngine;
        private boolean keylessAccess;

        public Key(boolean remoteStartEngine, boolean keylessAccess) {
            this.remoteStartEngine = remoteStartEngine;
            this.keylessAccess = keylessAccess;
        }
    }

    public Insurance insureCar(LocalDate validityPeriod, int costPolice, String numberPolice) {
        Insurance insurance = new Insurance(validityPeriod, costPolice, numberPolice);
        return insurance;
    }

    @AllArgsConstructor
    private class Insurance {
        LocalDate validityPeriod;
        int costPolice;
        String numberPolice;
    }
}
