/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author adars
 */
import java.sql.*;
public class JDBCTest {
    public static void main(String args[])throws Exception{
        //1. loadinng the class
        Class.forName("com.mysql.cj.jdbc.Driver");
        
        //2. Establishing the connection
        String url="jdbc:mysql://localhost:3306/sample";
        String uname="root";
        String pwd="root";
        
        Connection con= DriverManager.getConnection(url,uname,pwd);
        
        if(con!=null){
            System.out.println("Connection is established!");
        }else{
            System.out.println("Connection Failed");
        }
        
        //3. Create statement
        Statement st = con.createStatement();
        
        //4.Execute Queries
        String query="Select * from account";
        ResultSet rs= st.executeQuery(query);
        
        //process results
        
        while(rs.next()){
            System.out.println(rs.getInt(1)+" "+rs.getDouble(2)+" "+rs.getString(3));
        }
        
        //5. Close connection
        con.close();
        
        
    }
}
