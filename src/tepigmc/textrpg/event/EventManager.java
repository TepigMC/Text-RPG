package tepigmc.textrpg.event;

import tepigmc.textrpg.TextRpg;
import tepigmc.textrpg.entity.Entity;

public class EventManager {
  /**
   * Triggers all the Entity onEntityMove events whenever an Entity changes
   * position
   * @param entity the Entity that changed position
   */
  public static void onEntityMove(Entity entity) {
    entityEvent(e -> e.onEntityMove(entity));
    TextRpg.ui.refresh();
  }

  /**
   * Calls a lambda expression for each Entity and the Player
   * @param service the lambda expression to call
   */
  private static void entityEvent(EntityEventService service) {
    for (Entity entity : TextRpg.currentRoom().getEntities()) {
      service.call(entity);
    }
    service.call(TextRpg.player);
  }

  /**
   * An interface to use Java 8 lambda functions
   * @author Andrew Archibald
   */
  @FunctionalInterface
  public interface EntityEventService {
    public abstract void call(Entity entity);
  }
}
