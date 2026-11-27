package ca.lazanomentsoa.etudiantms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EtudiantMsApplication {

    public static void main(String[] args) {
        SpringApplication.run(EtudiantMsApplication.class, args);
    }
//
//    @Bean
//    CommandLineRunner commandLineRunner(TestEtudiantRepository etudiantRepository) {
//        return args -> {
//            for(int i = 0; i < 3; i++){
//                TestEtudiant testEnseignant = TestEtudiant.builder()
//                        .test("Etudiant #" + i)
//                        .build();
//                etudiantRepository.save(testEnseignant);
//            }
//        };
//    }

}
