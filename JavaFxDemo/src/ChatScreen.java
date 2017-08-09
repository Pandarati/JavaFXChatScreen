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

  public static void display(String title){
    window = new Stage();
    createScreen(title);


    //Chat Typing TextField

  }

  //Generates the ChatScreen for the user
  private static void createScreen(String title){

    window.setTitle("Chat Screen");
    window.setTitle(title);
    window.setMinWidth(250);

    //MainChat Screen Layout
    mainChatMiddle = new VBox();
    mainChatMiddle.setStyle("-fx-font-color: blue");

    Label msg1 = new Label("Jonathan: Hi there!");
    Label msg2 = new Label("Jonathan: Hi there!");
    Label msg3 = new Label("Jonathan: Hi there!");
    Label msg4 = new Label("Jonathan: Hi there!");
    Label msg5 = new Label("Jonathan: Hi there!");
    Label msg6 = new Label("Jonathan: Hi there!");
    Label msg7 = new Label("Jonathan: Hi there!");
    Label msg8 = new Label("Jonathan: Hi there!");
    Label msg9 = new Label("Jonathan: Hi there!");
    Label msg10 = new Label("Jonathan: Hi there!");
    Label msg11 = new Label("Jonathan: Hi there!");
    Label msg12 = new Label("Jonathan: Hi there!");
    Label msg13 = new Label("Jonathan: Hi there!");
    Label msg14 = new Label("Jonathan: Hi there!");
    Label msg15 = new Label("Jonathan: Hi there!");
    Label msg16 = new Label("Jonathan: Hi GOO!");


    mainChatMiddle.getChildren().addAll(msg1, msg2, msg3,msg4, msg5, msg6,msg7 ,msg8 ,msg9 ,msg10,msg11 ,msg12 ,msg13 ,msg14 ,msg15, msg16);

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
    Button commandsButton = new Button(" ? ");
    commandsButton.getStyleClass().add("button-blue");
    messageInputBottom.getChildren().add(commandsButton);

    //Commands Button On-click
    commandsButton.setOnAction(e -> MessagingMode.display());

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