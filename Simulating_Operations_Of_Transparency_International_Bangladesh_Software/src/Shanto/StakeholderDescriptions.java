package Shanto;

import java.util.HashMap;

public class StakeholderDescriptions {
    private HashMap<String, String> descriptions;

    public StakeholderDescriptions() {
        descriptions = new HashMap<>();
    }

    public void put(String stakeholderName, String stakeholderDescription) {
        descriptions.put(stakeholderName, stakeholderDescription);
    }

    public String getDescription(String stakeholderName) {
        return descriptions.get(stakeholderName);
    }

    public void clear() {
        descriptions.clear();
    }
}
