import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.concurrent.TimeUnit;

/**
 * Created by Jonathan on 8/6/2017.
 */
public class ChatScreen {

  private static Stage window;
  private static TextField userInput;
  private static VBox mainChatMiddle;
  private static ScrollPane scrollPane;
  private static AidenAI ai;
  private static boolean aidenResponseMode;

  public static void display(){
    window = new Stage();
    window.setTitle("Chat Screen");
    createScreen();

    //Code for the AIDEN AI
    startAiden(mainChatMiddle);


  }

  private static void startAiden(VBox mainChatMiddle){
    ai = new AidenAI(mainChatMiddle);
    aidenResponseMode = true;
    ai.welcomeMessage();
  }



  //Generates the ChatScreen for the user
  private static void createScreen(){
    window.setMinWidth(250);

    //MainChat Screen Layout
    mainChatMiddle = new VBox();
    mainChatMiddle.setStyle("-fx-font-color: blue");
    mainChatMiddle.getStyleClass().add("mainchat");

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
   * (every time we add to mainChatMiddle[VBox] we call this method)
   */
  private static void submitMessage() {
    String message = userInput.getText().toString();

    if(message.equals(""))
      return;

    EmojiChecker emojiChecker = new EmojiChecker(message);
    HBox formatMessage = emojiChecker.handleEmojiKeyCodes();

    if(formatMessage == null) {
      mainChatMiddle.getChildren().addAll(new Label("Jonathan: " + message));
    }
    else {
      mainChatMiddle.getChildren().addAll(formatMessage);
    }
    userInput.setText("");
    //Find a way to get ScrollPane to shift down all the way
    scrollPane.setVvalue(1);

    //Let Aiden view messages before submission
    if(aidenResponseMode) {
      ai.checkMessage(message);
      //Scoll needs to be reset after Aiden SPEAKS
      scrollPane.setVvalue(1);
    }



  }

}