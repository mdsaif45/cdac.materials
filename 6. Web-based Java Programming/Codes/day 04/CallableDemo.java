/**
 *Calling a stored procedure using CallableStatement interface
 *
 * use set method to set IN parameters
 *
 * Procedure used:
 *
 * DELIMITER $$
 * CREATE PROCEDURE getDetailsById(IN id INT)
 * BEGIN
 *      SELECT * FROM customers WHERE cid = id;
 * END $$
 * DELIMITER ;
 */
package jdbcapp;

import java.sql.*;

public class CallableDemo {

    public static void main(String[] args) throws Exception {
        //connect
        DBConnection dbcon = new DBConnection();
        Connection con = dbcon.getDBConnection();
        if (con != null) {
            System.out.println("Connected to DB");
        }

        String str1 = "{ CALL getDetailsById(?) }";

        CallableStatement cst = con.prepareCall(str1);

        cst.setInt(1, 888);
        ResultSet rs = cst.executeQuery();

        while (rs.next()) {
            System.out.println(rs.getInt(1) + "\t\t" + rs.getString(2) + "\t\t" + rs.getDouble(3) + "\t\t" + rs.getString(4));
        }

        cst.close();
        con.close();
    }
}
