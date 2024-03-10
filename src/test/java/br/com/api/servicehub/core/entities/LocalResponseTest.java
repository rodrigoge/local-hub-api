package br.com.api.servicehub.core.entities;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
public class LocalResponseTest {

    @Test
    void shouldReturnsAnService() {
        var service = new LocalResponse(LocalTypeEnum.FOOD, StateEnum.MINAS_GERAIS, "Paraisopolis");
        assertThat(service).isNotNull();
        assertThat(service.type()).isNotNull().isEqualTo(LocalTypeEnum.FOOD);
        assertThat(service.state()).isNotNull().isEqualTo(StateEnum.MINAS_GERAIS);
        assertThat(service.city()).isNotNull().isEqualTo("Paraisopolis");
    }

    @Test
    void shouldReturnsAnEmptyService() {
        var service = new LocalResponse(null, null, null);
        assertThat(service).isNotNull();
        assertThat(service.type()).isNull();
        assertThat(service.state()).isNull();
        assertThat(service.city()).isNull();
    }
}
