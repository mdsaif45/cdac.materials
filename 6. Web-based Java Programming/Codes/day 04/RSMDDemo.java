/**
 *ResultSetMetaData example
 *
 * getColumnLabel() -> gets the alias assigned to columns
 * (if not assigned, gets the actual column names instead)
 *
 * getColumnName() -> gets the actual column names
 */
package jdbcapp;

import java.sql.*;

public class RSMDDemo {

    public static void main(String[] args) throws Exception {
        //connect
        DBConnection dbcon = new DBConnection();
        Connection con = dbcon.getDBConnection();
        if (con != null) {
            System.out.println("Connected to DB");
        }

        Statement stmt = con.createStatement();
        String q1 = "select * from customers";
        ResultSet rs = stmt.executeQuery(q1);

        // get the metadata of the ResultSet
        ResultSetMetaData rsmd = rs.getMetaData();

        // get no. of columns
        int colCount = rsmd.getColumnCount();

        // printing column label(i.e alias, but here makes no difference)
        for (int i = 1; i <= colCount; i++) {
            System.out.print(rsmd.getColumnLabel(i) + "\t\t");
//            System.out.print(rsmd.getColumnName(i) + "\t\t");
        }

        System.out.println();
        System.out.println("-------------------------------------------------------");

        // printing column types
        for (int i = 1; i <= colCount; i++) {
            System.out.print(rsmd.getColumnTypeName(i) + "\t\t");
        }

        System.out.println();
        System.out.println("-------------------------------------------------------");

        while (rs.next()) {
            System.out.println(rs.getInt(1) + "\t\t" + rs.getString(2) + "\t\t" + rs.getDouble(3) + "\t\t" + rs.getString(4));
        }

        rs.close();
        stmt.close();
        con.close();
    }
}
