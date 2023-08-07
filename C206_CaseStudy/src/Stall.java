import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Stall {
	private String name;
	private ArrayList<MenuItem> menu;
	private ArrayList<Feedback> Feedback;

	public Stall(String name,ArrayList<MenuItem> menu) {
		this.name = name;
		this.menu =menu;
		this.Feedback=null;
	}
	
	
	
	public ArrayList<Feedback> getFeedback() {
		return Feedback;
	}

	public Stall(String name) {
		this.name = name;
		this.menu =null;

	}

	public void setMenu(ArrayList<MenuItem>  menu) {
		this.menu = menu;
	}
	public ArrayList<MenuItem>  getMenu() {
		return menu;
	}

	public String getName() {
		return name;
	}



}
