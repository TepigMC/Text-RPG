package tepigmc.textrpg.world;

import tepigmc.textrpg.TextRpg;
import tepigmc.textrpg.entity.Entity;

@Deprecated
public class Door extends Tile {
  private int roomId;

  /**
   * Creates a Door with a RoomGenerator to create the Room
   * @param generator the RoomGenerator to use
   */
  public Door(RoomGenerator generator) {
    super("door", '\u2591', false);
    Room room = new Room(generator);
    this.roomId = room.getId();
    TextRpg.world.addRoom(room);
  }

  /**
   * Gets the id of the Room that this door teleports the Entity to
   * @return the roomId
   */
  public int getRoomId() {
    return this.roomId;
  }

  /**
   * Called whenever an Entity steps onto this Tile
   * @param entity the Entity that moved
   */
  @Override
  public void onEntityStep(Entity entity) {
    System.out.println("Entity stepped onto a Door");
    TextRpg.setCurrentRoom(this.roomId);
  }
}
