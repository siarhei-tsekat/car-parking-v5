package net.tsekot.carparking.controller;

import net.tsekot.carparking.domain.Spot;
import net.tsekot.carparking.service.SpotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SpotController {

    private SpotService spotService;

    @Autowired
    public SpotController(SpotService spotService) {
        this.spotService = spotService;
    }

    @GetMapping(path = "/spot")
    public List<Spot> getSpotByType(@RequestParam(required = false, name = "spotType") String spotType) {

        if (spotType == null || spotType.isEmpty()) {
            return spotService.findAll();
        }
        return spotService.getBySpotType(spotType);
    }
}
