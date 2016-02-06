package initialization;

import com.sun.corba.se.impl.oa.poa.AOMEntry;

public class TestTile {
    private String terrain;
    private String AOE;
    private String item;

    public TestTile() {}
    public TestTile(String terrain, String AOE, String item) {
        this.terrain = terrain;
        this.AOE = AOE;
        this.item = item;
    }

    public void setTerrain(String terrain) {
        this.terrain = terrain;
    }

    public void setAOE(String AOE) {
        this.AOE = AOE;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public String toString() {
        return terrain;
    }

}
