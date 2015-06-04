package tepigmc.textrpg.world;

public class Exit {
  private Coordinates orginCoordinates;
  private int roomId;
  private int entranceId;

  /**
   * Creates an Exit
   * @param orginCoordinates the Coordinates to teleport from
   * @param roomId the id of the Room to teleport to
   * @param entrance the Entrance to teleport to in the Room
   */
  public Exit(Coordinates orginCoordinates, int roomId, int entranceId) {
    setOrginCoordinates(orginCoordinates);
    setRoomId(roomId);
    setEntranceId(entranceId);
  }

  /**
   * Gets the Coordinates from which the Player is teleported from
   * @return the orginCoordinates
   */
  public Coordinates getOrginCoordinates() {
    return this.orginCoordinates;
  }

  /**
   * Gets the Room id to be teleported to
   * @return the roomId
   */
  public int getRoomId() {
    return roomId;
  }

  /**
   * Gets the id of the Exit to be teleported to
   * @return the entranceId
   */
  public int getEntranceId() {
    return entranceId;
  }

  /**
   * Sets the orgin Coordinates to the given value
   * @param orginCoordinates the orginCoordinates to set
   */
  public void setOrginCoordinates(Coordinates orginCoordinates) {
    this.orginCoordinates = orginCoordinates;
  }

  /**
   * Sets the Room id to the given value
   * @param roomId the roomId to set
   */
  public void setRoomId(int roomId) {
    this.roomId = roomId;
  }

  /**
   * Sets the id of the Exit to be teleported to
   * @param entranceId the entranceId to set
   */
  public void setEntranceId(int entranceId) {
    this.entranceId = entranceId;
  }
}
