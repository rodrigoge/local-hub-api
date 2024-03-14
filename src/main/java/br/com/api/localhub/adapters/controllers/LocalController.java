package br.com.api.localhub.adapters.controllers;

import br.com.api.localhub.app.LocalService;
import br.com.api.localhub.core.entities.LocalRequest;
import br.com.api.localhub.core.entities.LocalResponse;
import br.com.api.localhub.core.entities.LocalTypeEnum;
import br.com.api.localhub.core.entities.OrderEnum;
import br.com.api.localhub.core.entities.StateEnum;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/locals")
@Log4j2
public class LocalController {

    @Autowired
    private LocalService localService;

    @GetMapping
    public ResponseEntity<List<LocalResponse>> getLocals(@RequestParam(required = false) String name,
                                                         @RequestParam(required = false) String address,
                                                         @RequestParam(required = false) LocalTypeEnum type,
                                                         @RequestParam(required = false) StateEnum status,
                                                         @RequestParam(required = false) String city,
                                                         @RequestParam(defaultValue = "0") int page,
                                                         @RequestParam(defaultValue = "25") int limit,
                                                         @RequestParam(defaultValue = "id") String column,
                                                         @RequestParam(defaultValue = "DESC") OrderEnum order) {
        log.info("Starting the get locals flow.");
        var localRequest = new LocalRequest(name, address, type, status, city, page, limit, column, order);
        log.info("Sending local request for get locals.");
        var localResponse = localService.getLocals(localRequest);
        log.info("Finishing the get locals flow.");
        return ResponseEntity.status(HttpStatus.OK).body(localResponse);
    }
}
