package tepigmc.textrpg.entity;

import tepigmc.textrpg.world.Coordinates;

public class Player extends Entity {
  /**
   * Creates a Player with given coordinates and icon
   * @param coordinates the position of the Player
   * @param icon the char used to display this Player in the UI
   */
  public Player(Coordinates coordinates, char icon) {
    super(coordinates, icon);
  }

  /**
   * Called whenever an Entity changes position
   * @param entity the Entity that moved
   */
  @Override
  public void onEntityMove(Entity entity) {
    System.out.println("moved: " + entity);
  }
}
