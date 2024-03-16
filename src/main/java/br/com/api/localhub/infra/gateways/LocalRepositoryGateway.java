package br.com.api.localhub.infra.gateways;

import br.com.api.localhub.adapters.gateways.LocalGateway;
import br.com.api.localhub.core.entities.LocalRequest;
import br.com.api.localhub.core.entities.LocalResponse;
import br.com.api.localhub.core.entities.OrderEnum;
import br.com.api.localhub.infra.persistence.Local;
import jakarta.persistence.EntityManager;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Log4j2
public class LocalRepositoryGateway implements LocalGateway {

    @Autowired
    private EntityManager entityManager;

    @Autowired
    private LocalMapper localMapper;

    @Override
    public List<LocalResponse> getLocals(LocalRequest request) {
        log.info("Creating criteria builder, query and root.");
        var criteriaBuilder = entityManager.getCriteriaBuilder();
        var criteriaQuery = criteriaBuilder.createQuery(Local.class);
        var root = criteriaQuery.from(Local.class);
        log.info("Building predicates to get locals.");
        var predicates = buildPredicatesToGetLocals(request, criteriaBuilder, root);
        log.info("Adding clauses by predicates.");
        criteriaQuery.where(predicates.toArray(new Predicate[0]));
        log.info("Sorting and ordering query to get locals.");
        sortAndOrderToGetLocals(request, criteriaQuery, criteriaBuilder, root);
        log.info("Getting result list by query to get locals.");
        var requestLimit = request.limit();
        var requestOffset = request.page();
        var locals = entityManager
                .createQuery(criteriaQuery)
                .setMaxResults(requestLimit)
                .setFirstResult(requestOffset)
                .getResultList();
        log.info("Building locals response to list.");
        return buildLocalsResponse(locals);
    }

    private List<Predicate> buildPredicatesToGetLocals(LocalRequest request, CriteriaBuilder criteriaBuilder, Root<Local> root) {
        log.info("Initializing building predicates to get locals flow.");
        List<Predicate> predicates = new ArrayList<>();
        log.info("Validating if there is a name in the request.");
        if (Objects.nonNull(request.name())) {
            predicates.add(criteriaBuilder.like(criteriaBuilder.lower(root.get("name")), "%" + request.name().toLowerCase() + "%"));
        }
        log.info("Validating if there is an address in the request.");
        if (Objects.nonNull(request.address())) {
            predicates.add(criteriaBuilder.like(criteriaBuilder.lower(root.get("address")), "%" + request.address().toLowerCase() + "%"));
        }
        log.info("Validating if there is a type in the request.");
        if (Objects.nonNull(request.type())) {
            predicates.add(criteriaBuilder.like(criteriaBuilder.lower(root.get("type")), "%" + request.type().toString().toLowerCase() + "%"));
        }
        log.info("Validating if there is a state in the request.");
        if (Objects.nonNull(request.state())) {
            predicates.add(criteriaBuilder.like(criteriaBuilder.lower(root.get("state")), "%" + request.state().toString().toLowerCase() + "%"));
        }
        log.info("Validating if there is a city in the request.");
        if (Objects.nonNull(request.city())) {
            predicates.add(criteriaBuilder.like(criteriaBuilder.lower(root.get("city")), "%" + request.city().toLowerCase() + "%"));
        }
        log.info("Finishing building predicates to get locals flow.");
        return predicates;
    }

    private void sortAndOrderToGetLocals(LocalRequest request,
                                         CriteriaQuery<Local> criteriaQuery,
                                         CriteriaBuilder criteriaBuilder,
                                         Root<Local> root) {
        log.info("Initializing sorting and ordering to get locals flow.");
        if (request.order().equals(OrderEnum.ASC))
            criteriaQuery.orderBy(criteriaBuilder.asc(root.get(request.column())));
        else criteriaQuery.orderBy(criteriaBuilder.desc(root.get(request.column())));
    }

    private List<LocalResponse> buildLocalsResponse(List<Local> locals) {
        log.info("Building mapping locals to locals response flow.");
        return locals.stream().map(localMapper::toLocalResponse).toList();
    }
}
