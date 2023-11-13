package com.car.car;

import com.car.car.domain.Car;
import com.car.car.domain.CarRepository;
import com.car.car.domain.Owner;
import com.car.car.domain.OwnerRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;

@SpringBootApplication
public class CarApplication implements CommandLineRunner {
	@Autowired
	private CarRepository repository;

	@Autowired
	private OwnerRepository ownerRepositoryrepository;
	private static final Logger logger =
			LoggerFactory.getLogger(CarApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(CarApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Owner owner1 = new Owner("John" , "Johnson");
		Owner owner2 = new Owner("Mary" , "Robinson");
		ownerRepositoryrepository.saveAll(Arrays.asList(owner1, owner2));

		Car car1 = new Car("Ford", "Mustang", "Red",
				"ADF-1121", 2021, 59000, owner1);
				Car car2 = new Car("Nissan", "Leaf", "White",
						"SSJ-3002", 2019, 29000, owner2);
				Car car3 = new Car("Toyota", "Prius", "Silver",
						"KKO-0212", 2020, 39000, owner2);
				repository.saveAll(Arrays.asList(car1, car2,
						car3));

		/*repository.save(new Car("Mustang","VAN", "Red", "ADF-1121", 2021, 59000));

		repository.save(new Car("Nissan", "Leaf",
						"White",
						"SSJ-3002", 2019, 29000));
		repository.save(new Car("Toyota", "Prius",
								"Silver",
								"KKO-0212", 2020, 39000));*/

		for (Car car : repository.findAll()) {
			logger.info(car.getBrand() + " " + car
					.getModel());
		}
	}

}
