package com.login;
import java.sql.*;

public class Validate
 {
     public static boolean checkUser(String email,String pass) 
     {
      boolean st =false;
      try{

	 //loading drivers for mysql
         Class.forName("com.mysql.jdbc.Driver");
 	 //creating connection with the database 
         Connection con=DriverManager.getConnection("jdbc:mysql://localhost/scv","root","");
         PreparedStatement ps =con.prepareStatement("select * from secretaria where email=? and senha=?");
         ps.setString(1, email);
         ps.setString(2, pass);
         ResultSet rs =ps.executeQuery();
         st = rs.next();
        
      }catch(Exception e)
      {
          e.printStackTrace();
      }
         return st;                 
  }   
}