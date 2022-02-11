package net.tsekot.carparking.service.impl;

import net.tsekot.carparking.domain.Spot;
import net.tsekot.carparking.domain.SpotType;
import net.tsekot.carparking.service.SpotService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SpotServiceImpl implements SpotService {

    public List<Spot> findAll() {
        return new ArrayList<>();
    }

    public List<Spot> getBySpotType(SpotType type) {
        return new ArrayList<>();
    }
}
