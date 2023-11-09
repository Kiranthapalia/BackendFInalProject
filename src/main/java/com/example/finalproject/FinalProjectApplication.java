package com.example.finalproject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.finalproject.domain.ShiftRepository;
import com.example.finalproject.domain.Department;
import com.example.finalproject.domain.Shift;
import com.example.finalproject.domain.DepartmentRepository;
import com.example.finalproject.domain.AppUser; // Import your AppUser class
import com.example.finalproject.domain.AppUserRepository; // Import your UserRepository class


@SpringBootApplication
public class FinalProjectApplication {

	private static final Logger log = LoggerFactory.getLogger(FinalProjectApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(FinalProjectApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(ShiftRepository srepository, DepartmentRepository drepository,
			AppUserRepository urepository) {
		return (args) -> {
			/*
			log.info("save a couple of departments and shifts");
			drepository.save(new Department("Sales"));
			drepository.save(new Department("Accounting"));
			drepository.save(new Department("IT"));
			drepository.save(new Department("Legal"));

			srepository.save(new Shift("Call the customer", "2023-11-01 08:00", "2023-11-02 04:30", "sakhi", "Active",
					drepository.findByName("IT").get(0)));
			srepository.save(new Shift("Attend the meeting", "2023-11-10 10:30", "2023-11-15 02:45", "bhabishya",
					"Pending", drepository.findByName("Sales").get(0)));
			srepository.save(new Shift("Check the account", "2023-11-11 09:15", "2023-11-11 12:00", "fredd", "Completed",
					drepository.findByName("Accounting").get(0)));

			log.info("fetch all shifts");
			for (Shift shift : srepository.findAll()) {
				log.info(shift.toString());
			}

			// Creating users: admin/admin user/user
			AppUser user1 = new AppUser("user", "$2a$06$3jYRJrg0ghaaypjZ/.g4SethoeA51ph3UD4kZi9oPkeMTpjKU5uo6", "USER");
			AppUser user2 = new AppUser("admin", "$2a$10$0MMwY.IQqpsVc1jC8u7IJ.2rT8b0Cd3b3sfIBGV2zfgnPGtT4r0.C", "ADMIN");
			AppUser user3 = new AppUser("sakhi", "$2a$12$hTQavA1kdAHMY6kdu7GNb.ST/YcByuRHDJ.vkhBu7k1lejGv..mDK", "USER");
			AppUser user4 = new AppUser("bhabishya", "$$2a$12$LJlVJ6rabUNWIlqyXOGZ3.s/Hw2K8MnQLvedZimbDW6vZMzo/FiMe", "USER");
			AppUser user5 = new AppUser("fredd", "$2a$12$91vHllvU6u5yrSeHoFHwJuXUMBz6IijQIrTiMj/WGBu2buScEz5ra", "USER");
			
			// pw for user 3,4,5 -- username12345
			
			urepository.save(user1);
			urepository.save(user2);
			urepository.save(user3);
			urepository.save(user4);
			urepository.save(user5);

			log.info("fetch all students");
			for (Shift shift : srepository.findAll()) {
				log.info(shift.toString());
			}*/
		};
	}
}


