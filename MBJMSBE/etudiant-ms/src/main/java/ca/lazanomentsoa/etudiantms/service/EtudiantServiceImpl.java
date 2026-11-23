package ca.lazanomentsoa.etudiantms.service;


import ca.lazanomentsoa.etudiantms.clientConfig.enseignant.EnseignantHttpInterface;
import ca.lazanomentsoa.etudiantms.dto.EtudiantDTO;
import ca.lazanomentsoa.etudiantms.dto.EtudiantItemToListDTO;
import ca.lazanomentsoa.etudiantms.entity.Etudiant;
import ca.lazanomentsoa.etudiantms.exception.EtudiantNotFound;
import ca.lazanomentsoa.etudiantms.repository.EtudiantRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EtudiantServiceImpl implements EtudiantService {
    private final EnseignantHttpInterface enseignantHttpInterface;
    private final EtudiantRepository etudiantRepository;

    public String getEnseignantMS() {
        return enseignantHttpInterface.getEnseignants();
    }

    public EtudiantDTO save(EtudiantDTO etudiantDTO) {
      // to do set qrCode
        Etudiant etudiant = etudiantRepository.save(etudiantDTO.toEntity());
        return EtudiantDTO.fromEntity(etudiant);
    }

    @Override
    public List<EtudiantItemToListDTO> findAll() {
        return etudiantRepository.findAll().stream().map(EtudiantItemToListDTO::fromEtudiantItem).toList();
    }

    @Override
    public EtudiantDTO findById(String id){
        return etudiantRepository.findById(id).map(EtudiantDTO::fromEntity).orElseThrow(()-> new EtudiantNotFound("Etudiant matricule: " + id + " not found"));
    }

}
