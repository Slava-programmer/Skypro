package Transport;

public class Bus extends Transport{
    String type;
    int numberOfSeats;

    public Bus(String brand, String model, int releaseDate, String countryOfOrigin, String color, int maxSpeed, String type, int numberOfSeats) {
        super(brand, model, releaseDate, countryOfOrigin, color, maxSpeed);
        this.type = type;
        this.numberOfSeats = numberOfSeats;
    }

    @Override
    public void refill() {
        fullTank = true;
        System.out.println("Объекты класса bus можно заправлять бензином или дизелем на заправке.\n"
                +getModel() +" заправлен");
    }

    @Override
    public String toString() {
        return "\n\033[92mАвтобус "+getBrand()+" "+ getModel()+" тип " + type +
                "\nПассажирских мест " + numberOfSeats +
                "\nЦвет " + color  +
                "\nМаксимальная скорость " + maxSpeed+" км/ч.\033[0m";
    }
}
