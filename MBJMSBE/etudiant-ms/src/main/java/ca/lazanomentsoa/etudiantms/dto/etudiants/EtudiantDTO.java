package ca.lazanomentsoa.etudiantms.dto.etudiants;

import ca.lazanomentsoa.etudiantms.entity.etudiant.Etudiant;
import ca.lazanomentsoa.etudiantms.entity.etudiant.Sexe;


public record EtudiantDTO (String id,
        String nom,
        String prenom,
        String dateDeNaissance,
        Sexe sexe,
        String addresse,
        String photoProfile,
        boolean isActive,
        String qrCode,
        String nomPere,
        String telephonePere,
        String professionPere,
        String nomMere,
        String telephoneMere,
        String professionMere,
        boolean isTuteur,
        String noteSupplementaire){


        public Etudiant toEntity(){

                return Etudiant.builder()
                        .id(this.id)
                        .nom(this.nom)
                        .prenom(this.prenom)
                        .dateDeNaissance(this.dateDeNaissance)
                        .sexe(this.sexe)
                        .addresse(this.addresse)
                        .isActive(this.isActive)
                        .photoProfile(this.photoProfile)
                        .nomPere(this.nomPere)
                        .telephonePere(this.telephonePere)
                        .professionPere(this.professionPere)
                        .nomMere(this.nomMere)
                        .telephoneMere(this.telephoneMere)
                        .professionMere(this.professionMere)
                        .isTuteur(this.isTuteur)
                        .noteSupplementaire(this.noteSupplementaire)
                        .build();
        }

        public static EtudiantDTO fromEntity(Etudiant etudiant){
                return new EtudiantDTO(
                        etudiant.getId(),
                        etudiant.getNom(),
                        etudiant.getPrenom(),
                        etudiant.getDateDeNaissance(),
                        etudiant.getSexe(),
                        etudiant.getAddresse(),
                        etudiant.getPhotoProfile(),
                        etudiant.isActive(),
                        etudiant.getQrCode(),
                        etudiant.getNomPere(),
                        etudiant.getTelephonePere(),
                        etudiant.getProfessionPere(),
                        etudiant.getNomMere(),
                        etudiant.getTelephoneMere(),
                        etudiant.getProfessionPere(),
                        etudiant.isTuteur(),
                        etudiant.getNoteSupplementaire()
                );
        }




}
