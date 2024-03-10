package br.com.api.servicehub.infra.persistence;

import br.com.api.servicehub.core.entities.LocalTypeEnum;
import br.com.api.servicehub.core.entities.StateEnum;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
public class LocalTest {

    @Test
    void shouldCreateNewService() {
        var service = new Local();
        var serviceId = UUID.fromString("bcc4f117-94f3-4c75-a24d-18ce117ab5e7");
        service.setId(serviceId);
        service.setType(LocalTypeEnum.FOOD);
        service.setState(StateEnum.MINAS_GERAIS);
        service.setCity("Paraisopolis");
        assertThat(service).isNotNull();
        assertThat(service.getId()).isNotNull().isEqualTo(serviceId);
        assertThat(service.getType()).isNotNull().isEqualTo(LocalTypeEnum.FOOD);
        assertThat(service.getState()).isNotNull().isEqualTo(StateEnum.MINAS_GERAIS);
        assertThat(service.getCity()).isNotNull().isEqualTo("Paraisopolis");
    }

    @Test
    void shouldReturnsEmptyService() {
        var service = new Local();
        assertThat(service).isNotNull();
        assertThat(service.getId()).isNull();
        assertThat(service.getType()).isNull();
        assertThat(service.getState()).isNull();
        assertThat(service.getCity()).isNull();
    }
}
