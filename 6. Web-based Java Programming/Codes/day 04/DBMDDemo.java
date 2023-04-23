/**
 *DatabaseMetaData example
 */
package jdbcapp;

import java.sql.*;

public class DBMDDemo {

    public static void main(String[] args) throws Exception {
        //connect
        DBConnection dbcon = new DBConnection();
        Connection con = dbcon.getDBConnection();
        if (con != null) {
            System.out.println("Connected to DB");
        }

        DatabaseMetaData dbmd = con.getMetaData();

        // database metadata
        System.out.println("Db version: " + dbmd.getDatabaseMajorVersion());
        System.out.println("Db product version: " + dbmd.getDatabaseProductVersion());
        System.out.println("Db product name: " + dbmd.getDatabaseProductName());
        System.out.println("Db user: " + dbmd.getUserName());
        System.out.println("Db driver name: " + dbmd.getDriverName());
        System.out.println("Db driver version: " + dbmd.getDriverVersion());

        con.close();
    }
}
