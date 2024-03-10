package br.com.api.servicehub.adapters;

import br.com.api.servicehub.core.entities.LocalTypeEnum;
import br.com.api.servicehub.core.entities.StateEnum;
import br.com.api.servicehub.infra.persistence.Local;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;
import java.util.Objects;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class LocalControllerIT {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate testRestTemplate;

    @Test
    void shouldGetServices() {
        var service = new Local();
        var serviceId = UUID.fromString("bcc4f117-94f3-4c75-a24d-18ce117ab5e7");
        service.setId(serviceId);
        service.setType(LocalTypeEnum.FOOD);
        service.setState(StateEnum.MINAS_GERAIS);
        service.setCity("Paraisopolis");
        var services = List.of(service);
        var serviceResponse = testRestTemplate.getForEntity(
                "http://localhost:" + port + "/services",
                Local[].class
        );
        assertEquals(HttpStatus.OK, serviceResponse.getStatusCode());
        var actualServices = List.of(Objects.requireNonNull(serviceResponse.getBody()));
        assertEquals(services.size(), actualServices.size());
    }
}
