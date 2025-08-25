// Base class
public class Vehicle {
   
    protected String make;
    protected String model;
    protected int year;
    protected double fuelLevel;

   
    public Vehicle(String make, String model, int year, double fuelLevel) {
        this.make = make;
        this.model = model;
        this.year = year;
        this.fuelLevel = fuelLevel;
    }

    
    public void startVehicle() {
        System.out.println(make + " " + model + " is starting...");
    }

    public void stopVehicle() {
        System.out.println(make + " " + model + " is stopping...");
    }

    public void refuel(double amount) {
        fuelLevel += amount;
        System.out.println(make + " " + model + " refueled. Fuel Level: " + fuelLevel);
    }

    public void displayVehicleInfo() {
        System.out.println("Vehicle Info:");
        System.out.println("Make: " + make);
        System.out.println("Model: " + model);
        System.out.println("Year: " + year);
        System.out.println("Fuel Level: " + fuelLevel);
        System.out.println("----------------------");
    }

    
    public static void main(String[] args) {
        // Create different types of vehicles
        Vehicle car = new Car("Toyota", "Camry", 2020, 50, 4);
        Vehicle truck = new Truck("Ford", "F-150", 2019, 70, 1000);
        Vehicle motorcycle = new Motorcycle("Harley-Davidson", "Street 750", 2021, 20, false);

        car.startVehicle();
        truck.refuel(20);
        motorcycle.stopVehicle();

        Vehicle[] vehicles = {car, truck, motorcycle};

        // Demonstrate polymorphic behavior
        for (Vehicle v : vehicles) {
            v.displayVehicleInfo(); // Calls overridden version if available
        }

        /*
         * Explanation:
         * - Reusability: The Vehicle class defines common properties and methods
         *   that all vehicle types share (start, stop, refuel, display info).
         *   Subclasses like Car, Truck, and Motorcycle inherit these instead
         *   of rewriting them.
         *
         * - Polymorphism: Even though 'vehicles' is an array of Vehicle,
         *   it can hold different types (Car, Truck, Motorcycle).
         *   Each subclass can override displayVehicleInfo() to add unique info.
         *
         * - Extensibility: Adding a new vehicle type (e.g., Bus, ElectricCar)
         *   only requires creating a new subclass of Vehicle, reusing all
         *   the common functionality while adding new features.
         */
    }
}

// ---------------- Subclasses ----------------
class Car extends Vehicle {
    private int numberOfDoors;

    public Car(String make, String model, int year, double fuelLevel, int numberOfDoors) {
        super(make, model, year, fuelLevel);
        this.numberOfDoors = numberOfDoors;
    }

    @Override
    public void displayVehicleInfo() {
        super.displayVehicleInfo();
        System.out.println("Number of Doors: " + numberOfDoors);
        System.out.println("----------------------");
    }
}

class Truck extends Vehicle {
    private double payloadCapacity;

    public Truck(String make, String model, int year, double fuelLevel, double payloadCapacity) {
        super(make, model, year, fuelLevel);
        this.payloadCapacity = payloadCapacity;
    }

    @Override
    public void displayVehicleInfo() {
        super.displayVehicleInfo();
        System.out.println("Payload Capacity: " + payloadCapacity + " kg");
        System.out.println("----------------------");
    }
}

class Motorcycle extends Vehicle {
    private boolean hasSidecar;

    public Motorcycle(String make, String model, int year, double fuelLevel, boolean hasSidecar) {
        super(make, model, year, fuelLevel);
        this.hasSidecar = hasSidecar;
    }

    @Override
    public void displayVehicleInfo() {
        super.displayVehicleInfo();
        System.out.println("Has Sidecar: " + hasSidecar);
        System.out.println("----------------------");
    }
}
