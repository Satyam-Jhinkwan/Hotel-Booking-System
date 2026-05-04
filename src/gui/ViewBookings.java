package gui;

import db.DBConnection;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ViewBookings extends JFrame {

    JTable table;
    DefaultTableModel model;

    public ViewBookings() {

        setTitle("All Bookings");
        setSize(700, 400);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        String[] columns = {
                "ID",
                "Guest Name",
                "Room No",
                "Room Type",
                "Days",
                "Total Amount"
        };

        model = new DefaultTableModel(columns, 0);

        table = new JTable(model);

        JScrollPane pane = new JScrollPane(table);

        add(pane, BorderLayout.CENTER);

        loadBookings();

        setVisible(true);
    }

    private void loadBookings() {

        try {

            Connection con = DBConnection.getConnection();

            String query = "SELECT * FROM bookings";

            PreparedStatement ps = con.prepareStatement(query);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                Object[] row = {
                        rs.getInt("id"),
                        rs.getString("guest_name"),
                        rs.getInt("room_number"),
                        rs.getString("room_type"),
                        rs.getInt("days"),
                        rs.getDouble("total_amount")
                };

                model.addRow(row);
            }

            con.close();

        } catch (Exception e) {

            JOptionPane.showMessageDialog(this,
                    "Error loading bookings");
        }
    }
}