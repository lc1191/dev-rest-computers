package com.example.devrestcomputers;

import com.example.devrestcomputers.entities.Laptop;
import com.example.devrestcomputers.repositories.LaptopRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class DevRestComputersApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(DevRestComputersApplication.class, args);
		LaptopRepository repository = context.getBean(LaptopRepository.class);

		Laptop l1 = new Laptop(null, "MSI","GS65",2019,15.6,false,12,32,1.5,6);
		Laptop l2 = new Laptop(null, "LENOVO","GXT",2020,16.5,false,8,12,1.0,2);
		Laptop l3 = new Laptop(null, "ASUS","FX-506",2021,15.6,false,8,16,0.5,8);
		Laptop l4 = new Laptop(null, "APPLE","M2-PRO",2022,15.9,false,16,64,2.0,12);

		repository.save(l1);
		repository.save(l2);
		repository.save(l3);
		repository.save(l4);
	}

}
