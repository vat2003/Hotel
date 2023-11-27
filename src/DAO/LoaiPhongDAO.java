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
import model.LoaiPhong;

/**
 *
 * @author anhta
 */
public class LoaiPhongDAO extends QLKS<LoaiPhong, String> {

    String INSERT_SQL = "insert into LoaiPhong (idLP, gia, soNguoi) values (?,?,?)";
    String UPDATE_SQL = "update LoaiPhong set gia = ?, soNguoi = ? where idLP = ?";
    String DELETE_SQL = "delete from LoaiPhong where idLP = ?";
    String SELECT_ALL_SQL = "select * from LoaiPhong";
    String SELECT_BY_ID_SQL = "select * from LoaiPhong where idLP = ?";

    public List<LoaiPhong> selectByID(String id) {
        id = "%" + id + "%";
        return selectBySql(SELECT_BY_ID_SQL, id);
    }

    @Override
    public void insert(LoaiPhong e) {
        try {
            jdbcHelper.update(INSERT_SQL, e.getIdLP(), e.getGia(), e.getSoNguoi());
        } catch (SQLException ex) {
            Logger.getLogger(LoaiPhongDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void update(LoaiPhong e) {
        try {
            jdbcHelper.update(UPDATE_SQL, e.getGia(), e.getSoNguoi(), e.getIdLP());
        } catch (SQLException ex) {
            Logger.getLogger(LoaiPhongDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void delete(String id) {
        try {
            jdbcHelper.update(DELETE_SQL, id);
        } catch (SQLException ex) {
            Logger.getLogger(LoaiPhongDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public LoaiPhong selectById(String id) {
        List<LoaiPhong> list = this.selectBySql(SELECT_BY_ID_SQL, id);
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    @Override
    public List<LoaiPhong> selectAll() {
        return this.selectBySql(SELECT_ALL_SQL);
    }

    @Override
    protected List<LoaiPhong> selectBySql(String sql, Object... args) {
        List<LoaiPhong> list = new ArrayList<>();
        try {
            ResultSet rs = jdbcHelper.query(sql, args);
            while (rs.next()) {
                LoaiPhong entity = new LoaiPhong();
                entity.setIdLP(rs.getString("idLP"));
                entity.setGia(rs.getFloat("gia"));
                entity.setSoNguoi(rs.getInt("soNguoi"));
                list.add(entity);
            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
