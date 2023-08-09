import java.util.ArrayList;

public class Tastybites {

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
						System.out.println(String.format("%-20s", "NAME"));
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
					else if (option == 5) {
						// view all feedback 

						ViewAllStalls(StallList);
						String ChooseStall=Helper.readString("Choose Stall to See Feedback > ");

						for (Stall a : StallList) {
							if(a.getName().equalsIgnoreCase(ChooseStall)) {
								for(Feedback b:feedbackList) {
									if (b.getAcc().equals(a)) {
										System.out.println(String.format("%-20s%-20s%-20.2f",b.getAcc().getName(), b.getFeedback(),b.getRating()));
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
				while (option != 4 && loginprocess==true) {

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
									for(MenuItem b:Selected.getMenu()) {
										System.out.println(String.format("%-20d %-20s $%-20.2f",i, b.getName(),b.getPrice()));
										i++;
									}
									System.out.println("Tasty Bites!");
									System.out.println("1. Add to Cart");
									System.out.println("2. Remove from Cart");
									System.out.println("3. View Cart");
									System.out.println("4. Make Payment");
									System.out.println("5. Back");
									Helper.line(80, "-");
									foodoption=Helper.readInt("Enter an option > ");

									if(foodoption==1) {//add to cart

										int Menuname =Helper.readInt("Menu Item to add to cart(Number) > ");

										Cart.add(new MenuItem(Selected.getMenu().get(Menuname-1).getName(),Selected.getMenu().get(Menuname-1).getPrice()));
										for(MenuItem a:Cart) {
											System.out.println(String.format(  "%-20s%-20.2f",a.getName(),a.getPrice()));
										}
									}else if (foodoption==2) {//remove from cart
										if(Cart.size()==0) {
											System.out.println("Cannot remove empty cart");
										}else {
											for(MenuItem a:Cart) {
												System.out.println(String.format(  "%-20s%-20.2f",a.getName(),a.getPrice()));
											}
											int Menuname =Helper.readInt("Menu Item to remove from to cart(Number) > ");
											for(MenuItem a:Cart) {
												if(Cart.indexOf(a)==Menuname-1){
													Cart.remove(Menuname-1);
													break;
												}
											}
										}
									}
									else if (foodoption==3) {//view cart
										if(Cart.size()==0) {
											System.out.println("Cannot View empty cart");
										}else {

											for(MenuItem a:Cart) {
												System.out.println(String.format(  "%-20s%-20.2f",a.getName(),a.getPrice()));
											}
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
								ViewAllStalls(StallList);
								int stalloption = Helper.readInt("Enter an Stall Number(Enter 0 to exit) > ");
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
								feedbackList.add(new Feedback(used,feedback,rating,Selected));
								System.out.println("Feedback Added");
								
								}
							}else if (feedbackoption==2) {
								//delete
								ViewMyFeedbacks(feedbackList, used);
							}
							else if (feedbackoption==3) {
								//view
								ViewMyFeedbacks(feedbackList, used);
							}

							else if (feedbackoption==4) {
								break;
							}else {
								System.out.println("Invalid Option");
							}









						}


					}

					else if (option == 5) {
						System.out.println("Closing System");
						System.exit(0);
					} else {
						System.out.println("Invalid option");}}



			}

		}
	}

	/**
	 * @param feedbackList
	 * @param used
	 */
	private static void ViewMyFeedbacks(ArrayList<Feedback> feedbackList, Account used) {
		for(Feedback a:feedbackList) {
			if(a.getAcc()==used) {
				System.out.println(String.format("%s%s%d",a.getAcc().getName(),a.getFeedback(),a.getRating() ));
			}
		}
	}

	/**
	 * 
	 */
	private static void FeedbackOptions() {
		System.out.println("1. Add Feedback");
		System.out.println("2. Delete Feedback");
		System.out.println("3. View All My Feedbacks");
		System.out.println("4. Quit");
	}

	/**
	 * @param StallList
	 */
	private static void DeleteMenu(ArrayList<Stall> StallList) {
		int stallNo =Helper.readInt("Store Number: ");
		boolean found=false;
		Stall stallSelected = null;
		for(Stall a:StallList) {
			if(StallList.indexOf(a)==stallNo) {
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
	private static void AddMenu(ArrayList<Stall> StallList) {
		int stallNo =Helper.readInt("Store Number: ");
		boolean found=false;
		Stall stallSelected = null;
		for(Stall a:StallList) {
			if(StallList.indexOf(a)==stallNo) {
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
			String Menuname =Helper.readString("Menu item Name: ");
			double MenuPrice =Helper.readDouble("Menu item Price: $");

			stallSelected.getMenu().add(new MenuItem(Menuname, MenuPrice));
			System.out.println("Menu added");
		}
	}

	/**
	 * @param StallList
	 */
	private static void AddStall(ArrayList<Stall> StallList) {
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
	private static boolean DeleteAccount(ArrayList<Account> AccountList, boolean loginprocess, String name) {
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
		return loginprocess;
	}

	/**
	 * @param StallList
	 */
	private static void DeleteStall(ArrayList<Stall> StallList) {

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
	private static void ViewAllStalls(ArrayList<Stall> StallList) {
		Helper.line(100, "-");
		System.out.println(String.format("%-20s%-20s", "STALL","STALL NUMBER"));
		int i=1;
		for (Stall a : StallList) {
			System.out.println(String.format("%-20s%-20d", a.getName(),i++));
		}
		Helper.line(100, "-");
	}

	/**
	 * @param AccountList
	 */
	private static void ViewAllAccount(ArrayList<Account> AccountList) {
		Helper.line(100, "-");
		System.out.println(String.format("%-20s", "NAME", "ROLE"));
		for (Account a : AccountList) {
			System.out.println(String.format("%-20s", a.getName(), a.getRole()));
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
		System.out.println("2. Edit Stalls");
		System.out.println("3. Edit Menu");
		System.out.println("4. Edit Queue");
		System.out.println("5. View Feedback");
		System.out.println("6. Delete my Account");
		System.out.println("7. Logout");
		System.out.println("8. Quit");
		Helper.line(80, "-");

	}
	public static void Customermenu() {
		System.out.println("Tasty Bites!");
		System.out.println("1. Delete my Account");
		System.out.println("2. View Stalls");
		System.out.println("3. Logout");
		System.out.println("4. Edit Feedback");
		System.out.println("5. Quit");
		Helper.line(80, "-");

	}

}

