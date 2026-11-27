package ca.lazanomentsoa.etudiantms.service.ecolage;

import ca.lazanomentsoa.etudiantms.dto.ResponseDTO;
import ca.lazanomentsoa.etudiantms.dto.ecolage.EcolageToPayDTO;
import ca.lazanomentsoa.etudiantms.dto.ecolage.MoiPaidEcolageDTO;
import ca.lazanomentsoa.etudiantms.entity.ecologe.Ecolage;
import ca.lazanomentsoa.etudiantms.repository.EcolageRepository;
import ca.lazanomentsoa.etudiantms.utils.Utils;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class EcolageServiceImpl implements EcolageService {
    private EcolageRepository ecolageRepository;

    @Override
    public ResponseDTO saveEcolageEtudiant(EcolageToPayDTO ecolageToPayDTO) {
        Ecolage ecolage = Ecolage.builder()
                .anneeScolaire(ecolageToPayDTO.anneeScolaire())
                .matriculeEtudiant(ecolageToPayDTO.matriculEtudutiant())
                .build();


        Ecolage savedEcolage = ecolageRepository.save(Utils.setPaydDate(ecolage, ecolageToPayDTO.mois()));
        return new ResponseDTO(false, "Ecolage Etudiant saved etudiant " + savedEcolage.getMatriculeEtudiant() + "annee scolaire " + savedEcolage.getAnneeScolaire());

    }

    @Override
    public Optional<MoiPaidEcolageDTO> getMoisPaydEcolage( String anneeScolaire, String matriculEdtudiant, int mois) {
        Ecolage ecolcageEtudiant = ecolageRepository.findByMatriculeEtudiantAndAnneeScolaire(matriculEdtudiant, anneeScolaire);
        if(ecolcageEtudiant == null)
            return Optional.empty();

        MoiPaidEcolageDTO moiPaidEcolageDTO = new MoiPaidEcolageDTO(anneeScolaire, Utils.getEtatEcolageDuMois(ecolcageEtudiant, mois));
        return Optional.of(moiPaidEcolageDTO);
    }


}
