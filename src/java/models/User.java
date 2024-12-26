/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;
import java.sql.SQLException;
import java.sql.ResultSet;
/**
 * @author Nitro 5
 */
public class User extends Model<User> {
    private String userID;
    private String username;
    private String email;
    private String password;
    private Role role;
    
    public enum Role {
        ADMIN, CUSTOMER
    }
    public User() {
        this.table = "user";  // Nama tabel di database
        this.primaryKey = "userID";  // Nama primary key
    }
     public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
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
    public Role getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = Role.valueOf(role.toUpperCase()); // Pastikan role yang diterima valid (ADMIN atau CUSTOMER)
    }
    public boolean validate(){
        return true;
    }
    @Override
    public User toModel(ResultSet rs) {
        User user = new User();
        try {
            user.setUserID(rs.getString("userID"));
            user.setUsername(rs.getString("username"));
            user.setEmail(rs.getString("email"));
            user.setPassword(rs.getString("password"));
            user.setRole(rs.getString("role"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return user;
    }
}
