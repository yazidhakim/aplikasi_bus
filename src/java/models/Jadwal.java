package models;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Jadwal extends Model<Jadwal> {
    private int jadwalID;          // Primary Key
    private int ruteID;            // Foreign Key
    private int busID;             // Foreign Key
    private Date tanggal;          // Tanggal keberangkatan
    private Time waktu_keberangkatan; // Waktu keberangkatan
    private Time waktu_kedatangan; // Waktu kedatangan
    private double harga_tiket;    // Harga tiket
    private String cityAsal;       // City asal
    private String cityTujuan;     // City tujuan
    private String busName;        // Bus name
    private String busType;        // Bus type

    public Jadwal() {
        this.table = "jadwal";     // Nama tabel
        this.primaryKey = "jadwalID"; // Nama primary key
    }

    public Jadwal(int jadwalID, int ruteID, int busID, Date tanggal, Time waktu_keberangkatan, Time waktu_kedatangan, double harga_tiket) {
        this.table = "jadwal";
        this.primaryKey = "jadwalID";
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
            jadwal.setJadwalID(rs.getInt("jadwal_id"));
            jadwal.setRuteID(rs.getInt("rute_id")); // Pastikan ini sesuai dengan alias di query
            jadwal.setBusID(rs.getInt("busID")); // Pastikan kolom ini juga dipilih dalam query
            jadwal.setTanggal(rs.getDate("tanggal"));
            jadwal.setWaktuKeberangkatan(rs.getTime("waktu_keberangkatan"));
            jadwal.setWaktuKedatangan(rs.getTime("waktu_kedatangan"));
            jadwal.setHargaTiket(rs.getDouble("harga_tiket"));
            jadwal.setCityAsal(rs.getString("city_asal"));
            jadwal.setCityTujuan(rs.getString("city_tujuan"));
            jadwal.setBusName(rs.getString("bus_name"));
            jadwal.setBusType(rs.getString("bus_type"));
            return jadwal;
        } catch (SQLException e) {
            e.printStackTrace();
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

    public String getCityAsal() {
        return cityAsal;
    }

    public void setCityAsal(String cityAsal) {
        this.cityAsal = cityAsal;
    }

    public String getCityTujuan() {
        return cityTujuan;
    }

    public void setCityTujuan(String cityTujuan) {
        this.cityTujuan = cityTujuan;
    }

    public String getBusName() {
        return busName;
    }

    public void setBusName(String busName) {
        this.busName = busName;
    }

    public String getBusType() {
        return busType;
    }

    public void setBusType(String busType) {
        this.busType = busType;
    }

    // This method fetches filtered schedules based on parameters.
   public List<Jadwal> getByFilters(String from, String to, String date, String busType) {
        List<Jadwal> jadwalList = new ArrayList<>();
        String query = "SELECT j.jadwalID AS jadwal_id, j.ruteID AS rute_id, j.busID, j.tanggal, j.waktu_keberangkatan, "
                + "j.waktu_kedatangan, j.harga_tiket, city_asal.name AS city_asal, city_tujuan.name AS city_tujuan, "
                + "b.name AS bus_name, tipe_bus.tipe AS bus_type "
                + "FROM jadwal j "
                + "JOIN rute r ON j.ruteID = r.ruteID "
                + "JOIN city AS city_asal ON city_asal.id = r.asal "
                + "JOIN city AS city_tujuan ON city_tujuan.id = r.tujuan "
                + "JOIN bus b ON j.busID = b.busID "
                + "JOIN tipe_bus ON b.tipeID = tipe_bus.tipeID "
                + "WHERE city_asal.name = ? AND city_tujuan.name = ? AND j.tanggal = ? AND tipe_bus.tipe = ?";

        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3307/aplikasi_bus", "root", "");
             PreparedStatement stmt = conn.prepareStatement(query)) {

            // Log parameter yang digunakan untuk pencarian
            System.out.println("Searching with parameters: from=" + from + ", to=" + to + ", date=" + date + ", busType=" + busType);

            stmt.setString(1, from);
            stmt.setString(2, to);
            stmt.setString(3, date);
            stmt.setString(4, busType);

            ResultSet rs = stmt.executeQuery();
            if (!rs.isBeforeFirst()) { // Jika tidak ada hasil
                System.out.println("No results found for the given parameters.");
            }

            while (rs.next()) {
                Jadwal jadwal = toModel(rs);
                jadwalList.add(jadwal);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return jadwalList;
    }

    @Override
    public String toString() {
        return 
                "jadwalID=" + jadwalID +
                ", ruteID=" + ruteID +
                ", busID=" + busID +
                ", tanggal=" + tanggal +
                ", waktu_keberangkatan=" + waktu_keberangkatan +
                ", waktu_kedatangan=" + waktu_kedatangan +
                ", harga_tiket=" + harga_tiket +
                ", cityAsal='" + cityAsal + '\'' +
                ", cityTujuan='" + cityTujuan + '\'' +
                ", busName='" + busName + '\'' +
                ", busType='" + busType + '\'' ;
    }
}