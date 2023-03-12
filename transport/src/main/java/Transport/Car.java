package Transport;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

@Getter
@Setter
public class Car extends Transport {


    float engineCapacity;

    private String countryOfOrigin;

    //new fields
    String gearbox;
    private String bodyType;
    String registrationNumber;
    private int numberOfSeats;
    String tireType;
    Insurance insurance;

    public Car(String brand, String model, float engineCapacity, String color, int releaseDate, String countryOfOrigin,
               String gearbox, String bodyType, String registrationNumber, int numberOfSeats, String tireType, int maxSpeed) {
        super(brand, model, releaseDate, countryOfOrigin, color, maxSpeed);

        if (engineCapacity == 0) {
            engineCapacity = 1.5F;
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

        this.engineCapacity = engineCapacity;
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

    public LocalDate getInsuranceValidDate() {
        return insurance.validityPeriod();
    }

    public void setInsurance(Insurance insurance) {
        this.insurance = insurance;
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

        if (getInsurance() == null) {
            System.out.println(getBrand() + " " + getModel() + " - " + "машина не застрахована, хотите приобресть страховочку недорого?");
        } else if (LocalDate.now().isAfter(getInsuranceValidDate())) {
            System.out.println("\033[91mСтраховка (гос.номер " + getRegistrationNumber() + ", полис № " + getInsuranceNumber() + ") просрочена!\033[0m");
        } else {
            System.out.println(getBrand() + " " + getModel() + " - " + "Страховка действительна до " + getInsuranceValidDate().format((DateTimeFormatter.ofPattern("dd.MM.yyyyг."))));
        }
    }

    @Override
    public String toString() {
        return "\n" + getBrand() + " " + getModel() + ", год выпуска " + getReleaseDate() + " страна производства " + countryOfOrigin +
                ", цвет " + color + "\nДвигатель "+ engineCapacity+"\nКоробка передач "+gearbox+"\nГосномер "+registrationNumber+"\nШины " +tireType + "\n"+"=".repeat(84);
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
        if (!numberPolice.matches("\\d{9}")) {
            System.out.println("Номер полиса некорректный, должно быть 9 цифр");
            numberPolice = (numberPolice+"недействительный");
        } else {
            return new Insurance(validityPeriod, costPolice, numberPolice);
        }
        return null;
    }

    private class Insurance {
        LocalDate validityPeriod;
        int costPolice;
        String numberPolice;

        public Insurance(LocalDate validityPeriod, int costPolice, String numberPolice) {

            this.validityPeriod = validityPeriod;
            this.costPolice = costPolice;
            this.numberPolice = numberPolice;
        }

        public LocalDate getValidityPeriod() {
            return validityPeriod;
        }

        public int getCostPolice() {
            return costPolice;
        }

        public String getNumberPolice() {
            return numberPolice;
        }

        public LocalDate validityPeriod() {
            return validityPeriod;
        }
    }



}
