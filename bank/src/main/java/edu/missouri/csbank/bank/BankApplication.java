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

	public static void main(String[] args) {
		SpringApplication.run(BankApplication.class, args);

		// Adding 1 User
		PersonalInfo test = new PersonalInfo("Bob", "no", "bob", new Date(100, 3, 20), "street", "U.S.", "217", "Bobsmells", "fart", 100023);
		Personalization test2 = new Personalization(NotificationLevel.NONE);
		List<String> deals = new ArrayList<>();
		deals.add("COOL STUFF!");
		Rewards test3 = new Rewards(150.45, 0.12, "1/12/24: $50 - Oranges", deals);
		Bank capitalOne = Bank.getInstance();
		User Bob = User.newUser(test, test2, test3);
		capitalOne.setName("CapitalOne");
		capitalOne.addUser(Bob);
		List<String> linkedAccounts = new ArrayList<>();
		AccountInfo testAccountInfo1 = new AccountInfo(150.45, 10000, 0.01, 0.005, 1, new Date(), linkedAccounts);
		Account bobSavings1 = new Account(AccountType.SAVINGS, "1257575744", testAccountInfo1);

		//
		// finish users
		// should we do new Date for accountInfo or make two version like what we did in User
		// get user age --> finish this
		// how to use the code below the main (how to print here)
		// discuss accounts - are they stored only in users?
		// how to update constructor in PersonalInfo

		/*
		Ask about how things are verified
		Ex: Verify that email,ssn,phone number is in correct format
		 */

	}
	@GetMapping("/hello")
	public String hello(@RequestParam(value = "name", defaultValue = "World") String name) {
		return String.format("Hello %s!", name);
		// 127.0.0.1:8080/hello?name=BObby%20SMith
	}

}
