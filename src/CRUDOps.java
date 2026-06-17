import java.sql.*;

public class CRUDOps {
     public static void main(String[] args) throws Exception { 
        //1. Loading drivers
        Class.forName("com.mysql.cj.jdbc.Driver");
        //2. Establishing the connection
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
        //3. Create Statement
        Statement st = con.createStatement();
        
        //4. CRUD Operations

        //insert
        String iq = "insert into student values(123,'Sara',7.5),(122,'Janes',8.1),(105,'Divas',8.3)";
        int x = st.executeUpdate(iq);
        if(x>0){
            System.out.println(x+" records inserted");
        }
        // update
        String uq ="update student set sname='John' where sid = 111";
        int y =st.executeUpdate(uq);
        if(y>0){
            System.out.println(y+ " record(s)are updated");
        }
        //delete
        String dq = "delete from student where cgpa <=7.5";
        int z = st.executeUpdate(dq);
        if(x>0){
            System.out.println(z+" records deleted");
        }
        //read or retrieve
        ResultSet rs = st.executeQuery("select * from student");
         System.out.println("Student Details:");
        while(rs.next()){
            System.out.println(rs.getInt("sid")+" "+rs.getString("sname")+" "+rs.getDouble(3));
        }
        //5. close the connection
        con.close();
    }
}
