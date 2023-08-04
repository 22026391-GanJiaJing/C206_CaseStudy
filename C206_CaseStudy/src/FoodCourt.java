import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


public class FoodCourt {
    private Map<String, Stall> stalls;

    public FoodCourt() {
        stalls = new HashMap<>();
    }

    public void addStall(String name) {
        stalls.put(name.toLowerCase(), new Stall(name));
    }

    public void addItemToStallMenu(String stallName, String item, double price) {
        String lowercaseStallName = stallName.toLowerCase();
        if (stalls.containsKey(lowercaseStallName)) {
            stalls.get(lowercaseStallName).addItemToMenu(item, price);
        } else {
            System.out.println("Stall not found!");
        }
    }

    public void displayMenu(String stallName) {
        String lowercaseStallName = stallName.toLowerCase();
        if (stalls.containsKey(lowercaseStallName)) {
            System.out.println("Menu for " + stalls.get(lowercaseStallName).getName() + ":");
            Map<String, Double> menu = stalls.get(lowercaseStallName).getMenu();
            for (Map.Entry<String, Double> entry : menu.entrySet()) {
                System.out.println(entry.getKey() + " - $" + entry.getValue());
            }
        } else {
            System.out.println("Stall not found!");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        FoodCourt foodCourt = new FoodCourt();

        foodCourt.addStall("Stall A");
        foodCourt.addItemToStallMenu("Stall A", "Noodles", 5.99);
        foodCourt.addItemToStallMenu("Stall A", "Rice Bowl", 6.99);

        foodCourt.addStall("Stall B");
        foodCourt.addItemToStallMenu("Stall B", "Burger", 4.99);
        foodCourt.addItemToStallMenu("Stall B", "Fries", 2.49);

        System.out.println("Available stalls:");
        for (String stallName : foodCourt.stalls.keySet()) {
            System.out.println(stallName);
        }

        while (true) {
            System.out.println("Enter the name of the stall to view its menu (or 'exit' to quit): ");
            String selectedStall = scanner.nextLine().trim();

            if (selectedStall.equalsIgnoreCase("exit")) {
                break;
            }

            foodCourt.displayMenu(selectedStall);
        }

        System.out.println("Thank you for using the Food Court Menu Viewer!");
        scanner.close();
    }
}
