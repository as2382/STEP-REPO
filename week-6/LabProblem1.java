// Parent class
class Fruit {
    protected String color;
    protected String taste;

    public Fruit(String color, String taste) {
        this.color = color;
        this.taste = taste;
    }

    public void displayInfo() {
        System.out.println("Fruit color: " + color + ", Taste: " + taste);
    }
}

// Child class
class Apple extends Fruit {
    private String variety;

    public Apple(String color, String taste, String variety) {
        super(color, taste); // Call parent constructor
        this.variety = variety;
    }

    public void displayAppleInfo() {
        displayInfo();
        System.out.println("Apple variety: " + variety);
    }
}

// Test class
public class LabProblem1 {
    public static void main(String[] args) {
        Apple apple = new Apple("Red", "Sweet", "Fuji");
        apple.displayAppleInfo();
    }
}
