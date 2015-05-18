package tepigmc.textrpg.entity;

import tepigmc.textrpg.event.EventManager;
import tepigmc.textrpg.world.Coordinates;

public abstract class Entity {
  private Coordinates coordinates;
  private char icon;

  /**
   * Creates an Entity with given coordinates and icon
   * @param coordinates the position of the Entity
   * @param icon the char used to display this Entity in the UI
   */
  public Entity(Coordinates coordinates, char icon) {
    this.coordinates = coordinates;
    this.icon = icon;
  }

  /**
   * Creates an Entity with the same data as the given Entity
   * @param x the Entity to copy
   */
  public Entity(Entity entity) {
    this(entity.getCoordinates(), entity.getIcon());
  }

  /**
   * Gets the horizontal position of the Entity
   * @return the x coordinate
   */
  public int getX() {
    return this.coordinates.x();
  }

  /**
   * Gets the vertical position of the Entity
   * @return the y coordinate
   */
  public int getY() {
    return this.coordinates.y();
  }

  /**
   * Gets the position of the entity
   * @return the coordinates
   */
  public Coordinates getCoordinates() {
    return this.coordinates;
  }

  /**
   * Gets the char used in rendering this Entity
   * @return the icon
   */
  public char getIcon() {
    return this.icon;
  }

  /**
   * Tests if the Entity can move relative to the given position
   * @param coordinates the relative coordinates to test
   * @return whether the Entity can move
   */
  public boolean canMove(Coordinates coordinates) {
    return false;
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
