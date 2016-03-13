package com.herosandwich.controller;

import javafx.scene.input.KeyCode;

import java.util.HashMap;

public class KeyBindings {
    private HashMap<KeyCode,Action> keyBindings;

    public KeyBindings() {
        keyBindings = new HashMap<KeyCode,Action>();
        keyBindings.put(KeyCode.DIGIT8, Action.MOVE_NORTH);
        keyBindings.put(KeyCode.DIGIT9, Action.MOVE_NORTH_EAST);
        keyBindings.put(KeyCode.DIGIT3, Action.MOVE_SOUTH_EAST);
        keyBindings.put(KeyCode.DIGIT2, Action.MOVE_SOUTH);
        keyBindings.put(KeyCode.DIGIT1, Action.MOVE_SOUTH_WEST);
        keyBindings.put(KeyCode.DIGIT7, Action.MOVE_NORTH_WEST);
    }
    
    public Action getAction(KeyCode code) {
        return keyBindings.get(code);
    }
}