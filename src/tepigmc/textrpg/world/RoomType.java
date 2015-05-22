package tepigmc.textrpg.world;

/**
 * An enum to store all the types of rooms and how to generate them
 * @author Andrew Archibald
 */
public enum RoomType {
  HOUSE(() -> {
    return RoomGenerator.border(new RoomTemplate(5, 10, 5, 10));
  });

  /**
   * An interface to use Java 8 lambda functions
   * @author Andrew Archibald
   */
  interface GeneratorService {
    RoomTemplate createTemplate();
  }

  GeneratorService service;

  /**
   * Creates a RoomType with a lambda to create a RoomTemplate
   * @param service a GeneratorService lambda that makes the RoomTemplate
   */
  RoomType(GeneratorService service) {
    this.service = service;
  }

  /**
   * Creates a RoomTemplate for this type of Room
   * @return the generated RoomTemplate
   */
  public RoomTemplate createTemplate() {
    return service.createTemplate();
  }
}
