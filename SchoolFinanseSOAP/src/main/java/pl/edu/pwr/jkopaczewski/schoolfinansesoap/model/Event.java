package pl.edu.pwr.jkopaczewski.schoolfinansesoap.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Setter
@Getter
@Entity
@Table(name = "events")
public class Event {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int eventId;
    private String name;
    private String place;
    private String date;

    public Event(String name, String place, String date) {
        this.name = name;
        this.place = place;
        this.date = date;
    }

    public Event() {
    }
}

