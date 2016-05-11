
package Classes;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class UserDAO 
{
    //Método Logiar el usuario:
    //si usuario y password es  valido devuelve un objeto de la tabla user de lo contrario devuelve un null:
    public static User login(String email, String password)
    {
        DBConnection db = new DBConnection();
        
        try 
        {
            PreparedStatement query = db.getConnection().prepareStatement("Select * From User Where Email = ? And Password = ?");
            
            query.setString(1, email);
            query.setString(2, password);
            
            ResultSet result = query.executeQuery();
            
            //result devuelve un objeto de la clase user:
            if (!result.next())
            {
                return null;
            }
            
            User user = new User
            (
                   result.getString("Email"), 
                   result.getString("FirstName"), 
                   result.getString("LastName"), 
                   result.getString("Password"), 
                   result.getInt("RolId")
            );
            
            return user;
            
        } 
        catch (SQLException ex) 
        {
          return null;
        }   
        
                
    }
    
   public  static  Response Create(User user)
   {
       DBConnection con = new DBConnection();
       
       //INSERT INTO user(Email, FirstName, LastName, Password, RolId) VALUES (?,?,?,?,?)
       
       try 
       {
           String sql = "INSERT INTO user(Email, FirstName, LastName, Password, RolId) VALUES (?,?,?,?,?)";
           
           PreparedStatement query = con.getConnection().prepareStatement(sql);
           query.setString(1, user.getEmail());
           query.setString(2, user.getFirstName());
           query.setString(3, user.getLastName());
           query.setString(4, user.getPassword());
           query.setInt(5, user.getRolId());
           
           query.executeLargeUpdate();
           
           con.CloseConecction();
           
           return  new Response (true);
           
       } 
       catch (Exception e) 
       {
           con.CloseConecction();
           return  new Response(e.getMessage());
       }      
      
   }
   
   public  static  Response Update(User user)
   {
       DBConnection con = new DBConnection();
       
       try 
       {
           String sql = "UPDATE user SET FirstName=?,LastName=?,Password=?,RolId=? WHERE Email=?";
           
           PreparedStatement query = con.getConnection().prepareStatement(sql);
           query.setString(1, user.getFirstName());
           query.setString(2, user.getLastName());
           query.setString(3, user.getPassword());
           query.setInt(4, user.getRolId());
           query.setString(5, user.getEmail());
           
           query.executeUpdate();
           
           con.CloseConecction();
           
           return new Response(true);
                   
       } 
       catch (Exception e) 
       {
           con.CloseConecction();
           return new Response(e.getMessage());
       }
   }
   
   public  static  Response Delete(String email)
   {
       DBConnection con = new DBConnection();
       
       try 
       {
           String sql = "DELETE FROM user WHERE Email = ?";
           PreparedStatement query = con.getConnection().prepareStatement(sql);
           query.setString(1, email);
           query.executeUpdate();
           
           con.CloseConecction();
           
           return  new Response(true);
       }
       catch (Exception e)
       {
           con.CloseConecction();
           return new Response(e.getMessage());
       }
   }
   
   public  static  ArrayList<User> get()
   {
       DBConnection con = new DBConnection();
       
       try 
       {
           ArrayList<User> users = new ArrayList<>();
           String sql = "Select * form User";
           PreparedStatement query = con.getConnection().prepareStatement(sql);
           
           ResultSet result = query.executeQuery();
           
           while(result.next())
           {
               User user = new User
                (
                        result.getString("Email"),
                        result.getString("FirstName"),
                        result.getString("LastName"),
                        result.getString("Password"),
                        result.getInt("RolId")
                );
               
               users.add(user);
           }
           
           con.CloseConecction();
           return users;
           
       } 
       catch (Exception e)
       {
           con.CloseConecction();
           return null;
       }
   }
}
