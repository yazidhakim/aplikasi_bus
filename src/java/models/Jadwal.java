package models;

import java.sql.ResultSet;
import java.sql.Time;
import java.sql.Date;

public class Jadwal extends Model<Jadwal> {
    private int jadwalID;          // Primary Key
    private int ruteID;            // Foreign Key
    private int busID;             // Foreign Key
    private Date tanggal;          // Tanggal keberangkatan
    private Time waktu_keberangkatan; // Waktu keberangkatan
    private Time waktu_kedatangan; // Waktu kedatangan
    private double harga_tiket;      // Harga tiket

    public Jadwal() {
        this.table = "jadwal";     // Nama tabel
        this.primaryKey = "jadwalID"; // Nama primary key
    }
    public Jadwal(int jadwalID, int ruteID, int busID, Date tanggal, Time waktu_keberangkatan, Time waktu_kedatangan, double harga_tiket) {
        this.table = "user";
        this.primaryKey = "userID";
        this.jadwalID = jadwalID;
        this.ruteID = ruteID;
        this.busID = busID;
        this.tanggal = tanggal;
        this.waktu_keberangkatan = waktu_keberangkatan;
        this.waktu_kedatangan = waktu_kedatangan;
        this.harga_tiket = harga_tiket;
    }


    @Override
    public Jadwal toModel(ResultSet rs) {
        try {
            Jadwal jadwal = new Jadwal();
            jadwal.setJadwalID(rs.getInt("jadwalID"));
            jadwal.setRuteID(rs.getInt("ruteID"));
            jadwal.setBusID(rs.getInt("busID"));
            jadwal.setTanggal(rs.getDate("tanggal")); // Mengambil tanggal
            jadwal.setWaktuKeberangkatan(rs.getTime("waktu_keberangkatan")); // Mengambil waktu keberangkatan
            jadwal.setWaktuKedatangan(rs.getTime("waktu_kedatangan")); // Mengambil waktu kedatangan
            jadwal.setHargaTiket(rs.getDouble("harga_tiket")); // Mengambil harga tiket
            return jadwal;
        } catch (Exception e) {
            return null;
        }
    }

    // Getters and Setters
    public int getJadwalID() {
        return jadwalID;
    }

    public void setJadwalID(int jadwalID) {
        this.jadwalID = jadwalID;
    }

    public int getRuteID() {
        return ruteID;
    }

    public void setRuteID(int ruteID) {
        this.ruteID = ruteID;
    }

    public int getBusID() {
        return busID;
    }

    public void setBusID(int busID) {
        this.busID = busID;
    }

    public Date getTanggal() {
        return tanggal;
    }

    public void setTanggal(Date tanggal) {
        this.tanggal = tanggal;
    }

    public Time getWaktuKeberangkatan() {
        return waktu_keberangkatan;
    }

    public void setWaktuKeberangkatan(Time waktu_keberangkatan) {
        this.waktu_keberangkatan = waktu_keberangkatan;
    }

    public Time getWaktuKedatangan() {
        return waktu_kedatangan;
    }

    public void setWaktuKedatangan(Time waktu_kedatangan) {
        this.waktu_kedatangan = waktu_kedatangan;
    }

    public double getHargaTiket() {
        return harga_tiket;
    }

    public void setHargaTiket(double harga_tiket) {
        this.harga_tiket = harga_tiket;
    }
}
