import java.sql.*;
import java.util.Scanner;
public class PSTDemo {
     public static void main(String[] args) throws Exception { 
        Scanner in = new Scanner(System.in);
        Class.forName("com.mysql.cj.jdbc.Driver");
        String url = "jdbc:mysql://localhost:3306/sample";
        String uname ="root";
        String pwd ="root";
        Connection con = DriverManager.getConnection(url,uname,pwd);
        if(con != null){
            System.out.println("Connection established!");
        }
        else{
            System.out.println("Connection Failed");
        }
        // Prepared Statement - demo 
        String q1 = "insert into student values (?,?,?)";
        
        System.out.println("Enter student details");
        int sid = in.nextInt();
        String sname = in.next();
        double cgpa = in.nextDouble();
        
        PreparedStatement pst = con.prepareStatement(q1);
        // set the placeholders
        pst.setInt(1, sid);
        pst.setString(2, sname);
        pst.setDouble(3, cgpa);
        
        int x = pst.executeUpdate();
        if(x>0)
             System.out.println(x+ " record(s) inserted");
        /*
        pst = con.prepareStatement("update student set sname = ? where sid = ?");
        pst.setString(1, "Jarvis");
        pst.setInt(2, 199);
        int y = pst.executeUpdate();
        if(y>0)
             System.out.println(y+ " record(s) updated");
       */
        ResultSet rs = pst.executeQuery("select * from student");  // just like Statement
         while(rs.next()){
            System.out.println(rs.getInt("sid")+" "+rs.getString("sname")+" "+rs.getDouble("cgpa"));
        }
        
         con.close();
     }
}