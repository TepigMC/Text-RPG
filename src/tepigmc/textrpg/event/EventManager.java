package tepigmc.textrpg.event;

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
   * 
   * @param e
   */
  public static void keyTyped(KeyEvent event) {
    System.out.println("Key Typed " + event.getKeyCode() + ", " + event.getKeyChar());
  }

  public static void keyPressed(KeyEvent event) {
    System.out.println("Key Pressed " + event.getKeyCode() + ", " + event.getKeyChar());
    char key = event.getKeyChar();
    try {
      if (key == KeyEvent.VK_UP && ActionManager.canMoveUp
          && TextRpg.player.canMove(Direction.UP))
        TextRpg.player.move(Direction.UP);
      else if (key == KeyEvent.VK_RIGHT && ActionManager.canMoveRight
          && TextRpg.player.canMove(Direction.RIGHT))
        TextRpg.player.move(Direction.RIGHT);
      else if (key == KeyEvent.VK_DOWN && ActionManager.canMoveDown
          && TextRpg.player.canMove(Direction.DOWN))
        TextRpg.player.move(Direction.DOWN);
      else if (key == KeyEvent.VK_LEFT && ActionManager.canMoveLeft
          && TextRpg.player.canMove(Direction.LEFT))
        TextRpg.player.move(Direction.LEFT);
      // TODO find problem with not moving
    }
    catch (Exception e) {
      e.printStackTrace();
    }
  }

  public static void keyReleased(KeyEvent event) {
    System.out.println("Key Released " + event.getKeyCode() + ", " + event.getKeyChar());
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
