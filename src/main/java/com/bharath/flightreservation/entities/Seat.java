package com.bharath.flightreservation.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Entity
@Table(name = "AIRPLANE_SEAT")
public class Seat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "spot")
    private String seatNumber;

    @Setter
    private boolean occupied;

    @ManyToOne
    private Flight flight;

    @Version
    private Integer version;

    public Seat(String seatNumber, Flight flight) {
        this.seatNumber = seatNumber;
        this.flight = flight;
    }
}
