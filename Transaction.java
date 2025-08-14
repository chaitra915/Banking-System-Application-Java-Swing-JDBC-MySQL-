package bankwith;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Transaction {
    private int userId;
    private String type;
    private String category;
    private double amount;

    public Transaction(int userId, String type, String category, double amount) {
        this.userId = userId;
        this.type = type;
        this.category = category;
        this.amount = amount;
    }

    // Save transaction to database
    public boolean save() {
        try (Connection conn = DBConnection.getConnection()) {
            String sql = "INSERT INTO transactions(user_id, type, category, amount) VALUES (?, ?, ?, ?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, userId);
            ps.setString(2, type);
            ps.setString(3, category);
            ps.setDouble(4, amount);
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Get transactions for a user
    public static List<Transaction> getTransactions(int userId) {
        List<Transaction> list = new ArrayList<>();
        try (Connection conn = DBConnection.getConnection()) {
            String sql = "SELECT * FROM transactions WHERE user_id=? ORDER BY date DESC";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, userId);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Transaction t = new Transaction(
                        rs.getInt("user_id"),
                        rs.getString("type"),
                        rs.getString("category"),
                        rs.getDouble("amount")
                );
                list.add(t);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    // Getters
    public String getType() { return type; }
    public String getCategory() { return category; }
    public double getAmount() { return amount; }
}
