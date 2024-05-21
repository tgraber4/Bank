package edu.missouri.csbank.bank;

import edu.missouri.csbank.bank.Users.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@SpringBootApplication
@RestController
public class BankApplication {
/*
	------ Notes For Tyler ------
	date.getTime() -> converts in long form
 */
	public static void main(String[] args) {
		SpringApplication.run(BankApplication.class, args);

		// Adding 1 User
		PersonalInfo test = new PersonalInfo("Bob", "no", "bob", new Date(100, 3, 20), "street", "U.S.", "217-999-9999", "bob@gmail.com", 100023);
		Personalization test2 = new Personalization(NotificationLevel.NONE);
		List<String> deals = new ArrayList<>();
		deals.add("COOL STUFF!");
		Rewards test3 = new Rewards(150.45, 0.12, "1/12/24: $50 - Oranges", deals);
		Bank capitalOne = Bank.getInstance();
		UserWrapper bobWrapper = UserWrapper.newUserWrapper(test, test2, test3);
		User bob = User.newUser(bobWrapper);
		capitalOne.setName("CapitalOne");
		capitalOne.addUser(bob);
		List<String> linkedAccounts = new ArrayList<>();
		AccountInfo testAccountInfo1 = AccountInfo.newAccountInfo(150.45, 10000, 0.01, 0.005, 1, linkedAccounts);
		Account bobSavings1 = new Account(AccountType.SAVINGS, "1257575744", testAccountInfo1);


		// go over all the ages and think of a good system
		// personal info - finish
		// go over SQL
		// Go over Base 64 - Java

	}
	@GetMapping("/hello")
	public String hello(@RequestParam(value = "name", defaultValue = "World") String name) {
		PersonalInfo test = new PersonalInfo("Bob", "no", "bob", new Date(100, 3, 20), "street", "U.S.", "217-999-9999", "bob@gmail.com", 100023);
		Personalization test2 = new Personalization(NotificationLevel.NONE);
		List<String> deals = new ArrayList<>();
		deals.add("COOL STUFF!");
		Rewards test3 = new Rewards(150.45, 0.12, "1/12/24: $50 - Oranges", deals);
		Bank capitalOne = Bank.getInstance();
		UserWrapper bobWrapper = UserWrapper.newUserWrapper(test, test2, test3);
		User bob = User.newUser(bobWrapper);
		return "User Name: " + bob.getWrapper().getInfo().getFirstName() + " " + bob.getWrapper().getInfo().getMiddleName() + " " + bob.getWrapper().getInfo().getLastName();
		// Without inputs: 127.0.0.1:8080/hello
		// With inputs : 127.0.0.1:8080/hello?name=BObby%20SMith
	}

}
