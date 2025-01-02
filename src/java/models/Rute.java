/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

import java.sql.ResultSet;

public class Rute extends Model<Rute> {
    private int ruteID;              // Primary Key
    private String asal;             // Lokasi keberangkatan
    private String tujuan;           // Lokasi tujuan
    private String estimasi_waktu;    // Estimasi waktu perjalanan

    public Rute() {
        this.table = "rute";         // Nama tabel
        this.primaryKey = "ruteID";  // Nama primary key
    }

    @Override
    public Rute toModel(ResultSet rs) {
        try {
            Rute rute = new Rute();
            rute.setRuteID(rs.getInt("ruteID"));
            rute.setAsal(rs.getString("asal"));
            rute.setTujuan(rs.getString("tujuan"));
            rute.setEstimasiWaktu(rs.getString("estimasi_waktu"));
            return rute;
        } catch (Exception e) {
            return null;
        }
    }

    // Getters and Setters
    public int getRuteID() {
        return ruteID;
    }

    public void setRuteID(int ruteID) {
        this.ruteID = ruteID;
    }

    public String getAsal() {
        return asal;
    }

    public void setAsal(String asal) {
        this.asal = asal;
    }

    public String getTujuan() {
        return tujuan;
    }

    public void setTujuan(String tujuan) {
        this.tujuan = tujuan;
    }

    public String getEstimasiWaktu() {
        return estimasi_waktu;
    }

    public void setEstimasiWaktu(String estimasi_waktu) {
        this.estimasi_waktu = estimasi_waktu;
    }
}
