package br.com.api.localhub.core.usecases;

import org.openapitools.model.LocalRequest;
import org.openapitools.model.LocalResponse;

import java.util.List;

public interface LocalUseCase {
    List<LocalResponse> getLocals(LocalRequest request);
}
