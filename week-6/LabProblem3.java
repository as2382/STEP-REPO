// Parent class
class Bird {
    public void fly() {
        System.out.println("A bird is flying...");
    }
}

// Child class - Penguin
class Penguin extends Bird {
    @Override
    public void fly() {
        System.out.println("Penguins can't really fly, they swim instead!");
    }
}

// Child class - Eagle
class Eagle extends Bird {
    @Override
    public void fly() {
        System.out.println("The eagle soars high in the sky!");
    }
}

// Test class
public class LabProblem3 {
    public static void main(String[] args) {
        Bird[] birds = new Bird[3];
        birds[0] = new Bird();
        birds[1] = new Penguin();
        birds[2] = new Eagle();

        for (Bird b : birds) {
            b.fly(); // Demonstrates polymorphism
        }
    }
}
