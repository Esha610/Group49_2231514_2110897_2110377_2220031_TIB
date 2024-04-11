package Shanto;

import javafx.beans.property.SimpleStringProperty;

public class SocialEvent {
    private final SimpleStringProperty eventName;
    private final SimpleStringProperty eventTime;
    private final SimpleStringProperty eventDate;
    private final SimpleStringProperty eventLocation;

    public SocialEvent(String eventName, String eventTime, String eventDate, String eventLocation) {
        this.eventName = new SimpleStringProperty(eventName);
        this.eventTime = new SimpleStringProperty(eventTime);
        this.eventDate = new SimpleStringProperty(eventDate);
        this.eventLocation = new SimpleStringProperty(eventLocation);
    }

    public String getEventName() {
        return eventName.get();
    }

    public String getEventTime() {
        return eventTime.get();
    }

    public String getEventDate() {
        return eventDate.get();
    }

    public String getEventLocation() {
        return eventLocation.get();
    }
}
