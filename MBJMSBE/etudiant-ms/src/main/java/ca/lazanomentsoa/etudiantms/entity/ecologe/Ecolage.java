package ca.lazanomentsoa.etudiantms.entity.ecologe;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

import java.time.LocalDate;
import java.util.Date;

@Entity
@Builder @Getter
@Setter @NoArgsConstructor @AllArgsConstructor
public class Ecolage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String matriculeEtudiant;
    private String anneeScolaire;
    private LocalDate septembre;
    private boolean isPaydSeptembre;
    private LocalDate octobre;
    private boolean isPaydOctobre;
    private LocalDate novembre;
    private boolean isPaydNovembre;
    private LocalDate decembre;
    private boolean isPaydDecembre;
    private LocalDate janvier;
    private boolean isPaydJanvier;
    private LocalDate fevrier;
    private boolean isPaydFevrier;
    private LocalDate mars;
    private boolean isPaydMars;
    private LocalDate avril;
    private boolean isPaydAvril;
    private LocalDate mai;
    private boolean isPaydMai;
    private LocalDate juin;
    private boolean isPaydJuin;
    private LocalDate juillet;
    private boolean isPaydJuillet;

}
