import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MenuManagement {
	private static List<MenuItem> menuItems = new ArrayList<>();

	public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nMenu Management System");
            System.out.println("1. Add new item to the menu");
            System.out.println("2. View all items in the menu");
            System.out.println("3. Delete an item from the menu");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine();
 

public class MenuManagement {
    private static List<MenuItem> menuItems = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nMenu Management System");
            System.out.println("1. Add new item to the menu");
            System.out.println("2. View all items in the menu");
            System.out.println("3. Delete an item from the menu");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine();


            switch (choice) {
                case 1:
                    System.out.print("Enter the new item name: ");
                    String newItemName = scanner.nextLine();
                    System.out.print("Enter the price for " + newItemName + ": ");
                    double newItemPrice = scanner.nextDouble();
                    scanner.nextLine(); // Consume newline character
                    addItem(newItemName, newItemPrice);
                    break;
                case 2:
                    viewMenu();
                    break;
                case 3:
                    System.out.print("Enter the item to delete: ");
                    String itemToDelete = scanner.nextLine();
                    deleteItem(itemToDelete);
                    break;
                case 4:
                    System.out.println("Exiting Menu Management System. Goodbye!");
                    scanner.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void addItem(String itemName, double itemPrice) {
        MenuItem newItem = new MenuItem(itemName, itemPrice);
        menuItems.add(newItem);
        System.out.println("Item added successfully!");
    }

    private static void viewMenu() {
        System.out.println("\nMenu Items:");
        System.out.println("--------------------------------------------------");
        System.out.printf("%-30s %s%n", "Item Name", "Price ($)");
        System.out.println("--------------------------------------------------");
        for (MenuItem item : menuItems) {
            System.out.printf("%-30s %.2f%n", item.getName(), item.getPrice());
        }
        System.out.println("--------------------------------------------------");
    }

    private static void deleteItem(String itemName) {
        for (int i = 0; i < menuItems.size(); i++) {
            MenuItem item = menuItems.get(i);
            if (item.getName().equalsIgnoreCase(itemName)) {
                menuItems.remove(i);
                System.out.println("Item deleted successfully!");
                return;
            }
        }
        System.out.println("Item not found in the menu.");
    }
}
}
