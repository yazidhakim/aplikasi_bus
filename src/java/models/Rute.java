/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

/**
 *
 * @author Nitro 5
 */
public class Rute {
    private int ruteID; //buat rute_ID
    private String bus; // tipe bus
    private String kotaAsal; //berangkat dari kota apa
    private String kotaAkhir; //sampai tujuan di kota apa
    private String pemberhentian; //berhenti daerah mana

 
    public Rute() {
    }

    public Rute(int ruteID, String bus, String kotaAsal, String kotaAkhir, String pemberhentian) {
        this.ruteID = ruteID;
        this.bus = bus;
        this.kotaAsal = kotaAsal;
        this.kotaAkhir = kotaAkhir;
        this.pemberhentian = pemberhentian;
    }

    public int getRuteID() {
        return ruteID;
    }

    public void setRuteID(int ruteID) {
        this.ruteID = ruteID;
    }

    public String getBus() {
        return bus;
    }

    public void setBus(String bus) {
        this.bus = bus;
    }

    public String getKotaAsal() {
        return kotaAsal;
    }

    public void setKotaAsal(String kotaAsal) {
        this.kotaAsal = kotaAsal;
    }

    public String getKotaAkhir() {
        return kotaAkhir;
    }

    public void setKotaAkhir(String kotaAkhir) {
        this.kotaAkhir = kotaAkhir;
    }

    public String getPemberhentian() {
        return pemberhentian;
    }

    public void setPemberhentian(String pemberhentian) {
        this.pemberhentian = pemberhentian;
    }

    // Metode tambahan untuk detail rute
    /*public String getRuteDetail() {
        return "Rute ID: " + ruteID + ", Bus: " + bus + ", Dari: " + kotaAsal +
                ", Ke: " + kotaAkhir + ", Pemberhentian: " + pemberhentian;
    }*/
}
