package tepigmc.textrpg.entity;

import tepigmc.textrpg.world.Coordinates;

public class NonPlayerCharacter extends Entity {
  /**
   * Creates a NonPlayerCharacter with given coordinates and icon
   * @param coordinates the position of the NonPlayerCharacter
   * @param icon the char used to display this NonPlayerCharacter in the UI
   */
  public NonPlayerCharacter(Coordinates coordinates, char icon) {
    super(coordinates, icon);
  }

  /**
   * Creates a NonPlayerCharacter with given icon
   * @param icon the char used to display this NonPlayerCharacter in the UI
   */
  public NonPlayerCharacter(char icon) {
    super(icon);
  }
}
