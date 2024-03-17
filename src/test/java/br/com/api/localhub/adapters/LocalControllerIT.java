package br.com.api.localhub.adapters;

import br.com.api.localhub.adapters.controllers.LocalController;
import br.com.api.localhub.app.LocalService;
import br.com.api.localhub.mocks.MockBuilder;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openapitools.model.LocalRequest;
import org.openapitools.model.LocalTypeEnum;
import org.openapitools.model.OrderEnum;
import org.openapitools.model.StateEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
@ActiveProfiles("test")
public class LocalControllerIT {

    @MockBean
    private LocalService localService;

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private LocalController localController;

    @Test
    void should_GetLocations_When_ValidInput() {
        var mockLocalResponses = MockBuilder.buildMockLocalResponses();
        when(localService.getLocals(any(LocalRequest.class))).thenReturn(mockLocalResponses);
        var localResponses = localController.getLocals(
                0,
                25,
                "id",
                OrderEnum.ASC,
                "Company Name S.A",
                "123 Main Street, Cityville",
                LocalTypeEnum.FOOD,
                StateEnum.MINAS_GERAIS,
                "Belo Horizonte"
        );
        assertNotNull(localResponses);
        assertNotNull(localResponses.getBody());
        assertEquals(mockLocalResponses.size(), localResponses.getBody().size());
        assertEquals(mockLocalResponses.getFirst().getName(), localResponses.getBody().getFirst().getName());
        assertEquals(mockLocalResponses.getFirst().getAddress(), localResponses.getBody().getFirst().getAddress());
        assertEquals(mockLocalResponses.getFirst().getType(), localResponses.getBody().getFirst().getType());
        assertEquals(mockLocalResponses.getFirst().getState(), localResponses.getBody().getFirst().getState());
        assertEquals(mockLocalResponses.getFirst().getCity(), localResponses.getBody().getFirst().getCity());
    }
}
