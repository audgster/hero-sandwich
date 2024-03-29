package controllers;
import models.menus.*;

public abstract class ControllerState{
	public abstract String toString();
	public abstract void north();
	public abstract void northEast();
	public abstract void east();
	public abstract void southEast();
	public abstract void south();
	public abstract void southWest();
	public abstract void west();
	public abstract void northWest();
	public abstract void enter();
}