package model;

public class Bookings {
    private String bookingId;
    private Customers customer;
    private Sceenings sceening;
    private Seats seat;

    public Bookings() {
    }

    public Bookings(String bookingId, Customers customer, Sceenings sceening, Seats seat) {
        this.bookingId = bookingId;
        this.customer = customer;
        this.sceening = sceening;
        this.seat = seat;
    }

    public String getBookingId() {
        return bookingId;
    }

    public void setBookingId(String bookingId) {
        this.bookingId = bookingId;
    }

    public Customers getCustomer() {
        return customer;
    }

    public void setCustomer(Customers customer) {
        this.customer = customer;
    }

    public Sceenings getSceening() {
        return sceening;
    }

    public void setSceening(Sceenings sceening) {
        this.sceening = sceening;
    }

    public Seats getSeat() {
        return seat;
    }

    public void setSeat(Seats seat) {
        this.seat = seat;
    }
}
