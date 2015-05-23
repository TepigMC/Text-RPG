package tepigmc.textrpg.world;

import java.util.ArrayList;
import java.util.List;

import tepigmc.textrpg.entity.Entity;
import tepigmc.textrpg.entity.Player;
import tepigmc.util.Grid;

public class Room {
  private static int nextId = 0;
  private int id = nextId++;
  private Grid<Tile> tiles;
  private List<Entity> entities;
  private RoomGenerator roomGenerator;
  private boolean hasGenerated;

  /**
   * Constructs a Room with a Tile Grid and a List of Entity objects
   * @param tiles a Grid of Tiles
   * @param entities a List of Entities
   */
  public Room(Grid<Tile> tiles, List<Entity> entities) {
    this.tiles = tiles;
    this.entities = entities;
    this.hasGenerated = true;
  }

  /**
   * Constructs a Room with a Tile Grid and no Entity objects
   * @param tiles a Grid of Tiles
   */
  public Room(Grid<Tile> tiles) {
    this(tiles, new ArrayList<Entity>());
  }

  /**
   * Constructs a Room from a RoomTemplate
   * @param roomTemplate the RoomTemplate to create the World from
   */
  public Room(RoomTemplate roomTemplate) {
    this(roomTemplate.createTiles(), roomTemplate.getEntities());
  }

  /**
   * Constructs a Room from a RoomTemplate
   * @param roomTemplate the RoomTemplate to create the World from
   */
  public Room(RoomGenerator roomGenerator) {
    this.roomGenerator = roomGenerator;
    this.hasGenerated = false;
  }

  /**
   * Gets the tiles Grid
   * @return tiles
   */
  public Grid<Tile> getTiles() {
    load();
    return this.tiles;
  }

  /**
   * Gets the Tile at the given Coordinates
   * @param coordinates the position to get the Tile
   * @return the tile at the Coordinates
   */
  public Tile getTile(Coordinates coordinates) {
    load();
    return getTile(coordinates.x(), coordinates.y());
  }

  /**
   * Gets the Tile at the given position
   * @param x the horizontal position of the Tile
   * @param y the vertical position of the Tile
   * @return the tile at the position
   */
  public Tile getTile(int x, int y) {
    load();
    return this.tiles.get(y, x);
  }

  /**
   * Gets the List of Entity objects
   * @return entities
   */
  public List<Entity> getEntities() {
    load();
    return this.entities;
  }

  /**
   * Gets the unique id of this room
   * @return the id
   */
  public int getId() {
    return this.id;
  }

  /**
   * Checks if the Coordinates are in bounds
   * @param coordinates the coordinates to check
   * @return whether the Coordinates are in bounds
   */
  public boolean inBounds(Coordinates coordinates) {
    return inBounds(coordinates.x(), coordinates.y());
  }

  /**
   * Checks if the position is in bounds
   * @param x the horizontal coordinate to check
   * @param y the vertical coordinate to check
   * @return whether the position is in bounds
   */
  public boolean inBounds(int x, int y) {
    return this.tiles.inBounds(y, x);
  }

  /**
   * Renders the tiles and entities with a Player in the Room
   */
  public String render(Player player) {
    load();
    return new RoomRenderer(this, player).render();
  }

  /**
   * Renders the tiles and entities with a Player in the Room
   */
  public String render() {
    load();
    return new RoomRenderer(this).render();
  }

  public void load() {
    if (!this.hasGenerated) {
      RoomTemplate roomTemplate = this.roomGenerator.createTemplate();
      this.tiles = roomTemplate.createTiles();
      this.entities = roomTemplate.getEntities();
      this.hasGenerated = true;
    }
  }
}
