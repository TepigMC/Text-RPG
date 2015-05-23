package tepigmc.textrpg.world;

import tepigmc.textrpg.entity.NonPlayerCharacter;

/**
 * An enum to store all the types of rooms and how to generate them
 * @author Andrew Archibald
 */
public enum RoomGenerator {
  HOUSE(() -> RoomGeneration.addEntityRandom(
      RoomGeneration.addDoor(RoomGeneration.border(new RoomTemplate(5, 10, 5, 10))),
      new NonPlayerCharacter('N'), 15));

  GeneratorService service;

  /**
   * Creates a RoomType with a lambda to create a RoomTemplate
   * @param service a GeneratorService lambda that makes the RoomTemplate
   */
  RoomGenerator(GeneratorService service) {
    this.service = service;
  }

  /**
   * An interface to use Java 8 lambda functions
   * @author Andrew Archibald
   */
  @FunctionalInterface
  public interface GeneratorService {
    public abstract RoomTemplate createTemplate();
  }

  /**
   * Creates a RoomTemplate for this type of Room
   * @return the generated RoomTemplate
   */
  public RoomTemplate createTemplate() {
    return service.createTemplate();
  }
}
