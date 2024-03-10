package br.com.api.servicehub.adapters.gateways;

import br.com.api.servicehub.core.entities.LocalRequest;
import br.com.api.servicehub.core.entities.LocalResponse;

import java.util.List;

public interface LocalGateway {

    List<LocalResponse> getLocations(LocalRequest request);
}
