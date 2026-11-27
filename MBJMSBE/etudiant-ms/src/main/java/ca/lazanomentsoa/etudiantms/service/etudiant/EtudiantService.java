package ca.lazanomentsoa.etudiantms.service.etudiant;

import ca.lazanomentsoa.etudiantms.dto.etudiants.EtudiantDTO;
import ca.lazanomentsoa.etudiantms.dto.etudiants.PagedEtudiantItemListDTO;


public interface EtudiantService {
     PagedEtudiantItemListDTO getAllEtudiants(String recherche,boolean isActive, int page, int size);
     EtudiantDTO findById(String id);
}
