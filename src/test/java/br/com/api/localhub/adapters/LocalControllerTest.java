package br.com.api.localhub.adapters;

import br.com.api.localhub.adapters.controllers.LocalController;
import br.com.api.localhub.app.LocalService;
import br.com.api.localhub.mocks.MockBuilder;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.openapitools.model.LocalTypeEnum;
import org.openapitools.model.OrderEnum;
import org.openapitools.model.StateEnum;
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
                0,
                25,
                "id",
                OrderEnum.ASC,
                "Company Name S.A",
                "123 Main Street, Cityville",
                LocalTypeEnum.FOOD,
                StateEnum.MINAS_GERAIS,
                "Belo Horizonte"
        );
        Assertions.assertThat(response).isNotNull();
        Assertions.assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        Assertions.assertThat(response.getBody()).isNotNull();
        Assertions.assertThat(response).isNotNull();
        Assertions.assertThat(response.getBody().size()).isEqualTo(1);
        Assertions.assertThat(response.getBody().getFirst().getName()).isEqualTo("Company Name S.A");
        Assertions.assertThat(response.getBody().getFirst().getAddress()).isEqualTo("123 Main Street, Cityville");
        Assertions.assertThat(response.getBody().getFirst().getType()).isEqualTo(LocalTypeEnum.FOOD);
        Assertions.assertThat(response.getBody().getFirst().getState()).isEqualTo(StateEnum.MINAS_GERAIS);
        Assertions.assertThat(response.getBody().getFirst().getCity()).isEqualTo("Belo Horizonte");
    }

    @Test
    void should_GetLocationsByDescending_When_ValidInput() {
        var mockLocalRequest = MockBuilder.buildMockLocalRequestByDescending();
        var mockLocalResponses = MockBuilder.buildMockLocalResponses();
        when(localService.getLocals(mockLocalRequest)).thenReturn(mockLocalResponses);
        var response = localController.getLocals(
                0,
                25,
                "id",
                OrderEnum.DESC,
                "Company Name S.A",
                "123 Main Street, Cityville",
                LocalTypeEnum.FOOD,
                StateEnum.MINAS_GERAIS,
                "Belo Horizonte"
        );
        Assertions.assertThat(response).isNotNull();
        Assertions.assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        Assertions.assertThat(response.getBody()).isNotNull();
        Assertions.assertThat(response).isNotNull();
        Assertions.assertThat(response.getBody().size()).isEqualTo(1);
        Assertions.assertThat(response.getBody().getFirst().getName()).isEqualTo("Company Name S.A");
        Assertions.assertThat(response.getBody().getFirst().getAddress()).isEqualTo("123 Main Street, Cityville");
        Assertions.assertThat(response.getBody().getFirst().getType()).isEqualTo(LocalTypeEnum.FOOD);
        Assertions.assertThat(response.getBody().getFirst().getState()).isEqualTo(StateEnum.MINAS_GERAIS);
        Assertions.assertThat(response.getBody().getFirst().getCity()).isEqualTo("Belo Horizonte");
    }
}
