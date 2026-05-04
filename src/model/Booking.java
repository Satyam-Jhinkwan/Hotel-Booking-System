package model;

public class Booking extends Room {

    private String guestName;
    private int days;
    private double totalAmount;

    public Booking(int roomNumber, String roomType, double pricePerDay,
                   String guestName, int days) {

        super(roomNumber, roomType, pricePerDay);

        this.guestName = guestName;
        this.days = days;
        this.totalAmount = pricePerDay * days;
    }

    public String getGuestName() {
        return guestName;
    }

    public int getDays() {
        return days;
    }

    public double getTotalAmount() {
        return totalAmount;
    }
}