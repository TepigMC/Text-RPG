package tepigmc.textrpg.world.generator;

import tepigmc.textrpg.world.RoomLayout;
import tepigmc.textrpg.world.Tiles;

public class RoomGenerator {
  /**
   * Sets the layout in a RoomLayout to be empty
   * @param roomLayout the RoomLayout to empty
   * @return the modified RoomLayout
   */
  public static RoomLayout empty(RoomLayout roomLayout) {
    char[][] layout = roomLayout.getLayout();
    int width = layout[0].length, height = layout.length;
    char empty = ' ';
    for (int r = 0; r < height; r++)
      for (int c = 0; c < width; c++)
        roomLayout.set(r, c, empty);
    roomLayout.put(empty, Tiles.empty);
    return roomLayout;
  }
  
  /**
   * Adds a border around the RoomLayout
   * @param roomLayout the RoomLayout to modify
   * @return the modified RoomLayout
   */
  public static RoomLayout border(RoomLayout roomLayout) {
    char[][] layout = roomLayout.getLayout();
    int width = layout[0].length, height = layout.length;
    char wall = 'x';
    for (int r = 0; r < height; r++) {
      if (r == 0 || r == height - 1) {
        for (int c = 0; c < width; c++)
          roomLayout.set(r, c, wall);
      }
      else {
        roomLayout.set(r, 0, wall);
        roomLayout.set(r, width - 1, wall);
      }
    }
    roomLayout.put(wall, Tiles.wall);
    return roomLayout;
  }
}
