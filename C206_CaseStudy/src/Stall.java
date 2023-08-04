import java.util.HashMap;
import java.util.Map;
/**
 * I declare that this code was written by me.
 * I will not copy or allow others to copy my code.
 * I understand that copying code is considered as plagiarism.
 *
 * gohja, 4 Aug 2023 9:54:43 am
 */

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
