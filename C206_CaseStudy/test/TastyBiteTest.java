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

	private ArrayList<Account> AccountList;
	private ArrayList<Stall> StallList;

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

		AccountList= new ArrayList<Account>();
		StallList= new ArrayList<Stall>();
	}


	@Test
	public void testAddCamcorder() {
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
	public void testAddChromebook() {
		// fail("Not yet implemented");
		// write your code here 
		
		// Test if can add to list
		assertEquals("Test if Chromebook list is empty",0,chromebookList.size());
		Chromebook cb4 = new Chromebook("CB0011", "My Google Chromebook 1st", "Mac OS");
		ResourceCentre.addChromebook(chromebookList, cb4);
		assertEquals("Test if the object has been added into the list",1,chromebookList.size());
		Chromebook cb5 = new Chromebook("CB0012", "SAMSUNG Chromebook 4+", "Win 10");
		ResourceCentre.addChromebook(chromebookList, cb5);
		assertEquals("Test if another object has been added to the list", 2, chromebookList.size());
		assertSame(cb5, chromebookList.get(1));
		Chromebook cb6 = new Chromebook("CB0011", "My Google Chromebook 1st", "Mac OS");
		
		//Test duplicates
		ResourceCentre.addChromebook(chromebookList, cb6);
		assertEquals("Test if duplicates cannot be added", 2, chromebookList.size());
		
		//Test empty
		Chromebook cbEmpty = new Chromebook("CB0014", "", "Win 10");
		ResourceCentre.addChromebook(chromebookList, cbEmpty);
		assertEquals("Test if duplicates cannot be added", 2, chromebookList.size());
	}

	@Test
	public void testRetrieveAllCamcorder() {
		//Test Case 1
		// Test if Item list is not null and empty
		assertNotNull("Test if there is valid Camcorder arraylist to add to", camcorderList);
		assertEquals("Test that the Camcorder arraylist is empty.", 0, camcorderList.size());
		// Attempt to retrieve the Camcoders 
		String allCamcorder= ResourceCentre.retrieveAllCamcorder(camcorderList);
		String testOutput = "";
		// Test if the output is empty
		assertEquals("Test that nothing is displayed", testOutput, allCamcorder);

		//Test Case 2
		ResourceCentre.addCamcorder(camcorderList, cc1);
		ResourceCentre.addCamcorder(camcorderList, cc2);
		// Test that the list is not empty
		assertEquals("Test that Camcorder arraylist size is 2.", 2, camcorderList.size());
		// Attempt to retrieve the Camcoders 
		allCamcorder= ResourceCentre.retrieveAllCamcorder(camcorderList);
		testOutput = String.format("%-10s %-30s %-10s %-10s %-20d\n","CC0011", "Nikon HDSLR", "Yes", "", 40);
		testOutput += String.format("%-10s %-30s %-10s %-10s %-20d\n","CC0012", "Sony DSC-RX100M7", "Yes", "", 20);
		// Test that the details are displayed correctly
		assertEquals("Test that the display is correct.", testOutput, allCamcorder);

		//Test Case 3
		cc3.setIsAvailable(false);
		ResourceCentre.addCamcorder(camcorderList, cc3);
		assertEquals("Test that Camcorder arraylist size is 2.", 3, camcorderList.size());
		assertFalse("Test that the last item in the arraylist is not available", camcorderList.get(2).getIsAvailable());
		// Attempt to retrieve the Camcoders 
		allCamcorder= ResourceCentre.retrieveAllCamcorder(camcorderList);
		testOutput = String.format("%-10s %-30s %-10s %-10s %-20d\n","CC0011", "Nikon HDSLR", "Yes", "", 40);
		testOutput += String.format("%-10s %-30s %-10s %-10s %-20d\n","CC0012", "Sony DSC-RX100M7", "Yes", "", 20);
		// Test that the details are displayed correctly
		assertEquals("Test that the display is correct.", testOutput, allCamcorder);
	}

	@Test
	public void testRetrieveAllChromebook() {
		//fail("Not yet implemented");
		// write your code here
		//fail("Not yet implemented");
		  // write your code here
		  // Test if Item list is not null and empty
		  assertNotNull("Test if there is valid Chromebook arraylist to add to", chromebookList);
		  assertEquals("Test that the Chromebook arraylist is empty.", 0, chromebookList.size());
		  // Attempt to retrieve the Chromebook
		  String allChromebook= ResourceCentre.retrieveAllChromebook(chromebookList);
		  String testOutput = "";
		  // Test if the output is empty
		  assertEquals("Test that nothing is displayed", testOutput, allChromebook);
		  
		//Test case 2
		  ResourceCentre.addChromebook(chromebookList, cb1);
		  ResourceCentre.addChromebook(chromebookList, cb2);
		  // Test that the list is not empty
		  assertEquals("Test that Chromebook arraylist size is 2.", 2, chromebookList.size());
		  //  Attempt to retrieve the Chromebook
		  allChromebook= ResourceCentre.retrieveAllChromebook(chromebookList);
		  testOutput = String.format("%-10s %-30s %-10s %-10s %-20s\n","CB0011", "My Google Chromebook 1st", "Yes", "", "Mac OS");
		  testOutput += String.format("%-10s %-30s %-10s %-10s %-20s\n","CB0012", "SAMSUNG Chromebook 4+", "Yes", "", "Win 10");
		  
		//Test Case 3 
		  cb3.setIsAvailable(false);
		  ResourceCentre.addChromebook(chromebookList, cb3);
		  assertEquals("Test that Chromebook arraylist size is 2.", 3, chromebookList.size());
		  assertFalse("Test that the last item in the arraylist is not available", chromebookList.get(2).getIsAvailable());
		  // Attempt to retrieve the Chromebook
		  allChromebook= ResourceCentre.retrieveAllChromebook(chromebookList);
		  testOutput = String.format("%-10s %-30s %-10s %-10s %-20s\n","CB0011", "My Google Chromebook 1st", "Yes", "", "Mac OS");
		  testOutput += String.format("%-10s %-30s %-10s %-10s %-20s\n","CB0012", "SAMSUNG Chromebook 4+", "Yes", "", "Win 10");
		  // Test that the details are displayed correctly
		  assertEquals("Test that the display is correct.", testOutput, allChromebook);
		
	}

	@Test
	public void testDoLoanCamcorder() {

		// Test Case 1 - Loan an available Item
		assertNotNull("test if there is valid Camcorder arraylist to loan from", camcorderList);
		ResourceCentre.addCamcorder(camcorderList, cc1);
		Boolean ok = ResourceCentre.doLoanCamcorder(camcorderList, "CC0011", "8-8-2020" );
		assertTrue("Test if an available item is ok to loan?", ok);
		assertFalse(camcorderList.get(0).getIsAvailable());
		assertEquals(camcorderList.get(0).getDueDate(),"8-8-2020");

		// Test Case 2 - Loan an unavailable item
		cc2.setIsAvailable(false);
		ResourceCentre.addCamcorder(camcorderList, cc2);
		assertFalse("Test that there is an item not available", camcorderList.get(1).getIsAvailable());
		ok = ResourceCentre.doLoanCamcorder(camcorderList, "CC0012", "8-8-2020" );
		assertFalse("Test that the loan fails.", ok);	

		// Test Case 3 - Item not found
		ok = ResourceCentre.doLoanCamcorder(camcorderList, "CC0016", "8-8-2020" );
		assertFalse("Test that the loan fails.", ok);

		// Test case 4 - Missing details
		ResourceCentre.addCamcorder(camcorderList, cc3);
		assertTrue("Test that there is an item available", camcorderList.get(2).getIsAvailable());
		ok = ResourceCentre.doLoanCamcorder(camcorderList, "CC0013", "" );
		assertFalse("Test that the loan fails.", ok);
	}

	@Test
	public void testDoLoanChromebook() {
		//fail("Not yet implemented");
		// write your code here
		  assertNotNull("test if there is valid Chromebook arraylist to loan from", chromebookList);
		  ResourceCentre.addChromebook(chromebookList, cb1);
		  Boolean ok = ResourceCentre.doLoanChromebook(chromebookList, "CB0011", "8-8-2020" );
		  assertTrue("Test if an available item is ok to loan?", ok);
		  assertFalse(chromebookList.get(0).getIsAvailable());
		  assertEquals(chromebookList.get(0).getDueDate(),"8-8-2020");

		  // Test Case 2 - Loan an unavailable item
		  cb2.setIsAvailable(false);
		  ResourceCentre.addChromebook(chromebookList, cb2);
		  assertFalse("Test that there is an item not available", chromebookList.get(1).getIsAvailable());
		  ok = ResourceCentre.doLoanChromebook(chromebookList, "CB0012", "8-8-2020" );
		  assertFalse("Test that the loan fails.", ok); 

		  // Test Case 3 - Item not found
		  ok = ResourceCentre.doLoanChromebook(chromebookList, "CB0016", "8-8-2020" );
		  assertFalse("Test that the loan fails.", ok);

		  // Test case 4 - Missing details
		  ResourceCentre.addChromebook(chromebookList, cb3);
		  assertTrue("Test that there is an item available", chromebookList.get(2).getIsAvailable());
		  ok = ResourceCentre.doLoanChromebook(chromebookList, "CB0013", "" );
		  assertFalse("Test that the loan fails.", ok);
	}

	@Test
	public void testDoReturnCamcorder() {
		
		// Test case 1: Return a loaned out item
		assertNotNull("Test if there is valid Camcorder arraylist to add to", camcorderList);
		ResourceCentre.addCamcorder(camcorderList, cc1);
		Boolean ok = ResourceCentre.doLoanCamcorder(camcorderList, "CC0011", "8-8-2020" );
		assertTrue("Test if CC0011 is successfully loaned out.", ok);
		Boolean isReturned = ResourceCentre.doReturnCamcorder(camcorderList, "CC0011");
		assertTrue("Test if the return of CC0011 is successful.", isReturned);
		assertTrue("Test that CC0011 is now available.",camcorderList.get(0).getIsAvailable());

		// Test case 2: Return an item that is not loaned out
		isReturned = ResourceCentre.doReturnCamcorder(camcorderList, "CC0011");
		assertFalse("Test that the return fails.", isReturned);
				
		// Test case 3: Return an item that does not exist 
		isReturned = ResourceCentre.doReturnCamcorder(camcorderList, "CC0013");
		assertFalse("Test the the return of CC0013 fails.", isReturned);	
	}
	
	@Test
	public void testDoReturnChromebook()  {
		//fail("Not yet implemented");
		// write your code here
		// Test case 1: Return a loaned out item
		assertNotNull("Test if there is valid Camcorder arraylist to add to", chromebookList);
		ResourceCentre.addChromebook(chromebookList, cb1);
		Boolean ok = ResourceCentre.doLoanChromebook(chromebookList, "CB0011", "8-8-2020" );
		assertTrue("Test if CB0011 is successfully loaned out.", ok);
		Boolean isReturned = ResourceCentre.doReturnChromebook(chromebookList, "CB0011");
		assertTrue("Test if the return of CB0011 is successful.", isReturned); 
		assertTrue("Test that CB0011 is now available.",chromebookList.get(0).getIsAvailable());

		// Test case 2: Return an item that is not loaned out
		isReturned = ResourceCentre.doReturnChromebook(chromebookList, "CB0011");
		assertFalse("Test that the return fails.", isReturned);
				
		// Test case 3: Return an item that does not exist 
		isReturned = ResourceCentre.doReturnChromebook(chromebookList, "CB0013");
		assertFalse("Test the the return of CB0013 fails.", isReturned);	
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
		AccountList = null;
		StallList = null;

	}

}
