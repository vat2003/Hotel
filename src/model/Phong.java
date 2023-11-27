/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author anhta
 */
public class Phong {
    private String maPhong;
    private String idLP;
    private boolean trangThai;
    private String tenDV;
    private float giaPhong;

    public Phong() {
    }

    public Phong(String maPhong, String idLP, boolean trangThai, String tenDV, float giaPhong) {
        this.maPhong = maPhong;
        this.idLP = idLP;
        this.trangThai = trangThai;
        this.tenDV = tenDV;
        this.giaPhong = giaPhong;
    }

    public String getMaPhong() {
        return maPhong;
    }

    public void setMaPhong(String maPhong) {
        this.maPhong = maPhong;
    }

    public String getIdLP() {
        return idLP;
    }

    public void setIdLP(String idLP) {
        this.idLP = idLP;
    }

    public boolean isTrangThai() {
        return trangThai;
    }

    public void setTrangThai(boolean trangThai) {
        this.trangThai = trangThai;
    }

    public String getTenDV() {
        return tenDV;
    }

    public void setTenDV(String tenDV) {
        this.tenDV = tenDV;
    }

    public float getGiaPhong() {
        return giaPhong;
    }

    public void setGiaPhong(float giaPhong) {
        this.giaPhong = giaPhong;
    }
    
}
