package br.com.api.servicehub.core.usecases;

import br.com.api.servicehub.core.entities.LocalRequest;
import br.com.api.servicehub.core.entities.LocalResponse;

import java.util.List;

public interface LocalUseCase {
    List<LocalResponse> getLocations(LocalRequest request);
}
