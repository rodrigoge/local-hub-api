package br.com.api.servicehub.app;

import br.com.api.servicehub.core.entities.LocalRequest;
import br.com.api.servicehub.core.entities.LocalResponse;
import br.com.api.servicehub.core.usecases.LocalUseCase;
import br.com.api.servicehub.infra.gateways.LocalRepositoryGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LocalService implements LocalUseCase {

    @Autowired
    private LocalRepositoryGateway localRepositoryGateway;

    @Override
    public List<LocalResponse> getLocations(LocalRequest request) {
        return localRepositoryGateway.getLocations(request);
    }
}
