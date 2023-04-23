/**
 Using DBConnection class
 * 
 * 1. Create object of DBConnection
 * 2. Call getDBConnection() and save the reference in a Connection obj
 * 
 * This program performs insert and update operations with DB
 */

package jdbcapp;

import java.sql.*;
import java.util.Scanner;

public class JdbcApplication04 {
      
    public static void main(String[] args) throws Exception {
        
        DBConnection dbcon = new DBConnection(); // class - getDBConnection()
        Connection con = dbcon.getDBConnection(); // loading & connecting - return con
        
        if(con != null)
            System.out.println("Connection established!");
        
        Statement st = con.createStatement();
//        String q1 = "insert into customers values(111,'XYZ', 40000,'Pune'),(222,'PQR', 60000,'Delhi')";
        String q1 = "update customers set balance = 100000 where cid = 222";
                
        int noOfRows = st.executeUpdate(q1);
        if(noOfRows > 0)
//            System.out.println(noOfRows + " records(s) inserted");
            System.out.println(noOfRows + " records(s) updated");
        
        String q2 = "select * from customers where balance > 30000";
        ResultSet rs = st.executeQuery(q2);
        
        while(rs.next()) {
            System.out.println(rs.getInt(1) + "\t" + rs.getString(2) + "\t" + rs.getDouble(3) + "\t" + rs.getString(4));
        }
        
        rs.close();
        st.close();
        con.close();
    }
}
