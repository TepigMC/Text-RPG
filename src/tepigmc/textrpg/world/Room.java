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
  private List<Exit> exits;
  private RoomGenerator roomGenerator;
  private boolean hasGenerated;

  /**
   * Constructs a Room with a Tile Grid and a List of Entity objects
   * @param tiles a Grid of Tiles
   * @param entities a List of Entities
   */
  public Room(Grid<Tile> tiles, List<Entity> entities, List<Exit> exits) {
    this.tiles = tiles;
    this.entities = entities;
    this.exits = exits;
    this.hasGenerated = true;
  }

  /**
   * Constructs a Room with a Tile Grid and no Entity objects
   * @param tiles a Grid of Tiles
   */
  public Room(Grid<Tile> tiles) {
    this(tiles, new ArrayList<Entity>(), new ArrayList<Exit>());
  }

  /**
   * Constructs a Room from a RoomTemplate
   * @param roomTemplate the RoomTemplate to create the World from
   */
  public Room(RoomTemplate roomTemplate) {
    this(roomTemplate.createTiles(), roomTemplate.getEntities(), roomTemplate.getExits());
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
    return getTile(coordinates.y(), coordinates.x());
  }

  /**
   * Gets the Tile at the given position
   * @param row the row to check
   * @param col the column to check
   * @return the tile at the position
   */
  public Tile getTile(int row, int col) {
    load();
    return this.tiles.get(row, col);
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
   * Gets the List of Exit objects
   * @return exits
   */
  public List<Exit> getExits() {
    load();
    return this.exits;
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
    return inBounds(coordinates.y(), coordinates.x());
  }

  /**
   * Checks if the position is in bounds
   * @param row the row to check
   * @param col the column to check
   * @return whether the position is in bounds
   */
  public boolean inBounds(int row, int col) {
    return this.tiles.inBounds(row, col);
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

  /**
   * Generates the Room if it is not generated
   */
  private void load() {
    if (!this.hasGenerated) {
      RoomTemplate roomTemplate = this.roomGenerator.createTemplate();
      this.tiles = roomTemplate.createTiles();
      this.entities = roomTemplate.getEntities();
      this.hasGenerated = true;
    }
  }
}
