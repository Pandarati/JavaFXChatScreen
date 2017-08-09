import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**Pop up for Root Commands
 * Displays them as buttons.
 * Created by Jonathan on 8/8/2017.
 */
public class ConvoMode {

  //Conversation Commands:
  private static Label convoCommands = new Label("Conversation Commands: ");
  private static Button cList = new Button("List Conversations");
  private static Button cAdd = new Button("Add Conversation");
  private static Button cJoin = new Button("Join Conversation");


  //Interest Commands:
  private static Label interestCommands = new Label("Interest Commands: ");
  private static Button userIAdd = new Button("Add User Interest");
  private static Button userIRemove = new Button("Remove User Interest");
  private static Button convIAdd = new Button("Add Conversation Interest ");
  private static  Button convIRemove = new Button("Remove Conversation Interest");
  private static Button statusUpdate = new Button("Get a status update on your interest");


  public static void display(){
    Stage window = new Stage();

    window.initModality(Modality.APPLICATION_MODAL);
    window.setTitle("ROOT MODE");
    window.setMinWidth(250);
    window.setResizable(false);

    VBox commandWindow = new VBox();
    convoCommands.setFont(new Font("Arial", 15));
    interestCommands.setFont(new Font("Arial", 15));
    commandWindow.setPadding(new Insets(10,10, 10, 10));
    commandWindow.getChildren().addAll(convoCommands, cList, cAdd, cJoin,interestCommands, userIAdd, userIRemove, convIAdd, convIRemove, statusUpdate);

    Scene scene = new Scene(commandWindow, 300, 250);
    window.setScene(scene);
    commandWindow.getStylesheets().add("Viper.css");
    window.showAndWait();
  }

}
