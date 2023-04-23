/**
 Ask user to enter the data to be inserted into the database
 * 
 */

package jdbcapp;

import java.sql.*;
import java.util.Scanner;

public class PSDemo02 {
public static void main(String[] args) throws Exception {
        DBConnection dbcon = new DBConnection();
        Connection con = dbcon.getDBConnection();
        
        if(con != null)
            System.out.println("Connection established");
        
        Scanner scanner = new Scanner(System.in);
        System.out.println("How many customer records you want to insert?");
        int numOfCustomers = scanner.nextInt();
        
        System.out.println("cid - cname - balance - city");
        
        PreparedStatement pst = null;
        
        for(int i = 0; i < numOfCustomers; i++) {
            System.out.println("Enter customer " + (i + 1) + " details");
            int cid = scanner.nextInt(); // cid
            String cname = scanner.next(); // cname
            Double balance = scanner.nextDouble(); // balance
            String city = scanner.next(); // city
        
            // ? is the placeholder
            String q1 = "insert into customers values(?,?,?,?)";
            pst = con.prepareStatement(q1);

            //(placeholder_number, value_to_insert_at_this_placeholder)
            pst.setInt(1, cid); // for 1st placeholder
            pst.setString(2, cname);
            pst.setDouble(3, balance);
            pst.setString(4, city);

            int rowsUpdated = pst.executeUpdate();
            
            if(rowsUpdated > 0)
                System.out.println((i + 1)+" rows inserted");
        }
        
        String q2 = "select * from customers";
        // you can use the previous pst instead of pst2
        PreparedStatement pst2 = con.prepareStatement(q2);
        // prepareStatement() can accept fully compiled query
        
        ResultSet rs = pst2.executeQuery();
        
        while(rs.next())
            System.out.println(rs.getInt(1) + "\t" + rs.getString(2) + "\t" + rs.getDouble(3) + "\t" + rs.getString(4));

        rs.close();
        pst.close();
        con.close();
    }    
}
