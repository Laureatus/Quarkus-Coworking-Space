package ch.zli.m223.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@Entity
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(readOnly = true)
    private Long id;

    @Column(nullable = false)
    private LocalDateTime bookedDate;

    @ManyToOne(optional = false)
    @Fetch(FetchMode.JOIN)
    private ApplicationUser user;

    @Column(nullable = false)
    private boolean wholeDay;

    @Column(nullable = false)
    private boolean halfDay;

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public LocalDateTime getBookedDate() {
        return bookedDate;
    }
    public void setBookedDate(LocalDateTime bookedDate) {
        this.bookedDate = bookedDate;
    }
    public ApplicationUser getUser() {
        return user;
    }
    public void setUser(ApplicationUser user) {
        this.user = user;
    }
    public boolean isWholeDay() {
        return wholeDay;
    }
    public void setWholeDay(boolean wholeDay) {
        this.wholeDay = wholeDay;
    }
    public boolean isHalfDay() {
        return halfDay;
    }
    public void setHalfDay(boolean halfDay) {
        this.halfDay = halfDay;
    }
}
