
package Classes;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


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
}
