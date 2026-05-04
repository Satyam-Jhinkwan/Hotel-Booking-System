package db;

import interfaces.Manageable;
import model.Booking;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BookingDAO implements Manageable {

    Booking booking;

    public BookingDAO() {
    }

    public BookingDAO(Booking booking) {
        this.booking = booking;
    }

    @Override
    public void addBooking() {

        try {
            Connection con = DBConnection.getConnection();
            String query = "INSERT INTO bookings(guest_name, room_number, room_type, days, total_amount) VALUES(?,?,?,?,?)";

            PreparedStatement ps = con.prepareStatement(query);

            ps.setString(1, booking.getGuestName());
            ps.setInt(2, booking.getRoomNumber());
            ps.setString(3, booking.getRoomType());
            ps.setInt(4, booking.getDays());
            ps.setDouble(5, booking.getTotalAmount());

            ps.executeUpdate();

            System.out.println("Booking Added Successfully");

            con.close();

        } catch (SQLException e) {
            System.out.println("Error while adding booking");
        }
    }

    @Override
    public void viewBookings() {

        try {
            Connection con = DBConnection.getConnection();
            
            String query = "SELECT * FROM bookings";

            PreparedStatement ps = con.prepareStatement(query);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                System.out.println("Booking ID: " + rs.getInt("id"));
                System.out.println("Guest Name: " + rs.getString("guest_name"));
                System.out.println("Room Number: " + rs.getInt("room_number"));
                System.out.println("Room Type: " + rs.getString("room_type"));
                System.out.println("Days: " + rs.getInt("days"));
                System.out.println("Total Amount: " + rs.getDouble("total_amount"));
                System.out.println("--------------------------");
            }

            con.close();

        } catch (SQLException e) {
            System.out.println("Error while fetching bookings");
        }
    }

     @Override
    public void cancelBooking(int id) {

        try {
            Connection con = DBConnection.getConnection();

            String query = "DELETE FROM bookings WHERE id=?";

            PreparedStatement ps = con.prepareStatement(query);

            ps.setInt(1, id);

            ps.executeUpdate();

            System.out.println("Booking Cancelled Successfully");

            con.close();

        } catch (SQLException e) {
            System.out.println("Error while cancelling booking");
        }
    }
}