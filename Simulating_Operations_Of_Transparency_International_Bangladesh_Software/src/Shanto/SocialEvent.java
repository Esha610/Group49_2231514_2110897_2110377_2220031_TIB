package Shanto;

import java.io.IOException;
import java.io.Serializable;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class SocialEvent implements Serializable {
    private transient StringProperty eventName;
    private transient StringProperty eventTime;
    private transient StringProperty eventDate;
    private transient StringProperty eventLocation;

    public SocialEvent(String eventName, String eventTime, String eventDate, String eventLocation) {
        this.eventName = new SimpleStringProperty(eventName);
        this.eventTime = new SimpleStringProperty(eventTime);
        this.eventDate = new SimpleStringProperty(eventDate);
        this.eventLocation = new SimpleStringProperty(eventLocation);
    }

    private void writeObject(java.io.ObjectOutputStream out) throws IOException {
        out.defaultWriteObject();
        out.writeObject(eventName.get());
        out.writeObject(eventTime.get());
        out.writeObject(eventDate.get());
        out.writeObject(eventLocation.get());
    }

    private void readObject(java.io.ObjectInputStream in) throws IOException, ClassNotFoundException {
        in.defaultReadObject();
        eventName = new SimpleStringProperty((String) in.readObject());
        eventTime = new SimpleStringProperty((String) in.readObject());
        eventDate = new SimpleStringProperty((String) in.readObject());
        eventLocation = new SimpleStringProperty((String) in.readObject());
    }

    public StringProperty eventNameProperty() {
        return eventName;
    }

    public StringProperty eventTimeProperty() {
        return eventTime;
    }

    public StringProperty eventDateProperty() {
        return eventDate;
    }

    public StringProperty eventLocationProperty() {
        return eventLocation;
    }
}
