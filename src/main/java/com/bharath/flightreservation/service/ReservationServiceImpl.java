package com.bharath.flightreservation.service;

import com.bharath.flightreservation.dto.ReservationRequest;
import com.bharath.flightreservation.entities.Flight;
import com.bharath.flightreservation.entities.Passenger;
import com.bharath.flightreservation.entities.Reservation;
import com.bharath.flightreservation.entities.Seat;
import com.bharath.flightreservation.repos.FlightRepository;
import com.bharath.flightreservation.repos.PassengerRepository;
import com.bharath.flightreservation.repos.ReservationRepository;
import com.bharath.flightreservation.repos.SeatRepository;
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

    @Autowired
    SeatRepository seatRepository;

    @Override
    public synchronized Reservation bookFlight(ReservationRequest request) {

        Flight flight =  flightRepository.findById(request.flightId()).get();

        Passenger passenger = new Passenger(
                request.firstName(),
                request.lastName(),
                request.email(),
                request.phone()
        );

        Passenger savedPassenger = passengerRepository.save(passenger);

        Seat seat = flight.getSeats()
                .stream()
                .filter(s -> s.getSeatNumber().equals(request.seatNumber()) && !s.isOccupied())
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Seat not found/unavailable"));

        seat.setOccupied(true);

        //seatRepository.f

        Seat savedSeat = seatRepository.save(seat);

        Reservation reservation = new Reservation(savedPassenger, flight, seat);

        return reservationRepository.save(reservation);
    }
}
