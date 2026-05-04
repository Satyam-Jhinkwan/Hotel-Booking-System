package gui;

import db.BookingDAO;
import model.Booking;

import javax.swing.*;
import java.awt.*;

public class BookingForm extends JFrame {

    JTextField nameField;
    JTextField roomField;
    JTextField daysField;

    JComboBox<String> roomTypeBox;

    JButton submitButton;

    public BookingForm() {

        setTitle("Room Booking Form");
        setSize(400, 350);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(5, 2, 10, 10));

        JLabel nameLabel = new JLabel("Guest Name:");
        JLabel roomLabel = new JLabel("Room Number:");
        JLabel typeLabel = new JLabel("Room Type:");
        JLabel daysLabel = new JLabel("Days:");

        nameField = new JTextField();
        roomField = new JTextField();
        daysField = new JTextField();

        String[] roomTypes = {"Standard", "Deluxe", "Suite"};
        roomTypeBox = new JComboBox<>(roomTypes);

        submitButton = new JButton("Book Now");

        add(nameLabel);
        add(nameField);

        add(roomLabel);
        add(roomField);

        add(typeLabel);
        add(roomTypeBox);

        add(daysLabel);
        add(daysField);

        add(new JLabel());
        add(submitButton);

        submitButton.addActionListener(e -> saveBooking());

        setVisible(true);
    }

    private void saveBooking() {

        try {

            String name = nameField.getText();
            int roomNo = Integer.parseInt(roomField.getText());
            int days = Integer.parseInt(daysField.getText());
            String roomType = roomTypeBox.getSelectedItem().toString();

            double price = 0;

            if (roomType.equals("Standard")) {
                price = 1000;
            } else if (roomType.equals("Deluxe")) {
                price = 2000;
            } else {
                price = 3000;
            }

            Booking booking = new Booking(roomNo, roomType, price, name, days);

            BookingDAO dao = new BookingDAO(booking);
            dao.addBooking();

            JOptionPane.showMessageDialog(this,
                    "Room Booked Successfully\nTotal Amount: " + booking.getTotalAmount());

            dispose();

        } catch (NumberFormatException e) {

            JOptionPane.showMessageDialog(this,
                    "Please enter valid numeric values");
        }
    }
}