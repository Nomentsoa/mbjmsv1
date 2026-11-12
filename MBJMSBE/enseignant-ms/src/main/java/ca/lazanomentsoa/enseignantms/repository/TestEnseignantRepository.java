package ca.lazanomentsoa.enseignantms.repository;

import ca.lazanomentsoa.enseignantms.entity.TestEnseignant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TestEnseignantRepository extends JpaRepository<TestEnseignant, String> {
}
