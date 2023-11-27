/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.Date;

public class KhachHang {

    private String maKH;
    private String dienThoai;
    private String hoten;
    private String CCCD;
    private Date ngaySinh;
    private String email;
    private int soLanDP;
    private String loaiKhach;
    private String ghiChu;
    private String tenPhong;


    public KhachHang() {
    }

    public KhachHang(String maKH, String dienThoai, String hoten, String CCCD, Date ngaySinh, String email, int soLanDP, String loaiKhach, String ghiChu, String tenPhong) {
        this.maKH = maKH;
        this.dienThoai = dienThoai;
        this.hoten = hoten;
        this.CCCD = CCCD;
        this.ngaySinh = ngaySinh;
        this.email = email;
        this.soLanDP = soLanDP;
        this.loaiKhach = loaiKhach;
        this.ghiChu = ghiChu;
        this.tenPhong = tenPhong;
    }

    
    
    public String getMaKH() {
        return maKH;
    }

    public void setMaKH(String maKH) {
        this.maKH = maKH;
    }

 

    public String getDienThoai() {
        return dienThoai;
    }

    public void setDienThoai(String dienThoai) {
        this.dienThoai = dienThoai;
    }

    public String getHoten() {
        return hoten;
    }

    public void setHoten(String hoten) {
        this.hoten = hoten;
    }

    public String getCCCD() {
        return CCCD;
    }

    public void setCCCD(String CCCD) {
        this.CCCD = CCCD;
    }

    public Date getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(Date ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getSoLanDP() {
        return soLanDP;
    }

    public void setSoLanDP(int soLanDP) {
        this.soLanDP = soLanDP;
    }

    public String getLoaiKhach() {
        return loaiKhach;
    }

    public void setLoaiKhach(String loaiKhach) {
        this.loaiKhach = loaiKhach;
    }

    public String getGhiChu() {
        return ghiChu;
    }

    public void setGhiChu(String ghiChu) {
        this.ghiChu = ghiChu;
    }

    public String getTenPhong() {
        return tenPhong;
    }

    public void setTenPhong(String tenPhong) {
        this.tenPhong = tenPhong;
    }

}
