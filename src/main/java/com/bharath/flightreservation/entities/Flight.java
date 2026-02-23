package com.bharath.flightreservation.entities;

import jakarta.persistence.*;
import lombok.Getter;

import java.util.Date;
import java.util.List;

@Getter
@Entity
public class Flight {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String flightNumber;
    private String operatingAirlines;
    private String departureCity;
    private String arrivalCity;
    private Date dateOfDeparture;
    private String estimatedDepartureTime;
    private Integer capacity;

    @OneToMany(mappedBy = "flight", fetch = FetchType.EAGER)
    private List<Seat> seats;

    public List<Seat> availableSeats() {
        return seats
                .stream()
                .filter(s -> !s.isOccupied())
                .toList();
    }

}
