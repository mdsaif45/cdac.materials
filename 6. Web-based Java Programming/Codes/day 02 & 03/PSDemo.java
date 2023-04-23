/**
 Using PreparedStatement Interface
 */

package jdbcapp;

import java.sql.*;

public class PSDemo {
    public static void main(String[] args) throws Exception {
        DBConnection dbcon = new DBConnection();
        Connection con = dbcon.getDBConnection();
        
        if(con != null)
            System.out.println("Connection established");
        
        // ? is the placeholder
        String q1 = "insert into customers values(?,?,?,?)";
        
        PreparedStatement pst = con.prepareStatement(q1);
        
        //(placeholder_number, value_to_insert_at_this_placeholder)
        pst.setInt(1, 333); // for 1st placeholder
        pst.setString(2, "LMN");
        pst.setDouble(3, 90000);
        pst.setString(4, "Mumbai");
        
        pst.setInt(1, 444); // for 1st placeholder
        pst.setString(2, "IJK");
        pst.setDouble(3, 70000);
        pst.setString(4, "Kolkata");
        
        int rowsUpdated = pst.executeUpdate();
        if(rowsUpdated > 0)
            System.out.println(rowsUpdated);
        
        pst.close();
        con.close();
    }
}
