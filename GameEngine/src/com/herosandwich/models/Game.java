package com.herosandwich.models;

import com.herosandwich.models.entity.Character;
import com.herosandwich.models.map.Map;

public class Game
{
    private Character avatar;
    private Map map;

    public void setAvatar(Character character)
    {
        this.avatar = character;
    }

    public void setMap(Map map)
    {
        this.map = map;
    }

    public Character getAvatar()
    {
        return this.avatar;
    }

    public Map getMap()
    {
        return this.map;
    }
}
