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

/**
 *
 * @author Vie
 */
public class DichVuDao extends HotelDao<Dichvu, String> {

    String INSERT_SQL = "insert into DichVu  values(?,?,?)";
    String UPDATE_SQL = "update DichVu set gia = ?, moTa = ? WHERE tenDV=?";
    String DELETE_SQL = "delete from DichVu where tenDV like ?";
    String SELECT_ALL_SQL = "select * from DichVu";
    String SELECT_BY_ID_SQL = "select * from DichVu where  tenDV like ?";
    String SELECT_BY_DICHVU_SQL = "select * from DichVu where tendichvu like ?";

    @Override
    public void insert(Dichvu e) {
        try {
            jdbcHelper.update(INSERT_SQL,
                    e.getTen(),
                    e.getGia(),
                    e.getMoTa()
            );
        } catch (SQLException ex) {
            Logger.getLogger(DichVuDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void update(Dichvu e) {
try {
            jdbcHelper.update(UPDATE_SQL,
                    e.getGia(),
                    e.getMoTa(),
                    e.getTen()
            );
        } catch (SQLException ex) {
            Logger.getLogger(DichVuDao.class.getName()).log(Level.SEVERE, null, ex);
        }    }

    @Override
    public void delete(String id) {
        try {
            jdbcHelper.update(DELETE_SQL, id);
        } catch (SQLException ex) {
            Logger.getLogger(DichVuDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public Dichvu selectById(String id) {
        List<Dichvu> list = this.selectBySql(SELECT_BY_ID_SQL, id);
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    @Override
    public List<Dichvu> selectAll() {
        return this.selectBySql(SELECT_ALL_SQL);
    }

    @Override
    protected List<Dichvu> selectBySql(String sql, Object... args) {
        List<Dichvu> list = new ArrayList<>();
        try {
            ResultSet rs = jdbcHelper.query(sql, args);
            while (rs.next()) {
                Dichvu entity = new Dichvu();
                entity.setTen(rs.getString("tenDV"));
                entity.setGia(rs.getDouble("gia"));
                entity.setMoTa(rs.getString("moTa"));
                list.add(entity);
            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
