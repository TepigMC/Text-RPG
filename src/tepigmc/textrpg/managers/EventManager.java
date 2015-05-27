package tepigmc.textrpg.managers;

import java.awt.event.KeyEvent;

import tepigmc.textrpg.TextRpg;
import tepigmc.textrpg.entity.Entity;
import tepigmc.textrpg.world.Direction;

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
   * This event is called whenever a key is typed in the UI
   * @param event the KeyEvent from the UI
   */
  public static void keyTyped(KeyEvent event) {

  }

  /**
   * This event is called whenever a key is pressed in the UI. It manages arrow
   * keys for movement.
   * @param event the KeyEvent from the UIs
   */
  public static void keyPressed(KeyEvent event) {
    int key = event.getKeyCode();
    Direction direction = null;
    if ((key == KeyEvent.VK_UP || key == KeyEvent.VK_KP_UP)
        && ActionManager.canMoveUp)
      direction = Direction.UP;
    else if ((key == KeyEvent.VK_RIGHT || key == KeyEvent.VK_KP_RIGHT)
        && ActionManager.canMoveRight)
      direction = Direction.RIGHT;
    else if ((key == KeyEvent.VK_DOWN || key == KeyEvent.VK_KP_DOWN)
        && ActionManager.canMoveDown)
      direction = Direction.DOWN;
    else if ((key == KeyEvent.VK_LEFT || key == KeyEvent.VK_KP_LEFT)
        && ActionManager.canMoveLeft)
      direction = Direction.LEFT;

    if (direction != null) {
      if (TextRpg.player.canMove(direction))
        try {
          TextRpg.player.move(direction);
        }
        catch (Exception e) {
          e.printStackTrace();
        }
      else {
        TextManager.addError("You can't move there");
      }
    }
  }

  /**
   * This event is called whenever a key is released in the UI
   * @param event the KeyEvent from the UI
   */
  public static void keyReleased(KeyEvent event) {
    // TODO handle enter
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
