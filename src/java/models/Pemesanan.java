package models;


public class Pemesanan {
    private int pemesananID;               // pemesanan_id (Primary Key)
    private int jadwalID;                  // jadwal_id (Foreign Key)
    private String userID;                 // user_id (Foreign Key)
    private int jumlah_tiket;               // jumlah_tiket
    private double total_harga;             // total_harga
    private String status_pemesanan;        // status_pemesanan
    private String tanggal_pemesanan;   // tanggal_pemesanan

    // Constructor
    public Pemesanan(int pemesananID, int jadwalID, String userID, int jumlahTiket, double totalHarga, String statusPemesanan, String tanggalPemesanan) {
        this.pemesananID = pemesananID;
        this.jadwalID = jadwalID;
        this.userID = userID;
        this.jumlah_tiket = jumlahTiket;
        this.total_harga = totalHarga;
        this.status_pemesanan = statusPemesanan;
        this.tanggal_pemesanan = tanggalPemesanan;
    }

    // Getter dan Setter
    public int getPemesananID() {
        return pemesananID;
    }

    public void setPemesananID(int pemesananID) {
        this.pemesananID = pemesananID;
    }

    public int getJadwalID() {
        return jadwalID;
    }

    public void setJadwalID(int jadwalId) {
        this.jadwalID = jadwalID;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userId) {
        this.userID = userID;
    }

    public int getJumlahTiket() {
        return jumlah_tiket;
    }

    public void setJumlahTiket(int jumlahTiket) {
        this.jumlah_tiket = jumlahTiket;
    }

    public double getTotalHarga() {
        return total_harga;
    }

    public void setTotalHarga(double totalHarga) {
        this.total_harga = totalHarga;
    }

    public String getStatusPemesanan() {
        return status_pemesanan;
    }

    public void setStatusPemesanan(String statusPemesanan) {
        this.status_pemesanan = statusPemesanan;
    }

    public String getTanggalPemesanan() {
        return tanggal_pemesanan;
    }

    public void setTanggalPemesanan(String tanggalPemesanan) {
        this.tanggal_pemesanan = tanggalPemesanan;
    }
}
