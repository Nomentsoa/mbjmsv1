package ca.lazanomentsoa.etudiantms.repository;

import ca.lazanomentsoa.etudiantms.entity.Etudiant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EtudiantRepository extends JpaRepository<Etudiant, String> {
}
