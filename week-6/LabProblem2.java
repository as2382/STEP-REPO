// Parent class
class Phone {
    protected String brand;
    protected String model;

    public Phone() {
        System.out.println("Phone default constructor called");
    }

    public Phone(String brand, String model) {
        this.brand = brand;
        this.model = model;
        System.out.println("Phone parameterized constructor called");
    }
}

// Child class
class SmartPhone extends Phone {
    private String operatingSystem;

    public SmartPhone() {
        super(); // Calls parent default constructor
        System.out.println("SmartPhone default constructor called");
    }

    public SmartPhone(String brand, String model, String operatingSystem) {
        super(brand, model); // Calls parent parameterized constructor
        this.operatingSystem = operatingSystem;
        System.out.println("SmartPhone parameterized constructor called");
    }

    public void displaySmartPhoneInfo() {
        System.out.println("Brand: " + brand + ", Model: " + model + ", OS: " + operatingSystem);
    }
}

// Test class
public class LabProblem2 {
    public static void main(String[] args) {
        SmartPhone sp1 = new SmartPhone();  // Uses default constructor
        SmartPhone sp2 = new SmartPhone("Samsung", "Galaxy S21", "Android"); // Uses parameterized constructor
        sp2.displaySmartPhoneInfo();
    }
}
