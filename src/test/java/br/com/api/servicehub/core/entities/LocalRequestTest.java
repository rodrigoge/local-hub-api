package br.com.api.servicehub.core.entities;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
public class LocalRequestTest {

    @Test
    void shouldReturnsAnLocalRequest() {
        var service = new LocalRequest(
                "Store testing",
                "Avenue Text, number 100",
                LocalTypeEnum.FOOD,
                StateEnum.MINAS_GERAIS,
                "Paraisopolis",
                0,
                25,
                "id",
                OrderEnum.ASC
        );
        assertThat(service).isNotNull();
        assertThat(service.name()).isNotNull().isEqualTo("Store testing");
        assertThat(service.address()).isNotNull().isEqualTo("Avenue Text, number 100");
        assertThat(service.type()).isNotNull().isEqualTo(LocalTypeEnum.FOOD);
        assertThat(service.state()).isNotNull().isEqualTo(StateEnum.MINAS_GERAIS);
        assertThat(service.city()).isNotNull().isEqualTo("Paraisopolis");
        assertThat(service.page()).isEqualTo(0);
        assertThat(service.limit()).isEqualTo(25);
        assertThat(service.column()).isNotNull().isEqualTo("id");
        assertThat(service.order()).isNotNull().isEqualTo(OrderEnum.ASC);
    }

    @Test
    void shouldReturnsAnEmptyService() {
        var service = new LocalRequest(
                null,
                null,
                null,
                null,
                null,
                0,
                25,
                null,
                null);
        assertThat(service).isNotNull();
        assertThat(service.name()).isNull();
        assertThat(service.address()).isNull();
        assertThat(service.type()).isNull();
        assertThat(service.state()).isNull();
        assertThat(service.city()).isNull();
        assertThat(service.column()).isNull();
        assertThat(service.order()).isNull();
    }
}
