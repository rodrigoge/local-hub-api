package br.com.api.servicehub.adapters;

import br.com.api.servicehub.app.LocalService;
import br.com.api.servicehub.core.entities.LocalRequest;
import br.com.api.servicehub.mocks.MockBuilder;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.ArgumentMatchers.any;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
@ActiveProfiles("test")
public class LocalControllerIT {

    @MockBean
    private LocalService localService;

    @Autowired
    private MockMvc mockMvc;

    @Test
    void should_GetLocations_When_ValidInput() throws Exception {
        var mockLocalResponses = MockBuilder.buildMockLocalResponses();
        Mockito.when(localService.getLocations(any(LocalRequest.class))).thenReturn(mockLocalResponses);
        var mockLocalRequest = MockBuilder.buildMockLocalRequestByAscending();
        mockMvc.perform(get("/services")
                        .contentType(MediaType.APPLICATION_JSON)
                        .param("name", "Company Name S.A")
                        .param("city", "123 Main Street, Cityville")
                        .param("page", "0")
                        .param("limit", "25")
                        .param("column", "id")
                        .param("order", "DESC"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$").isArray())
                .andExpect(jsonPath("$[0].name").value(mockLocalRequest.name()))
                .andExpect(jsonPath("$[0].city").value(mockLocalRequest.city()));
    }
}
