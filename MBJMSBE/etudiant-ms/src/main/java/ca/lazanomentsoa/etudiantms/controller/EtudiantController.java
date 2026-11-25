package ca.lazanomentsoa.etudiantms.controller;

import ca.lazanomentsoa.etudiantms.dto.etudiants.EtudiantDTO;
import ca.lazanomentsoa.etudiantms.dto.etudiants.EtudiantItemToListDTO;
import ca.lazanomentsoa.etudiantms.dto.etudiants.PagedEtudiantItemListDTO;
import ca.lazanomentsoa.etudiantms.service.EtudiantServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "${angular-fe.uri}")
@RequestMapping("/api/etudiants")
public class EtudiantController {
    private final EtudiantServiceImpl etudiantService;
    @Value("${build.name}")
    private String test = "test";

    @GetMapping("/{id}")
    public EtudiantDTO getEtudiant(@PathVariable String id) {
        return etudiantService.findById(id);
    }

    @PostMapping("")
    public EtudiantDTO createEtudiant(@RequestBody EtudiantDTO etudiantDTO){
        return etudiantService.save(etudiantDTO);
    }

    @GetMapping("")
    public PagedEtudiantItemListDTO etudiantListRecherche(
            @RequestParam(name = "recherche", defaultValue = "") String recherche,
            @RequestParam(name = "isActive", defaultValue = "true") boolean isActive,
            @RequestParam(name = "page", defaultValue = "0") int page,
            @RequestParam(name = "size", defaultValue = "10") int size

    ) {
        return etudiantService.getAllEtudiants(recherche, isActive, page, size);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity exceptionHandler(Exception e){
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
    }

}
