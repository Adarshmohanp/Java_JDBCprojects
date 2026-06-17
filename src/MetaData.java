import java.sql.*;
public class MetaData {
    public static void main(String[] args) throws Exception{
        Class.forName("com.mysql.cj.jdbc.Driver");
        String url = "jdbc:mysql://localhost:3306/sample";
        String uname ="root";
        String pwd ="root";
        Connection con = DriverManager.getConnection(url,uname,pwd);
        
        System.out.println("*************Database Meta Data*******************");
        DatabaseMetaData dbmd = con.getMetaData(); // from Connection
        System.out.println(dbmd.getDriverName());
        System.out.println(dbmd.getConnection());
        System.out.println(dbmd.getDatabaseProductName());
        System.out.println(dbmd.getDatabaseProductVersion());
        System.out.println(dbmd.getUserName());
        // get tables from the database
        String[] tables ={"TABLE"};
        ResultSet rs1 = dbmd.getTables(null, null, null, tables); //
        while(rs1.next()){
            System.out.println(rs1.getString(3));
        }
        
        System.out.println("**************ResultSet Meta Data******************");
        
        Statement st = con.createStatement();
        ResultSet rs2 = st.executeQuery("select * from student");
        ResultSetMetaData rsmd = rs2.getMetaData();  // meta data
        System.out.println("No of columns: "+rsmd.getColumnCount());
        
        int i = 1;
        while(i<=rsmd.getColumnCount()){// 3
           // System.out.print("Column name "+i+" : "+rsmd.getColumnName(i));
            System.out.print(rsmd.getColumnName(i)+"\t");
            //System.out.println("Column Type "+i+" : "+rsmd.getColumnTypeName(i));
            i++;
        }
        System.out.println();
        
        while(rs2.next()){
             System.out.print(rs2.getInt(1)+"\t"+rs2.getString(2)+"\t"+rs2.getDouble(3));
             System.out.println();
        }
        con.close();
    }
}
