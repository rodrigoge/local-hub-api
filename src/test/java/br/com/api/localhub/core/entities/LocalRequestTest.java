package br.com.api.localhub.core.entities;

import br.com.api.localhub.mocks.MockBuilder;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
public class LocalRequestTest {

    @Test
    void should_ReturnLocalRequest_When_ValidInput() {
        var mockLocalRequest = MockBuilder.buildMockLocalRequestByAscending();
        assertThat(mockLocalRequest).isNotNull();
        assertThat(mockLocalRequest.name()).isNotNull().isEqualTo("Company Name S.A");
        assertThat(mockLocalRequest.address()).isNotNull().isEqualTo("123 Main Street, Cityville");
        assertThat(mockLocalRequest.type()).isNotNull().isEqualTo(LocalTypeEnum.FOOD);
        assertThat(mockLocalRequest.state()).isNotNull().isEqualTo(StateEnum.MINAS_GERAIS);
        assertThat(mockLocalRequest.city()).isNotNull().isEqualTo("Belo Horizonte");
        assertThat(mockLocalRequest.page()).isEqualTo(0);
        assertThat(mockLocalRequest.limit()).isEqualTo(25);
        assertThat(mockLocalRequest.column()).isNotNull().isEqualTo("id");
        assertThat(mockLocalRequest.order()).isNotNull().isEqualTo(OrderEnum.ASC);
    }

    @Test
    void should_ReturnEmptyLocalRequest_When_WithoutConstructor() {
        var mockEmptyLocalRequest = MockBuilder.buildMockEmptyLocalRequest();
        assertThat(mockEmptyLocalRequest).isNotNull();
        assertThat(mockEmptyLocalRequest.name()).isNull();
        assertThat(mockEmptyLocalRequest.address()).isNull();
        assertThat(mockEmptyLocalRequest.type()).isNull();
        assertThat(mockEmptyLocalRequest.state()).isNull();
        assertThat(mockEmptyLocalRequest.city()).isNull();
        assertThat(mockEmptyLocalRequest.column()).isNull();
        assertThat(mockEmptyLocalRequest.order()).isNull();
    }
}
