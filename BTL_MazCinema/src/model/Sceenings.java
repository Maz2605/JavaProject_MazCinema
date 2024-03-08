package model;

import java.util.Date;

public class Sceenings {
    private String sceeningId;
    private Movies movie;
    private Rooms room;
    private Date sceeningTime;

    public Sceenings() {
        room = new Rooms();
        movie = new Movies();
    }

    public Sceenings(String sceeningId, Movies movie, Rooms room, Date sceeningTime) {
        this.room = new Rooms();
        this.movie =new Movies();
        this.sceeningId = sceeningId;
        this.movie = movie;
        this.room = room;
        this.sceeningTime = sceeningTime;
    }

    public String getSceeningId() {
        return sceeningId;
    }

    public void setSceeningId(String sceeningId) {
        this.sceeningId = sceeningId;
    }

    public Movies getMovie() {
        return movie;
    }

    public void setMovie(Movies movie) {
        this.movie = movie;
    }

    public Rooms getRoom() {
        return room;
    }

    public void setRoom(Rooms room) {
        this.room = room;
    }

    public Date getSceeningTime() {
        return sceeningTime;
    }

    public void setSceeningTime(Date sceeningTime) {
        this.sceeningTime = sceeningTime;
    }
}
