package br.com.api.localhub.core.entities;

import br.com.api.localhub.mocks.MockBuilder;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
public class LocalResponseTest {

    @Test
    void should_ReturnLocalResponse_When_ValidInput() {
        var buildMockLocalResponse = MockBuilder.buildMockLocalResponse();
        assertThat(buildMockLocalResponse).isNotNull();
        assertThat(buildMockLocalResponse.name()).isNotNull().isEqualTo("Company Name S.A");
        assertThat(buildMockLocalResponse.address()).isNotNull().isEqualTo("123 Main Street, Cityville");
        assertThat(buildMockLocalResponse.type()).isNotNull().isEqualTo(LocalTypeEnum.FOOD);
        assertThat(buildMockLocalResponse.state()).isNotNull().isEqualTo(StateEnum.MINAS_GERAIS);
        assertThat(buildMockLocalResponse.city()).isNotNull().isEqualTo("Belo Horizonte");
    }

    @Test
    void should_ReturnEmptyLocalResponse_When_WithoutConstructor() {
        var buildMockEmptyLocalResponse = MockBuilder.buildMockEmptyLocalResponse();
        assertThat(buildMockEmptyLocalResponse).isNotNull();
        assertThat(buildMockEmptyLocalResponse.name()).isNull();
        assertThat(buildMockEmptyLocalResponse.address()).isNull();
        assertThat(buildMockEmptyLocalResponse.type()).isNull();
        assertThat(buildMockEmptyLocalResponse.state()).isNull();
        assertThat(buildMockEmptyLocalResponse.city()).isNull();
    }
}
