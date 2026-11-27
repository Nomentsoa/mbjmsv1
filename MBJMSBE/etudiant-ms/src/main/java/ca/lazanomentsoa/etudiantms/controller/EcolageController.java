package ca.lazanomentsoa.etudiantms.controller;

import ca.lazanomentsoa.etudiantms.dto.ResponseDTO;
import ca.lazanomentsoa.etudiantms.dto.ecolage.EcolageToPayDTO;
import ca.lazanomentsoa.etudiantms.dto.ecolage.MoiPaidEcolageDTO;
import ca.lazanomentsoa.etudiantms.service.ecolage.EcolageService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/ecolages")
@AllArgsConstructor
public class EcolageController {
    private final EcolageService ecolageService;

    @PostMapping("")
    public ResponseEntity<ResponseDTO> createEtudiantEcoloage(@RequestBody EcolageToPayDTO ecolageToPayDTO) {
        return new ResponseEntity<>(ecolageService.saveEcolageEtudiant(ecolageToPayDTO), HttpStatus.CREATED);
    }

    @GetMapping("")
    public ResponseEntity<Optional<MoiPaidEcolageDTO>> getMoiPaydEcolage(@RequestParam(name = "anneeScolaire") String anneeScolaire, @RequestParam(name = "matriculeEtudiant") String matriculeEtudiant, @RequestParam(name = "mois", defaultValue = "0") int mois){
        return new ResponseEntity<>(ecolageService.getMoisPaydEcolage(anneeScolaire, matriculeEtudiant, mois), HttpStatus.OK);
    }

}
