package tepigmc.textrpg.world;

import tepigmc.textrpg.entity.Entity;
import tepigmc.util.Grid;
import tepigmc.util.RandomUtils;

public class RoomGeneration {
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
    if (roomTemplate != null) {
      int rows = roomTemplate.rows(), cols = roomTemplate.cols();
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
    }
    return roomTemplate;
  }

  /**
   * Adds a Door to the south side of the Room in the center
   * @param roomTemplate the RoomTemplate to add the Door to
   * @return the modified RoomTemplate
   */
  public static RoomTemplate addDoor(RoomTemplate roomTemplate) {
    if (roomTemplate != null) {
      int rows = roomTemplate.rows(), cols = roomTemplate.cols();
      roomTemplate.set(rows - 1, cols / 2, 'D');
      roomTemplate.put('D', new Door(RoomGenerator.HOUSE));
    }
    return roomTemplate;
  }

  /**
   * Adds an entity to the RoomTemplate at a random position
   * @param roomTemplate the RoomTemplate to modify
   * @return the modified RoomTemplate
   */
  public static RoomTemplate addEntityRandom(RoomTemplate roomTemplate, Entity entity,
      int attempts) {
    if (roomTemplate != null)
      for (int i = 0; i < attempts; i++) {
        Coordinates randomCoordinates = randomCoordinates(roomTemplate);
        if (roomTemplate.getCharacter(randomCoordinates.y(), randomCoordinates.x()) == null) {
          entity.setCoordinates(randomCoordinates);
          roomTemplate.addEntity(entity);
          break;
        }
      }
    return roomTemplate;
  }

  /**
   * Gets random Coordinates inside the room
   * @param roomTemplate the room to find Coordinates in
   * @return the random Coordinates
   */
  private static Coordinates randomCoordinates(RoomTemplate roomTemplate) {
    return new Coordinates(RandomUtils.randInt(0, roomTemplate.cols() - 1),
        RandomUtils.randInt(0, roomTemplate.rows() - 1));
  }
}
