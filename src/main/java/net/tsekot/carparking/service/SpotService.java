package net.tsekot.carparking.service;

import net.tsekot.carparking.domain.Spot;
import net.tsekot.carparking.domain.SpotType;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface SpotService {

    List<Spot> findAll();

     List<Spot> getBySpotType(SpotType type);
}
