
package librarymanagementsystem;
import java.sql.*;
import java.util.*;
public class Author {
    private Connection connection;
    
    public Author(Connection connection){
        this.connection=connection;
    }
    
    //create operation for authors
    public void addAuthor(String name){
        try{
            String sql="Insert into authors (name) values (?)";
            PreparedStatement statement=connection.prepareStatement(sql);
            statement.setString(1,name);
            statement.executeUpdate();
            statement.close();
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
    
    //update operation for author
    public void updateAuthor(int id,String newName){
        try{
            String sql="Update authors set name=? where id=?";
            PreparedStatement statement=connection.prepareStatement(sql);
            statement.setString(1,newName);
            statement.setInt(2,id);
            statement.executeUpdate();
            statement.close();
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
    
    //delete operation for authors
    
    public void deleteAuthor(int id){
        try{
            String sql="delete from authors where id=?";
            PreparedStatement statement=connection.prepareStatement(sql);
            statement.setInt(1, id);
            statement.executeUpdate();
            statement.close();
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
    
    //read operation for authors
    public List<String> getAllAuthors(){
        List<String> authors=new ArrayList<>();
        try{
            String sql="select * from authors";
            Statement statement = connection.createStatement();
            ResultSet resultSet=statement.executeQuery(sql);
            while(resultSet.next()){
                int id=resultSet.getInt("id");
                String name=resultSet.getString("name");
                authors.add("Author ID: "+id+", Name: "+name);
            }
            resultSet.close();
            statement.close();
        }catch(SQLException e){
            e.printStackTrace();
        }
        return authors;
    }
}
