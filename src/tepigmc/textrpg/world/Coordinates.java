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

  /**
   * Compares this and another Coordinates and returns whether the Coordinates
   * objects are equal
   * @param compare the Coordinates to compare to
   * @return if the Coordinates objects are equal
   */
  public boolean equals(Coordinates compare) {
    return x() == compare.x() && y() == compare.y();
  }

  /**
   * Creates a String representation of this Coordinates object
   */
  public String toString() {
    return "Coordinates(x: " + this.x + ", y: " + this.y + ")";
  }

}
