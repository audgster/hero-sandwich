package initialization;


import org.w3c.dom.Element;
import org.w3c.dom.Node;

import java.util.List;

public class AreaOfEffectCreator {

    private List<Node> areaEffectGroups;

    public AreaOfEffectCreator(List<Node> areaEffectGroups) {
        this.areaEffectGroups = areaEffectGroups;
    }

    public void createAreasOfEffectOnMap(TestMap map) {
        TestTile[][] mapGrid = map.getMap();

        for(int i = 0; i < areaEffectGroups.size(); i++) {
            Element currentAoe = (Element) areaEffectGroups.get(i);
            createAoeGroup(mapGrid, currentAoe);
        }
    }

    private void createAoeGroup(TestTile[][] mapGrid, Element aoeGroup) {
        String type = getAoeType(aoeGroup);
        int height = getAoeGroupHeight(aoeGroup);
        int width = getAoeGroupWidth(aoeGroup);
        int xOrigin = getAoeGroupXOrigin(aoeGroup);
        int yOrigin = getAoeGroupYOrigin(aoeGroup);
        for(int i = 0; i < height; i++) {
            for(int j=0; j < width; j++) {
                mapGrid[yOrigin+i][xOrigin+j].setAOE(type);
            }
        }
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
