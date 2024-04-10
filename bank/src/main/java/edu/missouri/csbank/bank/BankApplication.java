package edu.missouri.csbank.bank;

import edu.missouri.csbank.bank.Users.PersonalInfo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@SpringBootApplication
@RestController
public class BankApplication {

	public static void main(String[] args) {
		SpringApplication.run(BankApplication.class, args);
		PersonalInfo test = new PersonalInfo("Bob", "no", "bob", new Date(100, 3, 20), "street", "U.S.", "217", "Bobsmells", "fart", 100023);
	}
	@GetMapping("/hello")
	public String hello(@RequestParam(value = "name", defaultValue = "World") String name) {
		return String.format("Hello %s!", name);
	}
}
