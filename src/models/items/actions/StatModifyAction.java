package models.items.actions;

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
}
