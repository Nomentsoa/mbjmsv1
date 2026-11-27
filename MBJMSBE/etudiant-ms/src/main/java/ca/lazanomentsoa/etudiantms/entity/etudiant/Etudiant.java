package ca.lazanomentsoa.etudiantms.entity.etudiant;

import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import lombok.*;

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
    private boolean isActive = true;
    private String nomPere;
    @Column(length = 10)
    private String telephonePere;
    private String professionPere;
    private String nomMere;
    @Column(length = 10)
    private String telephoneMere;
    private String professionMere;
    private boolean isTuteur = false;
    private String noteSupplementaire;

}
