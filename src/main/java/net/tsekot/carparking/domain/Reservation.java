package net.tsekot.carparking.domain;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Date;

@Entity
@Table(name = "reservations")
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "reservation_id")
    private String reservationId;

    @Column(name = "user_id")
    private String userId;

    @Column(name = "spot_id")
    private String spotId;

    @Column(name = "start_time")
    @Temporal(TemporalType.TIMESTAMP)
    private Date startTime;

    @Column(name = "end_time")
    @Temporal(TemporalType.TIMESTAMP)
    private Date endTime;

    @Column(name = "price")
    private BigDecimal price;

    public Reservation() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getReservationId() {
        return reservationId;
    }

    public void setReservationId(String reservationId) {
        this.reservationId = reservationId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getSpotId() {
        return spotId;
    }

    public void setSpotId(String spotId) {
        this.spotId = spotId;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
    //todo: add validation of passed parameters
    public static Reservation buildReservation(String reservationId, String userId, String spotId, String startTime, String endTime, String price) {
        Reservation r = new Reservation();
        r.setReservationId(reservationId);
        r.setUserId(userId);
        r.setSpotId(spotId);
        r.setStartTime(Date.from(LocalDateTime.parse(startTime).toInstant(ZoneOffset.UTC)));
        r.setEndTime(Date.from(LocalDateTime.parse(endTime).toInstant(ZoneOffset.UTC)));
        r.setPrice(new BigDecimal(price));
        return r;
    }
}
