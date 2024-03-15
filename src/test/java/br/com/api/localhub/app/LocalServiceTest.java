package br.com.api.localhub.app;

import br.com.api.localhub.core.entities.LocalTypeEnum;
import br.com.api.localhub.core.entities.StateEnum;
import br.com.api.localhub.infra.gateways.LocalRepositoryGateway;
import br.com.api.localhub.mocks.MockBuilder;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class LocalServiceTest {

    @InjectMocks
    private LocalService localService;

    @Mock
    private LocalRepositoryGateway localRepositoryGateway;

    @Test
    void should_ReturnLocalResponseList_When_ValidInput() {
        var mockLocalRequest = MockBuilder.buildMockLocalRequestByAscending();
        var mockLocalResponses = MockBuilder.buildMockLocalResponses();
        when(localRepositoryGateway.getLocals(mockLocalRequest)).thenReturn(mockLocalResponses);
        var response = localService.getLocals(mockLocalRequest);
        assertThat(response).isNotNull();
        assertThat(response.size()).isEqualTo(1);
        assertThat(response.getFirst().name()).isEqualTo("Company Name S.A");
        assertThat(response.getFirst().address()).isEqualTo("123 Main Street, Cityville");
        assertThat(response.getFirst().type()).isEqualTo(LocalTypeEnum.FOOD);
        assertThat(response.getFirst().state()).isEqualTo(StateEnum.MINAS_GERAIS);
        assertThat(response.getFirst().city()).isEqualTo("Belo Horizonte");
    }
}
