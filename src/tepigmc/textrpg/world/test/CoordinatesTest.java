package tepigmc.textrpg.world.test;

import static org.junit.Assert.*;

import org.junit.Test;

import tepigmc.textrpg.world.Coordinates;

public class CoordinatesTest {
  @Test
  public void testToString() {
    assertEquals("Coordinates(x: 1, y: 2)", new Coordinates(1, 2).toString());
  }
}
