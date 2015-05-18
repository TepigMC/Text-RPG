package tepigmc.textrpg.entity;

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
   * Creates an Entity with given coordinates and icon
   * @param x the horizontal position of the Entity
   * @param y the vertical position of the Entity
   * @param icon the char used to display this Entity in the UI
   */
  public Entity(int x, int y, char icon) {
    this(new Coordinates(x, y), icon);
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
   * Tests if the Entity can move relative to the given position
   * @param coordinates the relative coordinates to test
   * @return whether the Entity can move
   */
  public boolean canMove(Coordinates coordinates) {
    return false;
  }

  public char getIcon() {
    return this.icon;
  }
}
