package tepigmc.textrpg.world;

public class Exit {
  private Coordinates orginCoordinates;
  private Coordinates newCoordinates;
  private int roomId;

  /**
   * Creates an Exit
   * @param orginCoordinates the Coordinates to teleport from
   * @param newCoordinates the Coordinates in the other Room to teleport to
   * @param roomId the id of the Room to teleport to
   */
  public Exit(Coordinates orginCoordinates, Coordinates newCoordinates, int roomId) {
    setOrginCoordinates(orginCoordinates);
    setNewCoordinates(newCoordinates);
    setRoomId(roomId);
  }

  /**
   * Gets the Coordinates from which the Player is teleported from
   * @return the orginCoordinates
   */
  public Coordinates getOrginCoordinates() {
    return this.orginCoordinates;
  }

  /**
   * Gets the Coordinates that the Player is teleported to in the other room
   * @return the newCoordinates
   */
  public Coordinates getNewCoordinates() {
    return this.newCoordinates;
  }

  /**
   * Gets the Room id to be teleported to
   * @return the roomId
   */
  public int getRoomId() {
    return roomId;
  }

  /**
   * Sets the orgin Coordinates to the given value
   * @param orginCoordinates the orginCoordinates to set
   */
  public void setOrginCoordinates(Coordinates orginCoordinates) {
    this.orginCoordinates = orginCoordinates;
  }

  /**
   * Sets the new Coordinates to the given value
   * @param newCoordinates the newCoordinates to set
   */
  public void setNewCoordinates(Coordinates newCoordinates) {
    this.newCoordinates = newCoordinates;
  }

  /**
   * Sets the Room id to the given value
   * @param roomId the roomId to set
   */
  public void setRoomId(int roomId) {
    this.roomId = roomId;
  }
}
