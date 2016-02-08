package initialization;


import models.entities.*;
import models.items.EquipableItem;
import models.items.EquipmentType;
import models.items.Item;
import util.Direction;
import util.EntityIdentifier;

import java.io.File;
import java.util.Scanner;

public class GameLoader {

    private File configFile;
    private Scanner scanner;

    public GameLoader(File file) {
        configFile = file;
        try {
            scanner = new Scanner(configFile);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void parseFile() {
        scanner.useDelimiter(" ");
        printScanner();
    }

    private void printScanner() {
        int i = 0;
        while(scanner.hasNext()){
            i+=1;
            String token = scanner.next();
            token = token.replace(System.getProperty("line.separator"), "");
            if(token.equalsIgnoreCase("Avatar"))
                loadAvatar(scanner);
        }
    }

    private Entity loadAvatar(Scanner scanner) {
        String name = "";
        EntityIdentifier entityIdentifier = EntityIdentifier.GROUND;
        Direction facingDirection = Direction.NORTH;
        Occupation occupation = new Sneak();
        EntityStats entityStats = new EntityStats();
        Inventory inventory = new Inventory();
        Equipment equipment = new Equipment();
        while(scanner.hasNext()) {
            String token = removeLineSeparator(scanner.next());
            if(token.equalsIgnoreCase("AvatarName:"))
                name = removeLineSeparator(scanner.next());
            else if(token.equalsIgnoreCase("EntityIdentifier:"))
                entityIdentifier = makeIntoEntityIdentifier(scanner.next());
            else if(token.equalsIgnoreCase("FacingDirection:"))
                facingDirection = makeIntoDirection(scanner.next());
            else if(token.equalsIgnoreCase("Occupation:"))
                occupation = makeIntoOccupation(scanner.next());
            else if(token.equalsIgnoreCase("EntityStats"))
                entityStats = makeEntityStats(scanner);
            else if(token.equalsIgnoreCase("Inventory"))
                inventory = makeInventory(scanner);
            else if(token.equalsIgnoreCase("Equipment"))
                equipment = makeEquipment(scanner);


        }

        System.out.println(name);
        System.out.println(entityIdentifier);
        System.out.println(facingDirection);
        System.out.println(occupation);
        System.out.println(entityStats.getStrength() + " " + entityStats.getAgility() + " " + entityStats.getIntellect() + " " + entityStats.getHardiness() + " " + entityStats.getModMovement());
        return new Entity();
    }

    private Equipment makeEquipment(Scanner scanner) {
        scanner.next();
        /*
        String initialToken = removeLineSeparator(scanner.next());
            while (scanner.hasNext()) {
                String token = removeLineSeparator(scanner.next());
                if (token.equalsIgnoreCase("}"))
                    break;
                else if(token.equalsIgnoreCase("bag")) {
                    ignoreBagSyntax(scanner);
                }
                else {
                    System.out.println("Adding item");
                    Item item = getNextItem(token, scanner);
                    inventory.add(item);
                }
            }
            */
        return new Equipment();
    }

    private Inventory makeInventory(Scanner scanner) {
        scanner.next();
        String initialToken = removeLineSeparator(scanner.next());
        if (initialToken.equalsIgnoreCase("capacity:")) {
            int capacity = Integer.parseInt(removeLineSeparator(scanner.next()));
            Inventory inventory = new Inventory(capacity);
            while (scanner.hasNext()) {
                String token = removeLineSeparator(scanner.next());
                if (token.equalsIgnoreCase("}"))
                    break;
                else if(token.equalsIgnoreCase("bag")) {
                    ignoreBagSyntax(scanner);
                }
                else {
                    System.out.println("Adding item");
                    Item item = getNextItem(token, scanner);
                    inventory.add(item);
                }
            }
            return inventory;
        }

/*
        Inventory inventory = new Inventory(Integer.parseInt(removeLineSeparator(scanner.next())));
        addItemsToInventory(Scanner scanner, inventory);
            */
        return null;
    }

    private void ignoreBagSyntax(Scanner scanner) {
        scanner.next();
    }

    private Item getNextItem(String token, Scanner scanner) {
        if(token.equalsIgnoreCase("EquipableItem")) {
            return createEquippableItem(scanner);
        }
        return null;
    }

    private Item createEquippableItem(Scanner scanner) {
        scanner.next();
        String name = "";
        StatModifiers statBoost = new StatModifiers();
        StatModifiers statRestrictions = new StatModifiers();
        EquipmentType equipmentType = EquipmentType.HELM;
        String occupationRestriction = "";
        while (scanner.hasNext()) {
            String token = removeLineSeparator(scanner.next());
            if (token.equalsIgnoreCase("}"))
                break;

            else if(token.equalsIgnoreCase("Name:"))
                name = removeLineSeparator(scanner.next());

            else if(token.equalsIgnoreCase("EquipmentType:"))
                equipmentType = EquipmentType.valueOf(removeLineSeparator(scanner.next()));

            else if(token.equalsIgnoreCase("StatBoost"))
                statBoost = createNextStatModifier(scanner);

            else if(token.equalsIgnoreCase("StatRestrictions"))
                statRestrictions = createNextStatModifier(scanner);

            else if(token.equalsIgnoreCase("OccupationRestriction:")) {
                token = removeLineSeparator(scanner.next());
                if(token.equalsIgnoreCase("none"))
                    continue;
            }

        }
        return new EquipableItem(name, equipmentType, statBoost, statRestrictions, occupationRestriction);
    }

    private StatModifiers createNextStatModifier(Scanner scanner) {
        scanner.next();
        StatModifiers statModifier = new StatModifiers();
        while (scanner.hasNext()) {
            String token = removeLineSeparator(scanner.next());
            if (token.equalsIgnoreCase("}"))
                break;

            else if (token.equalsIgnoreCase("life:"))
                statModifier.setLife(Integer.parseInt(removeLineSeparator(scanner.next())));

            else if (token.equalsIgnoreCase("mana:"))
                statModifier.setMana(Integer.parseInt(removeLineSeparator(scanner.next())));

            else if (token.equalsIgnoreCase("offensiveRating:"))
                statModifier.setOffRating(Integer.parseInt(removeLineSeparator(scanner.next())));

            else if (token.equalsIgnoreCase("defensiveRating:"))
                statModifier.setDefRating(Integer.parseInt(removeLineSeparator(scanner.next())));

            else if (token.equalsIgnoreCase("armorRating:"))
                statModifier.setArmorRating(Integer.parseInt(removeLineSeparator(scanner.next())));

            else if (token.equalsIgnoreCase("strength:"))
                statModifier.setLife(Integer.parseInt(removeLineSeparator(scanner.next())));

            else if (token.equalsIgnoreCase("agility:"))
                statModifier.setAgility(Integer.parseInt(removeLineSeparator(scanner.next())));

            else if (token.equalsIgnoreCase("intellect:"))
                statModifier.setIntellect(Integer.parseInt(removeLineSeparator(scanner.next())));

            else if (token.equalsIgnoreCase("hardiness:"))
                statModifier.setHardiness(Integer.parseInt(removeLineSeparator(scanner.next())));

            else if (token.equalsIgnoreCase("movement:"))
                statModifier.setMovement(Integer.parseInt(removeLineSeparator(scanner.next())));
        }
        return statModifier;
    }

    private EntityStats makeEntityStats(Scanner scanner) {
        EntityStats entityStats = new EntityStats();
        while(scanner.hasNext()) {
            String token = removeLineSeparator(scanner.next());
            if (token.equalsIgnoreCase("}")) { break; }

            else if (token.equalsIgnoreCase("livesLeft:"))
                try { entityStats.setLivesLeft(Integer.parseInt(removeLineSeparator(scanner.next()))); }
                catch (Exception e) { e.printStackTrace(); }

            else if (token.equalsIgnoreCase("currentLife:"))
                try { entityStats.setCurrentLife(Integer.parseInt(removeLineSeparator(scanner.next()))); }
                catch (Exception e) { e.printStackTrace(); }

            else if (token.equalsIgnoreCase("currentMana:"))
                try { entityStats.setCurrentMana(Integer.parseInt(removeLineSeparator(scanner.next()))); }
                catch (Exception e) { e.printStackTrace(); }

            else if (token.equalsIgnoreCase("xp:"))
                try { entityStats.setXp(Integer.parseInt(removeLineSeparator(scanner.next()))); }
                catch (Exception e) { e.printStackTrace(); }

            else if (token.equalsIgnoreCase("strength:"))
                try { entityStats.setStrength(Integer.parseInt(removeLineSeparator(scanner.next()))); }
                catch (Exception e) { e.printStackTrace(); }

            else if (token.equalsIgnoreCase("agility:"))
                try { entityStats.setAgility(Integer.parseInt(removeLineSeparator(scanner.next()))); }
                catch (Exception e) { e.printStackTrace(); }

            else if (token.equalsIgnoreCase("intellect:"))
                try { entityStats.setIntellect(Integer.parseInt(removeLineSeparator(scanner.next()))); }
                catch (Exception e) { e.printStackTrace(); }

            else if (token.equalsIgnoreCase("hardiness:"))
                try { entityStats.setHardiness(Integer.parseInt(removeLineSeparator(scanner.next()))); }
                catch (Exception e) { e.printStackTrace(); }

            else if (token.equalsIgnoreCase("movement:"))
                try { entityStats.setMovement(Integer.parseInt(removeLineSeparator(scanner.next()))); }
                catch (Exception e) { e.printStackTrace(); }


        }

        return entityStats;
    }

    private Occupation makeIntoOccupation(String occupation) {
        occupation = removeLineSeparator(occupation);
        if(occupation.equalsIgnoreCase("Smasher"))
            return new Smasher();
        else if(occupation.equalsIgnoreCase("Sneak"))
            return new Sneak();
        else if(occupation.equalsIgnoreCase("Summoner"))
            return new Summoner();
        else
            return null;
    }

    private Direction makeIntoDirection(String facingDirection) {
        return Direction.valueOf(removeLineSeparator(facingDirection));
    }

    private EntityIdentifier makeIntoEntityIdentifier(String entityIdentifier) {
        return EntityIdentifier.valueOf(removeLineSeparator(entityIdentifier));
    }
    private String removeLineSeparator(String token) {
        return token.replace(System.getProperty("line.separator"), "");

    }
}

/*

Just keep throwing
 */