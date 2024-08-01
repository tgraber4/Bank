package edu.missouri.csbank.bank;

import edu.missouri.csbank.bank.Users.*;
import edu.missouri.csbank.bank.sql.DBPasswordManager;
import edu.missouri.csbank.bank.sql.SQLConnectionManager;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@SpringBootApplication
@RestController
public class BankApplication {
/*
	------ Notes For Tyler ------
	date.getTime() -> converts in long form
 */





	public static void main(String[] args) {
		SpringApplication.run(BankApplication.class, args);
		DBPasswordManager manager = new DBPasswordManager();
		SQLConnectionManager connectionManager = new SQLConnectionManager(manager.getPassword());




//		will never to need to use select to get an individual user
//		instead all users will be imported from the database into the bank class











		createTable(connectionManager, new PersonalInfo());

		PersonalInfo test = new PersonalInfo("Bob", "no", "bob", new Date(100, 3, 20), "street", "U.S.", "217-999-9999", "bob@gmail.com", "English", 100023);


		clearTable(connectionManager, Tables.PERSONAL_INFO.getName());
		test.setFirstName("John");

		insert(connectionManager, test);




		Personalization test2 = new Personalization(NotificationLevel.NONE);
		List<String> deals = new ArrayList<>();
		deals.add("COOL STUFF!");
		Rewards test3 = Rewards.newRewards(150.45, deals);
		Bank capitalOne = Bank.getInstance();
		UserWrapper bobWrapper = UserWrapper.newUserWrapper(test, test2, test3);
		User bob = User.newUser(bobWrapper);
		capitalOne.setName("CapitalOne");
		capitalOne.addUser(bob);

		AccountInfo testAccountInfo1 = AccountInfo.newAccountInfo(150.45, 10000, 0.01, 0.005, 1);
		testAccountInfo1.addLinkedAccount("PNC-Illinois-Checking");
		Account bobSavings1 = new Account(AccountType.SAVINGS, "1257575744", testAccountInfo1);
		bob.getWrapper().addAccount(bobSavings1);

		AccountInfo testAccountInfo2 = AccountInfo.newAccountInfo(189, 10000, 0.02, 0.005, 1);
		testAccountInfo1.addLinkedAccount("testing");
		Account bobSavings2 = new Account(AccountType.SAVINGS, "3030303030", testAccountInfo2);
		bob.getWrapper().addAccount(bobSavings2);

		boolean testx = bob.getWrapper().removeAccount(bob.getWrapper().getAccountList().getFirst());
		System.out.println(testx);

		for (Account c : bob.getWrapper().getAccountList()) {
			System.out.println(c.getAccountInfo().getAPR());
		}

		// go over how to do accounts - different account types need different info
		// talk about Base 64 - Java  (https://www.baeldung.com/java-base64-encode-and-decode)
		/*
		Need to decide if Rewards Deals should be stored in the website or users.
		Deals should be one of these ways:
		- each user has their own custom deals
		- deals are dependent on user account age
		- deals are the same for everyone

		 */


		/*
		(!) (!) (!) ---------- Comments for Alex ---------- (!) (!) (!)

		- Since User has the UserWrapper should everything be done through the UserWrapper class or
		should I still give functionality to User
		Ex: addAccount() in User

		*/

	}
	private static void createTable (SQLConnectionManager connectionManager, SQLObject object) {
		String query = "CREATE TABLE IF NOT EXISTS " + object.getTable().getName() + "(\n";
		query += object.createString() + ");";
		System.out.println(query);
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
	private static void insert(SQLConnectionManager connectionManager, SQLObject object) {
		String query = "INSERT INTO " + object.getTable().getName() + " VALUES (";
		query += object.valuesString() + ");";
		System.out.println(query);
		try {
			PreparedStatement statement = connectionManager.getConnection().prepareStatement(query);
			int result = statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
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
