package tepigmc.textrpg.managers;

import java.util.ArrayList;
import java.util.List;

import tepigmc.textrpg.TextRpg;

public class TextManager {
  public static List<String> messages = new ArrayList<String>();

  /**
   * Adds a message to the List of messages to be displayed
   * @param message the message to add
   */
  public static void addMessage(String message) {
    messages.add(message);
    TextRpg.ui.displayMessage();
  }

  /**
   * Adds a message to the List of messages to be displayed and logs the error
   * @param message the message to add
   */
  public static void addError(String message) {
    System.err.println(message);
    addMessage(message);
  }

  /**
   * Checks if there are any messages that haven't been displayed
   * @return if there are any messages left
   */
  public static boolean hasNextMessage() {
    return messages.size() > 0;
  }

  /**
   * Gets the next message and removes it from the list
   * @return the next message
   */
  public static String nextMessage() {
    if (!hasNextMessage())
      return null;
    return messages.remove(0);
  }
}
