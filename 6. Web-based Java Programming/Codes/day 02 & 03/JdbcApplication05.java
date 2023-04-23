/**
Program to get user input from command line 
* and pass it in the query
* 
* We perform only update operation
*/

package jdbcapp;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class JdbcApplication05 {
    public static void main(String[] args) throws Exception {
         // Scanner object
        Scanner scanner = new Scanner(System.in);
        
        DBConnection dbcon = new DBConnection();
        Connection con = dbcon.getDBConnection();
        
        if(con != null)
            System.out.println("Connection established!");
        
        // asking user for inout
        System.out.println("Enter cid and balance to update");
        int cid = scanner.nextInt();
        double balance = scanner.nextDouble();
        
        Statement st = con.createStatement();
        String q1 = "update customers set balance = "+ balance +"where cid = " + cid;

        int noOfRows = st.executeUpdate(q1);
        if(noOfRows > 0)
            System.out.println(noOfRows + " record(s) updated");
        else
            System.out.println("Records not updated");
        
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
