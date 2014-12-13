import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import com.jdbc.MyConnection;
import com.table.action.*;

public class Test {
    public static void main(String[] args) throws SQLException {
        MyConnection util = new MyConnection();
        Connection conn = util.getConnection("webtblget", "root", "123456");
        if (true) {
            Statement stmt = conn.createStatement();
            stmt.execute("drop table if exists table1");
            stmt.execute("create table table1(" + "term varchar(50),"
                    + "lessonNum varchar(50)," + "lessonName varchar(50),"
                    + "techerName varchar(50)," + "kind varchar(50),"
                    + "grade varchar(50)," + "time varchar(50),"
                    + "myPoint varchar(50)," + "gradeKind varchar(50),"
                    + "remark varchar(50));");
        }
    }
}
