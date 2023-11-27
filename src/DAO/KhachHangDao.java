/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import java.util.List;
import model.KhachHang;
import Utils.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Acer
 */
public class KhachHangDao extends HotelDao<KhachHang, String> {

    String INSERT_SQL = "insert into KhachHang (dienThoai, hoten, CCCD, ngaySinh, email, loaiKhach, ghiChu) values (?,?,?,?,?,?,?)";

    String UPDATE_SQL = "update KhachHang set dienThoai = ?, hoten= ?, CCCD= ?, ngaySinh= ?, email= ?, loaiKhach= ?, ghiChu= ? where maKH = ?";
    String DELETE_SQL = "delete from KhachHang where maKH = ?";

    String SELECT_ALL_SQL = "select k.*, t.maPhong from KhachHang k left join DatPhong t on k.MaKH = t.MaKH ";
    String SELECT_BY_ID_SQL = "select k.*, t.maPhong from KhachHang k left join DatPhong t on k.MaKH = t.MaKH where k.maKH = ?";
    String timten = "select * from KhachHang where maKH = ?";

    public KhachHang selectByKeyword(String keyword) {
        List<KhachHang> list = this.selectBySql(timten, keyword);
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    public List<KhachHang> selectByKeyword1(String keyword) {
        return this.selectBySql(timten, keyword);
    }

    @Override
    public void insert(KhachHang e) {
        try {
            jdbcHelper.update(INSERT_SQL, e.getDienThoai(), e.getHoten(), e.getCCCD(), e.getNgaySinh(), e.getEmail(), e.getLoaiKhach(), e.getGhiChu());
        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(KhachHangDao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);

        }
    }

    @Override
    public void update(KhachHang e) {
        try {
            jdbcHelper.update(UPDATE_SQL,
                    e.getDienThoai(),
                    e.getHoten(),
                    e.getCCCD(),
                    e.getNgaySinh(),
                    e.getEmail(),
                    e.getLoaiKhach(),
                    e.getGhiChu(),
                    e.getMaKH()
            );
        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(KhachHangDao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
    }

    @Override
    public void delete(String id) {
        try {
            jdbcHelper.update(DELETE_SQL, id);
        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(KhachHangDao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
    }

    @Override
    public KhachHang selectById(String id) {
        List<KhachHang> list = this.selectBySql(SELECT_BY_ID_SQL, id);
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    @Override
    public List<KhachHang> selectAll() {
        return this.selectBySql(SELECT_ALL_SQL);
    }

    @Override
    protected List<KhachHang> selectBySql(String sql, Object... args) {

        List<KhachHang> list = new ArrayList<KhachHang>();
        try {
            ResultSet rs = jdbcHelper.query(sql, args);
            while (rs.next()) {
                KhachHang entity = new KhachHang();
                entity.setMaKH(rs.getString("maKH"));
                entity.setDienThoai(rs.getString("dienThoai"));
                entity.setHoten(rs.getString("hoten"));
                entity.setCCCD(rs.getString("CCCD"));
                entity.setNgaySinh(rs.getDate("ngaySinh"));
                entity.setEmail(rs.getString("email"));
                entity.setSoLanDP(rs.getInt("soLanDP"));
                entity.setLoaiKhach(rs.getString("loaiKhach"));
                entity.setGhiChu(rs.getString("ghiChu"));
                entity.setTenPhong(rs.getString("maPhong"));

                list.add(entity);
            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
