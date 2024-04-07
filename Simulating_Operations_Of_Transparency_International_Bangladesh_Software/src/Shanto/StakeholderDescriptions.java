package Shanto;

import java.util.HashMap;
import java.util.Map;

public class StakeholderDescriptions {
    private Map<String, String> descriptions;

    public StakeholderDescriptions() {
        descriptions = new HashMap<>();
    }

    public void put(String stakeholderName, String description) {
        descriptions.put(stakeholderName, description);
    }

    public String getDescription(String stakeholderName) {
        return descriptions.get(stakeholderName);
    }
}
