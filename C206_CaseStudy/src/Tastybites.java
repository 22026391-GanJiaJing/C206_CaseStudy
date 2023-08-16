import java.util.ArrayList;

public class Tastybites {

	private static final int LINE_LENGTH_80 = 80;
	private static final int LINE_LENGTH_100 = 100;
	private static final String LINE = "-";
	public static void main(String[] args) {

		ArrayList<Account> AccountList = new ArrayList<Account>();
		ArrayList<Stall> StallList = new ArrayList<Stall>();
		ArrayList<Queue> QueueList = new ArrayList<Queue>();
		ArrayList<MenuItem> Cart = new ArrayList<MenuItem>();
		ArrayList<Feedback> feedbackList = new ArrayList<Feedback>();

		AccountList.add(new Account("bob", "111", "Customer"));
		AccountList.add(new Account("alice", "222", "Staff"));

		ArrayList<MenuItem> menuList1=new ArrayList<MenuItem>();
		ArrayList<MenuItem> menuList2=new ArrayList<MenuItem>();

		menuList1.add(new MenuItem("chicken rice",4.50));
		menuList1.add(new MenuItem("maggie",5.50));
		menuList1.add(new MenuItem("chicken cutlet",8.50));
		menuList1.add(new MenuItem("chicken porriage",2.50));

		menuList2.add(new MenuItem("Duck rice",4.50));
		menuList2.add(new MenuItem("Noodles",5.50));
		menuList2.add(new MenuItem("Roasted Duck",8.50));
		menuList2.add(new MenuItem("Duck porriage",2.50));


		StallList.add(new Stall("MacKfc",menuList1));
		StallList.add(new Stall("BurgerWing",menuList2));



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
					Helper.line(80,LINE);
					CreateAccount(AccountList);


				} else if (option == 2) {
					// Login
					Helper.line(80,LINE);
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
					Helper.line(80,LINE);
					System.out.println("Closing System");
					System.exit(0);
				} else {
					System.out.println("Invalid option");}}

			//for staff============================================================================================================================
			if(used.getRole().equalsIgnoreCase("staff")){
				option = 0;
				while (option != 8 && loginprocess==true) {

					Tastybites.Staffmenu();
					option = Helper.readInt("Enter an option > ");

					if (option == 1) {
						// View all Accounts
						ViewAllAccount(AccountList);

					} else if (option == 2) {
						// Add new stall && display
						AddStall(StallList);



					}else if (option == 3) {
						ViewAllStalls(StallList);
						System.out.println("Tasty Bites!");
						System.out.println("1. Add new Menu");
						System.out.println("2. Delete Menu");
						int Secoption =Helper.readInt("Enter an option > ");

						if(Secoption==1) {// add 
							AddMenu(StallList);

						}else if(Secoption==2) {//delete
							DeleteMenu(StallList);


						}
						else {
							System.out.println("Invalid option");
						}
					}

					else if (option == 4) {
						// view queues choose to delete queue (completed order)
						if(QueueList.isEmpty()) {
							System.out.println("Queue is empty");
						}else {
							int i=1;
							String allCart="";
							for(Queue a:QueueList) {
								for(MenuItem b:a.getCart()) {
									allCart+=b.getName()+"\n";
								}
								System.out.println(String.format("%-20d%-20s%-20s",i,a.getPerson().getName(),allCart));
								i++;
							}
							if(Cart.isEmpty()) {
								int QueueNo=Helper.readInt("Enter Queue Number to Remove > ");
								if (QueueNo<=QueueList.size()) {
									QueueList.remove(QueueNo-1);
									System.out.println("Queue Number Removed");
								}else {
									System.out.println(QueueList.size());
									System.out.println("No Such Queue Number");
								}
							}

						}

					}
					else if (option == 5) {
						// view all feedback 

						ViewAllStalls(StallList);
						int ChooseStall=Helper.readInt("Choose Stall to See Feedback > ");

						boolean found=false;
						Stall Selected=null;
						for(Stall a:StallList) {
							if(StallList.indexOf(a)==ChooseStall-1) {
								Selected=a;
								found=true;
							}
						}
						if(found==false) {
							System.out.println("Stall not Found");
						}else {
							boolean ffound=false;
							for(Feedback a:feedbackList) {
								if(a.getStall()==Selected) {
									ffound=true;
								}
							}
							if (ffound==false) {
								System.out.println("No Feedback Found");
							}
							else {


								int i=1;
								System.out.println(String.format("%-5s%-5s%-30s%-10s","No","USER","FEEDBACK","RATING" ));
								for(Feedback a:feedbackList) {
									if(a.getStall()==Selected) {
										System.out.println(String.format("%-5d%-5s%-30s%-10d",i,a.getAcc().getName(),a.getFeedback(),a.getRating() ));
									}
								}

							}
						}

					}





					else if (option == 6) {
						// Delete Account

						loginprocess = DeleteAccount(AccountList, loginprocess, name);

					}
					else if (option == 7) {
						// logout

						loginprocess = false;

					}

					else if (option == 8 ) {
						Helper.line(80,LINE);
						System.out.println("Closing System");
						System.exit(0);
					} else {
						System.out.println("Invalid option");
					}
				}
			}

			else if(used.getRole().equalsIgnoreCase("customer")) {
				//for customer=============================================================================================================================
				option = 0;
				while (option != 5 && loginprocess==true) {

					Tastybites.Customermenu();
					option = Helper.readInt("Enter an option > ");

					if (option == 1) {
						// Delete Account

						loginprocess = DeleteAccount(AccountList, loginprocess, name);

					} else if (option == 2) {
						//view all stalls / add to cart /remove from cart/ view cart/make payment
						int foodoption=99;
						while ( foodoption!=4) {
							ViewAllStalls(StallList);

							int stalloption = Helper.readInt("Enter an Stall Number(Enter 0 to exit) > ");
							boolean found=false;
							Stall Selected=null;
							int i=1;
							for(Stall a:StallList) {
								if(StallList.indexOf(a)==stalloption-1) {
									Selected=a;
									found=true;
								}
							}
							if(stalloption==0) {
								break;
							}
							else if(found==false) {
								System.out.println("Stall not Found");
								break;
							}else {
								i=1;


								while(foodoption!=5 && foodoption!=4) {
									i=1;
									Helper.line(80,LINE);
									System.out.println(String.format("%-5s %-20s %-20s","No.", "ITEM","PRICE"));
									for(MenuItem b:Selected.getMenu()) {
										System.out.println(String.format("%-5d %-20s $%-20.2f",i, b.getName(),b.getPrice()));
										i++;
									}
									Helper.line(80,LINE);
									System.out.println("1. Add to Cart");
									System.out.println("2. Remove from Cart");
									System.out.println("3. View Cart");
									System.out.println("4. Make Payment");
									System.out.println("5. Back");
									Helper.line(80, LINE);
									foodoption=Helper.readInt("Enter an option > ");
									Helper.line(80,LINE);
									if(foodoption==1) {//add to cart

										int Menuname =Helper.readInt("Menu Item to add to cart(Number) > ");
										if (!Cart.isEmpty()) {
											for(MenuItem a:Cart) {
												if(a.getName().equalsIgnoreCase(Selected.getMenu().get(Menuname-1).getName())) {
													a.setQuantity(a.getQuantity()+1);
													System.out.println(Cart.size());
													break;
												}else {
													Cart.add(new MenuItem(Selected.getMenu().get(Menuname-1).getName(),Selected.getMenu().get(Menuname-1).getPrice(),1));
													break;
												}
											}
										}else {
											Cart.add(new MenuItem(Selected.getMenu().get(Menuname-1).getName(),Selected.getMenu().get(Menuname-1).getPrice(),1));
										}


										Helper.line(80,LINE);
										ViewCart(Cart);
										Helper.line(80,LINE);

										System.out.println("Item Added");
									}else if (foodoption==2) {//remove from cart
										if(Cart.size()==0) {
											System.out.println("Cannot remove empty cart");
										}else {
											ViewCart(Cart);
											int Menuname =Helper.readInt("Menu Item to remove from to cart(Number) > ");
											for(MenuItem a:Cart) {
												if(Cart.indexOf(a)==Menuname-1){
													if(a.getQuantity()==1) {
														Cart.remove(Menuname-1);
														System.out.println("Removed");
														break;
													}
													else { 
														
														a.setQuantity(a.getQuantity()-1);
														break;
													}
													
												}
											}
										}
									}
									else if (foodoption==3) {//view cart
										if(Cart.size()==0) {
											System.out.println("Cannot View empty cart");
										}else {
											ViewCart(Cart);
										}
									}
									else if (foodoption==4) {//Make payment
										if(Cart.size()==0) {
											System.out.println("Cart is Empty");
										}else {
											QueueList.add(new Queue(used,Cart));
											int Qno=0;
											for(Queue a:QueueList) {
												if(a.getPerson()==used) {
													Qno=QueueList.indexOf(a)+1;
												}
											}
											double total=0;
											System.out.println(String.format(  "%-10s%-20s%-20s","No","ITEM","PRICE","QUANTITY"));
											i=1;
											for(MenuItem a:Cart) {
												System.out.println(String.format(  "%-10%-20s%-20.2f%d",i,a.getName(),a.getPrice(),a.getQuantity()));
												total+=a.getPrice();
											}
											System.out.println(String.format("Total: $%.2f",total));

											Cart.clear();

											System.out.println("Your Queue Number is "+Qno);
										}
										break;
									}
									else if(foodoption==5) {
										break;
									}
								}
							}



						}

					}else if (option == 3) {
						// logout

						loginprocess = false;

					}
					else if (option == 4) {
						// edit feedback
						FeedbackOptions();

						int feedbackoption=Helper.readInt("Enter an Option > ");
						while (feedbackoption!=4) {

							if (feedbackoption==1) {
								//add
								addFeedback(StallList, feedbackList, used);
							}else if (feedbackoption==2) {
								//delete
								deleteFeedback(feedbackList, used);
							}
							else if (feedbackoption==3) {
								//view
								if(feedbackList.isEmpty()) {
									System.out.println("No Feedback To View");
								}
								else {


									ViewMyFeedbacks(feedbackList, used);
								}}

							else if (feedbackoption==4) {
								break;
							}else {
								System.out.println("Invalid Option");
							}
							FeedbackOptions();
							feedbackoption=Helper.readInt("Enter an Option > ");







						}


					}

					else if (option == 5) {
						Helper.line(80,LINE);
						System.out.println("Closing System");
						System.exit(0);
					} else {
						System.out.println("Invalid option");}}



			}

		}
	}

	/**
	 * @param StallList
	 * @param feedbackList
	 * @param used
	 */
	public static void addFeedback(ArrayList<Stall> StallList, ArrayList<Feedback> feedbackList, Account used) {
		ViewAllStalls(StallList);
		int stalloption = Helper.readInt("Enter an Stall Number > ");
		boolean found=false;
		Stall Selected=null;
		for(Stall a:StallList) {
			if(StallList.indexOf(a)==stalloption-1) {
				Selected=a;
				found=true;
			}
		}
		if(found==false) {
			System.out.println("Stall not found");
		}else {


			String feedback=Helper.readString("Enter Your Feedback > ");
			int rating=Helper.readInt("Enter Your Rating(1-5) > ");
			while(rating>5 ||rating<1) {
				rating=Helper.readInt("Re-Enter Your Rating(1-5) > ");
			}
			addfeedbacks(feedbackList, used, Selected, feedback, rating);
			System.out.println("Feedback Added");

		}
	}

	/**
	 * @param feedbackList
	 * @param used
	 * @param Selected
	 * @param feedback
	 * @param rating
	 */
	private static void addfeedbacks(ArrayList<Feedback> feedbackList, Account used, Stall Selected, String feedback,
			int rating) {
		feedbackList.add(new Feedback(used,feedback,rating,Selected));
	}

	/**
	 * @param feedbackList
	 * @param used
	 */
	public static void deleteFeedback(ArrayList<Feedback> feedbackList, Account used) {
		ViewMyFeedbacks(feedbackList, used);
		ArrayList<Feedback> myFeedback=new ArrayList<>();


		for(Feedback a:feedbackList) {
			if(a.getAcc()==used) {
				myFeedback.add(a);
			}
		}
		if(myFeedback.isEmpty()) {
			System.out.println("No Feedback Found from you");
		}else {
			int stalloption = Helper.readInt("Enter Feedback To Delete > ");
			for(Feedback a:myFeedback) {
				if(stalloption-1==myFeedback.indexOf(a)) {
					myFeedback.remove(a);
					feedbackList.remove(a);
					System.out.println("Feedback Deleted");
				}
				break;
			}
		}
	}

	/**
	 * @param Cart
	 */
	private static void ViewCart(ArrayList<MenuItem> Cart) {
		System.out.println(String.format(  "%-10s%-20s%-20s%-20s","No","ITEM","PRICE","QUANTITY"));
		int i=1;
		for(MenuItem a:Cart) {
			System.out.println(String.format(  "%-10d%-20s%-20.2f%d",i,a.getName(),a.getPrice(),a.getQuantity()));
			i++;
		}
	}

	/**
	 * @param feedbackList
	 * @param used
	 */
	public static void ViewMyFeedbacks(ArrayList<Feedback> feedbackList, Account used) {
		Helper.line(80,LINE);
		int i=1;
		System.out.println(String.format("%-5s%-5s%-30s%-10s","No","USER","FEEDBACK","RATING" ));
		for(Feedback a:feedbackList) {
			if(a.getAcc()==used) {
				System.out.println(String.format("%-5d%-5s%-30s%-10d",i,a.getAcc().getName(),a.getFeedback(),a.getRating() ));
			}
		}
		Helper.line(80,LINE);
	}

	/**
	 * 
	 */
	public static void FeedbackOptions() {
		Helper.line(80,LINE);
		System.out.println("1. Add Feedback");
		System.out.println("2. Delete Feedback");
		System.out.println("3. View All My Feedbacks");
		System.out.println("4. Back");
		Helper.line(80,LINE);
	}

	/**
	 * @param StallList
	 */
	public static void DeleteMenu(ArrayList<Stall> StallList) {
		int stallNo =Helper.readInt("Store Number: ");
		boolean found=false;
		Stall stallSelected = null;
		for(Stall a:StallList) {
			if(StallList.indexOf(a)==stallNo-1) {
				found=true;
				stallSelected=a;
				break;
			}
		}
		if(found==false) {
			System.out.println("Stall Not Found");
		}else {
			int i=1;
			for(MenuItem b:stallSelected.getMenu()) {
				System.out.println(String.format("%-20d %-20s $%-20.2f",i, b.getName(),b.getPrice()));
				i++;
			}
			int Menuname =Helper.readInt("Menu Item to Delete(Number) > ");

			stallSelected.getMenu().remove(Menuname-1);


			System.out.println("Menu Deleted");
		}
	}

	/**
	 * @param StallList
	 */
	public static void AddMenu(ArrayList<Stall> StallList) {
		int stallNo =Helper.readInt("Store Number: ");
		boolean found=false;
		Stall stallSelected = null;
		for(Stall a:StallList) {
			if(StallList.indexOf(a)==stallNo-1) {
				found=true;
				stallSelected=a;
				break;
			}
		}
		if(found==false) {
			System.out.println("Stall Not Found");
		}else {
			int i=1;
			System.out.println(String.format("%-10s %-20s $%-20s","No", "ITEM","PRICE"));
			for(MenuItem b:stallSelected.getMenu()) {
				System.out.println(String.format("%-10d %-20s $%-20.2f",i, b.getName(),b.getPrice()));
				i++;
			}
			String Menuname =Helper.readString("Menu item Name: ");
			double MenuPrice =Helper.readDouble("Menu item Price: $");

			stallSelected.getMenu().add(new MenuItem(Menuname, MenuPrice));
			System.out.println("Menu added");
		}
	}

	/**
	 * @param StallList
	 */
	public static void AddStall(ArrayList<Stall> StallList) {
		ViewAllStalls(StallList);
		System.out.println("Tasty Bites!");
		System.out.println("1. Add new Stall");
		System.out.println("2. Delete Stall");
		int Secoption =Helper.readInt("Enter an option > ");

		if(Secoption==1) {// add 
			String stallname =Helper.readString("Store Name: ");

			ArrayList<MenuItem> NewMenu=new ArrayList<MenuItem>();
			StallList.add(new Stall(stallname,NewMenu));
			System.out.println("Stall added");
		}else if(Secoption==2) {//delete
			DeleteStall(StallList);
		} else {
			System.out.println("Invalid option");}
	}

	/**
	 * @param AccountList
	 * @param loginprocess
	 * @param name
	 * @return
	 */
	public static boolean DeleteAccount(ArrayList<Account> AccountList, boolean loginprocess, String name) {
		Helper.line(LINE_LENGTH_80, LINE);
		char choice=Helper.readChar("Are you sure to delete Account?(Y/N) > ");
		Helper.line(LINE_LENGTH_80, LINE);
		if(choice=='Y') {


			for (Account a : AccountList) {
				if(a.getName().equalsIgnoreCase(name)) {
					AccountList.remove(a);
					System.out.println("Account deleted");
					loginprocess=false;
				}}}
		return loginprocess;
	}

	/**
	 * @param StallList
	 */
	public static void DeleteStall(ArrayList<Stall> StallList) {

		int SelectStall=Helper.readInt("Stall number to Delete: ");

		boolean found=false;

		for (Stall a : StallList) {
			if(StallList.indexOf(a)==SelectStall-1) {

				StallList.remove(StallList.indexOf(a));
				found=true;
				System.out.println("Stall deleted");
				break;
			}
		}
		if (found==false) {
			System.out.println("Stall not found");
		}
	}



	/**
	 * @param StallList
	 */
	public static void ViewAllStalls(ArrayList<Stall> StallList) {
		Helper.line(80, LINE);
		System.out.println(String.format("%-20s%-20s", "STALL","STALL NUMBER"));
		int i=1;
		for (Stall a : StallList) {
			System.out.println(String.format("%-20s%-20d", a.getName(),i++));
		}
		Helper.line(80, LINE);
	}

	/**
	 * @param AccountList
	 */
	public static void ViewAllAccount(ArrayList<Account> AccountList) {
		Helper.line(LINE_LENGTH_100, LINE);
		System.out.println(String.format("%-20s%s", "NAME", "ROLE"));
		for (Account a : AccountList) {
			System.out.println(String.format("%-20s%s", a.getName(), a.getRole()));
		}
		Helper.line(LINE_LENGTH_100, LINE);
	}

	/**
	 * @param AccountList
	 */
	public static void CreateAccount(ArrayList<Account> AccountList) {
		String name =Helper.readString("Name: ");
		String password=Helper.readString("Password: ");
		String role=Helper.readString("Role (Staff/Customer): ");
		role.toLowerCase();
		Account accountAdd = new Account(name,password,role);
		AccountList.add(accountAdd);
		System.out.println("Account Created");
	}




	public static void Mainmenu() {
		Helper.line(80, "=");
		System.out.println("TASTY BITES!");
		Helper.line(80, "=");
		System.out.println("1. Create New Account");
		System.out.println("2. Login");
		System.out.println("3. Quit");
		Helper.line(80, LINE);

	}
	public static void Staffmenu() {
		Helper.line(80, "=");
		System.out.println("STAFF");
		Helper.line(80, "=");
		System.out.println("1. View all Accounts");
		System.out.println("2. Edit Stalls");
		System.out.println("3. Edit Menu");
		System.out.println("4. Edit/View Queue");
		System.out.println("5. View Feedback");
		System.out.println("6. Delete my Account");
		System.out.println("7. Logout");
		System.out.println("8. Quit");
		Helper.line(80, LINE);

	}
	public static void Customermenu() {
		Helper.line(80, "=");
		System.out.println("CUSTOMER");
		Helper.line(80, "=");
		System.out.println("1. Delete my Account");
		System.out.println("2. View Stalls");
		System.out.println("3. Logout");
		System.out.println("4. Edit Feedback");
		System.out.println("5. Quit");
		Helper.line(80, LINE);

	}

}
