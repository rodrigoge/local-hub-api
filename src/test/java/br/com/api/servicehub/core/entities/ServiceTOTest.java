package br.com.api.servicehub.core.entities;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
public class ServiceTOTest {

    @Test
    void shouldReturnsAnService() {
        var service = new ServiceTO(ServiceTypeEnum.FOOD, StateEnum.MINAS_GERAIS, "Paraisopolis");
        assertThat(service).isNotNull();
        assertThat(service.type()).isNotNull().isEqualTo(ServiceTypeEnum.FOOD);
        assertThat(service.state()).isNotNull().isEqualTo(StateEnum.MINAS_GERAIS);
        assertThat(service.city()).isNotNull().isEqualTo("Paraisopolis");
    }

    @Test
    void shouldReturnsAnEmptyService() {
        var service = new ServiceTO(null, null, null);
        assertThat(service).isNotNull();
        assertThat(service.type()).isNull();
        assertThat(service.state()).isNull();
        assertThat(service.city()).isNull();
    }
}
