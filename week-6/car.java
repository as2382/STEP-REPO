// File: Vehicle.java
import java.util.Random;

public class Vehicle {
    // 🔹 Protected fields (accessible to subclasses)
    protected String brand;
    protected String model;
    protected int year;
    protected String engineType;

    // 🔹 Private fields (only accessible via getters/setters)
    private String registrationNumber;
    private boolean isRunning;

    // 🔹 Default constructor
    public Vehicle() {
        this.brand = "Unknown";
        this.model = "Unknown";
        this.year = 0;
        this.engineType = "Unknown";
        this.registrationNumber = generateRegistrationNumber();
        this.isRunning = false;
        System.out.println("Vehicle default constructor called");
    }

    // 🔹 Parameterized constructor
    public Vehicle(String brand, String model, int year, String engineType) {
        this.brand = brand;
        this.model = model;
        this.year = year;
        this.engineType = engineType;
        this.registrationNumber = generateRegistrationNumber();
        this.isRunning = false;
        System.out.println("Vehicle parameterized constructor called");
    }

    // 🔹 Methods
    public void start() {
        isRunning = true;
        System.out.println("Vehicle started");
    }

    public void stop() {
        isRunning = false;
        System.out.println("Vehicle stopped");
    }

    public String getVehicleInfo() {
        return "Brand: " + brand + ", Model: " + model + 
               ", Year: " + year + ", Engine: " + engineType +
               ", Reg#: " + registrationNumber + 
               ", Running: " + isRunning;
    }

    public void displaySpecs() {
        System.out.println("---- Vehicle Specs ----");
        System.out.println("Brand: " + brand);
        System.out.println("Model: " + model);
        System.out.println("Year: " + year);
        System.out.println("Engine Type: " + engineType);
    }

    // 🔹 Getter/Setter for registrationNumber
    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    // 🔹 Getter for isRunning (no setter, controlled by start/stop)
    public boolean isRunning() {
        return isRunning;
    }

    // 🔹 Helper method to generate random registration number
    private String generateRegistrationNumber() {
        Random rand = new Random();
        return "REG-" + (1000 + rand.nextInt(9000));
    }
}

// File: Car.java
public class Car extends Vehicle {
    // 🔹 Car-specific fields
    private int numberOfDoors;
    private String fuelType;
    private String transmissionType;

    // 🔹 Default constructor
    public Car() {
        super(); // Explicit call to Vehicle default constructor
        this.numberOfDoors = 4;
        this.fuelType = "Petrol";
        this.transmissionType = "Manual";
        System.out.println("Car default constructor called");
    }

    // 🔹 Parameterized constructor
    public Car(String brand, String model, int year, String engineType, 
               int numberOfDoors, String fuelType, String transmissionType) {
        super(brand, model, year, engineType); // Explicit call to Vehicle parameterized constructor
        this.numberOfDoors = numberOfDoors;
        this.fuelType = fuelType;
        this.transmissionType = transmissionType;
        System.out.println("Car parameterized constructor called");
    }

    // 🔹 Override start() with car-specific logic
    @Override
    public void start() {
        super.start(); // Call Vehicle's start method
        System.out.println("Car-specific startup sequence: Engine check, Seatbelt reminder, Dashboard lights ON");
    }

    // 🔹 Override displaySpecs()
    @Override
    public void displaySpecs() {
        super.displaySpecs(); // Call Vehicle displaySpecs
        System.out.println("---- Car Specs ----");
        System.out.println("Doors: " + numberOfDoors);
        System.out.println("Fuel Type: " + fuelType);
        System.out.println("Transmission: " + transmissionType);
    }

    // 🔹 Car-specific methods
    public void openTrunk() {
        System.out.println("Trunk opened");
    }

    public void playRadio() {
        System.out.println("Radio playing music");
    }

    // 🔹 Main method for testing
    public static void main(String[] args) {
        // 1️⃣ Test constructor chaining
        System.out.println("\n--- Creating Car using default constructor ---");
        Car car1 = new Car();

        System.out.println("\n--- Creating Car using parameterized constructor ---");
        Car car2 = new Car("Toyota", "Camry", 2022, "Hybrid", 4, "Petrol", "Automatic");

        // 2️⃣ Test inheritance of fields and methods
        System.out.println("\n--- Inherited fields & methods ---");
        System.out.println("Car2 brand: " + car2.brand); // protected access
        System.out.println("Car2 info: " + car2.getVehicleInfo());

        // 3️⃣ Test overridden methods
        System.out.println("\n--- Overridden start() method ---");
        car2.start();

        System.out.println("\n--- Overridden displaySpecs() method ---");
        car2.displaySpecs();

        // 4️⃣ Test car-specific methods
        System.out.println("\n--- Car-specific methods ---");
        car2.openTrunk();
        car2.playRadio();

        // 5️⃣ Test method resolution and polymorphism
        System.out.println("\n--- Polymorphic behavior ---");
        Vehicle polyCar = new Car("Honda", "Civic", 2021, "Petrol", 4, "Petrol", "CVT");
        polyCar.start();       // Calls overridden Car start()
        polyCar.displaySpecs();// Calls overridden Car displaySpecs()
        // polyCar.openTrunk(); // ❌ Not accessible via Vehicle reference
    }
}
