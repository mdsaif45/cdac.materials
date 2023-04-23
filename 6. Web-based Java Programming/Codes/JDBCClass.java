import java.sql.*;

public class JDBCClass {
    
    public static void main(String args[]) throws Exception
    {
        //Loading the Drivers
        Class.forName("com.mysql.cj.jdbc.Driver");
        
        // Connection
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/cdac", "root", "root");
        
        if(con!=null)
           System.out.println("Connection Established");
        
        //Create Statement
        Statement st=con.createStatement();
        
        String query1= "Select * from dept";
        String query2="insert into dept values(50,'Engineering','Landon')";
        
        int x= st.executeUpdate(query2);
        if(x>0){
            System.out.println(x+"Record Inserted");
        }
        //obtain result and process        
        ResultSet rs = st.executeQuery(query1);
        while(rs.next()){
            System.out.println(rs.getInt(1)+"\t "+rs.getString(2)+"\t"+rs.getString(3));
        }
        //closing connection
        con.close();
        st.close();
        rs.close();
    }
            
}
