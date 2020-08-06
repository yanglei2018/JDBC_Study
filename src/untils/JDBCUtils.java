package untils;

import java.io.FileReader;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

/**
 * JDBC工具类
 */
public class JDBCUtils {
    private static String url;
    private static String user;
    private static String password;
    private static String driver;

    /**
     * 使用静态代码块完成对配置文件的读取
     */
    static {
        try {
            Properties pro = new Properties();
            pro.load(new FileReader("src/jdbc.properties"));

            url = pro.getProperty("url");
            user = pro.getProperty("user");
            password = pro.getProperty("password");
            driver = pro.getProperty("driver");

            try {
                Class.forName(driver);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    /**
     * 获取对象
     * @return 连接对象
     */
    public static Connection getConnection() throws Exception{
        return DriverManager.getConnection(url,user,password);
    }

    /**
     * 释放资源
     * @param stmt 语句
     * @param conn 连接
     */
    public static void close(Statement stmt, Connection conn){
        if(stmt != null){
            try {
                stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if(conn != null){
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 重载
     * @param re
     * @param stmt
     * @param conn
     */
    public static void close(ResultSet re, Statement stmt, Connection conn){
        if(re != null){
            try {
                re.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if(stmt != null){
            try {
                stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if(conn != null){
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
