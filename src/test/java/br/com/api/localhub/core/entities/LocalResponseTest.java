package br.com.api.localhub.core.entities;

import br.com.api.localhub.mocks.MockBuilder;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.openapitools.model.LocalTypeEnum;
import org.openapitools.model.StateEnum;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
public class LocalResponseTest {

    @Test
    void should_ReturnLocalResponse_When_ValidInput() {
        var buildMockLocalResponse = MockBuilder.buildMockLocalResponse();
        assertThat(buildMockLocalResponse).isNotNull();
        assertThat(buildMockLocalResponse.getName()).isNotNull().isEqualTo("Company Name S.A");
        assertThat(buildMockLocalResponse.getAddress()).isNotNull().isEqualTo("123 Main Street, Cityville");
        assertThat(buildMockLocalResponse.getType()).isNotNull().isEqualTo(LocalTypeEnum.FOOD);
        assertThat(buildMockLocalResponse.getState()).isNotNull().isEqualTo(StateEnum.MINAS_GERAIS);
        assertThat(buildMockLocalResponse.getCity()).isNotNull().isEqualTo("Belo Horizonte");
    }

    @Test
    void should_ReturnEmptyLocalResponse_When_WithoutConstructor() {
        var buildMockEmptyLocalResponse = MockBuilder.buildMockEmptyLocalResponse();
        assertThat(buildMockEmptyLocalResponse).isNotNull();
        assertThat(buildMockEmptyLocalResponse.getName()).isNull();
        assertThat(buildMockEmptyLocalResponse.getAddress()).isNull();
        assertThat(buildMockEmptyLocalResponse.getType()).isNull();
        assertThat(buildMockEmptyLocalResponse.getState()).isNull();
        assertThat(buildMockEmptyLocalResponse.getCity()).isNull();
    }
}
