package tepigmc.textrpg;

public class TextRpgUI {
  /**
   * Creates a user interface for the game
   */
  public static void init() {
    // TODO create UI
    refresh();
  }

  /**
   * Refreshes the data in the user interface; Called whenever an event in the
   * EventManager fires
   */
  public static void refresh() {
    // TODO refresh UI
    System.out.println(TextRpg.renderCurrentRoom());
  }
}
