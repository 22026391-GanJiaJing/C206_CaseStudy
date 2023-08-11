
/**
 * I declare that this code was written by me.
 * I will not copy or allow others to copy my code.
 * I understand that copying code is considered as plagiarism.
 *
 * gohja, 4 Aug 2023 12:07:09 pm
 */

public class MenuItem {
	private String name;
	private double price;
	private int quantity;

	public MenuItem(String name, double price) {
		this.name = name;
		this.price = price;
		this.quantity=0;
	}
	public MenuItem(String name, double price,int quan) {
		this.name = name;
		this.price = price;
		this.quantity=quan;
	}

	public String getName() {
		return name;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getPrice() {
		return price;
	}
}
