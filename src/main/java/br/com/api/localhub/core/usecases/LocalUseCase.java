package br.com.api.localhub.core.usecases;

import br.com.api.localhub.core.entities.LocalRequest;
import br.com.api.localhub.core.entities.LocalResponse;

import java.util.List;

public interface LocalUseCase {
    List<LocalResponse> getLocals(LocalRequest request);
}
