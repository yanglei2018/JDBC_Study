package demo01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class JDBCDemo {
    public static void main(String[] args) throws Exception{
        //1. 导入驱动jar包
        //2. 注册驱动
        Class.forName("com.mysql.jdbc.Driver");//存在静态代码块
        //3. 获取数据库连接
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bookshop", "root", "yang1996");
        //4. 定义SQL语句
        String sql = "update book set b_price = 99.9 where b_id = 100001";
        //5. 获取执行SQL的对象Statement
        Statement stmt = conn.createStatement();
        //6. 执行SQL语句
        int count = stmt.executeUpdate(sql);
        //7. 处理结果
        System.out.println(count);
        //8. 释放资源
        stmt.close();
        conn.close();
    }

}
