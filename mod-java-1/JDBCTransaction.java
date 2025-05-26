import java.sql.*;

public class JDBCTransaction {
    public static void transfer(Connection conn, int from, int to, double amount) throws Exception {
        conn.setAutoCommit(false);
        try {
            PreparedStatement debit = conn.prepareStatement("UPDATE accounts SET balance=balance-? WHERE id=?");
            debit.setDouble(1, amount); debit.setInt(2, from); debit.executeUpdate();
            PreparedStatement credit = conn.prepareStatement("UPDATE accounts SET balance=balance+? WHERE id=?");
            credit.setDouble(1, amount); credit.setInt(2, to); credit.executeUpdate();
            conn.commit();
        } catch (Exception e) {
            conn.rollback();
        }
    }
}
