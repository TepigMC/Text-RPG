package tepigmc.textrpg.world;

public class Tiles {
  public static final Tile empty = new Tile("empty", ' ', false);
  public static final Tile wall = new Tile("wall", 'X', true); //'\u2588'
  public static final Tile unknown = new Tile("unknown", '?', false);
}
