// Base class
class Instrument {
    protected String name;
    protected String material;

    public Instrument(String name, String material) {
        this.name = name;
        this.material = material;
    }

    public void play() {
        System.out.println(name + " is playing.");
    }

    public void displayInfo() {
        System.out.println("Instrument: " + name + ", Material: " + material);
    }
}

// Child class - Piano
class Piano extends Instrument {
    private int keys;

    public Piano(String name, String material, int keys) {
        super(name, material);
        this.keys = keys;
    }

    @Override
    public void play() {
        System.out.println("The piano is playing melodious tunes with " + keys + " keys.");
    }
}

// Child class - Guitar
class Guitar extends Instrument {
    private int strings;

    public Guitar(String name, String material, int strings) {
        super(name, material);
        this.strings = strings;
    }

    @Override
    public void play() {
        System.out.println("The guitar strums beautifully with " + strings + " strings.");
    }
}

// Child class - Drum
class Drum extends Instrument {
    private String type; // e.g., Bass, Snare

    public Drum(String name, String material, String type) {
        super(name, material);
        this.type = type;
    }

    @Override
    public void play() {
        System.out.println("The drum beats powerfully (" + type + " drum).");
    }
}

// Test class
public class LabProblem5 {
    public static void main(String[] args) {
        Instrument[] instruments = new Instrument[3];
        instruments[0] = new Piano("Piano", "Wood", 88);
        instruments[1] = new Guitar("Guitar", "Metal & Wood", 6);
        instruments[2] = new Drum("Drum", "Plastic & Wood", "Snare");

        for (Instrument i : instruments) {
            i.displayInfo();
            i.play();
            System.out.println();
        }
    }
}
