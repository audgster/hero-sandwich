package com.herosandwich.creation;

import com.herosandwich.creation.entity.*;
import com.herosandwich.creation.init.*;
import com.herosandwich.models.entity.*;
import com.herosandwich.models.items.takeableItems.equipableItems.EquipableItem;
import com.herosandwich.models.occupation.Smasher;
import com.herosandwich.models.occupation.Sneak;
import com.herosandwich.models.occupation.Summoner;
import com.herosandwich.util.visitor.movement.AmphibiousMovementVisitor;
import com.herosandwich.util.visitor.movement.FlyingMovementVisitor;
import com.herosandwich.util.visitor.movement.GroundMovementVisitor;

import java.util.HashMap;

public class GameFactory
{
    private PetFactory petFactory = new PetFactory();
    private MountFactory mountFactory = new MountFactory();
    private NpcFactory npcFactory = new NpcFactory();
    private PlayerFactory playerFactory = new PlayerFactory();

    ItemInit init = ItemInit.getInstance();

    public Player vendSummonerAvatar(String name)
    {
        return playerFactory.vendCustomInstance(
                name,
                SummonerStats.lives,
                SummonerStats.strength,
                SummonerStats.agility,
                SummonerStats.intellect,
                SummonerStats.hardiness,
                SummonerStats.experience,
                SummonerStats.movement,
                new ModiferWithWeightStatStrategy(5),
                new GroundMovementVisitor(),
                new Summoner(),
                3
        );
    }

    public Player vendSmasherAvatar(String name)
    {
        return playerFactory.vendCustomInstance(
                name,
                SmasherStats.lives,
                SmasherStats.strength,
                SmasherStats.agility,
                SmasherStats.intellect,
                SmasherStats.hardiness,
                SmasherStats.experience,
                SmasherStats.movement,
                new ModiferWithWeightStatStrategy(5),
                new GroundMovementVisitor(),
                new Smasher(),
                3
        );
    }

    public Player vendSneakAvatar(String name)
    {
        return playerFactory.vendCustomInstance(
                name,
                SneakStats.lives,
                SneakStats.strength,
                SneakStats.agility,
                SneakStats.intellect,
                SneakStats.hardiness,
                SneakStats.experience,
                SneakStats.movement,
                new ModiferWithWeightStatStrategy(5),
                new GroundMovementVisitor(),
                new Sneak(),
                3
        );
    }

    // Hostile
    public Npc vendMoldySandwichNpc(NpcStats.Strength strength)
    {
        int modifier = strength.ordinal() + 1;

        if (strength == NpcStats.Strength.BOSS)
            modifier *= 5;

        Npc moldySandwich = npcFactory.vendCustomInstance(
                "Moldy Sandwich",
                NpcStats.lives,
                NpcStats.strength,
                NpcStats.agility,
                NpcStats.intellect,
                NpcStats.hardiness,
                NpcStats.experience,
                NpcStats.movement,
                new ModiferWithWeightStatStrategy(modifier),
                new Smasher(),
                new GroundMovementVisitor(),
                Attitude.HOSTILE,
                new HashMap<>(),
                new HashMap<>(),
                new String[] {"I will destroy you!", "It's only a flesh wound", "Come here I'll bite your bread off"}
        );

        moldySandwich.allocateSkillPoints(Skill.TWO_HANDED_WEAPON, 1);
        moldySandwich.allocateSkillPoints(Skill.ONE_HANDED_WEAPON, 1);
        moldySandwich.allocateSkillPoints(Skill.BRAWL, 5);

        EquipableItem brawler = init.getEquipableItem(ItemInit.ItemNames.FIST_WRAPS.ordinal());
        moldySandwich.insertItemToInventory(brawler);
        moldySandwich.equipItem(brawler);

        return moldySandwich;
    }

    // Very Hostile
    public Npc vendWonderbreadPBnJNpc(NpcStats.Strength strength)
    {
        int modifier = strength.ordinal() + 1;

        if (strength == NpcStats.Strength.BOSS)
            modifier *= 5;

        Npc wonderBread = npcFactory.vendCustomInstance(
                "Wonder Bread PBnJ (with No Crust)",
                NpcStats.lives,
                NpcStats.strength,
                NpcStats.agility,
                NpcStats.intellect,
                NpcStats.hardiness,
                NpcStats.experience,
                NpcStats.movement,
                new ModiferWithWeightStatStrategy(modifier),
                new Summoner(),
                new GroundMovementVisitor(),
                Attitude.VERY_HOSTILE,
                new HashMap<>(),
                new HashMap<>(),
                new String[] {"If you don't eat your meat, you can't have any pudding",
                        "How can you have any pudding if you don't eat your meat?"}
        );

        wonderBread.allocateSkillPoints(Skill.BOON, 1);
        wonderBread.allocateSkillPoints(Skill.BANE, 1);
        wonderBread.allocateSkillPoints(Skill.ENCHANTMENT, 5);

        EquipableItem staff = init.getEquipableItem(ItemInit.ItemNames.CELERY_STAFF.ordinal());
        wonderBread.insertItemToInventory(staff);
        wonderBread.equipItem(staff);

        return wonderBread;
    }

    // Neutral
    public Npc vendQuesedillaNpc(NpcStats.Strength strength)
    {
        int modifier = strength.ordinal() + 1;

        if (strength == NpcStats.Strength.BOSS)
            modifier *= 5;

        Npc quesedilla = npcFactory.vendCustomInstance(
                "Cheese Quesedilla",
                NpcStats.lives,
                NpcStats.strength,
                NpcStats.agility,
                NpcStats.intellect,
                NpcStats.hardiness,
                NpcStats.experience,
                NpcStats.movement,
                new ModiferWithWeightStatStrategy(modifier),
                new Sneak(),
                new GroundMovementVisitor(),
                Attitude.NEUTRAL,
                new HashMap<>(),
                new HashMap<>(),
                new String[] {"Hello señor",
                        "I'm not getting jalapeño business...",
                        "My business is nacho business"}
        );

        quesedilla.allocateSkillPoints(Skill.CREEP, 1);
        quesedilla.allocateSkillPoints(Skill.DETECTION, 1);
        quesedilla.allocateSkillPoints(Skill.REMOVE_TRAP, 1);

        EquipableItem staff = init.getEquipableItem(ItemInit.ItemNames.CIABATTA.ordinal());
        quesedilla.insertItemToInventory(staff);
        quesedilla.equipItem(staff);

        quesedilla.addOrReplaceSale(ItemInit.ItemNames.JALAPENO_POPPERS.ordinal(), 5);
        quesedilla.addOrReplaceSale(ItemInit.ItemNames.POTATO_CHIP_SHIV.ordinal(), 6);

        quesedilla.addOrReplaceSale(ItemInit.ItemNames.CELLOPHANE.ordinal(), 5);
        quesedilla.addOrReplaceSale(ItemInit.ItemNames.PLASTIC_SWORD.ordinal(), 15);
        quesedilla.addOrReplaceSale(ItemInit.ItemNames.ONION_RING_CHAKRAM.ordinal(), 10);
        quesedilla.addOrReplaceSale(ItemInit.ItemNames.POTATO_CHIP_SHIV.ordinal(), 7);
        quesedilla.addOrReplaceSale(ItemInit.ItemNames.PEA_SHOOTER.ordinal(), 6);

        quesedilla.addOrReplaceBuy(ItemInit.ItemNames.AMERICAN.ordinal(), 5);
        quesedilla.addOrReplaceBuy(ItemInit.ItemNames.PEPPER_JACK.ordinal(), 10);


        return quesedilla;
    }

    // Friendly
    public Npc vendDagwoodNpc(NpcStats.Strength strength)
    {
        int modifier = strength.ordinal() + 1;

        if (strength == NpcStats.Strength.BOSS)
            modifier *= 5;

        Npc dagwood = npcFactory.vendCustomInstance(
                "Dagwood, the king of all sandwiches",
                NpcStats.lives,
                NpcStats.strength,
                NpcStats.agility,
                NpcStats.intellect,
                NpcStats.hardiness,
                NpcStats.experience,
                NpcStats.movement,
                new ModiferWithWeightStatStrategy(modifier),
                new Summoner(),
                new GroundMovementVisitor(),
                Attitude.NEUTRAL,
                new HashMap<>(),
                new HashMap<>(),
                new String[] {"I'm much too beautiful to be eaten!",
                        "Beauty is in the stomach of the beholder"}
        );

        dagwood.allocateSkillPoints(Skill.ENCHANTMENT, 1);
        dagwood.allocateSkillPoints(Skill.BANE, 1);
        dagwood.allocateSkillPoints(Skill.BOON, 1);

        EquipableItem staff = init.getEquipableItem(ItemInit.ItemNames.CELERY_STAFF.ordinal());
        dagwood.insertItemToInventory(staff);
        dagwood.equipItem(staff);

        // Helm Items - sells
        dagwood.addOrReplaceSale(ItemInit.ItemNames.LETTUCE.ordinal(), 1);
        dagwood.addOrReplaceSale(ItemInit.ItemNames.TOMATO.ordinal(), 5);
        dagwood.addOrReplaceSale(ItemInit.ItemNames.ONION.ordinal(), 10);
        dagwood.addOrReplaceSale(ItemInit.ItemNames.PICKLES.ordinal(), 15);
        dagwood.addOrReplaceSale(ItemInit.ItemNames.BANANA_PEPPERS.ordinal(), 20);

        // Helm Items - buys
        dagwood.addOrReplaceBuy(ItemInit.ItemNames.LETTUCE.ordinal(), 1);
        dagwood.addOrReplaceBuy(ItemInit.ItemNames.TOMATO.ordinal(), 2);
        dagwood.addOrReplaceBuy(ItemInit.ItemNames.ONION.ordinal(), 6);
        dagwood.addOrReplaceBuy(ItemInit.ItemNames.PICKLES.ordinal(), 11);
        dagwood.addOrReplaceBuy(ItemInit.ItemNames.BANANA_PEPPERS.ordinal(), 16);

        return dagwood;
    }

    // Very Friendly
    public Npc vendDaveNpc(NpcStats.Strength strength)
    {
        int modifier = 100000000;

        Npc dave = npcFactory.vendCustomInstance(
                "Dave",
                NpcStats.lives,
                NpcStats.strength,
                NpcStats.agility,
                NpcStats.intellect,
                NpcStats.hardiness,
                NpcStats.experience,
                NpcStats.movement,
                new ModiferWithWeightStatStrategy(modifier),
                new Summoner(),
                new FlyingMovementVisitor(),
                Attitude.VERY_FRIENDLY,
                new HashMap<>(),
                new HashMap<>(),
                new String[] {"If you did that, it would be very sad cat",
                        "I hate hearing the door close during my close",
                        "Attacking me would be a Very Bad Idea (tm)",
                        "feline magic is powerful stuff.",
                        "Lions are such sweeties!",
                        "$45k for this 17th century cat? That's a Bargain!"
                }
        );

        dave.allocateSkillPoints(Skill.ENCHANTMENT, 5);
        dave.allocateSkillPoints(Skill.BANE, 5);
        dave.allocateSkillPoints(Skill.BOON, 5);

        EquipableItem staff = init.getEquipableItem(ItemInit.ItemNames.KITCHEN_STAFF.ordinal());
        dave.insertItemToInventory(staff);
        dave.equipItem(staff);

        // Helm Items - sells
        dave.addOrReplaceSale(ItemInit.ItemNames.LETTUCE.ordinal(), 1);
        dave.addOrReplaceSale(ItemInit.ItemNames.TOMATO.ordinal(), 5);
        dave.addOrReplaceSale(ItemInit.ItemNames.ONION.ordinal(), 10);
        dave.addOrReplaceSale(ItemInit.ItemNames.PICKLES.ordinal(), 15);
        dave.addOrReplaceSale(ItemInit.ItemNames.BANANA_PEPPERS.ordinal(), 20);

        // Helm Items - buys
        dave.addOrReplaceBuy(ItemInit.ItemNames.LETTUCE.ordinal(), 1);
        dave.addOrReplaceBuy(ItemInit.ItemNames.TOMATO.ordinal(), 2);
        dave.addOrReplaceBuy(ItemInit.ItemNames.ONION.ordinal(), 6);
        dave.addOrReplaceBuy(ItemInit.ItemNames.PICKLES.ordinal(), 11);
        dave.addOrReplaceBuy(ItemInit.ItemNames.BANANA_PEPPERS.ordinal(), 16);

        return dave;
    }

    public Pet vendTaterTotPet()
    {
        return petFactory.vendCustomInstance(
                "Tater Tot",
                1,
                1,
                1,
                1,
                1,
                1,
                1,
                new ModiferWithWeightStatStrategy(1000),
                new AmphibiousMovementVisitor()
        );
    }

    public Pet vendOlivePet()
    {
        return petFactory.vendCustomInstance(
                "Olive",
                1,
                1,
                1,
                1,
                1,
                1,
                1,
                new ModiferWithWeightStatStrategy(1000),
                new AmphibiousMovementVisitor()
        );
    }

    public Mount vendPlateMount()
    {
        return mountFactory.vendCustomMount(
                "Plate",
                45,
                null
        );
    }

    public Mount vendDeliBasketMount()
    {
        return mountFactory.vendCustomMount(
                "Deli Basket",
                45,
                null
        );
    }
}
