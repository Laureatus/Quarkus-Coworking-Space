package ch.zli.m223.model;

import java.time.LocalDateTime;

import javax.persistence.Entity;

@Entity
public class Booking {
    private Long id;
    private LocalDateTime bookedDate;
    private ApplicationUser user;
    private boolean wholeDay;
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
