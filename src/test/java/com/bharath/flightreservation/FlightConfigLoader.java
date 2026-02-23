package com.bharath.flightreservation;

import com.bharath.flightreservation.entities.Flight;
import com.bharath.flightreservation.entities.Seat;
import com.bharath.flightreservation.repos.FlightRepository;
import com.bharath.flightreservation.repos.SeatRepository;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

@Slf4j
@SpringBootTest
public class FlightConfigLoader {

    @Autowired
    FlightRepository flightRepository;

    @Autowired
    SeatRepository seatRepository;

    @Test
    void loadFlightsConfig() {

        log.info("loading flights config...");

        Map<Integer, String> lettersMap = new HashMap<>();
        lettersMap.put(1, "A");
        lettersMap.put(2, "B");
        lettersMap.put(3, "C");
        lettersMap.put(4, "D");
        lettersMap.put(5, "E");
        lettersMap.put(6, "F");

        log.info("searching flights...");

        List<Flight> flights = flightRepository.findAll();

        flights.stream()
                .filter(flight -> flight.getSeats().isEmpty())
                .forEach(flight ->  {

                    log.info("flight found {}", flight.getFlightNumber());

                    IntStream.iterate(0, i -> i + 1)
                            .limit(17)
                            .forEach(index -> {
                                IntStream.iterate(0, i -> i + 1)
                                        .limit(6)
                                        .forEach(letter -> {
                                            String seatNumber = (index + 1) + lettersMap.get(letter + 1);
                                            Seat seat = new Seat(seatNumber, flight);

                                            log.info("seat created/saving {}...", seat.getSeatNumber());

                                            seatRepository.save(seat);
                                        });
                            });

                });

    }
}
