package com.herosandwich.controller;

import javafx.scene.input.KeyCode;

import java.security.Key;
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
        keyBindings.put(KeyCode.Q,      Action.ATTACK);
        keyBindings.put(KeyCode.W,      Action.BIND_WONDS);
        keyBindings.put(KeyCode.E,      Action.BARGAIN);
        keyBindings.put(KeyCode.R,      Action.SKILL4);
        keyBindings.put(KeyCode.F,      Action.USE);
        keyBindings.put(KeyCode.A,      Action.SEARCH_MOVE_NORTH_WEST);
        keyBindings.put(KeyCode.S,      Action.SEARCH_MOVE_NORTH);
        keyBindings.put(KeyCode.D,      Action.SEARCH_MOVE_NORTH_EAST);
        keyBindings.put(KeyCode.Z,      Action.SEARCH_MOVE_SOUTH_WEST);
        keyBindings.put(KeyCode.X,      Action.SEARCH_MOVE_SOUTH);
        keyBindings.put(KeyCode.C,      Action.SEARCH_MOVE_SOUTH_EAST);
    }

    /** Return the action bound to the input key **/
    public Action getAction(KeyCode code) {
        return keyBindings.get(code);
    }

    /** Change the key binding of an action **/
    public void changeKey(KeyCode oldKey, KeyCode newKey) {
        // If the key you're trying to bind was already in use, unbind it from the action it was bound to
        if ( keyBindings.containsKey(newKey) ) {
            Action duplicate = keyBindings.remove(newKey);
            keyBindings.put(null, duplicate);
        }
        Action action = keyBindings.remove(oldKey);
        keyBindings.put(newKey, action);
    }
}