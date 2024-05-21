package edu.missouri.csbank.bank;

import com.google.gson.Gson;
import edu.missouri.csbank.bank.Users.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@SpringBootApplication
@RestController
public class BankApplication {

	public static void main(String[] args) {
		SpringApplication.run(BankApplication.class, args);

		// Adding 1 User
//		PersonalInfo test = new PersonalInfo("Bob", "no", "bob", new Date(100, 3, 20), "street", "U.S.", "217", "Bobsmells", "fart", 100023);
//		Personalization test2 = new Personalization(NotificationLevel.NONE);
//		List<String> deals = new ArrayList<>();
//		deals.add("COOL STUFF!");
//		Rewards test3 = new Rewards(150.45, 0.12, "1/12/24: $50 - Oranges", deals);
//		Bank capitalOne = Bank.getInstance();
//		User Bob = User.newUser(test, test2, test3);
//		capitalOne.setName("CapitalOne");
//		capitalOne.addUser(Bob);
//		Gson gson = new Gson();
//		System.out.println(gson.toJson(Bob));
//		System.out.println("Bobs Id: " + Bob.getUUID());
//		List<String> linkedAccounts = new ArrayList<>();
//		AccountInfo testAccountInfo1 = new AccountInfo(150.45, 10000, 0.01, 0.005, 1, new Date(), linkedAccounts);
//		Account bobSavings1 = new Account(AccountType.SAVINGS, "1257575744", testAccountInfo1);

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

	public static void test() {
		UUID id = UUID.fromString("ed3162c7-c50d-41b9-8914-f8a7c4a1a49f");
		Bank bank = Bank.getInstance();
		User user = bank.getUser(id);
		System.out.println(user);
	}
	@GetMapping("/hello")
	public String hello(@RequestParam(value = "name", defaultValue = "World") String uuid) {
		Gson gson = new Gson();
		UUID id = UUID.fromString(uuid);
		Bank bank = Bank.getInstance();
		String json = gson.toJson(bank.getUser(id));
		return json;
		// 127.0.0.1:8080/hello?name=BObby%20SMith
		//127.0.0.1:8080/hello?name=c6eff085-e81d-4732-ab05-1cd0a50df717
	}
}
