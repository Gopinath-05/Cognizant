import java.sql.*;

public class JDBCConnection {
    public static void main(String[] args) throws Exception {
        Connection conn = DriverManager.getConnection("jdbc:sqlite:students.db");
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM students");
        while (rs.next())
            System.out.println(rs.getInt(1) + " " + rs.getString(2));
        conn.close();
    }
}
