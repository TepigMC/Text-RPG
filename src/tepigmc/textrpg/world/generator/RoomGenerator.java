package tepigmc.textrpg.world.generator;

import java.util.HashMap;

import tepigmc.textrpg.world.RoomLayout;
import tepigmc.textrpg.world.Tile;

public class RoomGenerator {
  public static RoomLayout generateRectangle(int width, int height) {
    char[][] layout = new char[width][height];
    HashMap<Character, Tile> hashMap = new HashMap<Character, Tile>();
    // TODO
    return new RoomLayout(layout, hashMap);
  }
}
