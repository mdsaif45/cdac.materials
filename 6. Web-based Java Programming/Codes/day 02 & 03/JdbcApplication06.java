/**
Program to get user input from command line 
* and pass it in the query
* 
* We perform only delete operation
*/

package jdbcapp;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class JdbcApplication06 {
    public static void main(String[] args) throws Exception {
        
        Scanner scanner = new Scanner(System.in);
        
        DBConnection dbcon = new DBConnection();
        Connection con = dbcon.getDBConnection();
        
        if(con != null)
            System.out.println("Connection established!");
        
        System.out.println("Enter cid to delete");
        int cid = scanner.nextInt();
        
        Statement st = con.createStatement();
        String q1 = "delete from customers where cid = " + cid;

        int noOfRows = st.executeUpdate(q1);
        if(noOfRows > 0)
            System.out.println(noOfRows + " record(s) deleted");
        else
            System.out.println("Record not found");
        
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
