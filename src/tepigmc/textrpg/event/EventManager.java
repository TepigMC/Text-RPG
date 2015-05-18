package tepigmc.textrpg.event;

import tepigmc.textrpg.TextRpg;
import tepigmc.textrpg.TextRpgUI;
import tepigmc.textrpg.entity.Entity;
import tepigmc.textrpg.world.Room;

public class EventManager {
  /**
   * Triggers all the Entity onEntityMove events whenever an Entity changes
   * position
   * @param entity the Entity that changed position
   */
  public static void onEntityMove(Entity entity) {
    Room room = TextRpg.currentRoom();
    for (Entity e : room.getEntities()) {
      e.onEntityMove(entity);
    }
    TextRpgUI.refresh();
  }
}
