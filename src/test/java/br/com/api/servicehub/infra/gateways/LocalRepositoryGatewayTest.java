package br.com.api.servicehub.infra.gateways;

import br.com.api.servicehub.core.entities.LocalRequest;
import br.com.api.servicehub.core.entities.LocalTypeEnum;
import br.com.api.servicehub.core.entities.OrderEnum;
import br.com.api.servicehub.core.entities.StateEnum;
import br.com.api.servicehub.infra.persistence.Local;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.UUID;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class LocalRepositoryGatewayTest {

    @InjectMocks
    private LocalRepositoryGateway localRepositoryGateway;

    @Mock
    private EntityManager entityManager;

    @Mock
    private CriteriaBuilder criteriaBuilder;

    @Mock
    private CriteriaQuery<Local> criteriaQuery;

    @Mock
    private Root<Local> root;

    @Mock
    private TypedQuery<Local> typedQuery;

    @Mock
    private LocalMapper localMapper;

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
        var serviceId = UUID.fromString("bcc4f117-94f3-4c75-a24d-18ce117ab5e7");
        var local = new Local(
                serviceId,
                "Store testing",
                "Avenue Text, number 100",
                LocalTypeEnum.FOOD,
                StateEnum.MINAS_GERAIS,
                "Paraisopolis"
        );
        var locations = List.of(local);
        when(entityManager.getCriteriaBuilder()).thenReturn(criteriaBuilder);
        when(criteriaBuilder.createQuery(Local.class)).thenReturn(criteriaQuery);
        when(criteriaQuery.from(Local.class)).thenReturn(root);
        when(typedQuery.getResultList()).thenReturn(locations);
        when(entityManager.createQuery(criteriaQuery)).thenReturn(typedQuery);
        when(entityManager.createQuery(criteriaQuery).getResultList()).thenReturn(locations);
        var response = localRepositoryGateway.getLocations(localRequest);
        Assertions.assertEquals(1, response.size());
    }

    @Test
    void shouldReturnGetLocationsOrderingByDesc() {
        var localRequest = new LocalRequest(
                "Store testing",
                "Avenue Text, number 100",
                LocalTypeEnum.FOOD,
                StateEnum.MINAS_GERAIS,
                "Paraisopolis",
                0,
                25,
                "id",
                OrderEnum.DESC
        );
        var serviceId = UUID.fromString("bcc4f117-94f3-4c75-a24d-18ce117ab5e7");
        var local = new Local(
                serviceId,
                "Store testing",
                "Avenue Text, number 100",
                LocalTypeEnum.FOOD,
                StateEnum.MINAS_GERAIS,
                "Paraisopolis"
        );
        var locations = List.of(local);
        when(entityManager.getCriteriaBuilder()).thenReturn(criteriaBuilder);
        when(criteriaBuilder.createQuery(Local.class)).thenReturn(criteriaQuery);
        when(criteriaQuery.from(Local.class)).thenReturn(root);
        when(typedQuery.getResultList()).thenReturn(locations);
        when(entityManager.createQuery(criteriaQuery)).thenReturn(typedQuery);
        when(entityManager.createQuery(criteriaQuery).getResultList()).thenReturn(locations);
        var response = localRepositoryGateway.getLocations(localRequest);
        Assertions.assertEquals(1, response.size());
    }
}
