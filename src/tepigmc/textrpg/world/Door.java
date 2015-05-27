package tepigmc.textrpg.world;

import tepigmc.textrpg.TextRpg;

public class Door extends Tile {
  private int roomId;

  public Door(RoomGenerator generator) {
    super("door", '\u2591', false);
    Room room = new Room(generator);
    this.roomId = room.getId();
    TextRpg.world.addRoom(room);
  }

  public int getRoomId() {
    return this.roomId;
  }
}
