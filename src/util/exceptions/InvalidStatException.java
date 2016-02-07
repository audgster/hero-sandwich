package util.exceptions;

public class InvalidStatException extends Exception
{
    public InvalidStatException()
    {
        super("An attempt was made to modify a stat with an invalid value");
    }

    public InvalidStatException(String message)
    {
        super(message);
    }
}
