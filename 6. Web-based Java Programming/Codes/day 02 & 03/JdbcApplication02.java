/**
 Simple program where we store connections details in variables
 */
package jdbcapp;

import java.sql.*;

public class JdbcApplication02 {
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
        
        String query1 = "create table customers(cid int, cname varchar(10), balance float, city varchar(10), PRIMARY KEY(cid));";

        int noOfRows = st.executeUpdate(query1);
        
        System.out.println(noOfRows);
        
        con.close();

    }
}
