package ca.lazanomentsoa.etudiantms.dto.etudiants;

import ca.lazanomentsoa.etudiantms.entity.etudiant.Etudiant;
import ca.lazanomentsoa.etudiantms.entity.etudiant.Sexe;
import lombok.Builder;

@Builder
public record EtudiantItemToListDTO(
        String id,
        String nom,
        String prenom,
        String dateDeNaissance,
        Sexe sexe,
        String photoProfile,
        String qrCode
) {
    public static EtudiantItemToListDTO fromEtudiantItem(Etudiant etudiant) {
        if (etudiant == null) {
            return null;
        }
        return EtudiantItemToListDTO.builder()
                .id(etudiant.getId())
                .nom(etudiant.getNom())
                .prenom(etudiant.getPrenom())
                .dateDeNaissance(etudiant.getDateDeNaissance())
                .sexe(etudiant.getSexe())
                .photoProfile(etudiant.getPhotoProfile())
                .qrCode(etudiant.getQrCode())
                .build();
    }
}
