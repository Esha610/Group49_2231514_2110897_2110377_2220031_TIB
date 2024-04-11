package Shanto;

public class ActionPlan {
    private String name;

    public ActionPlan(String name) {
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
