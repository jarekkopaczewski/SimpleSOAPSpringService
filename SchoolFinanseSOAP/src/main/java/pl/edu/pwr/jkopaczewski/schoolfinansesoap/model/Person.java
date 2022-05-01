package pl.edu.pwr.jkopaczewski.schoolfinansesoap.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Setter
@Getter
@Entity
@Table(name = "people")
public class Person {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int personId;
    private String name;
    private String surname;

    public Person() {
    }

    public Person(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }
}