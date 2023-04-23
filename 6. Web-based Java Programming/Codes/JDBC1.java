import java.sql.*;

public class JDBC1
{
    public static void main(String args[]) throws Exception
    {
        //Class Loader
        Class.forName("com.mysql.cj.jdbc.Driver");
        
        //creating a Connection
        Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/cdachyd","root","root");
        
        if(con!=null){
            System.out.println("Connection Established");
        }
        
        //Creating Statement
        Statement st=con.createStatement();
        String query2="delete from worker where Worker_id=5";
        st.executeUpdate(query2);
        String query="select * from worker";
        
        //result and Process
        ResultSet rs=st.executeQuery(query);
        
        while(rs.next()){
            System.out.println(rs.getInt(1)+"\t "+rs.getString(2)+"\t "+rs.getString(3)+"");
        }
        
        con.close();
        st.close();
        rs.close();
        
        
    }
}
