package ca.lazanomentsoa.etudiantms.service.etudiant;


import ca.lazanomentsoa.etudiantms.clientConfig.enseignant.EnseignantHttpInterface;
import ca.lazanomentsoa.etudiantms.dto.etudiants.EtudiantDTO;
import ca.lazanomentsoa.etudiantms.dto.etudiants.EtudiantItemToListDTO;
import ca.lazanomentsoa.etudiantms.dto.etudiants.PagedEtudiantItemListDTO;
import ca.lazanomentsoa.etudiantms.entity.etudiant.Etudiant;
import ca.lazanomentsoa.etudiantms.exception.EtudiantNotFound;
import ca.lazanomentsoa.etudiantms.repository.EtudiantRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
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
    public PagedEtudiantItemListDTO getAllEtudiants(String recherche, boolean isActive, int page, int size) {
        Page<Etudiant> pagedEtudiant = etudiantRepository.rechercheEtudiants(recherche, isActive, PageRequest.of(page, size));
        List<EtudiantItemToListDTO> listEtudiants = pagedEtudiant.getContent().stream().map(EtudiantItemToListDTO::fromEtudiantItem).toList();
        return new PagedEtudiantItemListDTO(page, pagedEtudiant.getTotalPages(), size, listEtudiants);
    }

    @Override
    public EtudiantDTO findById(String id){
        return etudiantRepository.findById(id).map(EtudiantDTO::fromEntity).orElseThrow(()-> new EtudiantNotFound("Etudiant matricule: " + id + " not found"));
    }

}
