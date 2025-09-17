// Base class
class Color {
    protected String name;

    public Color(String name) {
        this.name = name;
        System.out.println("Color constructor called: " + name);
    }

    public void display() {
        System.out.println("Color: " + name);
    }
}

// First child
class PrimaryColor extends Color {
    protected int intensity; // 0–100 scale

    public PrimaryColor(String name, int intensity) {
        super(name); // Call parent constructor
        this.intensity = intensity;
        System.out.println("PrimaryColor constructor called: Intensity = " + intensity);
    }

    @Override
    public void display() {
        super.display();
        System.out.println("Intensity: " + intensity + "%");
    }
}

// Second child
class RedColor extends PrimaryColor {
    private String shade; // e.g., "Crimson", "Maroon"

    public RedColor(String name, int intensity, String shade) {
        super(name, intensity); // Calls PrimaryColor constructor
        this.shade = shade;
        System.out.println("RedColor constructor called: Shade = " + shade);
    }

    @Override
    public void display() {
        super.display();
        System.out.println("Shade: " + shade);
    }
}

// Test class
public class LabProblem4 {
    public static void main(String[] args) {
        RedColor red = new RedColor("Red", 90, "Crimson");
        red.display();
    }
}
