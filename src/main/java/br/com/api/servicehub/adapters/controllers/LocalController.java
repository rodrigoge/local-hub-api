package br.com.api.servicehub.adapters.controllers;

import br.com.api.servicehub.app.LocalService;
import br.com.api.servicehub.core.entities.LocalRequest;
import br.com.api.servicehub.core.entities.LocalResponse;
import br.com.api.servicehub.core.entities.LocalTypeEnum;
import br.com.api.servicehub.core.entities.OrderEnum;
import br.com.api.servicehub.core.entities.StateEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/services")
public class LocalController {

    @Autowired
    private LocalService localService;

    @GetMapping
    public ResponseEntity<List<LocalResponse>> getLocations(@RequestParam(required = false) String name,
                                                            @RequestParam(required = false) String address,
                                                            @RequestParam(required = false) LocalTypeEnum type,
                                                            @RequestParam(required = false) StateEnum status,
                                                            @RequestParam(required = false) String city,
                                                            @RequestParam(defaultValue = "0") int page,
                                                            @RequestParam(defaultValue = "25") int limit,
                                                            @RequestParam(defaultValue = "id") String column,
                                                            @RequestParam(defaultValue = "DESC") OrderEnum order) {
        var request = new LocalRequest(name, address, type, status, city, page, limit, column, order);
        var response = localService.getLocations(request);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
}
