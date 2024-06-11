package application;

import db.DB;

import java.sql.*;


public class Program {
    public static void main(String[] args) {
        Connection conn = null;
        PreparedStatement st = null;
        try {
            conn = DB.getConnection();
            st = conn.prepareStatement(
                    "update seller "
                    + "set BaseSalary = BaseSalary + ? "
                    + "WHERE "
                    + "(DepartmentId = ?)");
            st.setDouble(1, 200.0);
            st.setInt(2, 2);

            int rows = st.executeUpdate();
            System.out.println("Done! Rows Affected: " + rows);
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            DB.closeStatement(st);
            DB.closeConnection();
        }
    }
}
