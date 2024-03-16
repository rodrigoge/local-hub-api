package br.com.api.localhub.infra.configurations;

import br.com.api.localhub.infra.gateways.LocalRepositoryGateway;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class LocalConfigurationTest {

    @InjectMocks
    private LocalConfiguration localConfiguration;

    @Mock
    private LocalRepositoryGateway localRepositoryGateway;

    @Test
    void should_CreateLocalConfiguration_When_LoadBean() {
        var response = localConfiguration.localRepositoryGateway();
        Assertions.assertThat(response).isNotNull();
    }
}
