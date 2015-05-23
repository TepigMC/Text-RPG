package tepigmc.textrpg.world;

public enum Direction {
  UP(new Coordinates(0, -1)),
  RIGHT(new Coordinates(1, 0)),
  DOWN(new Coordinates(0, 1)),
  LEFT(new Coordinates(-1, 0)),
  NORTH(new Coordinates(0, -1)),
  EAST(new Coordinates(1, 0)),
  SOUTH(new Coordinates(0, 1)),
  WEST(new Coordinates(-1, 0)),
  NORTH_WEST(new Coordinates(-1, -1)),
  NORTH_EAST(new Coordinates(1, -1)),
  SOUTH_EAST(new Coordinates(1, 1)),
  SOUTH_WEST(new Coordinates(-1, 1)),
  NW(new Coordinates(-1, -1)),
  NE(new Coordinates(1, -1)),
  SE(new Coordinates(1, 1)),
  SW(new Coordinates(-1, 1));

  Coordinates relativeCoordinates;

  Direction(Coordinates relativeCoordinates) {
    this.relativeCoordinates = relativeCoordinates;
  }

  /**
   * Gets the relative coordinates in this direction
   * @return the relative coordinates
   */
  public Coordinates getRelativeCoordinates() {
    return this.relativeCoordinates;
  }

  /**
   * Gets the relative coordinates in this direction
   * @return the relative coordinates
   */
  public Coordinates getRelativeCoordinates(int amount) {
    return this.relativeCoordinates.multiply(amount);
  }

  /**
   * Gets the coordinates relative to the given coordinates in this direction
   * @param coordinates the coordinates to start at
   * @return the calculated coordinates
   */
  public Coordinates getRelativeCoordinates(Coordinates coordinates) {
    return coordinates.add(this.relativeCoordinates);
  }

  /**
   * Gets the coordinates relative to the given coordinates in this direction
   * @param coordinates the coordinates to start at
   * @return the calculated coordinates
   */
  public Coordinates getRelativeCoordinates(Coordinates coordinates, int amount) {
    return coordinates.add(this.relativeCoordinates.multiply(amount));
  }
}
