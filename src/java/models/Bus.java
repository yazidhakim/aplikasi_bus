/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

import java.sql.ResultSet;

public class Bus extends Model<Bus> {
    private int busID;          // Primary Key
    private String name;        // Nama bus
    private int kapasitas;      // Kapasitas bus
    private int tipeID;         // Foreign Key ke tipe_bus

    public Bus() {
        this.table = "bus";     // Nama tabel
        this.primaryKey = "busID"; // Nama primary key
    }

    @Override
    public Bus toModel(ResultSet rs) {
        try {
            Bus bus = new Bus();
            bus.setBusID(rs.getInt("busID"));
            bus.setName(rs.getString("name"));
            bus.setKapasitas(rs.getInt("kapasitas"));
            bus.setTipeID(rs.getInt("tipeID"));
            return bus;
        } catch (Exception e) {
            return null;
        }
    }

    // Getters and Setters
    public int getBusID() {
        return busID;
    }

    public void setBusID(int busID) {
        this.busID = busID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getKapasitas() {
        return kapasitas;
    }

    public void setKapasitas(int kapasitas) {
        this.kapasitas = kapasitas;
    }

    public int getTipeID() {
        return tipeID;
    }

    public void setTipeID(int tipeID) {
        this.tipeID = tipeID;
    }
}
