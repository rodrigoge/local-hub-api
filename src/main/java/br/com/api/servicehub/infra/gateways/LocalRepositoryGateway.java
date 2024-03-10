package br.com.api.servicehub.infra.gateways;

import br.com.api.servicehub.adapters.gateways.LocalGateway;
import br.com.api.servicehub.core.entities.LocalRequest;
import br.com.api.servicehub.core.entities.LocalResponse;
import br.com.api.servicehub.core.entities.OrderEnum;
import br.com.api.servicehub.infra.persistence.Local;
import jakarta.persistence.EntityManager;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class LocalRepositoryGateway implements LocalGateway {

    @Autowired
    private EntityManager entityManager;

    @Autowired
    private LocalMapper localMapper;

    @Override
    public List<LocalResponse> getLocations(LocalRequest request) {
        var criteriaBuilder = entityManager.getCriteriaBuilder();
        var criteriaQuery = criteriaBuilder.createQuery(Local.class);
        var root = criteriaQuery.from(Local.class);
        var predicates = buildPredicates(request, criteriaBuilder, root);
        criteriaQuery.where(predicates.toArray(new Predicate[0]));
        sortAndOrderLocations(request, criteriaQuery, criteriaBuilder, root);
        var locations = entityManager.createQuery(criteriaQuery).getResultList();
        return buildLocalResponseList(locations);
    }

    private List<Predicate> buildPredicates(LocalRequest request, CriteriaBuilder criteriaBuilder, Root<Local> root) {
        List<Predicate> predicates = new ArrayList<>();
        if (Objects.nonNull(request.type())) {
            predicates.add(criteriaBuilder.equal(root.get("name"), "%" + request.name().toLowerCase() + "%"));
        }
        if (Objects.nonNull(request.address())) {
            predicates.add(criteriaBuilder.equal(root.get("address"), "%" + request.address().toLowerCase() + "%"));
        }
        if (Objects.nonNull(request.type())) {
            predicates.add(criteriaBuilder.equal(root.get("type"), request.type()));
        }
        if (Objects.nonNull(request.state())) {
            predicates.add(criteriaBuilder.equal(root.get("state"), request.state()));
        }
        if (Objects.nonNull(request.city())) {
            predicates.add(criteriaBuilder.like(root.get("city"), "%" + request.city().toLowerCase() + "%"));
        }
        return predicates;
    }

    private void sortAndOrderLocations(LocalRequest request,
                                       CriteriaQuery<Local> criteriaQuery,
                                       CriteriaBuilder criteriaBuilder,
                                       Root<Local> root) {
        if (request.order().equals(OrderEnum.ASC))
            criteriaQuery.orderBy(criteriaBuilder.asc(root.get(request.column())));
        else criteriaQuery.orderBy(criteriaBuilder.desc(root.get(request.column())));
    }

    private List<LocalResponse> buildLocalResponseList(List<Local> locals) {
        return locals.stream().map(localMapper::toLocalResponse).toList();
    }
}
