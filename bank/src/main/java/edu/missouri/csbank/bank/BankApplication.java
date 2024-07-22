package edu.missouri.csbank.bank;

import edu.missouri.csbank.bank.Users.*;
import edu.missouri.csbank.bank.sql.DBPasswordManager;
import edu.missouri.csbank.bank.sql.SQLConnectionManager;
import edu.missouri.csbank.bank.types.TypeHolder;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
	static void createTable(SQLConnectionManager connectionManager, String name, List<String> typeList, List<String> typeNameList) {

		if (typeList.size() != typeNameList.size()) {
			System.out.println("(!) (!) size doesn't match up! (!) (!)");
			return;
		}
		String query = getString(name, typeList, typeNameList);
		try {
			PreparedStatement statement = connectionManager.getConnection().prepareStatement(query);
			int result = statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		// get type --> var.getClass()     | only works for non-primitive types though
	}

	private static String getString(String name, List<String> typeList, List<String> typeNameList) {
		String query = "CREATE TABLE IF NOT EXISTS " + name + "(\n";
		for (int i = 0; i < typeList.size(); i++) {
			query = query.concat("  " + typeNameList.get(i) + " ");
			if (Objects.equals(typeList.get(i).toLowerCase(), "string") || Objects.equals(typeList.get(i).toLowerCase(), "date")) {
				query = query.concat("VARCHAR(255)");
			} else if (Objects.equals(typeList.get(i).toLowerCase(), "int")) {
				query = query.concat("INT");
			}
			if ((i + 1) < typeList.size()) {
				query = query.concat(",\n");
			} else {
				query = query.concat("\n");
			}
		}
		query = query.concat(");");
		return query;
	}
	static void insertIntoTable (SQLConnectionManager connectionManager, String name, List<String> typeList, List<String> typeNameList, List<TypeHolder> typeHolderList) {
		if (typeList.size() != typeNameList.size() && typeNameList.size() != typeHolderList.size()) {
			System.out.println("(!) (!) size doesn't match up! (!) (!)");
			return;
		}
		String query = "INSERT INTO " + name + " (";
		for (int i = 0; i < typeNameList.size(); i++) {
			query = query.concat(typeNameList.get(i));
			if ((i + 1) < typeNameList.size()) {
				query = query.concat(", ");
			}
		}
		query = query.concat(")\n");
		query = query.concat("VALUES (");
		for (int i = 0; i < typeList.size(); i++) {
			if (Objects.equals(typeList.get(i).toLowerCase(), "string")) {
				query = query.concat("'" + typeHolderList.get(i).getStringHolder() + "'");
			} else if (Objects.equals(typeList.get(i).toLowerCase(), "int")) {
				query = query.concat("" + typeHolderList.get(i).getIntHolder());
			} else if (Objects.equals(typeList.get(i).toLowerCase(), "date")) {
				query = query.concat("" + typeHolderList.get(i).getDateHolder());
			}
			if ((i + 1) < typeNameList.size()) {
				query = query.concat(", ");
			}
		}
		query = query.concat(");");
		try {
			PreparedStatement statement = connectionManager.getConnection().prepareStatement(query);
			int result = statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	static void clearTable (SQLConnectionManager connectionManager, String name) {
		String query = "DELETE FROM " + name + ";";
		try {
			PreparedStatement statement = connectionManager.getConnection().prepareStatement(query);
			int result = statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		SpringApplication.run(BankApplication.class, args);
		DBPasswordManager manager = new DBPasswordManager();
		SQLConnectionManager connectionManager = new SQLConnectionManager(manager.getPassword());




//		query = "SELECT brand FROM cars;";
//		try {
//			PreparedStatement statement = connectionManager.getConnection().prepareStatement(query);
//			ResultSet rs = statement.executeQuery();
//			while (rs.next()) {
//				System.out.println(rs.getString(1));
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}


		// sql must be executed in main



		// for each class make a function which returns a list of types, their names, and a list of the typeHolders.

		// createTable(connectionManager, name, typeList, typeNameList);
		// insertIntoTable(connectionManager, name, typeList, typeNameList, typeHolderList);



		PersonalInfo test = new PersonalInfo("Bob", "no", "bob", new Date(100, 3, 20), "street", "U.S.", "217-999-9999", "bob@gmail.com", "English", 100023);
		createTable(connectionManager, "PersonalInfo", test.getTypeList(), test.getTypeNameList());
		clearTable(connectionManager, "PersonalInfo");
		insertIntoTable(connectionManager, "PersonalInfo", test.getTypeList(), test.getTypeNameList(), test.getTypeHolderList());
		test.setFirstName("John");
		test.update(connectionManager);



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
