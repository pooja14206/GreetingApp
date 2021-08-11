package com.org.model;

import lombok.Data;
import lombok.Generated;
import org.hibernate.Incubating;

import javax.persistence.*;

@Data
@Entity
@Table(name = "GREETINGS")
public class Greeting {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private final long id;
    private String message;

    public Greeting(){
        id = 0;
        message = "";
    }
    public Greeting(long id, String message) {
        this.id = id;
        this.message = message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}