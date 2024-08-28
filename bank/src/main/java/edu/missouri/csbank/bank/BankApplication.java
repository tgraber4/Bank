package edu.missouri.csbank.bank;

import edu.missouri.csbank.bank.sql.DBPasswordManager;
import edu.missouri.csbank.bank.sql.Tables;
import edu.missouri.csbank.bank.users.*;
import edu.missouri.csbank.bank.account.Account;
import edu.missouri.csbank.bank.account.AccountInfo;
import edu.missouri.csbank.bank.account.AccountType;
import edu.missouri.csbank.bank.bankholder.Bank;
import edu.missouri.csbank.bank.rewards.Rewards;
import edu.missouri.csbank.bank.sql.SQLConnectionManager;
import edu.missouri.csbank.bank.sql.SQLObject;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.*;

@SpringBootApplication
@RestController
public class BankApplication {

//		Note: Users will be loaded into the bank class.




	public static void main(String[] args) {
		SpringApplication.run(BankApplication.class, args);
//		DBPasswordManager manager = new DBPasswordManager();
//		SQLConnectionManager connectionManager = new SQLConnectionManager(manager.getPassword());






//		createTable(connectionManager, new PersonalInfo());
//
		PersonalInfo test = new PersonalInfo("Bob", "no", "bob", new Date(100, 3, 20), "street", "U.S.", "217-999-9999", "bob@gmail.com", "English", 100023);
//
//
//		clearTable(connectionManager, Tables.PERSONAL_INFO.getName());
//
//		UUID testuuid = UUID.randomUUID();
//
//		insert(connectionManager, test, testuuid);
//		test.setFirstName("John");
//		update(connectionManager, test, testuuid);



		// Step 1: Create Bank
		Bank capitalOne = Bank.getInstance();
		capitalOne.setName("CapitalOne");

		// Step 2: Load Users
		Personalization test2 = new Personalization(NotificationLevel.NONE);
		List<String> deals = new ArrayList<>();
		deals.add("COOL STUFF!");
		Rewards test3 = Rewards.newRewards(150.45, deals);
		UserWrapper bobWrapper = UserWrapper.newUserWrapper(test, test2, test3);
		User bob = User.newUser(bobWrapper);

		capitalOne.addUser(bob);


		// Account Testing
		AccountInfo testAccountInfo1 = AccountInfo.newAccountInfo(150.45, 10000, 0.01, 0.005, 1, "123456789");
		testAccountInfo1.addLinkedAccount("PNC-Illinois-Checking");
		Account bobSavings1 = new Account(AccountType.SAVINGS, testAccountInfo1);
		bob.getWrapper().addAccount(bobSavings1);

		AccountInfo testAccountInfo2 = AccountInfo.newAccountInfo(189, 10000, 0.02, 0.005, 1, "123456789");
		testAccountInfo1.addLinkedAccount("testing");
		Account bobSavings2 = new Account(AccountType.SAVINGS, testAccountInfo2);
		bob.getWrapper().addAccount(bobSavings2);



		for (Account c : bob.getWrapper().getAccountList()) {
			System.out.println(c.getAccountInfo().getAPR());
		}






		/*
		(!) (!) (!) ---------- Comments for Alex ---------- (!) (!) (!)

		- Since User has the UserWrapper should everything be done through the UserWrapper class or
		should I still give functionality to User
		Ex: addAccount() in User


		Need to decide if Rewards Deals should be stored in the website or users.
		Deals should be one of these ways:
		(-) each user has their own custom deals
		(-) deals are dependent on user account age
		(-) deals are the same for everyone

		Need to decide if rewardsPerks could be one of these ways:
        (-) as a custom list where each person's perks are unique
        (-) as a number which is called rewards level where different levels give different perks
		*/

	}
	private static void createTable (SQLConnectionManager connectionManager, SQLObject object) {
		String query = "CREATE TABLE IF NOT EXISTS " + object.getTable().getName() + "(\n";
		query += "  uuid " + "VARCHAR(255)" + ",\n";
		query += object.createString() + ");";
		try {
			PreparedStatement statement = connectionManager.getConnection().prepareStatement(query);
			int result = statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	private static void clearTable (SQLConnectionManager connectionManager, String name) {
		String query = "DELETE FROM " + name + ";";
		try {
			PreparedStatement statement = connectionManager.getConnection().prepareStatement(query);
			int result = statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	private static void insert(SQLConnectionManager connectionManager, SQLObject object, UUID uuid) {
		String query = "INSERT INTO " + object.getTable().getName() + " VALUES (";
		query += "'" + uuid + "',";
		query += object.valuesString() + ");";
		try {
			PreparedStatement statement = connectionManager.getConnection().prepareStatement(query);
			int result = statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	private static void update (SQLConnectionManager connectionManager, SQLObject object, UUID uuid) {

		List<String> updateString = object.updateString();
		int i = 0;
		for (String c : object.getTypeNameList()) {
			String query = "UPDATE " + object.getTable().getName() + "\n";
			query += "SET " + c + " = " + updateString.get(i) + "\n";
			query += "WHERE uuid = " + "'" + uuid + "';";
			System.out.println(query);
			try {
				PreparedStatement statement = connectionManager.getConnection().prepareStatement(query);
				int result = statement.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			i++;
		}

	}

	@GetMapping("/hello")
	public String hello(@RequestParam(value = "name", defaultValue = "World") String name) {
		PersonalInfo test = new PersonalInfo("Bob", "no", "bob", new Date(100, 3, 20), "street", "U.S.", "217-999-9999", "bob@gmail.com", "English",100023);
		Personalization test2 = new Personalization(NotificationLevel.NONE);
		List<String> deals = new ArrayList<>();
		deals.add("COOL STUFF!");
		Rewards test3 = Rewards.newRewards(150.45, deals);
		Bank capitalOne = Bank.getInstance();
		UserWrapper bobWrapper = UserWrapper.newUserWrapper(test, test2, test3);
		User bob = User.newUser(bobWrapper);
		return "User Name: " + bob.getWrapper().getInfo().getFirstName() + " " + bob.getWrapper().getInfo().getMiddleName() + " " + bob.getWrapper().getInfo().getLastName();
		// Without inputs: 127.0.0.1:8080/hello
		// With inputs : 127.0.0.1:8080/hello?name=BObby%20SMith
	}

}
