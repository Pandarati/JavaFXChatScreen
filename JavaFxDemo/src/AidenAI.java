import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

import java.util.ArrayList;
import java.util.regex.*;

/**This is the code the helper AI Aiden. He is only on the ClientSide, and he's specific to each user.
 *
 * Created by Jonathan on 8/10/2017.
 */
public class AidenAI {


  //Code that handles the main display of the user!
  private VBox mainChatMiddle;
  private final String NAME_TITLE = "AIDEN";

  /**
   * A specific user interacts with Aiden
   * @param mainChatMiddle
   */
  public AidenAI(VBox mainChatMiddle){
    this.mainChatMiddle = mainChatMiddle;
  }

  //Aiden's Welcome Message
  public void welcomeMessage(){
    Label msg1 = new Label("Welcome to the beta version of the Codeatouille App!");
    Label msg2 = new Label("Click the \"?\" for more options!");
    Label msg3 = new Label("My name is AIDEN! I am here to assist you! Ask em questions or type commands to me!");
    Label msg4 = new Label("Aiden has been succesfully configured!");

    msg1.getStyleClass().add("aiden-text");
    msg2.getStyleClass().add("aiden-text");
    msg3.getStyleClass().add("aiden-text");
    msg4.getStyleClass().add("aiden-text");


    this.mainChatMiddle.getChildren().addAll(msg1, msg2, msg3, msg4);
  }


  public void checkMessage(String message){


    //Lowercase the users message for easier interpretation and checks
    message = message.toLowerCase();
    switch (message){
      case "hi":
      case "hey":
      case "hello":
      case "sup":
      case "howdy":
        Label hi = new Label(NAME_TITLE + ": " + loadGreetings());
        hi.getStyleClass().add("aiden-text");
        mainChatMiddle.getChildren().add(hi);
        break;
      case "help":

        loadHelpCommands();
        break;
      case "how are you?":
      case "how are you":
        Label howAreYou = new Label(NAME_TITLE + ": " + loadHowAreYou());
        howAreYou.getStyleClass().add("aiden-text");
        mainChatMiddle.getChildren().add(howAreYou);

    }

  }

  private String loadGreetings(){
    //Generate A Random Number 1-5
    //Min + (int)(Math.random() * ((Max - Min) + 1))
    int randomNum = 1 + (int)(Math.random() * ((5 - 1) + 1));

    ArrayList<String> msgs = new ArrayList<String>();
    msgs.add("Howdy!");
    msgs.add("Hello!");
    msgs.add("Hi There!");
    msgs.add("Greetings and Humble Salutations!");
    msgs.add("Olah!");

    return msgs.get(randomNum);
  }

  private String loadHowAreYou(){

    //Generate A Random Number 1-5
    //Min + (int)(Math.random() * ((Max - Min) + 1))
    int randomNum = 1 + (int)(Math.random() * ((5 - 1) + 1));

    ArrayList<String> msgs = new ArrayList<String>();
    msgs.add("My systems seem in check!");
    msgs.add("I'm feeling spectacular. Thanks for asking!");
    msgs.add("Well!");
    msgs.add("Best I've ever been!");
    msgs.add("As that Tiger guy says it, I'mmmm Greeeeat!");

    return msgs.get(randomNum);
  }

  private void loadHelpCommands(){
    mainChatMiddle.getChildren().add(new Label(""));
    mainChatMiddle.getChildren().add(new Label("-----------------------------------------------------------------------------------------"));
    mainChatMiddle.getChildren().add(new Label(""));
    mainChatMiddle.getChildren().add(new Label("Conversation Commands: "));
    mainChatMiddle.getChildren().add(new Label("  c-list"));
    mainChatMiddle.getChildren().add(new Label("    List all conversations that the current user can interact with."));
    mainChatMiddle.getChildren().add(new Label("  c-add <title>"));
    mainChatMiddle.getChildren().add(new Label("     Add a new conversation with the given title and join it as the current user"));
    mainChatMiddle.getChildren().add(new Label("  c-join <title>"));
    mainChatMiddle.getChildren().add(new Label("    Join the conversation as the current user."));
    mainChatMiddle.getChildren().add(new Label(""));
    mainChatMiddle.getChildren().add(new Label("Interest Commands: "));
    mainChatMiddle.getChildren().add(new Label("  userI-add <name>"));
    mainChatMiddle.getChildren().add(new Label("    Add a new interest ina given user and follow their activity."));
    mainChatMiddle.getChildren().add(new Label("  userI-remove <name>"));
    mainChatMiddle.getChildren().add(new Label("    Remove a user interest to stop follow his or her activity."));
    mainChatMiddle.getChildren().add(new Label("  convI-remove <title>"));
    mainChatMiddle.getChildren().add(new Label("    Remove an existing interest in a given conversation title and stop following its activity."));
    mainChatMiddle.getChildren().add(new Label("  status-update"));
    mainChatMiddle.getChildren().add(new Label("    Get a status update on a user and their activity."));
    mainChatMiddle.getChildren().add(new Label(""));
    mainChatMiddle.getChildren().add(new Label("Access Control Commands: "));
    mainChatMiddle.getChildren().add(new Label(""));
    mainChatMiddle.getChildren().add(new Label("General Commands: "));
    mainChatMiddle.getChildren().add(new Label("  info"));
    mainChatMiddle.getChildren().add(new Label("    Display all info for the current user"));
    mainChatMiddle.getChildren().add(new Label("  back"));
    mainChatMiddle.getChildren().add(new Label("    Go back to ROOT MODE."));
    mainChatMiddle.getChildren().add(new Label("  exit"));
    mainChatMiddle.getChildren().add(new Label("    Exit the program."));
  }

}
