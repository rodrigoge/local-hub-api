package br.com.api.servicehub.infra.gateways;

import br.com.api.servicehub.core.entities.LocalRequest;
import br.com.api.servicehub.core.entities.LocalTypeEnum;
import br.com.api.servicehub.core.entities.OrderEnum;
import br.com.api.servicehub.core.entities.StateEnum;
import jakarta.persistence.EntityManager;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class LocalRepositoryGatewayTest {

    @InjectMocks
    private LocalRepositoryGateway localRepositoryGateway;

    @Mock
    private EntityManager entityManager;

    @Mock
    private CriteriaBuilder criteriaBuilder;

    @Test
    void shouldReturnGetLocations() {
        var localRequest = new LocalRequest(
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
        when(entityManager.getCriteriaBuilder()).thenReturn(criteriaBuilder);
        when(entityManager.createQuery(anyString())).thenReturn(any());
    }
}
