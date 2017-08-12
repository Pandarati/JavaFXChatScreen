import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import org.omg.CORBA.OBJ_ADAPTER;

import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Created by Jonathan on 8/10/2017.
 */
public class EmojiChecker {

  private static HBox messageDisplayBox;
  private String message;

  //Emoji Icon Variables
  private static ImageView joyEmoji;
  private static ImageView grinEmoji;
  private static ImageView toungeOutEmoji;
  private static ImageView cryEmoji;
  private static ImageView googleEmoji;


  public EmojiChecker(String message) {
    messageDisplayBox = new HBox();
    this.message = message;
  }

  /**
   * The main method of EmojiChecker that checks for emoji keycodes in the users message!
   * <p>
   * Current KeyCodes:
   * :joy:
   */
  public HBox handleEmojiKeyCodes() {


    //Load in the different format of the Emojis
    loadEmojis();
    if (message.contains(":joy:"))
      addJoyEmoji();
    else if(message.contains(":grin:"))
      addGrinEmoji();
    else if(message.contains(":tounge:"))
      addToungeOutEmoji();
    else if(message.contains(":cry:"))
      addCryEmoji();
    else if(message.contains(":google:"))
      addGoogleEmoji();
    else
      return null;



    return messageDisplayBox;
  }

  /**
   * Loads all of the emojis in the program
   */
  public void loadEmojis() {
    joyEmoji = new ImageView();
    joyEmoji.setImage(new Image("joyEmoji.png"));
    joyEmoji.setFitWidth(30);
    joyEmoji.setFitHeight(30);

    grinEmoji = new ImageView();
    grinEmoji.setImage(new Image("grin_emoji.png"));
    grinEmoji.setFitWidth(30);
    grinEmoji.setFitHeight(30);

    toungeOutEmoji = new ImageView();
    toungeOutEmoji.setImage(new Image("toungeout_emoji.png"));
    toungeOutEmoji.setFitWidth(30);
    toungeOutEmoji.setFitHeight(30);

    cryEmoji = new ImageView();
    cryEmoji.setImage(new Image("cry_emoji.png"));
    cryEmoji.setFitWidth(30);
    cryEmoji.setFitHeight(30);

    googleEmoji = new ImageView();
    googleEmoji.setImage(new Image("google_emoji.png"));
    googleEmoji.setFitWidth(30);
    googleEmoji.setFitHeight(30);


  }

  /**
   * Code for parsing in Joy Emoji
   */
  private void addJoyEmoji() {

    String keyCodeJoy = ":joy:";

    System.out.println("Add Emoji Method Ran!");

    //For when the user is just adding an emoji alone
    if (this.message.equals(keyCodeJoy))
      messageDisplayBox.getChildren().add(joyEmoji);

    //Split message
    String[] splitMessage = this.message.split(keyCodeJoy);
    ArrayList<HBox> results = new ArrayList<HBox>();

    for(int i = 0; i < splitMessage.length; i++){
      messageDisplayBox.getChildren().add(new Label("Jonathan: " + splitMessage[i]));
      messageDisplayBox.getChildren().add(joyEmoji);

    }
  }

  /**
   * Code for parsing in Joy Emoji
   */
  private void addGrinEmoji() {

    String keyCodeJoy = ":grin:";

    System.out.println("Add Emoji Method Ran!");

    //For when the user is just adding an emoji alone
    if (this.message.equals(keyCodeJoy))
      messageDisplayBox.getChildren().add(grinEmoji);

    //Split message
    String[] splitMessage = this.message.split(keyCodeJoy);
    ArrayList<HBox> results = new ArrayList<HBox>();

    for(int i = 0; i < splitMessage.length; i++){
      messageDisplayBox.getChildren().add(new Label("Jonathan: " + splitMessage[i]));
      messageDisplayBox.getChildren().add(grinEmoji);

    }
  }

  private void addToungeOutEmoji() {

    String keyCodeJoy = ":tounge:";

    System.out.println("Add Emoji Method Ran!");

    //For when the user is just adding an emoji alone
    if (this.message.equals(keyCodeJoy))
      messageDisplayBox.getChildren().add(toungeOutEmoji);

    //Split message
    String[] splitMessage = this.message.split(keyCodeJoy);
    ArrayList<HBox> results = new ArrayList<HBox>();

    for(int i = 0; i < splitMessage.length; i++){
      messageDisplayBox.getChildren().add(new Label("Jonathan: " + splitMessage[i]));
      messageDisplayBox.getChildren().add(toungeOutEmoji);

    }
  }

  private void addCryEmoji() {

    String keyCodeJoy = ":cry:";

    System.out.println("Add Emoji Method Ran!");

    //For when the user is just adding an emoji alone
    if (this.message.equals(keyCodeJoy))
      messageDisplayBox.getChildren().add(cryEmoji);

    //Split message
    String[] splitMessage = this.message.split(keyCodeJoy);
    ArrayList<HBox> results = new ArrayList<HBox>();

    for(int i = 0; i < splitMessage.length; i++){
      messageDisplayBox.getChildren().add(new Label("Jonathan: " + splitMessage[i]));
      messageDisplayBox.getChildren().add(cryEmoji);

    }
  }

  private void addGoogleEmoji() {

    String keyCodeJoy = ":google:";

    System.out.println("Add Emoji Method Ran!");

    //For when the user is just adding an emoji alone
    if (this.message.equals(keyCodeJoy))
      messageDisplayBox.getChildren().add(googleEmoji);

    //Split message
    String[] splitMessage = this.message.split(keyCodeJoy);
    ArrayList<HBox> results = new ArrayList<HBox>();

    for(int i = 0; i < splitMessage.length; i++){
      messageDisplayBox.getChildren().add(new Label("Jonathan: " + splitMessage[i]));
      messageDisplayBox.getChildren().add(googleEmoji);

    }
  }

}

