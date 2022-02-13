package net.tsekot.carparking.controller;

import net.tsekot.carparking.domain.Reservation;
import net.tsekot.carparking.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ReservationController {

    private ReservationService reservationService;

    @Autowired
    public ReservationController(ReservationService reservationService) {
        this.reservationService = reservationService;
    }

    @GetMapping(path = "/reservation")
    public List<Reservation> getAll(@RequestParam(required = false) String userId) {
        if (userId == null || userId.isEmpty()) {
            return reservationService.findAll();
        } else {
            return reservationService.findByUserId(userId);
        }
    }

    @PostMapping(path = "/reservation")
    public ReservationCreated reserveSpot(@RequestParam String userId,
                                          @RequestParam String spotId,
                                          @RequestParam String startTime) {
        //todo: add validation
        String reservationId = reservationService.reserveSpot(userId, spotId, startTime);

        return new ReservationCreated(reservationId);
    }

    @DeleteMapping(path = "/reservation/cancel")
    public ResponseEntity<HttpStatus> cancelReservation(@RequestParam String userId,
                                                        @RequestParam String reservationId) {

        if (userId != null && !userId.isEmpty() && reservationId != null && !reservationId.isEmpty()) {
            boolean res = reservationService.cancelReservation(userId, reservationId);
            return res ? ResponseEntity.status(HttpStatus.OK).build() : ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
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
