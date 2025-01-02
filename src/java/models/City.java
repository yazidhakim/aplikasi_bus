package models;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
public class City extends Model<City> {
    private int id;            // ID kota
    private int provinceId;    // ID provinsi
    private String name;       // Nama kota
    
    public City() {
        this.table = "city";         // Nama tabel
        this.primaryKey = "id";  // Nama primary key
    }
    // Constructor
    public City(int id, int provinceId, String name) {
        this.id = id;
        this.provinceId = provinceId;
        this.name = name;
    }

    // Getter dan Setter
    public int getkotaId() {
        return id;
    }

    public void setkotaId(int id) {
        this.id = id;
    }

    public int getProvinceId() {
        return provinceId;
    }

    public void setProvinceId(int provinceId) {
        this.provinceId = provinceId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    @Override
    public City toModel(ResultSet rs) {
        try {
            City city = new City();
            city.setkotaId(rs.getInt("id"));
            city.setProvinceId(rs.getInt("province_id"));
            city.setName(rs.getString("name"));
            return city;
        } catch (Exception e) {
            return null;
        }
    }
}
