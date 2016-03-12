package com.herosandwich.models.entity;

import com.herosandwich.models.map.Map;
import com.herosandwich.models.map.Tile;
import com.herosandwich.util.DirectionHex;
import com.herosandwich.util.PositionHex;
import com.herosandwich.util.visitor.EntityVisitor;
import com.herosandwich.util.visitor.movement.MovementVisitor;

public class Entity
{
    /*
    * Naming
    * */
    private String name;

    /*
    * Stats
    * */
    private EntityStats stats;

    /*
    * Position and Direction
    * */
    private PositionHex position;
    private DirectionHex direction;

    public Entity()
    {
        stats = new EntityStats();

        currentLife = getMaxLife();
        currentMana = getMaxMana();

        name = "Entity Dave";

        this.position = new PositionHex(0,0,0);
        this.direction = DirectionHex.SOUTH;
    }

    public Entity(String name, PrimaryStats stats, DeriveStatStrategy strategy){
        this.name = name;
        this.stats = new EntityStats(strategy, stats);
        currentLife = getMaxLife();
        currentMana = getMaxMana();
        this.position = new PositionHex(0,0,0);
        this.direction = DirectionHex.SOUTH;
    }

    public Entity(String name, PrimaryStats stats, DeriveStatStrategy strategy, PositionHex pos, DirectionHex dir){
        this.name = name;
        this.stats = new EntityStats(strategy, stats);
        currentLife = getMaxLife();
        currentMana = getMaxMana();
        this.position = pos;
        this.direction = dir;
    }

    public Entity(Entity entity)
    {
        name = entity.getName();

        this.stats = entity.getStats();

        currentLife = entity.getCurrentLife();
        currentMana = entity.getCurrentMana();

        position = entity.getPosition();
        direction = entity.getDirection();
    }

    private int currentLife;
    private int currentMana;

    /*
    * Accessors
    * */

    private EntityStats getStats()
    {
        return this.stats;
    }

    public String getName()
    {
        return name;
    }

    //Primary Stats
    public int getLives()
    {
        return stats.getLives();
    }

    public int getStrength()
    {
        return stats.getStrength();
    }

    public int getAgility()
    {
        return stats.getAgility();
    }

    public int getIntellect()
    {
        return stats.getIntellect();
    }

    public int getHardiness()
    {
        return stats.getHardiness();
    }

    public int getExperience()
    {
        return stats.getExperience();
    }

    public int getMovement()
    {
        return stats.getMovement();
    }

    // Derived Stats
    public int getLevel()
    {
        return stats.getLevel();
    }

    public int getMaxLife()
    {
        return stats.getLife();
    }

    public int getMaxMana()
    {
        return stats.getMana();
    }

    public int getOffensiveRating()
    {
        return stats.getOffensiveRating();
    }

    public int getDefensiveRating()
    {
        return stats.getDefensiveRating();
    }

    public int getArmorRating()
    {
        return stats.getArmorRating();
    }

    // Other
    public int getCurrentLife()
    {
        return this.currentLife;
    }

    public int getCurrentMana()
    {
        return this.currentMana;
    }

    public PositionHex getPosition(){
        return this.position;
    }

    public DirectionHex getDirection(){
        return this.direction;
    }

    /*
    * Modifiers
    * */

    public void setName(String name)
    {
        this.name = name;
    }

    //Primary stat modifiers
    public boolean modifyLives(int delta)
    {
        return stats.changeLives(delta);
    }

    public boolean modifyStrength(int delta)
    {
        return stats.changeStrength(delta);
    }

    public boolean modifyAgilty(int delta)
    {
        return stats.changeAgility(delta);
    }

    public boolean modifyIntellect(int delta)
    {
        return stats.changeIntellect(delta);
    }

    public boolean modifyExperience(int delta)
    {
        return stats.changeExperience(delta);
    }

    public boolean modifyMovement(int delta)
    {
        return stats.changeMovement(delta);
    }

    //Derived stat modifiers
    public boolean modifyLevel(int level)
    {
        return stats.addDerivedStat(new DerivedStats(level,0,0,0,0,0));
    }

    public boolean modifyMaxLife(int life)
    {
        return stats.addDerivedStat(new DerivedStats(0,life,0,0,0,0));
    }

    public boolean modifyMaxMana(int mana)
    {
        return stats.addDerivedStat(new DerivedStats(0,0,mana,0,0,0));
    }

    public boolean modifyOffensiveRating(int rating)
    {
        return stats.addDerivedStat(new DerivedStats(0,0,0,rating,0,0));
    }

    public boolean modifyDefensiveRating(int rating)
    {
        return stats.addDerivedStat(new DerivedStats(0,0,0,0,rating,0));
    }

    public boolean modifyArmorRating(int rating)
    {
        return stats.addDerivedStat(new DerivedStats(0,0,0,0,0,rating));
    }

    // Other modifiers

    public void modifyCurrentLife(int delta)
    {
        int newCurrentLife = getCurrentLife() + delta;
        int maxLife = getMaxLife();

        if (newCurrentLife > maxLife)
        {
            newCurrentLife = maxLife;
        }
        else if (newCurrentLife <= 0)
        {
            if (getLives() == 1)
            {
                newCurrentLife = 0;
                modifyLives(-1);
            }
            else
            {
                newCurrentLife = maxLife;
                modifyLives(-1);
            }
        }

        this.currentLife = newCurrentLife;
    }

    public void modifyCurrentMana(int delta)
    {
        int newCurrentMana = getCurrentMana() + delta;
        int maxMana = getMaxMana();

        if (newCurrentMana > maxMana)
        {
            newCurrentMana = maxMana;
        }
        else if (newCurrentMana <= 0)
        {
            newCurrentMana = 0;
        }

        this.currentLife = newCurrentMana;
    }

    public boolean addDerivedStat(DerivedStats derivedStats){ return stats.addDerivedStat(derivedStats); }

    public boolean removeDerivedStat(DerivedStats derivedStats){return stats.removeDerivedStat(derivedStats); }

    /*
    * Methods
    * */

    // Hook for visitor
    public void accept(EntityVisitor eVisitor)
    {
        eVisitor.visitEntity(this);
    }

    public void updatePosition(PositionHex pos){
        this.position = pos;
    }

    //movement
    public boolean move(DirectionHex d, Map map){
        this.direction = d;
        MovementVisitor visitor = new MovementVisitor();
        Tile t = map.getTile(this.position.getPosInDirection(this.direction));
        t.acceptTileVisitor(visitor);
        boolean canMove = visitor.canMove();
        if(canMove){
            map.moveEntity(this.position.getPosInDirection(this.direction), this);
            //updatePosition(this.position.getPosInDirection(this.direction));
        }
        return canMove;
    }

}
