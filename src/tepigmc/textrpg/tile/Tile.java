package tepigmc.textrpg.tile;

public abstract class Tile {
  private String id;
  private char icon;
  private boolean isSolid;
  
  public Tile(String id, char icon, boolean isSolid) {
    this.id = id;
    this.icon = icon;
    this.isSolid = isSolid;
  }
  
  public String getId() { return this.id; }
  public char getIcon() { return this.icon; }
  public boolean getSolid() { return this.isSolid; }

  public void setId(String id) { this.id = id; }
  public void setIcon(char icon) { this.icon = icon; }
  public void setSolid(boolean isSolid) { this.isSolid = isSolid; }

  public boolean equals(Tile compare) {
    if (this.getId() == compare.getId()
        && this.getIcon() == compare.getIcon()
        && this.getSolid() == compare.getSolid()) {
      return true;
    }
    return false;
  }
}
