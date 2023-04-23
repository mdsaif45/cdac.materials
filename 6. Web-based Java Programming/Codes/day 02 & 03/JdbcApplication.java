/**
 Basic and standard steps to connect to mySQL using JDBC Type4 driver
 */
package jdbcapp;

import java.sql.*;

public class JdbcApplication {
    public static void main(String[] args) throws Exception {
        // [1] loading driver
        Class.forName("com.mysql.cj.jdbc.Driver");
        
        // [2] connect to db
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/pgdac","root","12345@Abc");
        
        if(con != null)
            System.out.println("Connection established");
        
        // [3] create statement
        Statement stmt = con.createStatement();
        
        String query = "select * from dept";
        
        // [4] obtain and process results
        ResultSet rs = stmt.executeQuery(query);
        
        while(rs.next()) {
            System.out.println(rs.getInt(1) + " " + rs.getString(2) + " " + rs.getString(3));
        }
        
        // [5] close connections
        rs.close();
        stmt.close();
        con.close();
    }
}
