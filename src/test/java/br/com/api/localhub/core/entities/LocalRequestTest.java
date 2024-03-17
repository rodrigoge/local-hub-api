package br.com.api.localhub.core.entities;

import br.com.api.localhub.mocks.MockBuilder;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.openapitools.model.LocalTypeEnum;
import org.openapitools.model.OrderEnum;
import org.openapitools.model.StateEnum;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
public class LocalRequestTest {

    @Test
    void should_ReturnLocalRequest_When_ValidInput() {
        var mockLocalRequest = MockBuilder.buildMockLocalRequestByAscending();
        assertThat(mockLocalRequest).isNotNull();
        assertThat(mockLocalRequest.getName()).isNotNull().isEqualTo("Company Name S.A");
        assertThat(mockLocalRequest.getAddress()).isNotNull().isEqualTo("123 Main Street, Cityville");
        assertThat(mockLocalRequest.getType()).isNotNull().isEqualTo(LocalTypeEnum.FOOD);
        assertThat(mockLocalRequest.getState()).isNotNull().isEqualTo(StateEnum.MINAS_GERAIS);
        assertThat(mockLocalRequest.getCity()).isNotNull().isEqualTo("Belo Horizonte");
        assertThat(mockLocalRequest.getPage()).isEqualTo(0);
        assertThat(mockLocalRequest.getLimit()).isEqualTo(25);
        assertThat(mockLocalRequest.getColumn()).isNotNull().isEqualTo("id");
        assertThat(mockLocalRequest.getOrder()).isNotNull().isEqualTo(OrderEnum.ASC);
    }

    @Test
    void should_ReturnEmptyLocalRequest_When_WithoutConstructor() {
        var mockEmptyLocalRequest = MockBuilder.buildMockEmptyLocalRequest();
        assertThat(mockEmptyLocalRequest).isNotNull();
        assertThat(mockEmptyLocalRequest.getName()).isNull();
        assertThat(mockEmptyLocalRequest.getAddress()).isNull();
        assertThat(mockEmptyLocalRequest.getType()).isNull();
        assertThat(mockEmptyLocalRequest.getState()).isNull();
        assertThat(mockEmptyLocalRequest.getCity()).isNull();
        assertThat(mockEmptyLocalRequest.getColumn()).isNull();
        assertThat(mockEmptyLocalRequest.getOrder()).isNull();
    }
}
