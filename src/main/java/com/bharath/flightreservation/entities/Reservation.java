package com.bharath.flightreservation.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private boolean checkedIn;
    private int numberOfBags;

    @ManyToOne
    private Passenger passenger;

    @ManyToOne
    private Flight flight;

    public Reservation(Passenger passenger, Flight flight) {
        this.checkedIn = false;
        this.numberOfBags = 0;
        this.passenger = passenger;
        this.flight = flight;
    }
}
