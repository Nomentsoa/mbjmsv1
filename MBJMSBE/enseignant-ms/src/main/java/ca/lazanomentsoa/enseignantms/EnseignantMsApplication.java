package ca.lazanomentsoa.enseignantms;

import ca.lazanomentsoa.enseignantms.entity.TestEnseignant;
import ca.lazanomentsoa.enseignantms.repository.TestEnseignantRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class EnseignantMsApplication {

	public static void main(String[] args) {
		SpringApplication.run(EnseignantMsApplication.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner(TestEnseignantRepository enseignantRepository) {
		return args -> {
			for(int i = 0; i < 3; i++){
				TestEnseignant testEnseignant = TestEnseignant.builder()
						.text("Enseignant #" + i)
						.build();
				enseignantRepository.save(testEnseignant);
			}
		};
	}

}
