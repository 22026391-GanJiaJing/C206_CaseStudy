import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Stall {
    private String name;
    private int storeNo;
  private ArrayList menu;
  private ArrayList Feedback;

    public Stall(String name,int storeNo,ArrayList menu) {
        this.name = name;
        this.menu =menu;
        this.storeNo=storeNo;
    }
    public int getStoreNo() {
		return storeNo;
	}
	public Stall(String name) {
        this.name = name;
        this.menu =null;
        
    }

    public void setMenu(ArrayList menu) {
		this.menu = menu;
	}
	public ArrayList getMenu() {
		return menu;
	}

	public String getName() {
        return name;
    }

	

}
