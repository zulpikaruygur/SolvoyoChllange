import lombok.*;

@Data
public class Cars {

    private String make;
    private String model;
    private int year;
    private String licensePlateNumber;

    public Cars(String make, String model, int year, String licensePlateNumber) {
        this.make = make;
        this.model = model;
        this.year = year;
        this.licensePlateNumber = licensePlateNumber;
    }
}
