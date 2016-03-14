package com.herosandwich.creation.entity;

import com.herosandwich.models.entity.*;
import com.herosandwich.models.entity.Character;
import com.herosandwich.models.occupation.Occupation;
import com.herosandwich.util.visitor.movement.MovementCheckVisitor;

import java.util.HashMap;

public class NpcFactory
{
    private CharacterFactory characterFactory = new CharacterFactory();

    public Npc vendCustomInstance(
            String name,
            int lives,
            int strength,
            int agility,
            int intellect,
            int hardiness,
            int experience,
            int movement,
            DeriveStatStrategy statStrategy,
            Occupation occupation,
            MovementCheckVisitor visitor,
            Attitude attitudeTowardsPlayer,
            HashMap<Integer, Integer> sell,
            HashMap<Integer, Integer> buy,
            String[] thgs2say
    )
    {
        if (thgs2say.length < 1)
            throw new IllegalArgumentException("Npc cannot be speechless");
        if (attitudeTowardsPlayer == null)
            throw new IllegalArgumentException("Attitude towards player cannot be null");
        if (sell == null)
            throw new IllegalArgumentException("Npc Sales cannot be null");
        if (buy == null)
            throw new IllegalArgumentException("Npc Buys cannot be null");

        Character character = characterFactory.vendCustomInstance(
                name, lives, strength, agility, intellect, hardiness, experience, movement, statStrategy, visitor, occupation);

        return new Npc(character, attitudeTowardsPlayer, sell, buy, thgs2say);
    }

    public Npc transformFromCharacter(Character character, Attitude attitude, HashMap<Integer, Integer> sell, HashMap<Integer, Integer> buy, String[] thgs2say)
    {
        return new Npc(character, attitude, sell, buy, thgs2say);
    }

    public Npc vendDefaultInstance()
    {
        return new Npc();
    }
}
