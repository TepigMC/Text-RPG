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
    player = new Player(new Coordinates(2, 2), '\u263A');
    world = new World();
    world.addRoom(new Room(RoomGenerator.HOUSE));
    ui = new TextRpgUI();
    ui.init();
  }

  /**
   * Gets the Room the Player is currently in
   * @return the current Room
   */
  public static Room currentRoom() {
    return world.getRoom(currentRoomId);
  }

  public static void setCurrentRoom(int roomId) {
    currentRoomId = roomId;
  }

  /**
   * Renders the Room currently in view
   * @return the rendered room
   */
  public static String renderCurrentRoom() {
    return currentRoom().render(player);
  }

  /**
   * Sleeps for the given milliseconds
   * @param milli the time to sleep
   */
  public static void sleep(int milli) {
    try {
      Thread.sleep(milli);
    }
    catch (InterruptedException e) {
      e.printStackTrace();
    }
  }
}
