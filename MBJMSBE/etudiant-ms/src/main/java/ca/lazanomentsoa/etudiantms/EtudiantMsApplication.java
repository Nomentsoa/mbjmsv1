package ca.lazanomentsoa.etudiantms;

import ca.lazanomentsoa.etudiantms.entity.TestEtudiant;
import ca.lazanomentsoa.etudiantms.repository.TestEtudiantRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class EtudiantMsApplication {

    public static void main(String[] args) {
        SpringApplication.run(EtudiantMsApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(TestEtudiantRepository etudiantRepository) {
        return args -> {
            for(int i = 0; i < 3; i++){
                TestEtudiant testEnseignant = TestEtudiant.builder()
                        .test("Etudiant #" + i)
                        .build();
                etudiantRepository.save(testEnseignant);
            }
        };
    }

}
