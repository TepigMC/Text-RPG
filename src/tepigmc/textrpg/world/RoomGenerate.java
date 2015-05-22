package tepigmc.textrpg.world;

import tepigmc.util.Grid;

public class RoomGenerate {
  /**
   * Sets the grid in a RoomTemplate to be empty
   * @param roomTemplate the RoomTemplate to empty
   * @return the modified RoomTemplate
   */
  public static RoomTemplate empty(RoomTemplate roomTemplate) {
    Grid<Character> grid = roomTemplate.getGrid();
    char emptyChar = ' ';
    grid.setAll(emptyChar);
    roomTemplate.put(emptyChar, Tiles.empty);
    return roomTemplate;
  }

  /**
   * Adds a border around the RoomTemplate
   * @param roomTemplate the RoomTemplate to modify
   * @return the modified RoomTemplate
   */
  public static RoomTemplate border(RoomTemplate roomTemplate) {
    Grid<Character> grid = roomTemplate.getGrid();
    int rows = grid.rows(), cols = grid.cols();
    char wall = 'x';
    for (int r = 0; r < rows; r++) {
      if (r == 0 || r == rows - 1) {
        for (int c = 0; c < cols; c++)
          roomTemplate.set(r, c, wall);
      }
      else {
        roomTemplate.set(r, 0, wall);
        roomTemplate.set(r, cols - 1, wall);
      }
    }
    roomTemplate.put(wall, Tiles.wall);
    return roomTemplate;
  }
}
