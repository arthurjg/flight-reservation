package com.bharath.flightreservation.service;

import com.bharath.flightreservation.dto.ReservationRequest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ReservationServiceImplLoadTest {

    @Autowired
    ReservationServiceImpl reservationService;

    @Test
    void bookFlightLoadTest() throws InterruptedException {

        ReservationRequest request = ReservationRequest.builder()
                .flightId(1L)
                .firstName("John")
                .lastName("Lock")
                .email("jonhlocke@gmail.com")
                .phone("977556622")
                .seatNumber("10A")
                .build();

        /*for(int index = 0; index < 5; index++){
            reservationService.bookFlight(request);
        }*/

        Thread thread1 = new Thread(() -> {
            reservationService.bookFlight(request);
        });

        Thread thread2 = new Thread(() -> {
            reservationService.bookFlight(request);
        });

        Thread thread3 = new Thread(() -> {
            reservationService.bookFlight(request);
        });

        Thread thread4 = new Thread(() -> {
            reservationService.bookFlight(request);
        });

        Thread thread5 = new Thread(() -> {
            reservationService.bookFlight(request);
        });

        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
        thread5.start();

        Thread.sleep(5000);

    }

}