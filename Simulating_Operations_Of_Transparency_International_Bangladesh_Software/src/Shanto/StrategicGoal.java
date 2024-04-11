package Shanto;

public class StrategicGoal {
    private String name;

    public StrategicGoal(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name;
    }
}
