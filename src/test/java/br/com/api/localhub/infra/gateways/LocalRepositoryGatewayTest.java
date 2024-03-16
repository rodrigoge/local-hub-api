package br.com.api.localhub.infra.gateways;

import br.com.api.localhub.infra.persistence.Local;
import br.com.api.localhub.mocks.MockBuilder;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
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
    void should_ReturnLocationsInAscendingOrder_When_ValidLocalRequest() {
        var buildMockLocalRequest = MockBuilder.buildMockLocalRequestByAscending();
        var buildMockLocal = MockBuilder.buildMockLocal();
        var buildMockLocations = List.of(buildMockLocal);
        when(entityManager.getCriteriaBuilder()).thenReturn(criteriaBuilder);
        when(criteriaBuilder.createQuery(Local.class)).thenReturn(criteriaQuery);
        when(criteriaQuery.from(Local.class)).thenReturn(root);
        when(typedQuery.getResultList()).thenReturn(buildMockLocations);
        when(entityManager.createQuery(criteriaQuery)).thenReturn(typedQuery);
        when(entityManager.createQuery(criteriaQuery).setFirstResult(0)).thenReturn(typedQuery);
        when(entityManager.createQuery(criteriaQuery).setMaxResults(25)).thenReturn(typedQuery);
        when(entityManager.createQuery(criteriaQuery).getResultList()).thenReturn(buildMockLocations);
        var buildMockLocationsResponse = localRepositoryGateway.getLocals(buildMockLocalRequest);
        assertEquals(1, buildMockLocationsResponse.size());
    }

    @Test
    void should_ReturnLocationsInDescendingOrder_When_ValidLocalRequest() {
        var buildMockLocalRequest = MockBuilder.buildMockLocalRequestByDescending();
        var buildMockLocal = MockBuilder.buildMockLocal();
        var buildMockLocations = List.of(buildMockLocal);
        when(entityManager.getCriteriaBuilder()).thenReturn(criteriaBuilder);
        when(criteriaBuilder.createQuery(Local.class)).thenReturn(criteriaQuery);
        when(criteriaQuery.from(Local.class)).thenReturn(root);
        when(typedQuery.getResultList()).thenReturn(buildMockLocations);
        when(entityManager.createQuery(criteriaQuery)).thenReturn(typedQuery);
        when(entityManager.createQuery(criteriaQuery).setFirstResult(0)).thenReturn(typedQuery);
        when(entityManager.createQuery(criteriaQuery).setMaxResults(25)).thenReturn(typedQuery);
        when(entityManager.createQuery(criteriaQuery).getResultList()).thenReturn(buildMockLocations);
        when(entityManager.createQuery(criteriaQuery).getResultList()).thenReturn(buildMockLocations);
        var buildMockLocationsResponse = localRepositoryGateway.getLocals(buildMockLocalRequest);
        assertEquals(1, buildMockLocationsResponse.size());
    }
}
