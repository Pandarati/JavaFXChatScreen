import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

/** Code that handles LOG IN INFO
 * Created by Jonathan on 8/3/2017.
 */
public class Login extends Application {

  Stage window;
  Button button;

  public static void main(String[] args) {
    launch(args);
  }

  @Override
  public void start(Stage primaryStage) throws Exception {
    window = primaryStage;
    window.setTitle("Codeatouille Chat App");
    window.setResizable(true);

    GridPane grid = new GridPane();
    grid.setPadding(new Insets(10, 10, 10 ,10));
    grid.setVgap(8);
    grid.setHgap(8);

    //Name Label
    Label nameLabel = new Label("Username: ");
    GridPane.setConstraints(nameLabel, 0, 0);


    //Name input
    TextField nameInput = new TextField("");
    nameInput.setPromptText("username");
    GridPane.setConstraints(nameInput, 1,0);


    //Name Label
    Label passLabel = new Label("Password: ");
    GridPane.setConstraints(passLabel, 0, 1);

    //Password input
    TextField passInput = new TextField();
    passInput.setPromptText("password");
    GridPane.setConstraints(passInput, 1, 1);

    //Login Button
    Button loginButton = new Button("Log In");
    GridPane.setConstraints(loginButton, 1, 2);

    grid.getChildren().addAll(nameLabel, nameInput, passLabel, passInput, loginButton);

    Scene scene = new Scene(grid, 300, 200);
    window.setScene(scene);

    //window.show();
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

}