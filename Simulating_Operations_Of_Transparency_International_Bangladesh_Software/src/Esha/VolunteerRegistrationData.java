package Esha;

import java.io.Serializable;

public class VolunteerRegistrationData implements Serializable {
    private String campaignArea;
    private String timing;
    private String activity;
    private String additionalInfo;

    public VolunteerRegistrationData(String campaignArea, String timing, String activity, String additionalInfo) {
        this.campaignArea = campaignArea;
        this.timing = timing;
        this.activity = activity;
        this.additionalInfo = additionalInfo;
    }

    // Getters and setters
    public String getCampaignArea() {
        return campaignArea;
    }

    public void setCampaignArea(String campaignArea) {
        this.campaignArea = campaignArea;
    }

    public String getTiming() {
        return timing;
    }

    public void setTiming(String timing) {
        this.timing = timing;
    }

    public String getActivity() {
        return activity;
    }

    public void setActivity(String activity) {
        this.activity = activity;
    }

    public String getAdditionalInfo() {
        return additionalInfo;
    }

    public void setAdditionalInfo(String additionalInfo) {
        this.additionalInfo = additionalInfo;
    }
}
