package Transport;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class Transport {

    private String brand;
    private String model;
    private int releaseDate;
    private String countryOfOrigin;
    String color;
    int maxSpeed;

    public Transport(String brand, String model, int releaseDate, String countryOfOrigin, String color, int maxSpeed) {
        if (brand == null || brand.isEmpty()) {
            brand = "default";
        }
        if (model == null || model.isEmpty()) {
            model = "default";
        }
        if (countryOfOrigin == null || countryOfOrigin.isEmpty()) {
            countryOfOrigin = "default";
        }

        if (color == null || color.isEmpty()) {
            color = "белый";
        }
        if (releaseDate == 0) {
            releaseDate = 2000;
        }
        if (maxSpeed==0){
            maxSpeed=100;
        }
        this.brand = brand;
        this.model = model;
        this.releaseDate = releaseDate;
        this.countryOfOrigin = countryOfOrigin;
        this.color = color;
        this.maxSpeed = maxSpeed;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setMaxSpeed(int maxSpeed) {
                this.maxSpeed = maxSpeed;
    }
    @Override
    public String toString() {
        return "\n" + brand + " " + model + ", год выпуска " + releaseDate + " страна производства " + countryOfOrigin +
                ", цвет " + color + "\n"+ "=".repeat(84);
    }
}
