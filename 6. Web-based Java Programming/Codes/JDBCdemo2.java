import java.sql.*; // JDBC API
public class JDBCdemo2 {
    public static void main(String args[]) throws Exception{
        
        Class.forName("com.mysql.cj.jdbc.Driver");
        
        Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/cdachyd","root","root");
        if(con!=null){
            System.out.println("Connection Established");
        }
        
        Statement st=con.createStatement();
        
        String q1="create table customers(cid int primary key ,cname varchar(10),balance float,city varchar(10))";        
        int x=st.executeUpdate(q1);        
        System.out.println(x);        
        if(x>0){
            System.out.println("Table Created");
        }
        
        con.close();
        st.close();
    }
    
}
