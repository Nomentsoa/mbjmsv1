package ca.lazanomentsoa.etudiantms.dto.ecolage;

import java.util.List;

public record EcolageToPayDTO(String matriculEtudutiant,String anneeScolaire, List<Integer> mois){
}
