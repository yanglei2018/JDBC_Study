package untils;

import java.sql.Connection;
import java.sql.Statement;

public class test {
    public static void main(String[] args) throws  Exception{
        Connection cnn = JDBCUtils.getConnection();

        String sql = "update book set b_price = 99.9 where b_id = 100001";

        Statement stmt = cnn.createStatement();

        int count = stmt.executeUpdate(sql);

        System.out.println(count);

        JDBCUtils.close(stmt,cnn);
    }
}
