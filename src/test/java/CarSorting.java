import java.io.*;
import java.util.*;

public class Sample1 {

    //defining the main method
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.print("From which file do you want to load this information? ");
        String fileName = scanner.nextLine();

        //creating an arraylist to store Car objects
        ArrayList<Cars> cars = new ArrayList<>();

        try {
            File file = new File(System.getProperty("user.dir") + "\\src\\test\\resources\\" + fileName);
            //creating a scanner object to read from the text file
            Scanner sc = new Scanner(file);

            //looping through the text file line by line
            while (sc.hasNextLine()) {

                //skipping the line that starts with "Car"
                if (sc.nextLine().startsWith("Car")) {

                    //reading and storing the next four lines as strings
                    String makeLine = sc.nextLine();
                    String modelLine = sc.nextLine();
                    String yearLine = sc.nextLine();
                    String licenseLine = sc.nextLine();

                    //extracting the values after the colon in each line
                    String makeValue = makeLine.substring(makeLine.indexOf(":") +1).trim();
                    String modelValue = modelLine.substring(modelLine.indexOf(":") +1).trim();
                    int yearValue = Integer.parseInt(yearLine.substring(yearLine.indexOf(":") +1).trim());
                    String licenseValue = licenseLine.substring(licenseLine.indexOf(":") +1).trim();

                    //creating a new Car object with the extracted values and adding it to the arraylist
                    cars.add(new Cars(makeValue, modelValue, yearValue, licenseValue));
                }
            }
            //closing the scanner object
            sc.close();

        } catch (FileNotFoundException e) { //handling the exception if the file is not found

            System.out.println("File not found.");
        }

        //sorting the arraylist according to year using a comparator object
        Collections.sort(cars, Comparator.comparingInt(Cars::getYear));

       //printing out the sorted arraylist of cars using the desired pattern
        System.out.print("ArrayList: [");
        for (int i = 0; i < cars.size(); i++) {
            Cars car = cars.get(i);
            System.out.print(car.getYear() + " " + car.getMake() + " " + car.getModel() + " (" + car.getLicensePlateNumber() + ")");
            if (i < cars.size() - 1) { //adding a comma and a space after each element except the last one
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }
}
