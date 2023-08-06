import java.util.ArrayList;

public class Tastybites {

	public static void main(String[] args) {

		ArrayList<Account> AccountList = new ArrayList<Account>();
		ArrayList<Stall> StallList = new ArrayList<Stall>();
		ArrayList<Account> QueueList = new ArrayList<Account>();
		ArrayList<MenuItem> Cart = new ArrayList<MenuItem>();

		AccountList.add(new Account("bob", "111", "Customer"));
		AccountList.add(new Account("alice", "222", "Staff"));
		StallList.add(new Stall("MacKfc"));
		StallList.add(new Stall("BurgerWing"));



		int option = 0;
		boolean loginprocess=false;

		Account used=null;
		String name="";
		String password="";


		while(loginprocess==false) {
			while (option != 3 && loginprocess==false) {

				Tastybites.Mainmenu();
				option = Helper.readInt("Enter an option > ");

				if (option == 1) {
					// Create new Account
					CreateAccount(AccountList);


				} else if (option == 2) {
					// Login
					name =Helper.readString("Username: ");
					password=Helper.readString("Password: ");

					for (Account a:AccountList) {
						if(a.getName().equalsIgnoreCase(name) && a.getPassword().equalsIgnoreCase(password)) {
							loginprocess=true;
							System.out.println("Login successful");
							used=a;
						}
					}
					if (loginprocess==false) {
						System.out.println("Wrong Username or Password");
					}
				} else if (option == 3  ) {
					System.out.println("Closing System");
					System.exit(0);
				} else {
					System.out.println("Invalid option");}}

			//for staff
			if(used.getRole().equalsIgnoreCase("staff")){
				option = 0;
				while (option != 3 && loginprocess==true) {

					Tastybites.Staffmenu();
					option = Helper.readInt("Enter an option > ");

					if (option == 1) {
						// View all Accounts
						ViewAllAccount(AccountList);

					} else if (option == 2) {
						// Add new stall && display
						String stallname =Helper.readString("Name: ");

						StallList.add(new Stall(stallname));

					}else if (option == 3) {
						// Delete Stalls && display
						ViewAllStalls(StallList);

						String SelectStall=Helper.readString("Name of Stall You Want to Delete: ");

						boolean found=false;

						for (Stall a : StallList) {
							if(a.getName().equalsIgnoreCase(SelectStall)) {
								StallList.remove(a);
								found=true;
								System.out.println("Stall deleted");
							}
						}
						if (found==false) {
							System.out.println("Stall not found");
						}


					}
					else if (option == 4) {
						ViewAllStalls(StallList);
						String stallchoose=Helper.readString("Choose Stall to Edit: " );



					}
					else if (option == 5) {
						// view queues choose to delete queue (completed order)
						System.out.println(String.format("%-20s%s", "NAME"));
						for (Account a : QueueList) {
							System.out.println(String.format("%-20s%s", a.getName()));
						}

					}
					else if (option == 6) {
						// view all feedback
						for (Stall a : StallList) {
							System.out.println(String.format("%-20s%s", a.getName()));
						}

					}
					else if (option == 7) {
						// Delete Account

						Helper.line(100, "-");
						char choice=Helper.readChar("Are you sure to delete Account?(Y/N) > ");
						Helper.line(100, "-");
						if(choice=='Y') {


							for (Account a : AccountList) {
								if(a.getName().equalsIgnoreCase(name)) {
									AccountList.remove(a);
									System.out.println("Stall deleted");
									loginprocess=false;
								}}}

					}

					else if (option == 8 ) {
						System.out.println("Closing System");
					} else {
						System.out.println("Invalid option");}}
			}
			else if(used.getRole().equalsIgnoreCase("customer")) {
				//for customer
				option = 0;
				while (option != 3 && loginprocess==true) {

					Tastybites.Customermenu();
					option = Helper.readInt("Enter an option > ");

					if (option == 1) {
						// Delete Account

						Helper.line(100, "-");
						choice=Helper.readChar("Are you sure to delete Account?(Y/N) > ");
						Helper.line(100, "-");
						if(choice=='Y') {


							for (Account a : AccountList) {
								if(a.getName().equalsIgnoreCase(name)) {
									AccountList.remove(a);
									System.out.println("Stall deleted");
									loginprocess=false;
								}
							}
						}

					} else if (option == 2) {
						ViewAllStalls(StallList);

					} else if (option == 3) {
						//Add to cart
						ViewCart(Cart);



					}
					else if (option == 4) {
						//Delete from cart
						ViewCart(Cart);



					}
					else if (option == 5) {
						//View cart 
						ViewCart(Cart);



					}
					else if (option == 6) {
						//make payment (add to queue)
						ViewCart(Cart);



					}else if (option == 7) {
						System.out.println("Closing System");
					} else {
						System.out.println("Invalid option");}}



			}

		}
	}

	/**
	 * @param Cart
	 */
	private static void ViewCart(ArrayList<MenuItem> Cart) {
		Helper.line(100, "-");
		System.out.println(String.format("%-20s%s", "NAME"));
		for (MenuItem a:Cart) {

			System.out.println(String.format("%-20s%s", a.getName()));
		}
		Helper.line(100, "-");
	}

	/**
	 * @param StallList
	 */
	private static void ViewAllStalls(ArrayList<Stall> StallList) {
		Helper.line(100, "-");
		System.out.println(String.format("%-20s%s", "NAME"));
		for (Stall a : StallList) {
			System.out.println(String.format("%-20s%s", a.getName()));
		}
		Helper.line(100, "-");
	}

	/**
	 * @param AccountList
	 */
	private static void ViewAllAccount(ArrayList<Account> AccountList) {
		Helper.line(100, "-");
		System.out.println(String.format("%-20s%s", "NAME", "ROLE"));
		for (Account a : AccountList) {
			System.out.println(String.format("%-20s%s", a.getName(), a.getRole()));
		}
		Helper.line(100, "-");
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

	}
	public static void Staffmenu() {
		System.out.println("Tasty Bites!");
		System.out.println("1. View all Accounts");
		System.out.println("2. Add New Stall");
		System.out.println("3. Delete Stall");
		System.out.println("4. Edit Menu");
		System.out.println("5. Edit Queue");
		System.out.println("6. View Feedback");
		System.out.println("7. Delete my Account");
		System.out.println("8. Quit");
		Helper.line(80, "-");

	}
	public static void Customermenu() {
		System.out.println("Tasty Bites!");
		System.out.println("1. Delete my Account");
		System.out.println("2. View Stalls");
		System.out.println("3. Add to Cart");
		System.out.println("4. Remove to Cart");
		System.out.println("5. View Cart");
		System.out.println("6. Make Payment");
		System.out.println("7. Quit");
		Helper.line(80, "-");

	}

}

