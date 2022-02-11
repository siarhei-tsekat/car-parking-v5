package net.tsekot.carparking.service.impl;

import net.tsekot.carparking.domain.DomainException;
import net.tsekot.carparking.domain.Reservation;
import net.tsekot.carparking.domain.Spot;
import net.tsekot.carparking.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class ReservationServiceImpl implements ReservationService {

    private EntityManagerFactory entityManagerFactory;

    @Autowired
    public ReservationServiceImpl(EntityManagerFactory entityManagerFactory) {
        this.entityManagerFactory = entityManagerFactory;
    }

    public String reserveSpot(String userId, String spotId, String startTime) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();

        Spot spot = entityManager.find(Spot.class, Spot.idFromString(spotId));

        if (spot == null) {
            throw new DomainException("Spot with id: " + spotId + " wasn't found");
        }
        if (spot.getAvailable()) {
            spot.setAvailable(false);
            entityManager.persist(spot);
            String reservationId = UUID.randomUUID().toString();
            entityManager.persist(Reservation.buildReservation(reservationId, userId, spotId, startTime, startTime, "22.0")); //TODO: get rid of hardcoded price value

            entityManager.getTransaction().commit();
            return reservationId;
        } else {
            entityManager.getTransaction().rollback();
            throw new DomainException("Spot with id: " + spotId + " not available for the reservation.");
        }
    }

    public List<Reservation> findAll() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        return new ArrayList<>();
//        entityManager.find(Reservation.class, )
    }
}
