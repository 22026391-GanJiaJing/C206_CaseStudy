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
		ArrayList<Account> AccountList = new ArrayList<Account>();
		// Test if AccountList is empty
		assertEquals("Test that the Account arrayList is empty",0,AccountList.size());
		// Attempt to retrieve the Accounts from accountlist
		AccountList.add(A3);
		assertEquals("Chloe",AccountList.get(0).getName());


		//Test case 2
		//add two items and view list
		AccountList.add(A1);
		AccountList.add(A2);
		assertEquals(3, AccountList.size());
		String ExpectedOutput="Alice,Bob";
		String ActualOutput=AccountList.get(1).getName()+","+AccountList.get(2).getName();
		assertEquals(ExpectedOutput, ActualOutput);





	}
	@Test
	public void testViewAllstalls() {
		//Test Case 1
		ArrayList<Stall> StallList = new ArrayList<Stall>();
		// Test if StallList is empty
		assertEquals("Test that the Stall arrayList is empty",0,StallList.size());
		// Attempt to retrieve the Accounts from StallList
		StallList.add(s3);
		assertEquals("IAte",StallList.get(0).getName());
		//Test case 2

		//add two items and view list
		StallList.add(s1);
		StallList.add(s2);
		assertEquals(3, StallList.size());
		String ExpectedOutput="MacAte,CoolMeat";
		String ActualOutput=StallList.get(1).getName()+","+StallList.get(2).getName();
		assertEquals(ExpectedOutput, ActualOutput);


	}
	@Test
	public void testViewAllmenus() {
		ArrayList<MenuItem> menuList1=new ArrayList<MenuItem>();
		// Test Case 1: Checking if menuList1 is initially empty
		assertEquals("Test that the Menu arrayList is empty", 0, menuList1.size());

		// Adding menu items to menuList1
		menuList1.add(new MenuItem("chicken rice", 4.50));
		assertEquals("chicken rice", menuList1.get(0).getName());

		// Test Case 2: Adding multiple menu items and checking their names
		menuList1.add(new MenuItem("maggie", 5.50));
		menuList1.add(new MenuItem("chicken cutlet", 8.50));
		menuList1.add(new MenuItem("chicken porridge", 2.50));

		assertEquals(4, menuList1.size());

		String expectedOutput = "maggie,chicken cutlet,chicken porridge";
		String actualOutput = menuList1.get(1).getName() + "," + menuList1.get(2).getName() + "," + menuList1.get(3).getName();
		assertEquals(expectedOutput, actualOutput);
	}

	@Test
	public void testViewAllorders() {
		ArrayList<MenuItem> Cart = new ArrayList<MenuItem>();
		// Test Case 1: Checking if Cart is initially empty
		assertEquals("Test that the Cart arrayList is empty", 0, Cart.size());

		// Adding an order to the Cart
		MenuItem menuItem = new MenuItem("Chicken Rice", 4.50);
		Cart.add(menuItem);
		assertEquals(1, Cart.size());

		// Test Case 2: Adding multiple orders and checking the size
		Cart.add(new MenuItem("Noodles", 3.50));
		Cart.add(new MenuItem("Fried Rice", 5.0));
		assertEquals(3, Cart.size());

		String expectedOutput = "Noodles,Fried Rice";
		String actualOutput = Cart.get(1).getName() + "," + Cart.get(2).getName();
		assertEquals(expectedOutput, actualOutput);
	}


	@Test
	public void testViewAllqueue() {
		ArrayList<Queue> QueueList = new ArrayList<Queue>();
		// Test Case 1: Checking if QueueList is initially empty
		assertEquals("Test that the Queue arrayList is empty", 0, QueueList.size());

		// Creating sample data for QueueList
		Queue queue1 = new Queue(A1, Cart);
		QueueList.add(queue1);

		// Checking if QueueList is not empty
		assertFalse("QueueList should not be empty", QueueList.isEmpty());

		// Test Case 2: Adding multiple queues and checking the size
		QueueList.add(new Queue(A2, Cart));
		QueueList.add(new Queue(A3, Cart));
		assertEquals(3, QueueList.size());
	}


	@Test
	public void testViewAllfeedbacks() {
		ArrayList<Feedback> feedbackList = new ArrayList<Feedback>();
		// Test Case 1: Checking if feedbackList is initially empty
		assertEquals("Test that the feedback arrayList is empty", 0, feedbackList.size());

		// Adding feedback to the feedbackList
		Feedback feedback1 = new Feedback(A1, "Nice food!", 4, s1);
		Tastybites.AddnewFeedback(feedbackList, feedback1);
		assertEquals(1, feedbackList.size());

		// Test Case 2: Adding multiple feedbacks and checking the size and content
		Feedback feedback2 = new Feedback(A2, "Great service!", 5, s2);
		Tastybites.AddnewFeedback(feedbackList, feedback2);
	

		Feedback feedback3 = new Feedback(A3, "Average experience.", 3, s1);
		Tastybites.AddnewFeedback(feedbackList, feedback3);
	

		assertEquals(3, feedbackList.size());
	}

	@Test
	public void testAdduser() {
		ArrayList<Account> AccountList = new ArrayList<Account>();
		//test case 1
		AccountList.add(A1);
		assertEquals(1, AccountList.size());

		// Test case 2: Adding multiple users and verifying the count
		AccountList.add(A2);
		AccountList.add(A3);
		assertEquals(3, AccountList.size());
	}

	@Test
	public void testAddstall() {
		ArrayList<Stall> StallList = new ArrayList<Stall>();
		// Test case 1: Adding a stall to the StallList
		StallList.add(s1);
		assertEquals(1, StallList.size());

		// Test case 2: Adding multiple stalls and verifying the count
		StallList.add(s2);
		StallList.add(s3);
		assertEquals(3, StallList.size());
	}

	@Test
	public void testAddmenu() {
		ArrayList<MenuItem> menuList = new ArrayList<>();
		Stall stall = new Stall("TestStall", menuList);

		// Test Case 1: Adding a menu item to a stall's menu and checking the size
		MenuItem newItem = new MenuItem("New Item", 10.0);
		stall.getMenu().add(newItem);
		assertEquals(1, stall.getMenu().size());

		// Test Case 2: Adding multiple menu items and checking the size
		ArrayList<MenuItem> newMenuItems = new ArrayList<>();
		newMenuItems.add(new MenuItem("Item 1", 8.0));
		newMenuItems.add(new MenuItem("Item 2", 12.0));
		stall.getMenu().addAll(newMenuItems);
		assertEquals(3, stall.getMenu().size());
	}

	@Test
	public void testAddorder() {
		ArrayList<MenuItem> Cart = new ArrayList<MenuItem>();
		// Creating sample menu items
		MenuItem menuItem1 = new MenuItem("Item 1", 8.0);
		MenuItem menuItem2 = new MenuItem("Item 2", 12.0);

		// Adding a menu item to the Cart
		Cart.add(menuItem1);
		assertEquals(1, Cart.size());

		// Adding multiple menu items to the Cart
		Cart.add(menuItem2);
		Cart.add(menuItem1);
		assertEquals(3, Cart.size());
	}

	@Test
	public void testAddqueue() {
		ArrayList<Queue> QueueList = new ArrayList<Queue>();
		// Test case 1: Adding a queue to the QueueList
		Queue newQueue = new Queue(A1, Cart);
		QueueList.add(newQueue);
		assertEquals(1, QueueList.size());

		// Test case 2: Adding multiple queues and verifying the count
		QueueList.add(new Queue(A2, Cart));
		QueueList.add(new Queue(A3, Cart));
		assertEquals(3, QueueList.size());
	}

	@Test
	public void testAddfeedback() {
		ArrayList<Feedback> feedbackList = new ArrayList<Feedback>();
		// Test case 1: Adding feedback to the feedbackList
		assertEquals(0, feedbackList.size());
		Feedback newFeedback = new Feedback(A1, "Nice", 4, s1);
		Tastybites.AddnewFeedback(feedbackList, newFeedback);
		assertEquals(1, feedbackList.size());

		// Test case 2: Adding multiple feedbacks and verifying the count
		Tastybites.AddnewFeedback(feedbackList, new Feedback(A2, "Nice", 4, s1));
		Tastybites.AddnewFeedback(feedbackList, new Feedback(A3, "Nice", 4, s1));
		assertEquals(3, feedbackList.size());
		
		// Test case 3: check if the first feedback added is the same.
		assertEquals(newFeedback,feedbackList.get(0));

	}

	@Test
	public void testDeleteuser() {
		ArrayList<Account> AccountList = new ArrayList<Account>();
		// Test if can delete from list
		//Test if can delete when not in list

		AccountList.add(A1);
		int initialSize = AccountList.size();

		boolean removed = AccountList.remove(A1);
		assertTrue(removed);
		assertEquals(initialSize - 1, AccountList.size());

		// Test if can delete when not in list

		int newSize = AccountList.size();
		boolean notRemoved = AccountList.remove(A1);
		assertFalse(notRemoved);
		assertEquals(newSize, AccountList.size());
	}

	@Test
	public void testDeletestall() {
		ArrayList<Stall> StallList = new ArrayList<Stall>();
		StallList.add(s1);
		int initialSize = StallList.size();

		boolean removed = StallList.remove(s1);
		assertTrue(removed);
		assertEquals(initialSize - 1, StallList.size());

		// Test if can delete when not in list
		int newSize = StallList.size();
		boolean notRemoved = StallList.remove(s1);
		assertFalse(notRemoved);
		assertEquals(newSize, StallList.size());
	}

	@Test
	public void testDeletemenu() {
		// Creating a new stall and adding it to the StallList
		ArrayList<MenuItem> initialMenu = new ArrayList<>();
		ArrayList<Stall> StallList = new ArrayList<Stall>();
		Stall newStall = new Stall("New Stall", initialMenu);
		StallList.add(newStall);

		// Adding a menu item to the new stall's menu
		MenuItem newItem = new MenuItem("New Item", 10.0);
		newStall.getMenu().add(newItem);
		int initialSize = newStall.getMenu().size();

		// Test Case 1: Deleting a menu item from the stall's menu
		boolean removed = newStall.getMenu().remove(newItem);
		assertTrue(removed);
		assertEquals(initialSize - 1, newStall.getMenu().size());

		// Test Case 2: Attempting to delete a menu item that doesn't exist
		int newSize = newStall.getMenu().size();
		boolean notRemoved = newStall.getMenu().remove(newItem);
		assertFalse(notRemoved);
		assertEquals(newSize, newStall.getMenu().size());
	}


	@Test
	public void testDeleteorder() {
		ArrayList<MenuItem> Cart = new ArrayList<MenuItem>();
		// Test Case 1: Deleting an order from the Cart
		MenuItem item1 = new MenuItem("Item 1", 8.0);
		Cart.add(item1);
		int initialSize = Cart.size();

		boolean removed = Cart.remove(item1);
		assertTrue(removed);
		assertEquals(initialSize - 1, Cart.size());

		// Test Case 2: Deleting a non-existing order from the Cart
		MenuItem item2 = new MenuItem("Item 2", 10.0);
		int newSize = Cart.size();
		boolean notRemoved = Cart.remove(item2);
		assertFalse(notRemoved);
		assertEquals(newSize, Cart.size());
	}

	@Test
	public void testDeleteQueue() {
		ArrayList<Queue> QueueList = new ArrayList<Queue>();
		Queue queue1 = new Queue(A1, Cart);
		QueueList.add(queue1);
		int initialSize = QueueList.size();

		boolean removed = QueueList.remove(queue1);
		assertTrue(removed);
		assertEquals(initialSize - 1, QueueList.size());

		int newSize = QueueList.size();
		boolean notRemoved = QueueList.remove(queue1);
		assertFalse(notRemoved);
		assertEquals(newSize, QueueList.size());
	}

	@Test
	public void testDeletefeedback() {
		ArrayList<Feedback> feedbackList = new ArrayList<Feedback>();
		Feedback feedback1 = new Feedback(A1, "Nice", 8, s1);
		feedbackList.add(feedback1);
		int initialSize = feedbackList.size();

		boolean removed = feedbackList.remove(feedback1);
		assertTrue(removed);
		assertEquals(initialSize - 1, feedbackList.size());

		int newSize = feedbackList.size();
		boolean notRemoved = feedbackList.remove(feedback1);
		assertFalse(notRemoved);
		assertEquals(newSize, feedbackList.size());
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