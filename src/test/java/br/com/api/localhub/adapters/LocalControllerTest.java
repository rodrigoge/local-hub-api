package br.com.api.localhub.adapters;

import br.com.api.localhub.adapters.controllers.LocalController;
import br.com.api.localhub.app.LocalService;
import br.com.api.localhub.core.entities.LocalTypeEnum;
import br.com.api.localhub.core.entities.OrderEnum;
import br.com.api.localhub.core.entities.StateEnum;
import br.com.api.localhub.mocks.MockBuilder;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class LocalControllerTest {

    @Mock
    private LocalService localService;

    @InjectMocks
    private LocalController localController;

    @Test
    void should_GetLocationsByAscending_When_ValidInput() {
        var mockLocalRequest = MockBuilder.buildMockLocalRequestByAscending();
        var mockLocalResponses = MockBuilder.buildMockLocalResponses();
        when(localService.getLocals(mockLocalRequest)).thenReturn(mockLocalResponses);
        var response = localController.getLocals(
                "Company Name S.A",
                "123 Main Street, Cityville",
                LocalTypeEnum.FOOD,
                StateEnum.MINAS_GERAIS,
                "Belo Horizonte",
                0,
                25,
                "id",
                OrderEnum.ASC
        );
        Assertions.assertThat(response).isNotNull();
        Assertions.assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        Assertions.assertThat(response.getBody()).isNotNull();
        Assertions.assertThat(response).isNotNull();
        Assertions.assertThat(response.getBody().size()).isEqualTo(1);
        Assertions.assertThat(response.getBody().getFirst().name()).isEqualTo("Company Name S.A");
        Assertions.assertThat(response.getBody().getFirst().address()).isEqualTo("123 Main Street, Cityville");
        Assertions.assertThat(response.getBody().getFirst().type()).isEqualTo(LocalTypeEnum.FOOD);
        Assertions.assertThat(response.getBody().getFirst().state()).isEqualTo(StateEnum.MINAS_GERAIS);
        Assertions.assertThat(response.getBody().getFirst().city()).isEqualTo("Belo Horizonte");
    }

    @Test
    void should_GetLocationsByDescending_When_ValidInput() {
        var mockLocalRequest = MockBuilder.buildMockLocalRequestByDescending();
        var mockLocalResponses = MockBuilder.buildMockLocalResponses();
        when(localService.getLocals(mockLocalRequest)).thenReturn(mockLocalResponses);
        var response = localController.getLocals(
                "Company Name S.A",
                "123 Main Street, Cityville",
                LocalTypeEnum.FOOD,
                StateEnum.MINAS_GERAIS,
                "Belo Horizonte",
                0,
                25,
                "id",
                OrderEnum.DESC
        );
        Assertions.assertThat(response).isNotNull();
        Assertions.assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        Assertions.assertThat(response.getBody()).isNotNull();
        Assertions.assertThat(response).isNotNull();
        Assertions.assertThat(response.getBody().size()).isEqualTo(1);
        Assertions.assertThat(response.getBody().getFirst().name()).isEqualTo("Company Name S.A");
        Assertions.assertThat(response.getBody().getFirst().address()).isEqualTo("123 Main Street, Cityville");
        Assertions.assertThat(response.getBody().getFirst().type()).isEqualTo(LocalTypeEnum.FOOD);
        Assertions.assertThat(response.getBody().getFirst().state()).isEqualTo(StateEnum.MINAS_GERAIS);
        Assertions.assertThat(response.getBody().getFirst().city()).isEqualTo("Belo Horizonte");
    }
}
