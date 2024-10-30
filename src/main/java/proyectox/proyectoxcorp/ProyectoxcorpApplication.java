package proyectox.proyectoxcorp;

import org.modelmapper.ModelMapper;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import proyectox.proyectoxcorp.entity.Contact;
import proyectox.proyectoxcorp.repository.ContactRepository;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class ProyectoxcorpApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProyectoxcorpApplication.class, args);
	}

	@Bean
	CommandLineRunner runner(ContactRepository contactRepository) {

		return args -> {
			List<Contact> contacts = Arrays.asList(
					new Contact("Carlos", "carlos@example.com", LocalDateTime.now()),
					new Contact("Maria", "maria@example.com", LocalDateTime.now()),
					new Contact("Juan", "juan@example.com", LocalDateTime.now()),
					new Contact("Ana", "ana@example.com", LocalDateTime.now()),
					new Contact("Luis", "luis@example.com", LocalDateTime.now()),
					new Contact("Sofia", "sofia@example.com", LocalDateTime.now()),
					new Contact("Pedro", "pedro@example.com", LocalDateTime.now()),
					new Contact("Laura", "laura@example.com", LocalDateTime.now()),
					new Contact("Miguel", "miguel@example.com", LocalDateTime.now()),
					new Contact("Elena", "elena@example.com", LocalDateTime.now())
			);

			// Guardar todos los contactos en la base de datos
			contactRepository.saveAll(contacts);
		};
	}
	//Lo hacemos injectable para todo el proyecto por si tenemos mas servicios
	@Bean
	ModelMapper modelMapper(){
		return new ModelMapper();
	}

}
