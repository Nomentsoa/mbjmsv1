package ca.lazanomentsoa.etudiantms.service;

import ca.lazanomentsoa.etudiantms.dto.EtudiantDTO;
import ca.lazanomentsoa.etudiantms.dto.EtudiantItemToListDTO;

import java.util.List;

public interface EtudiantService {
     List<EtudiantItemToListDTO> findAll();
     EtudiantDTO findById(String id);
}
