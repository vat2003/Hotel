/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Utils;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.DriverManager;
/**
 *
 * @author ktn39
 */
public class jdbcHelper {

    static String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    static String dburl = "jdbc:sqlserver://localhost:1433;database=QlKhachSan;encrypt=false";
    static String user = "sa";
    static String pass = "voanhtai111";

    static {
        try {
            Class.forName(driver);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static PreparedStatement getStmt(String sql, Object... args) throws SQLException {
        Connection connection = DriverManager.getConnection(dburl, user, pass);
        PreparedStatement pstmt = null;
        if (sql.trim().startsWith("{")) {
            pstmt = connection.prepareCall(sql);
        } else {
            pstmt = connection.prepareStatement(sql);
        }
        for (int i = 0; i < args.length; i++) {
            pstmt.setObject(i + 1, args[i]);
        }
        return pstmt;
    }
    
    public static int update(String sql, Object... args) throws SQLException{
        try {
            PreparedStatement stmt = jdbcHelper.getStmt(sql, args);
            try {
                return stmt.executeUpdate();
            } finally {
                stmt.getConnection().close();
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    
    public static ResultSet query(String sql, Object... args) throws SQLException{
        PreparedStatement stmt = jdbcHelper.getStmt(sql, args);
        return stmt.executeQuery();
    }
    
    public static Object value(String sql, Object... args){
        try {
            ResultSet rs = jdbcHelper.query(sql, args);
            if(rs.next()){
//                return rs.getObject(0);
                return rs.getObject(1);
            }
            rs.getStatement().getConnection().close();
            return null;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
