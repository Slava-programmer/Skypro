package Transport;

public class Train extends Transport {
    int costTicket;
    int timeRace;
    String departureStation;
    String arrivalStation;
    int numberCars;

    public Train(String brand, String model, int releaseDate, String countryOfOrigin, String color, int maxSpeed, int costTicket, int timeRace, String departureStation, String arrivalStation, int numberCars) {
        super(brand, model, releaseDate, countryOfOrigin, color, maxSpeed);
        this.costTicket = costTicket;
        this.timeRace = timeRace;
        this.departureStation = departureStation;
        this.arrivalStation = arrivalStation;
        this.numberCars = numberCars;
    }

    public int getCostTicket() {
        return costTicket;
    }

    public void setCostTicket(int costTicket) {
        this.costTicket = costTicket;
    }

    public int getTimeRace() {
        return timeRace;
    }

    public void setTimeRace(int timeRace) {
        this.timeRace = timeRace;
    }

    public String getDepartureStation() {
        return departureStation;
    }

    public void setDepartureStation(String departureStation) {
        this.departureStation = departureStation;
    }

    public String getArrivalStation() {
        return arrivalStation;
    }

    public void setArrivalStation(String arrivalStation) {
        this.arrivalStation = arrivalStation;
    }

    public int getNumberCars() {
        return numberCars;
    }

    public void setNumberCars(int numberCars) {
        this.numberCars = numberCars;
    }

    public Train(String model, int releaseDate, String countryOfOrigin, int maxSpeed, int costTicket, int timeRace, String departureStation, String arrivalStation, int numberCars) {
        super(model, releaseDate, countryOfOrigin, maxSpeed);
        this.costTicket = costTicket;
        this.timeRace = timeRace;
        this.departureStation = departureStation;
        this.arrivalStation = arrivalStation;
        this.numberCars = numberCars;
    }

    @Override
    public void refill() {
        fullTank = true;
        System.out.println("Паровозы все эти заправляем углём или соляркой.\n" +
                getModel() + " заправлен");
    }

    @Override
    public String toString() {
        return "\n" + "=".repeat(82) + "\n" +
                "Поезд " + getModel() + " " + departureStation + " - " + arrivalStation +
                "\nВремя в пути " + timeRace + " часа(ов) " +
                "\nСтоимость билета " + costTicket + " рублей" +
                "\nВагонов " + numberCars +
                "\nМаксимальная скорость " + maxSpeed + "км/ч.\n" + "=".repeat(82);
    }
}

