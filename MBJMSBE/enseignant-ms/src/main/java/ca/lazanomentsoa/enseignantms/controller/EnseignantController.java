package ca.lazanomentsoa.enseignantms.controller;

import ca.lazanomentsoa.enseignantms.entity.TestEnseignant;
import ca.lazanomentsoa.enseignantms.repository.TestEnseignantRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/enseignants")
public class EnseignantController{
    private final TestEnseignantRepository testEnseignantRepository;

    public EnseignantController(TestEnseignantRepository testEnseignantRepository) {
        this.testEnseignantRepository = testEnseignantRepository;
    }

    @GetMapping("")
    public List<TestEnseignant> getEnseignants() {
        return testEnseignantRepository.findAll();
    }
}
