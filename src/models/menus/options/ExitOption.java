package models.menus.options;

public  class ExitOption extends Option{
	public ExitOption(){
		name = "Exit";
	}
  	public void execute(){
  		System.exit(0);
  	}
}
