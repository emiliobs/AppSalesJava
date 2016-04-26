
package Classes;


public class User
{
   //Atributos de la tabla User:
    protected String Email;
    protected  String FirstName;
    protected  String LastName;
    protected  String Password;
    protected  int RolId;
    
    public User(String Email, String FirstName, String LastName, String Password, int RolId) {
        this.Email = Email;
        this.FirstName = FirstName;
        this.LastName = LastName;
        this.Password = Password;
        this.RolId = RolId;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String FirstName) {
        this.FirstName = FirstName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String LastName) {
        this.LastName = LastName;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }

    public int getRolId() {
        return RolId;
    }

    public void setRolId(int RolId) {
        this.RolId = RolId;
    }

    
    
    
}
