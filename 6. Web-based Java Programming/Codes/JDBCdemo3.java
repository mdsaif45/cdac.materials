import java.sql.*;
import java.util.*;

public class JDBCdemo3 {
    
    
    public static void main(String args[]) throws Exception{
        DBConnection dbcon=new DBConnection();//Class- getDBConnection Method
        
        Connection con=dbcon.getDBConnection();
        if(con!=null){
            System.out.println("Connection hoo geyaa");
        }
        Statement st=con.createStatement();
        Scanner in= new Scanner(System.in);
        System.out .println("Enter 1 for delete or 2 for update");
        int x=in.nextInt();
        if(x==1){
            System.out.println("Enter cid no. to delete a customer");
            int del=in.nextInt();
            String q1="delete from customers where cid="+del;
            int y=st.executeUpdate(q1);
            if(y>0){
                System.out.println(y+" record delete");
            }
        }
        if(x==2){
            System.out.println("Enter enter cid And balance to update ");
        int id=in.nextInt();
        double bal=in.nextDouble();        
        String q1="update customers set balance="+bal+" where cid="+id;
        
        int z=st.executeUpdate(q1);
        if(z>0){
            System.out.println(z+"Record Updated");
        }
        else{
            System.out.println("Record Not Updated");
        }
        }
        String query="select * from customers ";
        ResultSet rs=st.executeQuery(query);
        
        while(rs.next()){
            System.out.println(rs.getInt(1)+"\t "+rs.getString(2)+"\t "+rs.getString(3)+"\t"+rs.getString(4));
        }
            
              
        con.close();
        rs.close();
        st.close();
    }
}
