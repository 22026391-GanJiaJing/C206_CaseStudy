import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class AccountsMain {

	private ArrayList<Account> accounts = new ArrayList<Account>();

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AccountsMain accMain = new AccountsMain();
		accMain.start();
	}

	// Account Main Menu Startup
	private void start() {
		int option = -1;
		accMainMenu();
		loadAccounts();

		while (option != 4) {
			option = Helper.readInt("Enter Choice > ");
			if (option == 1) {
				viewAccounts();
			} else if (option == 2) {
				createAccount();
			} else if (option == 3) {
				deleteAccount();
			} else if (option != 4) {
				System.out.println("Invalid choice!");
			}
		}

		System.out.println("Goodbye!");

	}

	// Account Main Menu (Contains 3 options, view, create, delete)
	private void accMainMenu() {
		Helper.line(100, "=");
		System.out.println("CANTEEN ACCOUNT MANAGEMENT SYSTEM");
		Helper.line(100, "=");
		System.out.println("1. View all accounts\n2. Create an account\n3. Delete an account\n4. Exit");
	}

	// Text file database of all existing accounts
	private void loadAccounts() {
		try {
			File file = new File("Accounts.txt");
			FileReader fr = new FileReader(file);
			BufferedReader br = new BufferedReader(fr);

			String line = br.readLine();
			while (line != null) {
				String[] accInfoSplit = line.split(",");

				accounts.add(new Account(accInfoSplit[0], accInfoSplit[1], accInfoSplit[2]));

				line = br.readLine();
			}

			br.close();

		} catch (FileNotFoundException e) {
			System.out.println("File not found");
		} catch (IOException io) {
			System.out.println("Error occured during file read");
		}

	}

	// View all accounts in tabular format. User story 20
	private void viewAccounts() {

	}

	// Create an account. User story 19
	private void createAccount() {

	}

	// Delete an account. User story 21
	private void deleteAccount() {

	}

}
