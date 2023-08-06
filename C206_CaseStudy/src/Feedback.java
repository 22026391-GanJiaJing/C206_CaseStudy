/**
 * I declare that this code was written by me. I will not copy or allow others
 * to copy my code. I understand that copying code is considered as plagiarism.
 *
 * Gan Jia Jing, Aug 6, 2023 9:26:26 PM
 */

/**
 * @author 22026391
 *
 */
public class Feedback {
	private Account acc;
	private String Feedback;
	private int Rating;
	private Stall stall;
	
	public Feedback(Account acc, String feedback, int rating, Stall stall) {
		super();
		this.acc = acc;
		Feedback = feedback;
		Rating = rating;
		this.stall = stall;
	}
	public Account getAcc() {
		return acc;
	}
	public String getFeedback() {
		return Feedback;
	}
	public int getRating() {
		return Rating;
	}
	public Stall getStall() {
		return stall;
	}
	
	
	
	
}
