package br.com.api.localhub.infra.persistence;

import br.com.api.localhub.core.entities.LocalTypeEnum;
import br.com.api.localhub.core.entities.StateEnum;
import br.com.api.localhub.mocks.MockBuilder;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
public class LocalTest {

    @Test
    void should_ReturnLocal_When_ValidInput() {
        var buildMockLocal = MockBuilder.buildMockLocal();
        assertThat(buildMockLocal).isNotNull();
        assertThat(buildMockLocal.getId()).isNotNull().isEqualTo(UUID.fromString("bcc4f117-94f3-4c75-a24d-18ce117ab5e7"));
        assertThat(buildMockLocal.getName()).isNotNull().isEqualTo("Company Name S.A");
        assertThat(buildMockLocal.getAddress()).isNotNull().isEqualTo("123 Main Street, Cityville");
        assertThat(buildMockLocal.getType()).isNotNull().isEqualTo(LocalTypeEnum.FOOD);
        assertThat(buildMockLocal.getState()).isNotNull().isEqualTo(StateEnum.MINAS_GERAIS);
        assertThat(buildMockLocal.getCity()).isNotNull().isEqualTo("Belo Horizonte");
    }

    @Test
    void should_ReturnEmptyLocal_When_WithoutConstructor() {
        var buildMockEmptyLocal = MockBuilder.buildMockEmptyLocal();
        assertThat(buildMockEmptyLocal).isNotNull();
        assertThat(buildMockEmptyLocal.getId()).isNull();
        assertThat(buildMockEmptyLocal.getName()).isNull();
        assertThat(buildMockEmptyLocal.getAddress()).isNull();
        assertThat(buildMockEmptyLocal.getType()).isNull();
        assertThat(buildMockEmptyLocal.getState()).isNull();
        assertThat(buildMockEmptyLocal.getCity()).isNull();
    }
}
