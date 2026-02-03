package com.bharath.flightreservation.dto;

public record ReservationRequest(
        Long flightId,
        String firstName,
        String lastName,
        String email,
        String phone
) {
}
