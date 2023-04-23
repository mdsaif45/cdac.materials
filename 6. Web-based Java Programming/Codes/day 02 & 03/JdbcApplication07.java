/**
 Aggregate functions of mysql
 * 
 */

package jdbcapp;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class JdbcApplication07 {
    public static void main(String[] args) throws Exception {
        
        DBConnection dbcon = new DBConnection();
        Connection con = dbcon.getDBConnection();
        
        if(con != null)
            System.out.println("Connection established!");
        
        Statement st = con.createStatement();
        String q1 = "select count(*), min(balance), max(balance), avg(balance), sum(balance) from customers";

        ResultSet rs = st.executeQuery(q1);
        
        while(rs.next()) {
            System.out.println(rs.getInt(1));
            System.out.println(rs.getDouble(2));
            System.out.println(rs.getDouble(3));
            System.out.println(rs.getDouble(4));
            System.out.println(rs.getDouble(5));
        }
        
        rs.close();
        st.close();
        con.close();
    }
}
