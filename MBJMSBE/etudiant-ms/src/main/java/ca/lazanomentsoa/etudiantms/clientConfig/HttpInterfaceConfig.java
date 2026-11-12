package ca.lazanomentsoa.etudiantms.clientConfig;

import ca.lazanomentsoa.etudiantms.clientConfig.enseignant.EnseignantHttpInterface;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatusCode;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.support.WebClientAdapter;
import org.springframework.web.service.invoker.HttpServiceProxyFactory;
import reactor.core.publisher.Mono;

@Configuration
public class HttpInterfaceConfig {
    @Bean
    @LoadBalanced
    public WebClient.Builder webClientBuilder(){
        return WebClient.builder();
    }

    @Bean
    public EnseignantHttpInterface enseignantHttpInterface(WebClient.Builder webClientBuilder){
        WebClient webClient = webClientBuilder.baseUrl("http://enseignant-ms")
                .defaultStatusHandler(HttpStatusCode::is4xxClientError, (clientResponse -> Mono.empty()))
                .build();
        WebClientAdapter adapter = WebClientAdapter.create(webClient);
        HttpServiceProxyFactory factory = HttpServiceProxyFactory.builderFor(adapter).build();

        return factory.createClient(EnseignantHttpInterface.class);
    }
}
