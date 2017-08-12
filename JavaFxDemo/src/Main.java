import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import java.util.HashMap;


/**
 * Created by Jonathan on 8/1/2017.
 */
public class Main extends Application {

  //When moved over to CodeU 2017 code, the ID would be unqiue
  HashMap<String, User> userLogins = new HashMap<String, User>();

  Stage window;
  TextField nameInput;
  PasswordField passInput;


  public static void main(String[] args) {
    launch(args);
  }

  @Override
  public void start(Stage primaryStage) throws Exception {
    window = primaryStage;
    window.setTitle("Codeatouille Chat App");
    window.setResizable(true);

    GridPane grid = new GridPane();
    grid.setPadding(new Insets(10, 10, 10, 10));
    grid.setVgap(8);
    grid.setHgap(10);

    //Name Label;
    Label nameLabel = new Label("Username:");
    nameLabel.setStyle("-fx-text-fill: #E8E8E8");
    GridPane.setConstraints(nameLabel, 0,0);

    //Name Input
    nameInput = new TextField("");
    nameInput.setPromptText("username");
    GridPane.setConstraints(nameInput, 1, 0);

    //Password Label
    Label passLabel = new Label("Password:");
    GridPane.setConstraints(passLabel, 0, 1);

    //Password Input
    passInput = new PasswordField();
    passInput.setPromptText("password");
    GridPane.setConstraints(passInput, 1, 1);

    //Login
    Button loginButton = new Button("Log In");
    GridPane.setConstraints(loginButton, 1,2);

    Button signUpButton = new Button("Sign Up");
    signUpButton.getStyleClass().add("button-blue");
    GridPane.setConstraints(signUpButton, 1,3);

    final boolean[] properSignUp = {false};
    signUpButton.setOnAction(e -> {
      properSignUp[0] = signUp(nameInput.getText().toString(), passInput.getText().toString());

      //If the user sucessfully signed up. They should be promopted to try to log in with their credentials.
      if(properSignUp[0]){
        //Make a prompt to tell the user to log in
        System.out.println("Try to Log In");
      }
      //A field was left empty! Notify the user
      else {
        System.out.println("Either the User Name or Log In was inncorrect");
      }

    });

    loginButton.setOnAction(e -> {
      signIn(nameInput.getText().toString(), passInput.getText().toString());

    });

    //Add everything to grid
    grid.getChildren().addAll(nameLabel, nameInput, passLabel, passInput, loginButton, signUpButton);

    Scene scene = new Scene(grid, 400, 300);
    scene.getStylesheets().add("Viper.css");
    window.setScene(scene);
    window.show();

  }

  /**
   * Procedure for closing the program
   *
   */
  private void closeProgram(){
    Boolean answer = ConfirmBox.display("Title", "Sure you want to exit?");
    if(answer) {
      window.close();
    }
  }

  private boolean isInt(TextField input, String message){
    try {
      int age = Integer.parseInt(message);
      return true;
    }
    catch (NumberFormatException e){
      System.out.println("Please type a number!");
    }

    //User didn't eneter a number
    return false;
  }

  /** Signs up a user
   *
   * return boolean
   *
   */
  private boolean signUp(String username, String password){

    if(username.length() == 0 || password.length() == 0){
      return  false;
    }

    User user = new User(username, password);
    userLogins.put(username, user);

    //Clear the Username and Password field for user
    nameInput.setText("");
    passInput.setText("");

    AlertBox.display("Sign Up", "You have successfully registered! Try to sign-in! Welcome " + username + "!");

    return true;
  }

  /** Logs in the Users
   *
   * @return boolean
   */
  private void signIn(String username, String password){

    if(username.length() == 0 || password.length() == 0){
      System.out.println("Text is missing out of the username or password field!");
    }

    if(userLogins.get(username) != null) {

      if(userLogins.get(username).getPassword().equals(password)){
        User user = userLogins.get(username);
        System.out.println("Welcome, " + user.getName() + "!");

        //Change to the ConvoMode Scene
        window.close();
        ChatScreen.display();

      }
      else {
        System.out.println("Wrong Password");
        passInput.setText("");
        passInput.setPromptText("Wrong Password!");
      }

    }

  }
}
