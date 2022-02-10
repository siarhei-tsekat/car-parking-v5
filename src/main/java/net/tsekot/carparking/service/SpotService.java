package net.tsekot.carparking.service;

import net.tsekot.carparking.domain.Spot;
import net.tsekot.carparking.domain.SpotType;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SpotService {
    public List<Spot> findAll() {
        return new ArrayList<>();
    }

    public List<Spot> getBySpotType(SpotType type) {
        return new ArrayList<>();
    }
}
