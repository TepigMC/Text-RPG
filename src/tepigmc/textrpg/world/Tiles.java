package tepigmc.textrpg.world;

public class Tiles {
  public static final Tile empty = new Tile("empty", ' ', false);
  public static final Tile wall = new Tile("wall", '\u2588', true);
  public static final Tile unknown = new Tile("unknown", '?', false);
  public static final Tile door = new Tile("door", '\u2591', false);
}
