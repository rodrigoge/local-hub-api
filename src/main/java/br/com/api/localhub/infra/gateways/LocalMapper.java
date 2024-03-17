package br.com.api.localhub.infra.gateways;

import br.com.api.localhub.infra.persistence.Local;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.openapitools.model.LocalResponse;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface LocalMapper {

    LocalResponse toLocalResponse(Local local);
}
