package Login;

import untils.JDBCUtils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class LoginDemo {
    /**
     * 实现登录逻辑
     * @param username
     * @param password
     * @return 是否成功
     */
    public boolean login(String username, String password){
        Connection cnn = null;
        Statement stmt = null;
        ResultSet res = null;

        if(username == null || password == null){
            return false;
        }
        try {
            //获取连接
            cnn = JDBCUtils.getConnection();
            //定义SQL语句
            String sql = "select * from user where u_name = '"+username+"' and u_pwd = '"+password+"'";
            //获取执行sql的
            stmt = cnn.createStatement();
            //执行SQL
            res = stmt.executeQuery(sql);

            return res.next();//如果有下一行，返回ture
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            JDBCUtils.close(res,stmt,cnn);
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println("请输入用户名：");
        Scanner sc = new Scanner(System.in);
        String username = sc.nextLine();
        System.out.println("请输入密码：");
        String password = sc.nextLine();

        //由于login不是静态方法，因此使用创建对象的办法调用
        boolean login = new LoginDemo().login(username, password);

        //boolean login = login(username, password);
        if(login == true){
            System.out.println("登录成功");
        }
        else {
            System.out.println("登录失败");
        }
    }
}
