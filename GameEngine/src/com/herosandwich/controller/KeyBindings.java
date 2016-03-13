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
        keyBindings.put(KeyCode.Q,      Action.SKILL1);
        keyBindings.put(KeyCode.W,      Action.SKILL2);
        keyBindings.put(KeyCode.E,      Action.SKILL3);
        keyBindings.put(KeyCode.R,      Action.SKILL4);
        keyBindings.put(KeyCode.F,      Action.USE);
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