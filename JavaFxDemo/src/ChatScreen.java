import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * Created by Jonathan on 8/6/2017.
 */
public class ChatScreen {

  public static void display(){
    Stage window = new Stage();
    window.setTitle("Chat Screen");

    VBox layout = new VBox();
    Scene chatScreen = new Scene(layout, 300, 200);
    window.setScene(chatScreen);

  }

}
