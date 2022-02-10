package net.tsekot.carparking.controller;

import net.tsekot.carparking.domain.Reservation;
import net.tsekot.carparking.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ReservationController {

    private ReservationService reservationService;

    @Autowired
    public ReservationController(ReservationService reservationService) {
        this.reservationService = reservationService;
    }

    @GetMapping(path = "/reservation")
    public List<Reservation> getAll() {
        return reservationService.findAll();
    }

    @PostMapping(path = "/reservation")
    public ReservationCreated reserveSpot(@RequestParam String userId,
                                          @RequestParam String spotId,
                                          @RequestParam String startTime) {

        String reservationId = reservationService.reserveSpot(userId, spotId, startTime);

        return new ReservationCreated(reservationId);
    }

    class ReservationCreated {
        private String reservationId;

        public ReservationCreated(String reservationId) {
            this.reservationId = reservationId;
        }

        public String getReservationId() {
            return reservationId;
        }

        public void setReservationId(String reservationId) {
            this.reservationId = reservationId;
        }
    }
}
