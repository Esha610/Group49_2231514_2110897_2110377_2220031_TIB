package Esha;

import java.io.Serializable;

public class RequestingMentorshipData implements Serializable {
    private String selectedGoal;
    private String selectedSkill;
    private String selectedField;
    private String extraDescription;

    // Constructor
    public RequestingMentorshipData(String selectedGoal, String selectedSkill, String selectedField, String extraDescription) {
        this.selectedGoal = selectedGoal;
        this.selectedSkill = selectedSkill;
        this.selectedField = selectedField;
        this.extraDescription = extraDescription;
    }

    
    
    
    public String getSelectedGoal() {
        return selectedGoal;
    }

    public void setSelectedGoal(String selectedGoal) {
        this.selectedGoal = selectedGoal;
    }

    public String getSelectedSkill() {
        return selectedSkill;
    }

    public void setSelectedSkill(String selectedSkill) {
        this.selectedSkill = selectedSkill;
    }

    public String getSelectedField() {
        return selectedField;
    }

    public void setSelectedField(String selectedField) {
        this.selectedField = selectedField;
    }

    public String getExtraDescription() {
        return extraDescription;
    }

    public void setExtraDescription(String extraDescription) {
        this.extraDescription = extraDescription;
    }
}
