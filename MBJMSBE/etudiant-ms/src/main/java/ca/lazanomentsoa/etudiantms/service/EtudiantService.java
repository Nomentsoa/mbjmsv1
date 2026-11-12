package ca.lazanomentsoa.etudiantms.service;


import ca.lazanomentsoa.etudiantms.clientConfig.enseignant.EnseignantHttpInterface;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EtudiantService {
    private final EnseignantHttpInterface enseignantHttpInterface;

    public String getEnseignantMS() {
        return enseignantHttpInterface.getEnseignants();
    }
}
