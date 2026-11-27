package ca.lazanomentsoa.etudiantms.service.ecolage;

import ca.lazanomentsoa.etudiantms.dto.ResponseDTO;
import ca.lazanomentsoa.etudiantms.dto.ecolage.EcolageToPayDTO;
import ca.lazanomentsoa.etudiantms.dto.ecolage.MoiPaidEcolageDTO;

import java.util.Optional;


public interface EcolageService {
    ResponseDTO saveEcolageEtudiant(EcolageToPayDTO ecolageToPayDTO);
    Optional<MoiPaidEcolageDTO> getMoisPaydEcolage(String anneeScolaire, String matriculEdtudiant,  int mois);
}
