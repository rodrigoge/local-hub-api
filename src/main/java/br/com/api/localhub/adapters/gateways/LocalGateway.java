package br.com.api.localhub.adapters.gateways;

import org.openapitools.model.LocalRequest;
import org.openapitools.model.LocalResponse;

import java.util.List;

public interface LocalGateway {

    List<LocalResponse> getLocals(LocalRequest request);
}
