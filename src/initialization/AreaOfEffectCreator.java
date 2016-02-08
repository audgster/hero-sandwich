package initialization;


import models.map.Map;
import models.map.Tile;
import models.map.areaofeffect.*;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

import java.util.List;

public class AreaOfEffectCreator {

    private List<Node> areaEffectGroups;

    public AreaOfEffectCreator(List<Node> areaEffectGroups) {
        this.areaEffectGroups = areaEffectGroups;
    }

    public void createAreasOfEffectOnMap(Tile[][] tileGrid) {
        for(int i = 0; i < areaEffectGroups.size(); i++) {
            Element currentAoe = (Element) areaEffectGroups.get(i);
            createAoeGroup(tileGrid, currentAoe);
        }
    }

    private void createAoeGroup(Tile[][] mapGrid, Element aoeGroup) {
        int height = getAoeGroupHeight(aoeGroup);
        int width = getAoeGroupWidth(aoeGroup);
        int xOrigin = getAoeGroupXOrigin(aoeGroup);
        int yOrigin = getAoeGroupYOrigin(aoeGroup);
        for(int i = 0; i < height; i++) {
            for(int j=0; j < width; j++) {
                mapGrid[yOrigin+i][xOrigin+j].addAoE(getAoe(aoeGroup.getAttribute("type")));
            }
        }
    }

    private AreaOfEffect getAoe(String type) {
        if(type.equalsIgnoreCase("heal-damage"))
            return new HealDamageAoE(100);
        else if(type.equalsIgnoreCase("insta-death"))
            return new InstaDeathAoE();
        else if(type.equalsIgnoreCase("level-up"))
            return new LevelUpAoE();
        else if(type.equalsIgnoreCase("take-damage"))
            return new TakeDamageAoE(10);
        else
            return null;
    }

    private int getAoeGroupXOrigin(Element aoeGroup) {
        return Integer.parseInt(aoeGroup.getAttribute("x-origin"));
    }

    private int getAoeGroupYOrigin(Element aoeGroup) {
        return Integer.parseInt(aoeGroup.getAttribute("y-origin"));
    }

    private int getAoeGroupHeight(Element aoeGroup) {
        return Integer.parseInt(aoeGroup.getAttribute("height"));
    }

    private int getAoeGroupWidth(Element aoeGroup) {
        return Integer.parseInt(aoeGroup.getAttribute("width"));
    }

    private String getAoeType(Element aoeGroup) {
        String type = aoeGroup.getAttribute("type");
        if(type.equalsIgnoreCase("instaDeath"))
            return "D";
        else if(type.equalsIgnoreCase("heal"))
            return "H";
        else if(type.equalsIgnoreCase("levelUp"))
            return "L";
        else
            return "ERROR";
    }

}
