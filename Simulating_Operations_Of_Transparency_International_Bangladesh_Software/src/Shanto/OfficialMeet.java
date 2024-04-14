package Shanto;

import java.io.IOException;
import java.io.Serializable;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class OfficialMeet implements Serializable {
    private transient StringProperty title;
    private transient StringProperty time;
    private transient StringProperty date;
    private transient StringProperty location;

    public OfficialMeet(String title, String time, String date, String location) {
        this.title = new SimpleStringProperty(title);
        this.time = new SimpleStringProperty(time);
        this.date = new SimpleStringProperty(date);
        this.location = new SimpleStringProperty(location);
    }


    private void writeObject(java.io.ObjectOutputStream out) throws IOException {
        out.defaultWriteObject();
        out.writeObject(title.get());
        out.writeObject(time.get());
        out.writeObject(date.get());
        out.writeObject(location.get());
    }

    private void readObject(java.io.ObjectInputStream in) throws IOException, ClassNotFoundException {
        in.defaultReadObject();
        title = new SimpleStringProperty((String) in.readObject());
        time = new SimpleStringProperty((String) in.readObject());
        date = new SimpleStringProperty((String) in.readObject());
        location = new SimpleStringProperty((String) in.readObject());
    }

    public StringProperty titleProperty() {
        return title;
    }

    public StringProperty timeProperty() {
        return time;
    }

    public StringProperty dateProperty() {
        return date;
    }

    public StringProperty locationProperty() {
        return location;
    }
}
