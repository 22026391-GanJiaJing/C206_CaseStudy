
/**
 * I declare that this code was written by me.
 * I will not copy or allow others to copy my code.
 * I understand that copying code is considered as plagiarism.
 *
 * 22013795, 4 Aug 2023 11:17:18 am
 */

public class OrderItem {
	private MenuItem menuItem;
	private int quantity;  
	private String specialInstructions;

	public OrderItem(MenuItem menuItem, int quantity, String specialInstructions) {
		this.menuItem = menuItem;
		this.quantity = quantity;
		this.specialInstructions = specialInstructions;
	}

	public MenuItem getMenuItem() {
		return menuItem;
	}

	public void setMenuItem(MenuItem menuItem) {
		this.menuItem = menuItem;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getSpecialInstructions() {
		return specialInstructions;
	}

	public void setSpecialInstructions(String specialInstructions) {
		this.specialInstructions = specialInstructions;
	}

}

