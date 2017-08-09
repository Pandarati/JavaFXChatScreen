import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import sun.plugin2.message.Message;


/**
 * Created by Jonathan on 8/6/2017.
 */
public class ChatScreen {

  private static Stage window;
  private static TextField userInput;
  private static VBox mainChatMiddle;
  private static ScrollPane scrollPane;

  public static void display(){
    window = new Stage();
    window.setTitle("Chat Screen");
    createScreen();


    //Chat Typing TextField

  }

  //Generates the ChatScreen for the user
  private static void createScreen(){
    window.setMinWidth(250);

    //MainChat Screen Layout
    mainChatMiddle = new VBox();
    mainChatMiddle.setStyle("-fx-font-color: blue");

    Label msg1 = new Label("Welcome to the beta version of the Codatouille App!");
    Label msg2 = new Label("Click the \"?\" for more options! ");


    mainChatMiddle.getChildren().addAll(msg1, msg2);

    scrollPane = new ScrollPane();
    scrollPane.setContent(mainChatMiddle);
    scrollPane.setStyle("-fx-background: #383838; -fx-text-fill:yellow;");
    //sp.setStyle("-fx-text-fill:yellow;");


    //Submit and type messages screen
    HBox messageInputBottom = new HBox();
    userInput = new TextField();
    userInput.setAlignment(Pos.CENTER_LEFT);
    Button submitButton = new Button("Submit");
    messageInputBottom.getChildren().addAll(userInput, submitButton);
    messageInputBottom.setAlignment(Pos.CENTER);

    //Add Listener to Submitting messages
    //Adds to Buttons & Adds if the user pressed ENTER
    submitButton.setOnAction(e -> submitMessage());
    userInput.setOnKeyPressed(
            event -> {
              if(event.getCode() == KeyCode.ENTER)
                submitMessage();
            }
    );

    //CommandButton(Let's the user click the commands they want instead of always typing them)
    Button helpButton = new Button(" ? ");
    helpButton.getStyleClass().add("button-blue");
    messageInputBottom.getChildren().add(helpButton);

    //Commands Button On-click
    helpButton.setOnAction(e -> ConvoMode.display());

    //MASTER LAYOUT: Combines little pieces of layout together
    BorderPane masterLayout = new BorderPane();
    masterLayout.setCenter(scrollPane);
    masterLayout.setBottom(messageInputBottom);

    Scene chatScreen = new Scene(masterLayout, 300, 200);
    chatScreen.getStylesheets().add("Viper.css");
    window.setScene(chatScreen);

    window.show();
  }


  /**
   * Submits the user message that is typed in the UserInput field
   */
  private static void submitMessage() {
    String message = userInput.getText().toString();

    if(message.equals(""))
      return;

    mainChatMiddle.getChildren().add(new Label("Jonathan: "  + message));
    userInput.setText("");

    //Find a way to get ScrollPane to shift down all the way
    scrollPane.setVvalue(1);
  }

}