package ca.lazanomentsoa.etudiantms.service;

import ca.lazanomentsoa.etudiantms.dto.etudiants.EtudiantDTO;
import ca.lazanomentsoa.etudiantms.dto.etudiants.EtudiantItemToListDTO;
import ca.lazanomentsoa.etudiantms.dto.etudiants.PagedEtudiantItemListDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface EtudiantService {
     PagedEtudiantItemListDTO getAllEtudiants(String recherche,boolean isActive, int page, int size);
     EtudiantDTO findById(String id);
}
