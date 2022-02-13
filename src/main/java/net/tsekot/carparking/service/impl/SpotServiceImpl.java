package net.tsekot.carparking.service.impl;

import net.tsekot.carparking.domain.Spot;
import net.tsekot.carparking.domain.SpotType;
import net.tsekot.carparking.service.SpotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.ArrayList;
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
//        entityManager.find()
        return new ArrayList<>();
    }

    public List<Spot> getBySpotType(SpotType type) {
        return new ArrayList<>();
    }
}
