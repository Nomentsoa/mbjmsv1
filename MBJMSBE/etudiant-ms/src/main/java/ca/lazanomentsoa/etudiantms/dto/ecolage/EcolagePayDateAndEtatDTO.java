package ca.lazanomentsoa.etudiantms.dto.ecolage;

import java.time.LocalDate;

public record EcolagePayDateAndEtatDTO (LocalDate payDate, boolean etat) {
}
