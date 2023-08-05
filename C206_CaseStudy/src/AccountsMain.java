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

		
	}

	// Account Main Menu (Contains 3 options, view, create, delete)
	private void accMainMenu() {

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
			}

			br.close();

		} catch (FileNotFoundException e) {
			System.out.println("File not found");
		} catch (IOException io) {
			System.out.println("Error occured during file read");
		}

	}

}
