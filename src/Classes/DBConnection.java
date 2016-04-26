
package Classes;

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class DBConnection 
{
   private  final String db = "Sales";
   private final String  login = "root";
   private final  String password = "";
   private final  String url = "jdbc:mysql://localhost/" + db;
   private  Connection  connection = null;
   
   public  DBConnection()
   {
       try 
       {
           Class.forName("com.mysql.jdbc.Driver");
           this.connection = (Connection) DriverManager.getConnection(url, login, password);
       }
       catch (ClassNotFoundException | SQLException  ex) 
       {
           Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
       }
   }
   
  public  Connection getConnection()
  {
      return this.connection;
  }
  
  public  void CloseConecction()
  {
      this.connection = null;
  }
   
}
