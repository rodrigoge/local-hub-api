package br.com.api.localhub.adapters.gateways;

import br.com.api.localhub.core.entities.LocalRequest;
import br.com.api.localhub.core.entities.LocalResponse;

import java.util.List;

public interface LocalGateway {

    List<LocalResponse> getLocals(LocalRequest request);
}
