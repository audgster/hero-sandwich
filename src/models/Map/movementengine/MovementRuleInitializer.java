package models.map.movementengine;

import models.map.movementengine.interfaces.IMovementRule;
import models.map.movementengine.interfaces.IMovementRuleInitializer;

import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MovementRuleInitializer implements IMovementRuleInitializer
{
    public HashMap<String, IMovementRule> initializeMovementRules() { return new HashMap<>(); }

    private static final String CONFIG_RELATIVE_PATH = "//////";

    public void parseMovementRule()
    {
        for (URL u : ((URLClassLoader)Thread.currentThread().getContextClassLoader()).getURLs()) {
            System.out.println(u.toString());
        }
    }
}
