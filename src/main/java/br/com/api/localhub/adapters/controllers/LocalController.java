package br.com.api.localhub.adapters.controllers;

import br.com.api.localhub.app.LocalService;
import lombok.extern.log4j.Log4j2;
import org.openapitools.api.LocalsApi;
import org.openapitools.model.LocalRequest;
import org.openapitools.model.LocalResponse;
import org.openapitools.model.LocalTypeEnum;
import org.openapitools.model.OrderEnum;
import org.openapitools.model.StateEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Log4j2
public class LocalController implements LocalsApi {

    @Autowired
    private LocalService localService;

    @Override
    public ResponseEntity<List<LocalResponse>> getLocals(Integer page,
                                                         Integer limit,
                                                         String column,
                                                         OrderEnum order,
                                                         String name,
                                                         String address,
                                                         LocalTypeEnum type,
                                                         StateEnum state,
                                                         String city) {
        log.info("Starting the get locals flow.");
        var localRequest = new LocalRequest(name, address, type, state, city, page, limit, column, order);
        log.info("Sending local request for get locals.");
        var localResponse = localService.getLocals(localRequest);
        log.info("Finishing the get locals flow.");
        return ResponseEntity.status(HttpStatus.OK).body(localResponse);
    }
}
