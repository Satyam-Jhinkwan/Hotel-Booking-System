package gui;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {

    JButton addButton;
    JButton viewButton;
    JLabel titleLabel;

    public MainFrame() {

        setTitle("Hotel Booking System");
        setSize(500, 350);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();

        panel.setLayout(new GridLayout(3, 1, 15, 15));
        panel.setBorder(BorderFactory.createEmptyBorder(30, 40, 30, 40));

        titleLabel = new JLabel("Hotel Room Booking System", JLabel.CENTER);

        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));

        addButton = new JButton("Book Room");
        viewButton = new JButton("View Bookings");

        addButton.setFont(new Font("Arial", Font.PLAIN, 18));
        viewButton.setFont(new Font("Arial", Font.PLAIN, 18));

        panel.add(titleLabel);
        panel.add(addButton);
        panel.add(viewButton);

        add(panel);

        addButton.addActionListener(e -> new BookingForm());

        viewButton.addActionListener(e -> new ViewBookings());

        setVisible(true);
    }
}