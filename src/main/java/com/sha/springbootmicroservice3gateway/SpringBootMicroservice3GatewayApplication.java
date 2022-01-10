package com.sha.springbootmicroservice3gateway;

import com.sha.springbootmicroservice3gateway.model.Customer;
import com.sha.springbootmicroservice3gateway.repository.ICustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
@PropertySource("classpath:application-${spring.profiles.active:default}.properties")
public class SpringBootMicroservice3GatewayApplication implements CommandLineRunner {

	public static void main(String[] args)  {
		SpringApplication.run(SpringBootMicroservice3GatewayApplication.class, args);
	}


	@Autowired
	private ICustomerRepository customerRepository;


	@Override
	public void run(String... args) throws Exception {
	//get requestinde gorebilmek icin burada default musteri olusturdum.
	Customer customer1 = new Customer();
		customer1.setFirstName("erdem");
		customer1.setLastName("canturk");
		customer1.setPhoneNum("+90 0543 111 22 33");
		customer1.setCustMail("canturkerdem@hotmail.com");
		customer1.setStreet("kozyatagi");

		customerRepository.save(customer1);

	Customer customer2 = new Customer();
		customer2.setFirstName("emre");
		customer2.setLastName("canturk");
		customer2.setPhoneNum("+90 0543 555 66 77");
		customer2.setCustMail("canturkemre@hotmail.com");
		customer2.setStreet("acibadem");

		customerRepository.save(customer2);


}

}
