package tepigmc.textrpg.world;

import java.util.HashMap;
import java.util.List;

public class World {
  private HashMap<Integer, Room> rooms;
  
  /**
   * Creates a new empty World
   */
  public World() {
    this.rooms = new HashMap<Integer, Room>();
  }
  
  /**
   * Creates a World with given rooms
   * @param rooms the rooms to add to the World
   */
  public World(List<Room> rooms) {
    this();
    for (Room room : rooms)
      addRoom(room);
  }
  
  /**
   * Adds a room to the World
   * @param room the Room to add
   */
  public void addRoom(Room room) {
    this.rooms.put(room.getId(), room);
  }
}
