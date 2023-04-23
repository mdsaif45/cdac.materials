/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.lms.db;

import com.lms.pojo.Book;
import com.lms.pojo.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author CDAC
 */
public class DBOperations {
    DBConnection dbcon = null;
    Connection con = null;
    String query = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;
    
    public boolean saveUserDetails(String name, String email, String mobile, String address, String password)
    {
        int rows = 0;
        dbcon = new DBConnection();
        con = dbcon.getDBConnection();        
        query =  "insert into userdetails values(?,?,?,?)";
        try {
            pstmt = con.prepareStatement(query);
            pstmt.setString(1, name);
            pstmt.setString(2, email);
            pstmt.setString(3, mobile);
            pstmt.setString(4, address);
            rows = pstmt.executeUpdate();
            if(rows == 1){
                query = "insert into userlogininfo values(?,?)";
                pstmt = con.prepareStatement(query);
                pstmt.setString(1, email);
                pstmt.setString(2, password);
                rows = pstmt.executeUpdate();
                if(rows == 1){
                    return true;
                }
            }
            
        } catch (SQLException soe) {
            Logger.getLogger(DBOperations.class.getName()).log(Level.SEVERE, null, soe);
        }
        finally{
            if(con != null){
                try {
                    con.close();
                } catch (SQLException ex) {
                    Logger.getLogger(DBOperations.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return false;
    }
    
    public boolean verifyUserLoginDetails(String email, String password){
        dbcon = new DBConnection();
        con = dbcon.getDBConnection();
        query =  "select email from userlogininfo where email=? and password=?";
        try {
            pstmt = con.prepareStatement(query);
            pstmt.setString(1, email);
            pstmt.setString(2, password);
            rs = pstmt.executeQuery();              
            if(rs.next()){
                System.out.println("=="+rs.getString("email"));
                return true;
            }                       
        } catch (SQLException ex) {
            Logger.getLogger(DBOperations.class.getName()).log(Level.SEVERE, null, ex);
        } finally{
            if(con != null){
                try {
                    con.close();
                } catch (SQLException ex) {
                    Logger.getLogger(DBOperations.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return false;        
    }
    
    
    public User getSelectedUserDetails(String email){
        //String value = null;
        User user = null;
        dbcon = new DBConnection();
        con = dbcon.getDBConnection();
        query =  "select * from userdetails where email=?";
        try {
            pstmt = con.prepareStatement(query);
            pstmt.setString(1, email);            
            rs = pstmt.executeQuery();              
            while(rs.next()){                   
                System.out.println(rs.getString("name")+""+rs.getString("mobile")+""+rs.getString("address"));                
                user = new User();
                user.setName(rs.getString("name"));
                user.setMobile(rs.getString("mobile"));
                user.setAddress(rs.getString("address"));
                //value = rs.getString("name")+"$"+rs.getString("mobile")+"$"+rs.getString("address");
            }
        } catch (SQLException ex) {
            Logger.getLogger(DBOperations.class.getName()).log(Level.SEVERE, null, ex);
        } finally{
            if(con != null){
                try {
                    con.close();
                } catch (SQLException ex) {
                    Logger.getLogger(DBOperations.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return user;
    }
    
    public boolean updateUserDetails(String name, String email, String mobile, String address) {
        int rows = 0;
        dbcon = new DBConnection();
        con = dbcon.getDBConnection();
        query = "update userdetails set name=?, mobile=?, address=? where email=?";
        try {
            pstmt = con.prepareStatement(query);
            pstmt.setString(1, name);
            pstmt.setString(2, mobile);
            pstmt.setString(3, address);
            pstmt.setString(4, email);
            rows = pstmt.executeUpdate();
            if (rows == 1) {
                return true;
            }
        } catch (SQLException soe) {
            Logger.getLogger(DBOperations.class.getName()).log(Level.SEVERE, null, soe);
        } finally {
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException ex) {
                    Logger.getLogger(DBOperations.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return false;
    }
    
    public void updatePassword(String email, String newPassword){
    
    }
    
    
    public List getBookDetails(){        
        List list_Books = null;
        Book bk = null;
        dbcon = new DBConnection();
        con = dbcon.getDBConnection();
        query =  "select * from bookdetails";
        try {
            pstmt = con.prepareStatement(query);                       
            rs = pstmt.executeQuery();         
            list_Books = new ArrayList<>();
            while(rs.next()){                   
               bk = new Book();
               bk.setId(rs.getInt("id"));
               bk.setName(rs.getString("name"));
               bk.setAuthor(rs.getString("author"));
               bk.setPublisher(rs.getString("publisher"));
               list_Books.add(bk);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DBOperations.class.getName()).log(Level.SEVERE, null, ex);
        } finally{
            if(con != null){
                try {
                    con.close();
                } catch (SQLException ex) {
                    Logger.getLogger(DBOperations.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return list_Books;
    }
    
    
//    public static void main(String[] args) {
//        DBOperations dob = new DBOperations();
//        System.out.println("=="+dob.saveUserDetails("abc", "abc@cdac.in", "1234567890", "hyd", "abc@123"));
//    }
}
