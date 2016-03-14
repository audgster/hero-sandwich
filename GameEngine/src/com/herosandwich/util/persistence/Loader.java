package com.herosandwich.util.persistence;

import com.herosandwich.models.Game;
import com.herosandwich.models.entity.Character;

public interface Loader
{
    Game loadGame();

    Game loadGame(Character newPlayer);
}
