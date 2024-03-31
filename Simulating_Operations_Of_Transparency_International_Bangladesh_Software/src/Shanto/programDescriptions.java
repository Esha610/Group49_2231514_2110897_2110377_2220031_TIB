
package Shanto;

import java.util.HashMap;

public class programDescriptions {
    private HashMap<String, String> descriptions;

    public programDescriptions() {
        descriptions = new HashMap<>();
    }

    public void put(String programName, String programDescription) {
        descriptions.put(programName, programDescription);
    }

    public String getDescription(String programName) {
        return descriptions.get(programName);
    }

    public void clear() {
        descriptions.clear();
    }
}
