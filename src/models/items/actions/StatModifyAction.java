package models.items.actions;

import java.util.ArrayList;
import java.util.List;

public abstract class StatModifyAction implements IAction
{
    int baseModifier;

    public StatModifyAction(int baseModifier)
    {
        this.baseModifier = baseModifier;
    }

    protected int getModificationAmount()
    {
        return baseModifier;
    }

    @Override
    public List<String> getSaveState() {
        List<String> state = new ArrayList<String>();
        state.add("\t\t\t\t\tStatModifyAction: " + baseModifier + System.getProperty("line.separator"));
        return state;
    }
}
