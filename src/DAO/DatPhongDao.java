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
import model.Dichvu;
import model.datphong;

/**
 *
 * @author Vie
 */
public class DatPhongDao extends HotelDao<model.datphong, String> {

    String INSERT_SQL = "insert into DatPhong1 (maPhong, maKH, soNguoi, checkIn, checkOut, donGia, ghiChu) values(?,?,?,?,?,?,?)";
    String UPDATE_SQL = "update DatPhong1 set maPhong = ?, maKH= ?, soNguoi= ?, checkIn= ?, checkOut= ?, donGia= ?, ghiChu= ? where idDP = ?";
    String DELETE_SQL = "delete from DatPhong1 where idDP = ?";
    String SELECT_ALL_SQL = "select * from DatPhong1";
    String SELECT_BY_ID_SQL = "select * from DatPhong1 where  idDP like ?";

    @Override
    public void insert(model.datphong e) {
        try {
            jdbcHelper.update(INSERT_SQL, e.getMaphong(), e.getMakh(), e.getSonguoi(), e.getCheckin(), e.getCheckout(), e.getMoney(), e.getGhichu()
            );
        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(KhachHangDao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);

        }
    }

    @Override
    public void update(model.datphong e) {
        try {
            jdbcHelper.update(INSERT_SQL, e.getMaphong(), e.getMakh(), e.getSonguoi(), e.getCheckin(), e.getCheckout(), e.getMoney(), e.getGhichu(), e.getId()
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
    public model.datphong selectById(String id) {
        List<datphong> list = this.selectBySql(SELECT_BY_ID_SQL, id);
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    @Override
    public List<datphong> selectAll() {
        return this.selectBySql(SELECT_ALL_SQL);
    }

    @Override
    protected List<datphong> selectBySql(String sql, Object... args) {
        List<datphong> list = new ArrayList<datphong>();
        try {
            ResultSet rs = jdbcHelper.query(sql, args);
            while (rs.next()) {
                datphong entity = new datphong();
                entity.setId(rs.getInt("idDP"));
                entity.setMaphong(rs.getString("maPhong"));
                entity.setMakh(rs.getInt("maKH"));
                entity.setSonguoi(rs.getInt("soNguoi"));
                entity.setCheckin(rs.getDate("checkIn"));
                entity.setCheckout(rs.getDate("checkOut"));
                entity.setMoney(rs.getDouble("donGia"));
                entity.setGhichu(rs.getString("ghiChu"));

                list.add(entity);
            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }    }

}
