package com.bharath.flightreservation.service;

import com.bharath.flightreservation.dto.ReservationRequest;
import com.bharath.flightreservation.entities.Flight;
import com.bharath.flightreservation.entities.Passenger;
import com.bharath.flightreservation.entities.Reservation;
import com.bharath.flightreservation.repos.FlightRepository;
import com.bharath.flightreservation.repos.PassengerRepository;
import com.bharath.flightreservation.repos.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReservationServiceImpl implements ReservationService {

    @Autowired
    FlightRepository flightRepository;

    @Autowired
    PassengerRepository passengerRepository;

    @Autowired
    ReservationRepository reservationRepository;

    @Override
    public Reservation bookFlight(ReservationRequest request) {

        Flight flight =  flightRepository.findById(request.flightId()).get();

        Passenger passenger = new Passenger(
                request.firstName(),
                request.lastName(),
                request.email(),
                request.phone()
        );

        Passenger savedPassenger = passengerRepository.save(passenger);

        Reservation reservation = new Reservation(savedPassenger, flight);

        Reservation savedReservation = reservationRepository.save(reservation);

        return savedReservation;
    }
}
