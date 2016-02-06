package models;

import views.Listener;
import java.util.*;

public interface Subject{
	
	public void addListener(Listener listener);
	
	public void removeListener(Listener listener);
	
	public void notifyListeners();
	
}
