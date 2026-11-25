package ca.lazanomentsoa.etudiantms.dto.etudiants;

import java.util.List;

public record PagedEtudiantItemListDTO(
        int currentPage,
        int totalPages,
        int pageSize,
        List<EtudiantItemToListDTO> etudiantItemListDTOs
) {
}
