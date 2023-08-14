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
		// Test if AccountList is empty
		assertEquals("Test that the Account arrayList is empty",0,AccountList.size());
		// Attempt to retrieve the Accounts from accountlist
		assertEquals("",AccountList.get(0).getName());
		//Test case 2
		
		//add two items and view list
		AccountList.add(A1);
		AccountList.add(A2);
		assertEquals(2, AccountList.size());
	

	}
	@Test
	public void testViewAllmenus() {
		//Test Case 1
		// Test if AccountList is empty
		assertEquals("Test that the Account arrayList is empty",0,AccountList.size());
		// Attempt to retrieve the Accounts from accountlist
		assertEquals("",AccountList.get(0).getName());
		//Test case 2
		
		//add two items and view list
		AccountList.add(A1);
		AccountList.add(A2);
		assertEquals(2, AccountList.size());
	



	}
	@Test
	public void testViewAllorders() {
		//Test Case 1
		// Test if AccountList is empty
		assertEquals("Test that the Account arrayList is empty",0,AccountList.size());
		// Attempt to retrieve the Accounts from accountlist
		assertEquals("",AccountList.get(0).getName());
		//Test case 2
		
		//add two items and view list
		AccountList.add(A1);
		AccountList.add(A2);
		assertEquals(2, AccountList.size());
	


	}
	@Test
	public void testViewAllqueue() {
		//Test Case 1
		// Test if AccountList is empty
		assertEquals("Test that the Account arrayList is empty",0,AccountList.size());
		// Attempt to retrieve the Accounts from accountlist
		assertEquals("",AccountList.get(0).getName());
		//Test case 2
		
		//add two items and view list
		AccountList.add(A1);
		AccountList.add(A2);
		assertEquals(2, AccountList.size());
		



	}
	@Test
	public void testViewAllfeedbacks() {
		//Test Case 1
		// Test if AccountList is empty
		assertEquals("Test that the Account arrayList is empty",0,AccountList.size());
		// Attempt to retrieve the Accounts from accountlist
		assertEquals("",AccountList.get(0).getName());
		//Test case 2
		
		//add two items and view list
		AccountList.add(A1);
		AccountList.add(A2);
		assertEquals(2, AccountList.size());
		


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
	    // Test case 1: Adding a menu item to a stall's menu
	    MenuItem newItem = new MenuItem("New Item", 10.0);
	    Stall targetStall = StallList.get(0); // Assuming you have stalls in the list
	    targetStall.getMenu().add(newItem);
	    assertEquals(1, targetStall.getMenu().size());

	    // Test case 2: Adding multiple menu items and verifying the count
	    ArrayList<MenuItem> newMenuItems = new ArrayList<>();
	    newMenuItems.add(new MenuItem("Item 1", 8.0));
	    newMenuItems.add(new MenuItem("Item 2", 12.0));
	    targetStall.getMenu().addAll(newMenuItems);
	    assertEquals(3, targetStall.getMenu().size());
	}
	@Test
	public void testAddorder() {
		// Test case 1: Adding an order to the OrderList
	    ArrayList<MenuItem> MenuItems = new ArrayList<>();
	    MenuItems.add(new MenuItem("Item 1", 8.0));
	    Cart.add(MenuItems.get(0));
	    assertEquals(1, Cart.size());

	    // Test case 2: Adding multiple orders and verifying the count
	    Cart.add(MenuItems.get(0));
	    Cart.add(MenuItems.get(0));
	    assertEquals(3, Cart.size());
	}
	
	@Test
	public void testAddqueue() {
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
	    // Test case 1: Adding feedback to the feedbackList
	    Feedback newFeedback = new Feedback(A1, "Nice", 8, s1);
	    feedbackList.add(newFeedback);
	    assertEquals(1, feedbackList.size());

	    // Test case 2: Adding multiple feedbacks and verifying the count
	    feedbackList.add(new Feedback(A2, "Nice", 8, s1));
	    feedbackList.add(new Feedback(A3, "Nice", 8, s1));
	    assertEquals(3, feedbackList.size());
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
		ArrayList<MenuItem> menuList = new ArrayList<MenuItem>();
	    menuList.add(new MenuItem("Item1", 5.0));
	    Stall stall = new Stall("StallWithMenu", menuList);
	    StallList.add(stall);
	    
	    int initialSize = stall.getMenu().size();
	    
	    boolean removed = stall.getMenu().remove(menuList.get(0));
	    assertTrue(removed);
	    assertEquals(initialSize - 1, stall.getMenu().size());

	    // Test if can delete when not in list
	    int newSize = stall.getMenu().size();
	    boolean notRemoved = stall.getMenu().remove(menuList.get(0));
	    assertFalse(notRemoved);
	    assertEquals(newSize, stall.getMenu().size());
	}
	
	@Test
	public void testDeleteorder() {
	    ArrayList<MenuItem> MenuItems = new ArrayList<>();
	    MenuItems.add(new MenuItem("Item 1", 8.0));
	    Cart.add(MenuItems.get(0));
	    int initialSize = Cart.size();

	    boolean removed = Cart.remove(MenuItems.get(0));
	    assertTrue(removed);
	    assertEquals(initialSize - 1, Cart.size());

	    int newSize = Cart.size();
	    boolean notRemoved = Cart.remove(MenuItems.get(0));
	    assertFalse(notRemoved);
	    assertEquals(newSize, Cart.size());
	}
	@Test
	public void testDeleteQueue() {
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
