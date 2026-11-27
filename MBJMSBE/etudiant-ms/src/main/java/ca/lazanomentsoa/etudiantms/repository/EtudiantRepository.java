package ca.lazanomentsoa.etudiantms.repository;

import ca.lazanomentsoa.etudiantms.entity.etudiant.Etudiant;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface EtudiantRepository extends JpaRepository<Etudiant, String> {
    @Query("""
            SELECT e  FROM Etudiant e
                        WHERE (:recherche IS NULL OR :recherche = ''
                                    OR LOWER(e.nom) LIKE LOWER(CONCAT('%', :recherche, '%'))
                                    OR LOWER(e.prenom) LIKE LOWER(CONCAT('%', :recherche, '%'))
                                    OR LOWER(e.id) LIKE LOWER(CONCAT('%', :recherche, '%')) 
                               )
                        AND e.isActive = :isActive
            """)
    Page<Etudiant> rechercheEtudiants(@Param("recherche") String recherche,@Param("isActive") boolean isActive, Pageable pageable);
}
