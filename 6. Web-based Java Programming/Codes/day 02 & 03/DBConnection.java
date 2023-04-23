/**
 Class for DB connection
 * Separate class which connects to mySQL database
 * 
 * @method getDBConnection()
 *  @returns Connection object
 * 
 * note: can be made static to avoid declaration in main(),
 * but since the driver does not return a "static" reference,
 * it is advised to not make it static.
 * 
 * *sigh* likh lo ek aur line... #SadLife
 */

package jdbcapp;

import java.sql.*;

public class DBConnection {
    Connection con = null;
    
    public Connection getDBConnection() {
        try{
            // load driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // establish connection, and we get a Connection object after conn. is successfull
            String url = "jdbc:mysql://localhost:3306/advjava";
            String uname = "root";
            String pwd = "12345@Abc";
            con = DriverManager.getConnection(url, uname, pwd);
        }
        catch(Exception e) {
            System.out.println(e);
        }
        
        return con;
    }
}
