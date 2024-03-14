package br.com.api.localhub.app;

import br.com.api.localhub.core.entities.LocalRequest;
import br.com.api.localhub.core.entities.LocalResponse;
import br.com.api.localhub.core.usecases.LocalUseCase;
import br.com.api.localhub.infra.gateways.LocalRepositoryGateway;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Log4j2
public class LocalService implements LocalUseCase {

    @Autowired
    private LocalRepositoryGateway localRepositoryGateway;

    @Override
    public List<LocalResponse> getLocals(LocalRequest request) {
        log.info("Sending the get locals to repository gateway.");
        return localRepositoryGateway.getLocals(request);
    }
}
