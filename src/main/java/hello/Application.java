package hello;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Application{
	
	private static final Logger log = LoggerFactory.getLogger(Application.class);
	
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
        
    }
    
    @Bean
	public CommandLineRunner demo(ContactRepository repository) {
		return (args) -> {
			// save a couple of contact
			/*repository.save(new Contact("Jack", "Bauer"));
			repository.save(new Contact("Chloe", "O'Brian"));
			repository.save(new Contact("Kim", "Bauer"));
			repository.save(new Contact("David", "Palmer"));
			repository.save(new Contact("Michelle", "Dessler"));*/

			// fetch all contacts
			log.info("Contact found with findAll():");
			log.info("-------------------------------");
			for (Contact contact : repository.findAll()) {
				log.info(contact.toString());
			}
			log.info("");

			// fetch contacts by last name
			log.info("Contact found with findByNom('Bauer'):");
			log.info("--------------------------------------------");
			repository.findByNom("Bauer").forEach(bauer -> {
				log.info(bauer.toString());
			});
			// for (Contact bauer : repository.findByLastName("Bauer")) {
			// 	log.info(bauer.toString());
			// }
			log.info("");
		};
	}

}