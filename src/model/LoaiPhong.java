/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author anhta
 */
public class LoaiPhong {
    private String idLP;
    private float gia;
    private int soNguoi;

    public LoaiPhong() {
    }

    public LoaiPhong(String idLP, float gia, int soNguoi) {
        this.idLP = idLP;
        this.gia = gia;
        this.soNguoi = soNguoi;
    }

    public String getIdLP() {
        return idLP;
    }

    public void setIdLP(String idLP) {
        this.idLP = idLP;
    }

    public float getGia() {
        return gia;
    }

    public void setGia(float gia) {
        this.gia = gia;
    }

    public int getSoNguoi() {
        return soNguoi;
    }

    public void setSoNguoi(int soNguoi) {
        this.soNguoi = soNguoi;
    }
    
}
