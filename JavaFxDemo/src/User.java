/**
 * Created by Jonathan on 8/6/2017.
 */
public class User {

  private String name;
  private String password;

  public User(String name, String password){
    this.name = name;
    this.password = password;
  }

  public String getName(){
    return this.name;
  }

  public String getPassword() {return this.password; }

}

