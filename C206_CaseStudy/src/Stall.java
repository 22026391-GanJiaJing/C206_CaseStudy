import java.util.HashMap;
import java.util.Map;

public class Stall {
    private String name;
  private MenuItem menu;

    public Stall(String name,MenuItem menu) {
        this.name = name;
        this.menu =menu;
        
    }
    public Stall(String name) {
        this.name = name;
        this.menu =null;
        
    }

    public void setMenu(MenuItem menu) {
		this.menu = menu;
	}
	public MenuItem getMenu() {
		return menu;
	}

	public String getName() {
        return name;
    }

}
