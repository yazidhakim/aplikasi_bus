package models;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public abstract class Model<E> {

    private Connection con;
    private Statement stmt;
    private boolean isConnected;
    private String message;
    protected String table;
    protected String primaryKey;
    protected String select = "*";
    private String where = "";
    private String join = "";
    private String otherQuery = "";

    private void connect() {
        String db_name = "aplikasi_bus";
        String username = "root";
        String password = "";
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3307/" + db_name, username, password);
            stmt = con.createStatement();
            isConnected = true;
            message = "Database Terkoneksi";
        } catch (Exception e) {
            isConnected = false;
            message = e.getMessage();
        }
    }

    private void disconnect() {
        try {
            stmt.close();
            con.close();
        } catch (Exception e) {
            message = e.getMessage();
        }
    }

    public void insert() {
        try {
            connect();
            String cols = "", values = "";
            for (Field field : this.getClass().getDeclaredFields()) {
                field.setAccessible(true);
                Object value = field.get(this);
                if (value != null) {
                    cols += field.getName() + ", ";
                    values += "'" + value + "', ";
                }
            }
            // Hilangkan tanda koma terakhir
            cols = cols.substring(0, cols.length() - 2);
            values = values.substring(0, values.length() - 2);
            String query = "INSERT INTO " + table + "(" + cols + ") VALUES (" + values + ")";
            stmt.executeUpdate(query);
            message = "Insert successful";
        } catch (Exception e) {
            message = e.getMessage();
        } finally {
            disconnect();
        }
    }

    public void update() {
        try {
            connect();
            String values = "";
            Object pkValue = 0;
            for (Field field : this.getClass().getDeclaredFields()) {
                field.setAccessible(true);
                Object value = field.get(this);
                if (field.getName().equals(primaryKey)) {
                    pkValue = value;
                } else if (value != null) {
                    values += field.getName() + " = '" + value + "', ";
                }
            }
            String query = "UPDATE " + table + " SET " + values.substring(0, values.length() - 2)
                    + " WHERE " + primaryKey + " = '" + pkValue + "'";
            stmt.executeUpdate(query);
            message = "Update successful";
        } catch (Exception e) {
            message = e.getMessage();
        } finally {
            disconnect();
        }
    }

    public void delete() {
        try {
            connect();
            Object pkValue = 0;
            for (Field field : this.getClass().getDeclaredFields()) {
                field.setAccessible(true);
                if (field.getName().equals(primaryKey)) {
                    pkValue = field.get(this);
                    break;
                }
            }
            String query = "DELETE FROM " + table + " WHERE " + primaryKey + " = '" + pkValue + "'";
            stmt.executeUpdate(query);
            message = "Delete successful";
        } catch (Exception e) {
            message = e.getMessage();
        } finally {
            disconnect();
        }
    }

    public ArrayList<E> get() {
        ArrayList<E> res = new ArrayList<>();
        try {
            connect();
            String query = "SELECT " + select + " FROM " + table;
            if (!join.equals("")) query += join;
            if (!where.equals("")) query += " WHERE " + where;
            if (!otherQuery.equals("")) query += " " + otherQuery;
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                res.add(toModel(rs));
            }
        } catch (Exception e) {
            message = e.getMessage();
        } finally {
            disconnect();
        }
        return res;
    }

    public abstract E toModel(ResultSet rs);

    // Getters and Setters
    public boolean isConnected() {
        return isConnected;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void select(String cols) {
        select = cols;
    }

    public void join(String table, String on) {
        join += " JOIN " + table + " ON " + on;
    }

    public void where(String cond) {
        where = cond;
    }

    public void addQuery(String query) {
        otherQuery = query;
    }
}
