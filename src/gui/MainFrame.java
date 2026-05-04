package gui;
import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {

    JButton addButton;
    JButton viewButton;

    public MainFrame() {

        setTitle("Hotel Booking System");
        setSize(400, 250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        addButton = new JButton("Book Room");
        viewButton = new JButton("View Bookings");

        setLayout(new GridLayout(2, 1, 20, 20));

        add(addButton);
        add(viewButton);

        addButton.addActionListener(e -> new BookingForm());

        viewButton.addActionListener(e -> new ViewBookings());

        setVisible(true);
    }
}