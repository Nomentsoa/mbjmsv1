package ca.lazanomentsoa.etudiantms.repository;

import ca.lazanomentsoa.etudiantms.entity.ecologe.Ecolage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface EcolageRepository extends JpaRepository<Ecolage, Long> {
    @Query("""
    SELECT e FROM Ecolage e
    WHERE e.matriculeEtudiant =:matriculeEtudiant
    AND e.anneeScolaire
    LIKE CONCAT("%", :anneeScolaire ,"%")
    ORDER BY e.id DESC LIMIT 1
""")
    Ecolage findByMatriculeEtudiantAndAnneeScolaire(@Param("matriculeEtudiant") String matriculeEtudiant, @Param("anneeScolaire") String anneeScolaire);


}
