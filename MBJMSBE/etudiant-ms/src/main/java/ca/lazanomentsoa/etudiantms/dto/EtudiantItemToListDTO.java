package ca.lazanomentsoa.etudiantms.dto;

import ca.lazanomentsoa.etudiantms.entity.Etudiant;
import ca.lazanomentsoa.etudiantms.entity.Sexe;
import lombok.Builder;

import java.util.Date;
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
