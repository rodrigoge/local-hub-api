package br.com.api.localhub.infra.configurations;

import br.com.api.localhub.infra.gateways.LocalRepositoryGateway;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LocalConfiguration {

    @Bean
    public LocalRepositoryGateway localRepositoryGateway() {
        return new LocalRepositoryGateway();
    }
}
