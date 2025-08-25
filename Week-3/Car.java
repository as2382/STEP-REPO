public class Car {
    // Instance variables (attributes)
    String brand;
    String model;
    int year;
    String color;
    boolean isRunning;

    // Constructor
    public Car(String brand, String model, int year, String color) {
        this.brand = brand;
        this.model = model;
        this.year = year;
        this.color = color;
        this.isRunning = false; // by default, the car is off
    }

    // Method to start the engine
    public void startEngine() {
        if (!isRunning) {
            isRunning = true;
            System.out.println(brand + " " + model + " engine started.");
        } else {
            System.out.println(brand + " " + model + " is already running.");
        }
    }

    // Method to stop the engine
    public void stopEngine() {
        if (isRunning) {
            isRunning = false;
            System.out.println(brand + " " + model + " engine stopped.");
        } else {
            System.out.println(brand + " " + model + " is already off.");
        }
    }

    // Method to display car info
    public void displayInfo() {
        System.out.println("Car Information:");
        System.out.println("Brand: " + brand);
        System.out.println("Model: " + model);
        System.out.println("Year: " + year);
        System.out.println("Color: " + color);
        System.out.println("Is Running: " + isRunning);
        System.out.println("----------------------");
    }

    // Method to get car age
    public int getAge(int currentYear) {
        return currentYear - year;
    }

    // Main method
    public static void main(String[] args) {
        // Create 3 different Car objects with different attributes
        Car car1 = new Car("Toyota", "Camry", 2015, "Red");
        Car car2 = new Car("Ford", "Mustang", 2020, "Blue");
        Car car3 = new Car("Tesla", "Model 3", 2022, "White");

        // Demonstrating method calls
        car1.displayInfo();
        car1.startEngine();
        car1.stopEngine();
        System.out.println("Car age: " + car1.getAge(2025) + " years\n");

        car2.displayInfo();
        car2.startEngine();
        System.out.println("Car age: " + car2.getAge(2025) + " years\n");

        car3.displayInfo();
        car3.startEngine();
        car3.stopEngine();
        System.out.println("Car age: " + car3.getAge(2025) + " years\n");

        
    }
}
