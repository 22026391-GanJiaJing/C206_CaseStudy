import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
// C206 AY2023 SEM1 - Eclipse 21-09 JDK16

public class TastyBiteTest {
	// prepare test data
	private Account A1;
	private Account A2;
	private Account A3;
	private Account A4;
	private Stall s1;
	private Stall s2;
	private Stall s3;
	private Stall s4;
	private ArrayList<Account> AccountList;
	private ArrayList<Stall> StallList;
	private ArrayList<Queue> QueueList;
	private ArrayList<MenuItem> Cart;
	private ArrayList<Feedback> feedbackList;

	private ArrayList<MenuItem> menuList1;
	private ArrayList<MenuItem> menuList2;
	private ArrayList<MenuItem> menuList3;
	private ArrayList<MenuItem> menuList4;


	public TastyBiteTest() {
		super();
	}

	@Before
	public void setUp() throws Exception {
		// prepare test data
		A1 = new Account("Alice", "111", "Staff");
		A2 = new Account("Bob", "222", "Staff");
		A3 = new Account("Chloe", "333", "Customer");
		A4 = new Account("David", "444", "Customer");
		s1 = new Stall("MacAte");
		s2 = new Stall("CoolMeat");
		s3 = new Stall("IAte");
		s4 = new Stall("PearList");

		ArrayList<Account> AccountList = new ArrayList<Account>();
		ArrayList<Stall> StallList = new ArrayList<Stall>();
		ArrayList<Queue> QueueList = new ArrayList<Queue>();
		ArrayList<MenuItem> Cart = new ArrayList<MenuItem>();
		ArrayList<Feedback> feedbackList = new ArrayList<Feedback>();

		ArrayList<MenuItem> menuList1=new ArrayList<MenuItem>();
		ArrayList<MenuItem> menuList2=new ArrayList<MenuItem>();
		ArrayList<MenuItem> menuList3=new ArrayList<MenuItem>();
		ArrayList<MenuItem> menuList4=new ArrayList<MenuItem>();

		menuList1.add(new MenuItem("chicken rice",4.50));
		menuList1.add(new MenuItem("maggie",5.50));
		menuList1.add(new MenuItem("chicken cutlet",8.50));
		menuList1.add(new MenuItem("chicken porriage",2.50));

		menuList2.add(new MenuItem("Duck rice",4.50));
		menuList2.add(new MenuItem("Noodles",5.50));
		menuList2.add(new MenuItem("Roasted Duck",8.50));
		menuList2.add(new MenuItem("Duck porriage",2.50));

		menuList3.add(new MenuItem("chicken rice",4.50));
		menuList3.add(new MenuItem("maggie",5.50));
		menuList3.add(new MenuItem("chicken cutlet",8.50));
		menuList3.add(new MenuItem("chicken porriage",2.50));

		menuList4.add(new MenuItem("Duck rice",4.50));
		menuList4.add(new MenuItem("Noodles",5.50));
		menuList4.add(new MenuItem("Roasted Duck",8.50));
		menuList4.add(new MenuItem("Duck porriage",2.50));


		StallList.add(new Stall("MacAte",menuList1));
		StallList.add(new Stall("CoolMeat",menuList2));
		StallList.add(new Stall("IAte",menuList3));
		StallList.add(new Stall("PearList",menuList4));


	}





	@Test
	public void testViewAllusers() {
		//Test Case 1
		// Test if AccountList is not null and empty
		
		// Attempt to retrieve the Accounts from accountlist
		
		
		

	
	}
	@Test
	public void testViewAllstalls() {
		//Test Case 1
				// Test if AccountList is not null and empty
				
				// Attempt to retrieve the Accounts from accountlist

	}
	@Test
	public void testViewAllmenus() {
		//Test Case 1
				// Test if AccountList is not null and empty
				
				// Attempt to retrieve the Accounts from accountlist

	}
	@Test
	public void testViewAllorders() {
		//Test Case 1
				// Test if AccountList is not null and empty
				
				// Attempt to retrieve the Accounts from accountlist

	}
	@Test
	public void testViewAllqueue() {
		//Test Case 1
				// Test if AccountList is not null and empty
				
				// Attempt to retrieve the Accounts from accountlist

	}
	@Test
	public void testViewAllfeedbacks() {
		//Test Case 1
				// Test if AccountList is not null and empty
				
				// Attempt to retrieve the Accounts from accountlist

	}
	@Test
	public void testAdduser() {
		// Item list is not null and it is empty
		assertNotNull("Test if there is valid Camcorder arraylist to add to", camcorderList);
		assertEquals("Test that the Camcorder arraylist is empty.", 0, camcorderList.size());
		//Given an empty list, after adding 1 item, the size of the list is 1
		ResourceCentre.addCamcorder(camcorderList, cc1);		
		assertEquals("Test that the Camcorder arraylist size is 1.", 1, camcorderList.size());


		// Add an item
		ResourceCentre.addCamcorder(camcorderList, cc2);
		assertEquals("Test that the Camcorder arraylist size is now 2.", 2, camcorderList.size());
		//The item just added is as same as the last item in the list
		assertSame("Test that Camcorder is added to the end of the list.", cc2, camcorderList.get(1));

		// Add an item that already exists in the list
		ResourceCentre.addCamcorder(camcorderList, cc2);
		assertEquals("Test that the Camcorder arraylist size is unchange.", 2, camcorderList.size());

		// Add an item that has missing detail
		Camcorder cc_missing = new Camcorder("CC0014", "", 60);
		ResourceCentre.addCamcorder(camcorderList, cc_missing);
		assertEquals("Test that the Camcorder arraylist size is unchange.", 2, camcorderList.size());
	}
	@Test
	public void testAddstall() {

	}
	@Test
	public void testAddmenu() {

	}
	@Test
	public void testAddorder() {

	}
	@Test
	public void testAddqueue() {

	}
	@Test
	public void testAddfeedback() {

	}
	@Test
	public void testDeleteuser() {
		// Test if can delete from list
		//Test if can delete when not in list
		
	}
	@Test
	public void testDeletestall() {

	}
	@Test
	public void testDeletemenu() {

	}
	@Test
	public void testDeleteorder() {

	}
	@Test
	public void testDeleteQueue() {

	}
	@Test
	public void testDeletefeedback() {

	}





}

@After
public void tearDown() throws Exception {
	A1 = null;
	A2 = null;
	A3 = null;
	A4 = null;
	s1 = null;
	s2 = null;
	s3 = null;
	s4 = null;
	AccountList = null;
	StallList = null;
	QueueList = null;
	Cart = null;
	feedbackList = null;
	menuList1 = null;
	menuList2 = null;
	menuList3 = null;
	menuList4 = null;

}

}
