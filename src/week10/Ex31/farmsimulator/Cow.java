package week10.Ex31.farmsimulator;

import java.util.Random;

public class Cow implements Milkable, Alive {
    private String name;
    private double capacity, amount = 0;
    private static final String[] NAMES = new String[]{
            "Anu", "Arpa", "Essi", "Heluna", "Hely",
            "Hento", "Hilke", "Hilsu", "Hymy", "Ihq", "Ilme", "Ilo",
            "Jaana", "Jami", "Jatta", "Laku", "Liekki",
            "Mainikki", "Mella", "Mimmi", "Naatti",
            "Nina", "Nyytti", "Papu", "Pullukka", "Pulu",
            "Rima", "Soma", "Sylkki", "Valpu", "Virpi"};

    public Cow() {
        this.name = Cow.randomName();
        this.capacity = Cow.randomCapacity();
    }

    public Cow(String name) {
        this.name = name;
        this.capacity = Cow.randomCapacity();
    }

    public String getName() {
        return name;
    }

    public double getCapacity() {
        return capacity;
    }

    public double getAmount() {
        return amount;
    }

    private static String randomName() {
        return NAMES[new Random().nextInt(NAMES.length)];
    }

    private static double randomCapacity() {
        return 15 + new Random().nextInt(26);
    }

    public String toString() {
        return name + " " + Math.ceil(amount) + "/" + Math.ceil(capacity);
    }

    public double milk() {
        double temp = amount;
        amount = 0;
        return temp;
    }

    public void liveHour() {
        amount += 0.7 + 1.3 * new Random().nextDouble();
        if (amount > capacity) {
            amount = capacity;
        }
    }
}