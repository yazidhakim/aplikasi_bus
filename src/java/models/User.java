package models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class User extends Model<User> {
    private int userID;
    private String username;
    private String email;
    private String password;

    public User() {
        this.table = "user";
        this.primaryKey = "userID";
    }

    public User(int userID, String username, String email, String password) {
        this.table = "user";
        this.primaryKey = "userID";
        this.userID = userID;
        this.username = username;
        this.email = email;
        this.password = password;
    }

    // Getters and Setters
    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    
    @Override
    public void insert() {
    try {
        // Memuat driver JDBC
        Class.forName("com.mysql.cj.jdbc.Driver"); // Untuk MySQL Connector/J 8.x
        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3307/aplikasi_bus", "root", "")) {
            String sql = "INSERT INTO user (userID, username, email, password) VALUES (?, ?, ?, ?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, this.userID); // Pastikan userID sudah diisi
            stmt.setString(2, this.username);
            stmt.setString(3, this.email);
            stmt.setString(4, this.password);
            stmt.executeUpdate();
            System.out.println("User  inserted successfully");
        }
    } catch (ClassNotFoundException e) {
        e.printStackTrace();
        System.out.println("Driver tidak ditemukan.");
    } catch (SQLException e) {
        e.printStackTrace();
    }
}
    @Override
    public User toModel(ResultSet rs) {
        try {
            return new User(
                rs.getInt("userID"),
                rs.getString("username"),
                rs.getString("email"),
                rs.getString("password")
            );
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public boolean validate() {
        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3307/aplikasi_bus", "root", "")) {
            String sql = "SELECT * FROM user WHERE username = ? AND password = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, this.username);
            stmt.setString(2, this.password);
            ResultSet rs = stmt.executeQuery();
            return rs.next();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
