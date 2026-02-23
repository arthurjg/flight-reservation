package com.bharath.flightreservation.entities;

import jakarta.persistence.*;
import lombok.Getter;
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

    @ManyToOne
    private Seat seat;

    public Reservation(Passenger passenger, Flight flight, Seat seat) {
        this.checkedIn = false;
        this.numberOfBags = 0;
        this.passenger = passenger;
        this.flight = flight;
        this.seat = seat;
    }
}
