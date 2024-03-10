package br.com.api.servicehub.infra.gateways;

import br.com.api.servicehub.core.entities.LocalResponse;
import br.com.api.servicehub.infra.persistence.Local;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface LocalMapper {

    LocalResponse toLocalResponse(Local local);
}
