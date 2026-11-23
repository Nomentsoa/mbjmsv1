package ca.lazanomentsoa.etudiantms.entity;

import jakarta.annotation.Nullable;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import lombok.*;

import java.util.Date;

@Entity
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class Etudiant {
    @Id
    private String id;
    private String nom;
    private String prenom;
    private String dateDeNaissance;
    @Enumerated(EnumType.STRING)
    private Sexe sexe;
    private String addresse;
    private String photoProfile;
    @Nullable
    private String qrCode;
    private String nomPere;
    private String telephonePere;
    private String professionPere;
    private String nomMere;
    private String telephoneMere;
    private String professionMere;
    private boolean isTuteur = false;
    private String noteSupplementaire;

}
