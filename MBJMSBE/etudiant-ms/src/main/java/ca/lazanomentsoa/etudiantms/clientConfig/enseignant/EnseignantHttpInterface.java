package ca.lazanomentsoa.etudiantms.clientConfig.enseignant;

import org.springframework.web.service.annotation.GetExchange;
import org.springframework.web.service.annotation.HttpExchange;

@HttpExchange("/api/enseignants")
public interface EnseignantHttpInterface {

    @GetExchange("")
    String getEnseignants();


}
