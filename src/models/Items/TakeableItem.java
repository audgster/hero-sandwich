package models.Items;

public abstract class TakeableItem extends Item {
    /* METHODS */
    
    /*  executeInteraction(:Tile,:Entity): void
    **  in: The Entity initiating the interaction and the Tile it takes place on
    */
   abstract void executeInteraction(Tile, Entity) {};
}
