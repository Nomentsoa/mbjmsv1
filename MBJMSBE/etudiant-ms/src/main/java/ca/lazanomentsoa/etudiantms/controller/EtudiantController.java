package ca.lazanomentsoa.etudiantms.controller;

import ca.lazanomentsoa.etudiantms.dto.EtudiantDTO;
import ca.lazanomentsoa.etudiantms.dto.EtudiantItemToListDTO;
import ca.lazanomentsoa.etudiantms.service.EtudiantServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    public List<EtudiantItemToListDTO> etudiantList() {
        return etudiantService.findAll();
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity exceptionHandler(Exception e){
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
    }

}
