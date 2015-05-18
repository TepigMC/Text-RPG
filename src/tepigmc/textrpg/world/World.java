package tepigmc.textrpg.world;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class World {
  private Map<Integer, Room> rooms;

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
   * Gets the rooms Map
   * @return the rooms
   */
  public Map<Integer, Room> getRooms() {
    return this.rooms;
  }

  /**
   * Gets the Room with the given id
   * @param key the unique id of the Room
   * @return the Room with the matching id
   */
  public Room getRoom(int key) {
    return this.rooms.get(key);
  }

  /**
   * Adds a room to the World
   * @param room the Room to add
   */
  public void addRoom(Room room) {
    this.rooms.put(room.getId(), room);
  }
}
