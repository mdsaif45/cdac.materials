import java.sql.*;
public class DBConnection {
   static Connection c1=null;    
   public Connection getDBConnection(){
       try{
        Class.forName("com.mysql.cj.jdbc.Driver");
        
        String url="jdbc:mysql://localhost:3306/test";
        String uname="root";
        String pwd="";
        
        c1 = DriverManager.getConnection(url, uname, pwd);
        
       }catch(Exception e){
           System.out.println(e);
       }
       return c1;
   }
}

