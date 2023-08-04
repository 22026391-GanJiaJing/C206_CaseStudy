import java.util.ArrayList;
import java.util.List;
/**
 * I declare that this code was written by me.
 * I will not copy or allow others to copy my code.
 * I understand that copying code is considered as plagiarism.
 *
 * 22013795, 4 Aug 2023 11:19:31 am
 */

public class Order {

	private List<OrderItem> items;

	public Order() {
		items = new ArrayList<>();
	}

	public void addItem(OrderItem item) {
		items.add(item);
	}
	public void updateItem(int index, OrderItem newItem) {
		if (index >= 0 && index < items.size()) {
			items.set(index, newItem);
		} else {
			System.out.println("Invalid index. Item not updated.");
		}
	}

	public void removeItem(int index) {
		if (index >= 0 && index < items.size()) {
			items.remove(index);
		} else {
			System.out.println("Invalid index. Item not removed.");
		}
	}

	public void clearOrder() {
		items.clear();
	}

	public double getTotalAmount() {
		double total = 0;
		for (OrderItem item : items) {
			total += item.getMenuItem().getPrice() * item.getQuantity();
		}
		return total;
	}

	public List<OrderItem> getItems() {
		return items;
	}
}

