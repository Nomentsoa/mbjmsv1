package ca.lazanomentsoa.etudiantms.repository;

import ca.lazanomentsoa.etudiantms.entity.TestEtudiant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.RestController;

@RestController
public interface TestEtudiantRepository extends JpaRepository<TestEtudiant, String> {
}
