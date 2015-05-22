package tepigmc.textrpg;

import tepigmc.textrpg.entity.Player;
import tepigmc.textrpg.world.Coordinates;
import tepigmc.textrpg.world.Room;
import tepigmc.textrpg.world.RoomGenerator;
import tepigmc.textrpg.world.World;

public class TextRpg {
  public static Player player;
  public static World world;
  public static TextRpgUI ui;
  public static int currentRoomId = 0;

  public static void main(String[] args) {
    setup();
    // while (true)
    loop();
  }

  /**
   * This is called once when the TextRpg starts
   */
  private static void setup() {
    player = new Player(new Coordinates(2, 2), 'P'); // '\u263A'
    world = new World();
    world.addRoom(new Room(RoomGenerator.HOUSE));
    ui = new TextRpgUI();
    ui.init();
    try {
      player.moveRelative(new Coordinates(-1, 1));
    }
    catch (Exception e) {
      e.printStackTrace();
    }
  }

  /**
   * This is repeated infinitely after the setup completes
   */
  private static void loop() {

  }

  /**
   * Gets the Room the Player is currently in
   * @return the current Room
   */
  public static Room currentRoom() {
    return world.getRoom(currentRoomId);
  }

  /**
   * Renders the Room currently in view
   * @return the rendered room
   */
  public static String renderCurrentRoom() {
    return currentRoom().render(player);
  }
}
