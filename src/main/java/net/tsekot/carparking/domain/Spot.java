package net.tsekot.carparking.domain;

import sun.rmi.runtime.Log;

import javax.persistence.*;

@Entity
@Table(name = "spots")
public class Spot {

    @Id
    private long id;

    @Column(name = "spot_id")
    private String spotId;

    @Column(name = "spot_type")
    @Enumerated(EnumType.ORDINAL)
    private SpotType spotType;

    @Column(name = "available", columnDefinition = "INT(1)")
    private Boolean available;


    public Spot() {
    }

    public static Long idFromString(String spotId) {
        return Long.valueOf(spotId);
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getSpotId() {
        return spotId;
    }

    public void setSpotId(String spotId) {
        this.spotId = spotId;
    }

    public SpotType getSpotType() {
        return spotType;
    }

    public void setSpotType(SpotType spotType) {
        this.spotType = spotType;
    }

    public Boolean getAvailable() {
        return available;
    }

    public void setAvailable(Boolean available) {
        this.available = available;
    }
}
