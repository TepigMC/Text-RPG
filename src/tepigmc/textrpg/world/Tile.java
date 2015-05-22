package tepigmc.textrpg.world;

public class Tile {
  private String id;
  private char icon;
  private boolean isSolid;

  /**
   * Constructs a Tile object
   * @param id the id to be used to identify Tile types
   * @param icon the icon to be shown in the map screen
   * @param isSolid whether the Tile is solid
   */
  public Tile(String id, char icon, boolean isSolid) {
    this.id = id;
    this.icon = icon;
    this.isSolid = isSolid;
  }

  /**
   * Gets the id used to identify Tile types
   * @return id
   */
  public String getId() {
    return this.id;
  }

  /**
   * Gets the icon shown in the map screen
   * @return icon
   */
  public char getIcon() {
    return this.icon;
  }

  /**
   * Gets if the Tile is solid
   * @return isSolid
   */
  public boolean isSolid() {
    return this.isSolid;
  }

  /**
   * Sets the id used to identify Tile types to the given id
   * @param id
   */
  public void setId(String id) {
    this.id = id;
  }

  /**
   * Sets the icon shown in the map screen to the given icon
   * @param icon
   */
  public void setIcon(char icon) {
    this.icon = icon;
  }

  /**
   * Sets if the Tile is solid to isSolid
   * @param isSolid
   */
  public void setSolid(boolean isSolid) {
    this.isSolid = isSolid;
  }

  /**
   * Compares this and another Tile and returns whether the Tile objects are
   * equal
   * @param compare the Tile to compare to
   * @return if the Tile objects are equal
   */
  public boolean equals(Tile compare) {
    return getId() == compare.getId() && getIcon() == compare.getIcon()
        && isSolid() == compare.isSolid();
  }

  /**
   * Creates a String representation of this Tile
   */
  public String toString() {
    return "Tile(id: " + this.id + ", icon: " + this.icon + ", isSolid: "
        + this.isSolid + ")";
  }
}
