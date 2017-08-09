import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**Pop up for Root Commands
 * Displays them as buttons.
 * Created by Jonathan on 8/8/2017.
 */
public class MessagingMode {

  //Access Control Commands:
  private static Label accessCtrlCommands = new Label("Access Control Commands: ");
  private static Button addMember = new Button("Add a member to the conversation");
  private static Button addOwner = new Button("Add a owner to the conversation");

  //General Commands:
  private static Label generalCommands = new Label("General Commands: ");
  private static Button goBackAScene = new Button("Go Back a Scene");
  private static Button exitProgram = new Button("Exit Program");


  public static void display(){
    Stage window = new Stage();

    window.initModality(Modality.APPLICATION_MODAL);
    window.setTitle("ROOT MODE");
    window.setMinWidth(250);
    window.setResizable(false);

    VBox commandWindow = new VBox();
    accessCtrlCommands.setFont(new Font("Arial", 15));
    generalCommands.setFont(new Font("Arial", 15));
    commandWindow.setPadding(new Insets(10,10, 10, 10));
    commandWindow.getChildren().addAll(accessCtrlCommands, addMember, addOwner, generalCommands, goBackAScene, exitProgram);
    
    Scene scene = new Scene(commandWindow, 300, 250);
    window.setScene(scene);
    commandWindow.getStylesheets().add("Viper.css");
    window.showAndWait();
  }

}
