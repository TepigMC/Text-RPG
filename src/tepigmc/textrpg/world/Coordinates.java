package tepigmc.textrpg.world;

public class Coordinates {
  private int x;
  private int y;

  /**
   * Create a Coordinates object with the position (x, y)
   * @param x the horizontal position
   * @param y the vertical position
   */
  public Coordinates(int x, int y) {
    this.x = x;
    this.y = y;
  }

  /**
   * Creates a copy of the given Coordinates object
   * @param coordinates the Coordinates object to copy
   */
  public Coordinates(Coordinates coordinates) {
    this.x = coordinates.x();
    this.y = coordinates.y();
  }

  /**
   * Gets the horizontal position
   * @return the x coordinate
   */
  public int x() {
    return this.x;
  }

  /**
   * Gets the vertical position
   * @return the y coordinate
   */
  public int y() {
    return this.y;
  }
  
  /**
   * Adds two coordinates together
   * @param coordinates the Coordinates to add to this
   * @return the result of the addition
   */
  public Coordinates add(Coordinates coordinates) {
    return new Coordinates(this.x + coordinates.x(), this.y + coordinates.y());
  }
}
