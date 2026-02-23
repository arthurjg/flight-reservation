package com.bharath.flightreservation.dto;

import lombok.Builder;

@Builder
public record ReservationRequest(
        Long flightId,
        String firstName,
        String lastName,
        String email,
        String phone,
        String seatNumber
) {
}
