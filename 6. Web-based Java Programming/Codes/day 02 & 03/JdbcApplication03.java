/**
 Program where we perform insertion of data as well as retrieval
 */
package jdbcapp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;


public class JdbcApplication03 {
    public static void main(String[] args) throws Exception {
                
        // load driver
        Class.forName("com.mysql.cj.jdbc.Driver");
        
        // establish connection, and we get a Connection object after conn. is successfull
        String url = "jdbc:mysql://localhost:3306/advjava";
        String uname = "root";
        String pwd = "12345@Abc";
        Connection con = DriverManager.getConnection(url, uname, pwd);
        
        if(con != null)
            System.out.println("Connection established");
        
        Statement st = con.createStatement();
        
        String query1 = "insert into customers values(1234, 'ABC', 50000, 'Hyderabad')";
        int noOfRows = st.executeUpdate(query1);
        if(noOfRows > 0)
            System.out.println(noOfRows + " row(s) inserted");
        
        String query2 = "select * from customers";
        ResultSet rs = st.executeQuery(query2);
        
        while(rs.next()) {
            System.out.println(rs.getInt(1) + "\t" + rs.getString(2) + "\t" + rs.getDouble(3) + "\t" + rs.getString(4));
        }
        
        System.out.println(noOfRows);
        
        con.close();
    }
}
