package net.tsekot.carparking.service.impl;

import net.tsekot.carparking.domain.DomainException;
import net.tsekot.carparking.domain.Spot;
import net.tsekot.carparking.domain.SpotType;
import net.tsekot.carparking.service.SpotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;
import java.util.List;

@Service
public class SpotServiceImpl implements SpotService {

    private EntityManagerFactory entityManagerFactory;

    @Autowired
    public SpotServiceImpl(EntityManagerFactory entityManagerFactory) {
        this.entityManagerFactory = entityManagerFactory;
    }

    public List<Spot> findAll() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        String query = "select s from Spot s";
        return entityManager.createQuery(query, Spot.class).getResultList();
    }

    public List<Spot> getBySpotType(String type) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        String query = "select s from Spot s where s.spotType = :type";

        try {
            SpotType spotType = SpotType.fromString(type);

            TypedQuery<Spot> tQuery = entityManager.createQuery(query, Spot.class);
            tQuery.setParameter("type", spotType);
            return tQuery.getResultList();

        } catch (Exception e) {
            throw new DomainException(e);
        }
    }
}
