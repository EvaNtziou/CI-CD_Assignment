package com.CICD.assignment;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ResourceDAO {

    private final SDB db = new SDB(); // Instance of SDB class

    // Fetch all resources from the database
    public List<Resource_Stock> getAllResources() {
        List<Resource_Stock> resources = new ArrayList<>();
        String sql = "SELECT * FROM resource_stock";

        try (Connection con = db.getConnection();
             Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                long id = rs.getLong("id");
                String name = rs.getString("name");
                int quantity = rs.getInt("quantity");

                resources.add(new Resource_Stock(id, name, quantity));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resources;
    }

    // Fetch resource by ID
    public Resource_Stock getResourceById(long id) {
        String sql = "SELECT * FROM resource_stock WHERE id = ?";
        Resource_Stock resource = null;

        try (Connection con = db.getConnection();
             PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setLong(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    String name = rs.getString("name");
                    int quantity = rs.getInt("quantity");
                    resource = new Resource_Stock(id, name, quantity);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resource;
    }

    // Create a new resource
    public int createResource(Resource_Stock resource) {
        String sql = "INSERT INTO resource_stock (name, quantity) VALUES (?, ?)";
        int rowsInserted = 0;

        try (Connection con = db.getConnection();
             PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setString(1, resource.getName());
            stmt.setInt(2, resource.getQuantity());
            rowsInserted = stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rowsInserted;
    }

    // Update an existing resource
    public int updateResource(long id, Resource_Stock resource) {
        String sql = "UPDATE resource_stock SET name = ?, quantity = ? WHERE id = ?";
        int rowsUpdated = 0;

        try (Connection con = db.getConnection();
             PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setString(1, resource.getName());
            stmt.setInt(2, resource.getQuantity());
            stmt.setLong(3, id);
            rowsUpdated = stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rowsUpdated;
    }

    // Delete a resource
    public void deleteResource(long id) {
        String sql = "DELETE FROM resource_stock WHERE id = ?";

        try (Connection con = db.getConnection();
             PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setLong(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
