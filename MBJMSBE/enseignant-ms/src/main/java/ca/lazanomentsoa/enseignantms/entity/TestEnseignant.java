package ca.lazanomentsoa.enseignantms.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

@Entity
@Setter @Getter @NoArgsConstructor @AllArgsConstructor @Builder
public class TestEnseignant {
    @Id @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    private String text;
}
