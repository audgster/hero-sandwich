package models.Items;

/**
 * Created by simonnea on 2/1/16.
 */


public abstract class Item {

    /* METHODS */
    
    /*  executeInteraction(:Tile,:Entity): void
    **  in: The Entity initiating the interaction and the Tile it takes place on
    */
    abstract void executeInteraction(Tile, Entity) {};
    
}
