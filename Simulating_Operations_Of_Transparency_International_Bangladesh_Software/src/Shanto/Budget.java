package Shanto;

public class Budget {
    private String name;
    private double amount;

    public Budget(String name, double amount) {
        this.name = name;
        this.amount = amount;
    }

    public String getName() {
        return name;
    }

    public double getAmount() {
        return amount;
    }

    @Override
    public String toString() {
        return name + " - $" + amount;
    }
}
