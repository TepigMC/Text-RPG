package tepigmc.textrpg.entity;

import tepigmc.textrpg.TextRpg;
import tepigmc.textrpg.event.EventManager;
import tepigmc.textrpg.world.Coordinates;
import tepigmc.textrpg.world.Room;

public abstract class Entity {
  private Coordinates coordinates;
  private char icon;

  /**
   * Creates an Entity with given coordinates and icon
   * @param coordinates the position of the Entity
   * @param icon the char used to display this Entity in the UI
   */
  public Entity(Coordinates coordinates, char icon) {
    setCoordinates(coordinates);
    this.icon = icon;
  }

  /**
   * Creates an Entity with given icon
   * @param icon the char used to display this Entity in the UI
   */
  public Entity(char icon) {
    this(new Coordinates(-1, -1), icon);
  }

  /**
   * Creates an Entity with the same data as the given Entity
   * @param entity the Entity to copy
   */
  public Entity(Entity entity) {
    this(entity.getCoordinates(), entity.getIcon());
  }

  /**
   * Gets the horizontal position of the Entity, -1 if Coordinates are null
   * @return the x coordinate
   */
  public int getX() {
    if (this.coordinates == null)
      return -1;
    return this.coordinates.x();
  }

  /**
   * Gets the vertical position of the Entity, -1 if Coordinates are null
   * @return the y coordinate
   */
  public int getY() {
    if (this.coordinates == null)
      return -1;
    return this.coordinates.y();
  }

  /**
   * Gets the position of the entity
   * @return the coordinates
   */
  public Coordinates getCoordinates() {
    if (this.coordinates == null)
      return new Coordinates(-1, -1);
    return this.coordinates;
  }

  /**
   * Gets the position of the entity relative to the given coordinates
   * @return the coordinates
   */
  public Coordinates getCoordinatesRelative(Coordinates relativeCoordinates) {
    return this.coordinates.add(relativeCoordinates);
  }

  /**
   * Gets the char used in rendering this Entity
   * @return the icon
   */
  public char getIcon() {
    return this.icon;
  }

  /**
   * Sets the position of the entity to the given Coordinates
   * @param the coordinates to set
   * @return the previous value for coordinates
   */
  public Coordinates setCoordinates(Coordinates coordinates) {
    Coordinates previous = this.coordinates;
    if (coordinates == null)
      coordinates = new Coordinates(-1, -1);
    this.coordinates = coordinates;
    return previous;
  }

  /**
   * Sets the char used in rendering this Entity
   * @return the icon
   */
  public char setIcon(char icon) {
    char previous = this.icon;
    this.icon = icon;
    return previous;
  }

  /**
   * Tests if the Entity can move to the given position
   * @param coordinates the coordinates to test
   * @return whether the Entity can move
   */
  public boolean canMove(Coordinates coordinates) {
    Room room = TextRpg.currentRoom();
    // TODO out of bounds error; add inBounds(row, col) to Grid
    return !room.getTile(coordinates.y(), coordinates.x()).isSolid();
  }

  /**
   * Tests if the Entity can move relative to the given position
   * @param coordinates the relative coordinates to test
   * @return whether the Entity can move
   */
  public boolean canMoveRelative(Coordinates relativeCoordinates) {
    return canMove(getCoordinatesRelative(relativeCoordinates));
  }

  /**
   * Moves this Entity to the coordinates; Subclasses cannot Override this
   * method
   * @param coordinates the coordinates to move to
   * @throws Exception
   */
  public final void move(Coordinates coordinates) throws Exception {
    if (!canMove(coordinates))
      throw new Exception("Entity cannot move there! " + this + ", "
          + coordinates);
    this.coordinates = coordinates;
    EventManager.onEntityMove(this);
  }

  /**
   * Moves this Entity to the relative coordinates; Subclasses cannot Override
   * this method
   * @param coordinates the coordinates to move relative to
   * @throws Exception
   */
  public final void moveRelative(Coordinates relativeCoordinates) throws Exception {
    move(getCoordinatesRelative(relativeCoordinates));
  }

  /**
   * Called whenever an Entity changes position
   * @param entity the Entity that moved
   */
  public void onEntityMove(Entity entity) {

  }

  /**
   * Creates a String representation of this Entity
   */
  public String toString() {
    return "Entity(coordinates: " + this.coordinates + ", icon: " + this.icon
        + ")";
  }
}
