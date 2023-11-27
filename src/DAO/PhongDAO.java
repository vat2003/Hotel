/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Utils.jdbcHelper;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Phong;

/**
 *
 * @author anhta
 */
public class PhongDAO extends QLKS<Phong, String> {

    String INSERT_SQL = "insert into Phong (maPhong, idLP, trangThai, giaPhong, tenDV) values (?,?,?,?,?)";
    String UPDATE_SQL = "update Phong set idLP = ?, trangThai = ?, giaPhong = ?, tenDV = ? where maPhong = ? ";
    String DELETE_SQL = "delete from Phong where maPhong = ?";
    String SELECT_ALL_SQL = "select * from Phong";
    String SELECT_BY_ID_SQL = "select * from Phong where maPhong = ?";
    String SELECT_BY_EMPTY_ROOM_SQL = "select * from Phong where trangThai = 1";
    String SELECT_BY_NON_EMPTY_ROOM_SQL = "select * from Phong where trangThai = 0";
    String COUNT_ALL_ROOM = "select count(*) from phong";
    String COUNT_EMPTY_ROOM = "select count(trangthai) from phong where trangThai = 1";
    String COUNT_NON_EMPTY_ROOM = "select count(trangthai) from phong where trangThai = 0";

    public List<Phong> selectByID(Integer id) {
        return selectBySql(SELECT_BY_ID_SQL, id);
    }

    @Override
    public void insert(Phong e) {
        try {
            jdbcHelper.update(INSERT_SQL, e.getMaPhong(), e.getIdLP(), e.isTrangThai(), e.getGiaPhong(), e.getTenDV());
        } catch (SQLException ex) {
            Logger.getLogger(PhongDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void update(Phong e) {
        try {
            jdbcHelper.update(UPDATE_SQL, e.getIdLP(), e.isTrangThai(), e.getGiaPhong(), e.getTenDV(), e.getMaPhong());
        } catch (SQLException ex) {
            Logger.getLogger(PhongDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void delete(String id) {
        try {
            jdbcHelper.update(DELETE_SQL, id);
        } catch (SQLException ex) {
            Logger.getLogger(PhongDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public Phong selectById(String id) {
        List<Phong> list = this.selectBySql(SELECT_BY_ID_SQL, id);
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    @Override
    public List<Phong> selectAll() {
        return this.selectBySql(SELECT_ALL_SQL);
    }

    public List<Phong> selectByEmptyRoom() {
        return this.selectBySql(SELECT_BY_EMPTY_ROOM_SQL);
    }

    public List<Phong> selectByNONEmptyRoom() {
        return this.selectBySql(SELECT_BY_NON_EMPTY_ROOM_SQL);
    }

    @Override
    protected List<Phong> selectBySql(String sql, Object... args) {
        List<Phong> list = new ArrayList<>();
        try {
            ResultSet rs = jdbcHelper.query(sql, args);
            while (rs.next()) {
                Phong entity = new Phong();
                entity.setMaPhong(rs.getString("maPhong"));
                entity.setIdLP(rs.getString("idLP"));
                entity.setTrangThai(rs.getBoolean("trangThai"));
                entity.setTenDV(rs.getString("tenDV"));
                entity.setGiaPhong(rs.getFloat("giaPhong"));
                list.add(entity);
            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public int countAllRoom() {
        return (int) jdbcHelper.value(COUNT_ALL_ROOM);
    }
    public int countEmptyRoom() {
        return (int) jdbcHelper.value(COUNT_EMPTY_ROOM);
    }
    public int countNONEmptyRoom() {
        return (int) jdbcHelper.value(COUNT_NON_EMPTY_ROOM);
    }
}
