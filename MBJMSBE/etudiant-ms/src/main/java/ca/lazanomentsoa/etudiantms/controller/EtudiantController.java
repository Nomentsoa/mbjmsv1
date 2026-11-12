package ca.lazanomentsoa.etudiantms.controller;

import ca.lazanomentsoa.etudiantms.entity.TestEtudiant;
import ca.lazanomentsoa.etudiantms.repository.TestEtudiantRepository;
import ca.lazanomentsoa.etudiantms.service.EtudiantService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "${angular-fe.uri}")
public class EtudiantController {
    private final EtudiantService etudiantService;
    private final TestEtudiantRepository testEtudiantRepository;
    @Value("${build.name}")
    private String test = "test";

    @GetMapping("/api/etudiants")
    public String etudiant() {
        return test +" "+ etudiantService.getEnseignantMS();
    }

    @GetMapping("/api/etudiants/list")
    public List<TestEtudiant> etudiantList() {
        return testEtudiantRepository.findAll();
    }
}
