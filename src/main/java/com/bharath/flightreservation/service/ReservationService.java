package com.bharath.flightreservation.service;

import com.bharath.flightreservation.dto.ReservationRequest;
import com.bharath.flightreservation.entities.Reservation;

public interface ReservationService {

    public Reservation bookFlight(ReservationRequest request);
}
