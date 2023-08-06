import java.util.ArrayList;

public class Tastybites {

	public static void main(String[] args) {

		ArrayList<Account> AccountList = new ArrayList<Account>();
		ArrayList<Stall> StallList = new ArrayList<Stall>();

		AccountList.add(new Account("bob", "111", "Customer"));
		AccountList.add(new Account("alice", "222", "Staff"));
		StallList.add(new Stall("MacKfc"));
		StallList.add(new Stall("BurgerWing"));

		int option = 0;
		boolean loginprocess=false;
		while (option != 3 && loginprocess==false) {

			Tastybites.Mainmenu();
			option = Helper.readInt("Enter an option > ");

			if (option == 1) {
				// Create new Account
				CreateAccount(AccountList);


			} else if (option == 2) {
				// Login
				String name =Helper.readString("Username: ");
				String password=Helper.readString("Password: ");

				for (Account a:AccountList) {
					if(a.getName().equalsIgnoreCase(name) && a.getPassword().equalsIgnoreCase(password)) {
						loginprocess=true;
						System.out.println("Login successful");
					}
				}
				if (loginprocess==false) {
					System.out.println("Wrong Username or Password");
				}
			} else if (option == 3 || loginprocess==true ) {
				System.out.println("Closing System");
			} else {
				System.out.println("Invalid option");}}
		
		//for staff
		option = 0;
		while (option != 3 && loginprocess==false) {

			Tastybites.Mainmenu();
			option = Helper.readInt("Enter an option > ");

			if (option == 1) {
				// View all Accounts
				

			} else if (option == 2) {
				// Add new stall && display
				
				
			}else if (option == 3) {
				// Delete Stalls && display
				
				
			}
			else if (option == 4) {
				// edit stall menu choose stall to edit then add or delete option
				
				
			}
			else if (option == 5) {
				// view queues
				
				
			}
			else if (option == 5) {
				// delete queue (completed order)
				
				
			}
			else if (option == 5) {
				// view all feedback
				
				
			}
			
			else if (option == 6 || loginprocess==true ) {
				System.out.println("Closing System");
			} else {
				System.out.println("Invalid option");}}
		
		//for customer
		option = 0;
		while (option != 3 && loginprocess==false) {

			Tastybites.Mainmenu();
			option = Helper.readInt("Enter an option > ");

			if (option == 1) {
				// Delete Account


			} else if (option == 2) {
				// view all stalls choose alr then go into menu or feedback to add or delete feedback

					
			} else if (option == 2) {
				//Add to cart
				
				

					
			}
			 else if (option == 2) {
					//Delete from cart
					
					

						
				}
			 else if (option == 2) {
					//View all order 
					
					

						
				}
			 else if (option == 2) {
					//make payment (add to queue)
					
					

						
				}else if (option == 3 || loginprocess==true ) {
				System.out.println("Closing System");
			} else {
				System.out.println("Invalid option");}}



	}




	/**
	 * @param AccountList
	 */
	private static void CreateAccount(ArrayList<Account> AccountList) {
		String name =Helper.readString("Name: ");
		String password=Helper.readString("Password: ");
		String role=Helper.readString("Role (Staff/Customer): ");
		role.toLowerCase();
		AccountList.add(new Account(name,password,role));
	}




	public static void Mainmenu() {
		System.out.println("Tasty Bites!");
		System.out.println("1. Create New Account");
		System.out.println("2. Login");
		System.out.println("3. Quit");
		Helper.line(80, "-");

	}}

//	public static void setHeader(String header) {
//		Helper.line(80, "-");
//		System.out.println(header);
//		Helper.line(80, "-");
//	}
//
//	public static String showAvailability(boolean isAvailable) {
//		String avail;
//
//		if (isAvailable == true) {
//			avail = "Yes";
//		} else {
//			avail = "No";
//		}
//		return avail;
//	}

//	//================================= Option 1 View items (CRUD- Read) =================================
//	public static String retrieveAllCamcorder(ArrayList<Camcorder> camcorderList) {
//		String output = "";
//
//		for (int i = 0; i < camcorderList.size(); i++) {
//			if (camcorderList.get(i).getIsAvailable()) {
//				output += String.format("%-10s %-30s %-10s %-10s %-20d\n", camcorderList.get(i).getAssetTag(),
//					camcorderList.get(i).getDescription(), 
//					ResourceCentre.showAvailability(camcorderList.get(i).getIsAvailable()),
//					camcorderList.get(i).getDueDate(),camcorderList.get(i).getOpticalZoom());
//			}
//		}
//		return output;
//	}
//	
//	public static void viewAllCamcorder(ArrayList<Camcorder> camcorderList) {
//		ResourceCentre.setHeader("CAMCORDER LIST");
//		String output = String.format("%-10s %-30s %-10s %-10s %-20s\n", "ASSET TAG", "DESCRIPTION",
//				"AVAILABLE", "DUE DATE","OPTICAL ZOOM");
//		 output += retrieveAllCamcorder(camcorderList);	
//		System.out.println(output);
//	}
//
//	public static String retrieveAllChromebook(ArrayList<Chromebook> chromebookList) {
//		String output = "";
//		// write your code here
//
//		for (int i = 0; i < chromebookList.size(); i++) {
//			if (chromebookList.get(i).getIsAvailable()) {
//				output += String.format("%-10s %-30s %-10s %-10s %-20s\n", chromebookList.get(i).getAssetTag(),
//						chromebookList.get(i).getDescription(), 
//					ResourceCentre.showAvailability(chromebookList.get(i).getIsAvailable()),
//					chromebookList.get(i).getDueDate(),chromebookList.get(i).getOs()); 
//			 }
//		}
//		return output;
//	}
//	public static void viewAllChromebook(ArrayList<Chromebook> chromebookList) {
//		// write your code her
//		ResourceCentre.setHeader("CHROMEBOOK LIST");
//		String output = String.format("%-10s %-30s %-10s %-10s %-20s\n", "ASSET TAG", "DESCRIPTION",
//				"AVAILABLE", "DUE DATE","OPTICAL ZOOM");
//		 output += retrieveAllChromebook(chromebookList);	
//
//		System.out.println(output);
//	}
//
//	//================================= Option 2 Add an item (CRUD - Create) =================================
//	public static Camcorder inputCamcorder() {
//		String tag = Helper.readString("Enter asset tag > ");
//		String description = Helper.readString("Enter description > ");
//		int zoom = Helper.readInt("Enter optical zoom > ");
//
//		Camcorder cc= new Camcorder(tag, description, zoom); 
//		return cc;
//		
//	}
//	public static void addCamcorder(ArrayList<Camcorder> camcorderList, Camcorder cc) {
//		Camcorder item;
//		for(int i = 0; i < camcorderList.size(); i++) {
//			item = camcorderList.get(i);
//			if (item.getAssetTag().equalsIgnoreCase(cc.getAssetTag()) )
//				return;
//		}
//		if ((cc.getAssetTag().isEmpty()) || (cc.getDescription().isEmpty()) ) {
//			return;
//		}
//		
//		camcorderList.add(cc);
//	}
//	
//	public static Chromebook inputChromebook() {	
//		Chromebook cb =null;
//		// write your code here
//		String tag = Helper.readString("Enter asset tag > ");
//		String description = Helper.readString("Enter description > ");
//		String os = Helper.readString("Enter operating system > ");
//
//		cb= new Chromebook(tag, description, os);
//		return cb;
//		
//	}	
//	public static void addChromebook(ArrayList<Chromebook> chromebookList, Chromebook cb) {
//
//		Chromebook item;
//		for(int i = 0; i < chromebookList.size(); i++) {
//			item = chromebookList.get(i);
//			if (item.getAssetTag().equalsIgnoreCase(cb.getAssetTag()) )
//				return;
//		}
//		if ((cb.getAssetTag().isEmpty()) || (cb.getDescription().isEmpty()) ) {
//			return;
//		}
//	
//		chromebookList.add(cb);
//	}
//	
//	//================================= Option 3 Loan an item (CRUD - Update) =================================
//	public static boolean doLoanCamcorder(ArrayList<Camcorder> camcorderList, String tag, String dueDate) {
//		
//		boolean isLoaned = false;
//
//		if (tag.isEmpty() || dueDate.isEmpty())
//			return false;
//		
//		for (int i = 0; i < camcorderList.size(); i++) {
//			if (tag.equalsIgnoreCase(camcorderList.get(i).getAssetTag())
//					&& camcorderList.get(i).getIsAvailable() == true) {
//				
//				camcorderList.get(i).setIsAvailable(false);
//				camcorderList.get(i).setDueDate(dueDate);
//				
//				isLoaned = true;
//			}
//		}
//		return isLoaned;
//	}
//	public static void loanCamcorder(ArrayList<Camcorder> camcorderList) {
//		ResourceCentre.viewAllCamcorder(camcorderList);
//		String tag = Helper.readString("Enter asset tag > ");
//		String due = Helper.readString("Enter due date > ");
//		Boolean isLoaned =doLoanCamcorder(camcorderList, tag, due);
//		if (isLoaned == false) {
//			System.out.println("Invalid asset tag");
//		} else {
//			System.out.println("Camcorder " + tag + " loaned out");
//		}
//	}
//	
//	public static boolean doLoanChromebook(ArrayList<Chromebook> chromebookList, String tag, String dueDate) {
//		// write your code here
//		boolean isLoaned = false;
//
//		  if (tag.isEmpty() || dueDate.isEmpty())
//		   return false;
//		  
//		  for (int i = 0; i < chromebookList.size(); i++) {
//		   if (tag.equalsIgnoreCase(chromebookList.get(i).getAssetTag())
//		     && chromebookList.get(i).getIsAvailable() == true) {
//		    
//		    chromebookList.get(i).setIsAvailable(false);
//		    chromebookList.get(i).setDueDate(dueDate);
//		    
//		    isLoaned = true; 
//		   }
//		  }
//		  return isLoaned;
//	}
//	public static void loanChromebook(ArrayList<Chromebook> chromebookList) {
//		// write your code here		
//		ResourceCentre.viewAllChromebook(chromebookList); 
//		  String tag = Helper.readString("Enter asset tag > ");
//		  String due = Helper.readString("Enter due date > ");
//		  Boolean isLoaned =doLoanChromebook(chromebookList, tag, due);
//		  if (isLoaned == false) {
//		   System.out.println("Invalid asset tag");
//		  } else {
//		   System.out.println("Chromebook " + tag + " loaned out");
//		  }
//		 
//	}
//	
//	//================================= Option 4 Return an item (CRUD - Update)=================================
//	public static boolean doReturnCamcorder(ArrayList<Camcorder> camcorderList,String tag) {
//		boolean isReturned = false;
//
//		if (tag.isEmpty())
//			return false;
//		
//		for (int i = 0; i < camcorderList.size(); i++) {
//			if (tag.equalsIgnoreCase(camcorderList.get(i).getAssetTag())
//					&& camcorderList.get(i).getIsAvailable() == false) {
//				camcorderList.get(i).setIsAvailable(true);
//				camcorderList.get(i).setDueDate("");
//				isReturned = true;
//				
//			}
//		}
//		return isReturned;
//		
//	}
//	public static void returnCamcorder(ArrayList<Camcorder> camcorderList) {
//		ResourceCentre.viewAllCamcorder(camcorderList);
//		String tag = Helper.readString("Enter asset tag > ");
//		Boolean isReturned = doReturnCamcorder(camcorderList, tag);
//		
//		if (isReturned == false) {
//			System.out.println("Invalid asset tag");
//		} else {
//			System.out.println("Camcorder " + tag + " returned");
//		}
//	}
//
//	public static boolean doReturnChromebook(ArrayList<Chromebook> chromebookList,String tag){
//		boolean isReturned = false;
//		// write your code here
//
//		
//		if (tag.isEmpty())
//			return false;
//		
//		for (int i = 0; i < chromebookList.size(); i++) {
//			if (tag.equalsIgnoreCase(chromebookList.get(i).getAssetTag())
//					&& chromebookList.get(i).getIsAvailable() == false) {
//				chromebookList.get(i).setIsAvailable(true);
//				chromebookList.get(i).setDueDate("");
//				isReturned = true;
//				
//			}
//		}
//		return isReturned;
//	}
//	public static void returnChromebook(ArrayList<Chromebook> chromebookList) {
//		// write your code here
//		ResourceCentre.viewAllChromebook(chromebookList);
//		String tag = Helper.readString("Enter asset tag > ");
//		Boolean isReturned = doReturnChromebook(chromebookList, tag);
//		
//		if (isReturned == false) {
//			System.out.println("Invalid asset tag");
//		} else {
//			System.out.println("Camcorder " + tag + " returned");
//		}
//	}
//
//
//}
