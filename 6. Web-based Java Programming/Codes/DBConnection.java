import java.sql.*;

public class DBConnection {
    
    Connection c1=null;
    public Connection getDBConnection(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
        
        c1=DriverManager.getConnection("jdbc:mysql://localhost:3306/cdachyd","root","root");
        }
        catch(Exception e){
            System.out.println(e);
        }
        return c1;
    }
}
