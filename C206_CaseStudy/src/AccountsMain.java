import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
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
		Helper.line(100,"-");
		System.out.println(String.format("%-20s%s", "NAME", "ROLE"));
		for (Account a : accounts) {
			System.out.println(String.format("%-19s%s", a.getName(), a.getRole()));
		}
		Helper.line(100,"-");

//		System.out.println(String.format("%-19s%s", accounts.get(0).getName(), accounts.get(0).getRole()));
	}

	// Create an account. User story 19
	private void createAccount() {
		Helper.line(100,"-");
		// User input
		String accName = Helper.readString("Enter account name: ");
		String accPass = Helper.readString("Enter account password: ");
		String accRole = Helper.readString("Enter account role: ");

		// Writing account details to text file
		try {
			File file = new File("Accounts.txt");
			FileWriter fw = new FileWriter(file, true);
			BufferedWriter bw = new BufferedWriter(fw);

			bw.write(accName + ", " + accPass + ", " + accRole + "\n");

			bw.close();

			System.out.println("Account added! Please refresh the program!");

		} catch (IOException io) {
			System.out.println("There was an error writing to the file.");
		}
		Helper.line(100,"-");
	}

	// Delete an account. User story 21
	private void deleteAccount() {
		Helper.line(100,"-");
		File tempAccFile = new File("tempAccounts.txt");
		String deletionName = Helper.readString("Enter name of account for deletion: ");
		
		
		
		Helper.line(100,"-");
	}

}
