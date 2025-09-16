// File: MultilevelInheritanceDemo.java

// 🔹 Base class
class Animal {
    // Protected fields (accessible to subclasses)
    protected String species;
    protected String habitat;
    protected int lifespan;
    protected boolean isWildlife;

    // Constructor
    public Animal(String species, String habitat, int lifespan, boolean isWildlife) {
        this.species = species;
        this.habitat = habitat;
        this.lifespan = lifespan;
        this.isWildlife = isWildlife;
        System.out.println("Animal constructor: Creating " + species);
    }

    // Methods
    public void eat() {
        System.out.println("Animal is eating");
    }

    public void sleep() {
        System.out.println("Animal is sleeping");
    }

    public void move() {
        System.out.println("Animal is moving");
    }

    public String getAnimalInfo() {
        return "Species: " + species + ", Habitat: " + habitat +
               ", Lifespan: " + lifespan + " years, Wildlife: " + isWildlife;
    }
}

// 🔹 Intermediate class
class Mammal extends Animal {
    // Mammal-specific fields
    protected String furColor;
    protected boolean hasWarmBlood;
    protected int gestationPeriod; // in days

    // Constructor
    public Mammal(String species, String habitat, int lifespan, boolean isWildlife,
                  String furColor, int gestationPeriod) {
        super(species, habitat, lifespan, isWildlife);
        this.furColor = furColor;
        this.hasWarmBlood = true; // always true for mammals
        this.gestationPeriod = gestationPeriod;
        System.out.println("Mammal constructor: Adding mammal traits");
    }

    // Override move()
    @Override
    public void move() {
        super.move();
        System.out.println("Mammal is walking/running");
    }

    // Mammal-specific methods
    public void nurse() {
        System.out.println("Mammal is nursing offspring");
    }

    public void regulateTemperature() {
        System.out.println("Maintaining body temperature");
    }
}

// 🔹 Specific class
class Dog extends Mammal {
    // Dog-specific fields
    private String breed;
    private boolean isDomesticated;
    private int loyaltyLevel; // 1–10
    private String favoriteActivity;

    // Constructor 1: Basic dog with minimal parameters
    public Dog(String breed) {
        super("Dog", "Various", 13, true, "Varies", 63); // default mammal/animal values
        this.breed = breed;
        this.isDomesticated = true;
        this.loyaltyLevel = 5;
        this.favoriteActivity = "Playing fetch";
        System.out.println("Dog constructor: Creating basic " + breed + " dog");
    }

    // Constructor 2: Detailed dog
    public Dog(String species, String habitat, int lifespan, boolean isWildlife,
               String furColor, int gestationPeriod,
               String breed, boolean isDomesticated, int loyaltyLevel, String favoriteActivity) {
        super(species, habitat, lifespan, isWildlife, furColor, gestationPeriod);
        this.breed = breed;
        this.isDomesticated = isDomesticated;
        this.loyaltyLevel = loyaltyLevel;
        this.favoriteActivity = favoriteActivity;
        System.out.println("Dog constructor: Creating " + breed + " dog");
    }

    // Constructor 3: Copy constructor
    public Dog(Dog other) {
        this(other.species, other.habitat, other.lifespan, other.isWildlife,
             other.furColor, other.gestationPeriod,
             other.breed, other.isDomesticated, other.loyaltyLevel, other.favoriteActivity);
        System.out.println("Dog constructor: Copying " + other.breed + " dog");
    }

    // Override eat()
    @Override
    public void eat() {
        super.eat();
        System.out.println("Dog is eating kibble and wagging tail while eating");
    }

    // Override move()
    @Override
    public void move() {
        System.out.println("Dog is running and playing");
    }

    // Override sleep()
    @Override
    public void sleep() {
        System.out.println("Dog is sleeping in doghouse");
    }

    // Dog-specific methods
    public void bark() {
        System.out.println("Woof! Woof!");
    }

    public void fetch() {
        System.out.println("Dog is fetching the ball");
    }

    public void showLoyalty() {
        System.out.println("Dog loyalty level: " + loyaltyLevel + "/10");
    }

    // Demonstrate calling up the chain
    public void demonstrateInheritance() {
        System.out.println("\n--- Demonstrating Inheritance Chain ---");
        eat();   // overridden in Dog
        sleep(); // overridden in Dog
        move();  // overridden in Dog
        nurse(); // Mammal-specific
        regulateTemperature(); // Mammal-specific
        System.out.println(getAnimalInfo()); // Animal-level
    }

    // 🔹 Main method
    public static void main(String[] args) {
        System.out.println("\n--- Testing Constructor Chaining ---");
        Dog dog1 = new Dog("Labrador"); // minimal constructor

        System.out.println("\n--- Testing Detailed Constructor ---");
        Dog dog2 = new Dog("Dog", "Domestic", 15, true, "Golden", 60,
                           "Golden Retriever", true, 9, "Swimming");

        System.out.println("\n--- Testing Copy Constructor ---");
        Dog dog3 = new Dog(dog2);

        System.out.println("\n--- Testing Method Overriding ---");
        dog2.eat();
        dog2.move();
        dog2.sleep();

        System.out.println("\n--- Testing Dog-specific Methods ---");
        dog2.bark();
        dog2.fetch();
        dog2.showLoyalty();

        System.out.println("\n--- Demonstrating Inheritance ---");
        dog2.demonstrateInheritance();

        System.out.println("\n--- Testing instanceof relationships ---");
        System.out.println("dog2 instanceof Dog: " + (dog2 instanceof Dog));
        System.out.println("dog2 instanceof Mammal: " + (dog2 instanceof Mammal));
        System.out.println("dog2 instanceof Animal: " + (dog2 instanceof Animal));
    }
}

