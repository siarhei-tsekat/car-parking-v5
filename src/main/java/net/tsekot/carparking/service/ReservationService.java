package net.tsekot.carparking.service;

import net.tsekot.carparking.domain.Reservation;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ReservationService {

    String reserveSpot(String userId, String spotId, String startTime);

    List<Reservation> findAll();
}
