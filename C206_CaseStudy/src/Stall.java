import java.util.HashMap;
import java.util.Map;

public class Stall {
    private String name;
    private Map<String, Double> menu;

    public Stall(String name) {
        this.name = name;
        this.menu = new HashMap<>();
    }

    public String getName() {
        return name;
    }

    public void addItemToMenu(String item, double price) {
        menu.put(item, price);
    }

    public Map<String, Double> getMenu() {
        return menu;
    }
}
