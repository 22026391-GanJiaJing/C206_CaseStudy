import java.util.ArrayList;

/**
 * I declare that this code was written by me. I will not copy or allow others
 * to copy my code. I understand that copying code is considered as plagiarism.
 *
 * Gan Jia Jing, Aug 8, 2023 5:43:59 AM
 */

/**
 * @author 22026391
 *
 */
public class Queue {
	
	private Account person;
	private ArrayList<MenuItem>cart ;
	public Account getPerson() {
		return person;
	}
	public ArrayList<MenuItem> getCart() {
		return cart;
	}
	public Queue(Account person, ArrayList<MenuItem> cart) {

		this.person = person;
		this.cart = cart;
	}
	
	
	
	
}
