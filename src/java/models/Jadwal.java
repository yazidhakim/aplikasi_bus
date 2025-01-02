package models;

import java.sql.ResultSet;
import java.sql.Time;
import java.sql.Date;
import java.util.List;

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

    public List<Jadwal> getByFilters(String from, String to, String date, String busType) {
        String query = "SELECT j.jadwalID AS jadwal_id, j.waktu_keberangkatan, j.waktu_kedatangan, "
                + "j.harga_tiket, j.seatReady, city_asal.name AS city_asal, city_tujuan.name AS city_tujuan, "
                + "b.name AS bus_name, tipe_bus.tipe AS bus_type "
                + "FROM jadwal j "
                + "JOIN rute r ON j.ruteID = r.ruteID "
                + "JOIN city AS city_asal ON city_asal.id = r.asal "
                + "JOIN city AS city_tujuan ON city_tujuan.id = r.tujuan "
                + "JOIN bus b ON j.busID = b.busID "
                + "JOIN tipe_bus ON b.tipeID = tipe_bus.tipeID "
                + "WHERE city_asal.name = ? AND city_tujuan.name = ? AND j.tanggal = ? AND tipe_bus.tipe = ?";
    }
    
}
