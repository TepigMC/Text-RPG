package tepigmc.textrpg.entity;

import tepigmc.textrpg.world.Coordinates;

public class NonPlayerCharacter extends Entity {
  /**
   * Creates a NonPlayerCharacter with given coordinates, icon, and whether it
   * can change rooms
   * @param coordinates the position of the NonPlayerCharacter
   * @param icon the char used to display this NonPlayerCharacter in the UI
   * @param canChangeRooms whether this NonPlayerCharacter can use doors
   */
  public NonPlayerCharacter(Coordinates coordinates, char icon, boolean canChangeRooms) {
    super(coordinates, icon, canChangeRooms);
  }

  /**
   * Creates a NonPlayerCharacter with given coordinates and icon
   * @param coordinates the position of the NonPlayerCharacter
   * @param icon the char used to display this NonPlayerCharacter in the UI
   */
  public NonPlayerCharacter(Coordinates coordinates, char icon) {
    super(coordinates, icon, false);
  }

  /**
   * Creates an NonPlayerCharacter with given icon
   * @param icon the char used to display this NonPlayerCharacter in the UI
   */
  public NonPlayerCharacter(char icon) {
    this(new Coordinates(-1, -1), icon);
  }
}
