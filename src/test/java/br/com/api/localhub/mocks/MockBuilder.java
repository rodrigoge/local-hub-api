package br.com.api.localhub.mocks;

import br.com.api.localhub.core.exceptions.FlowException;
import br.com.api.localhub.infra.gateways.LocalRepositoryGateway;
import br.com.api.localhub.infra.persistence.Local;
import org.openapitools.model.LocalRequest;
import org.openapitools.model.LocalResponse;
import org.openapitools.model.LocalTypeEnum;
import org.openapitools.model.OrderEnum;
import org.openapitools.model.StateEnum;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public class MockBuilder {

    public static LocalResponse buildMockLocalResponse() {
        return new LocalResponse(
                "Company Name S.A",
                "123 Main Street, Cityville",
                LocalTypeEnum.FOOD,
                StateEnum.MINAS_GERAIS,
                "Belo Horizonte"
        );
    }

    public static LocalResponse buildMockEmptyLocalResponse() {
        return new LocalResponse(null, null, null, null, null);
    }

    public static List<LocalResponse> buildMockLocalResponses() {
        return List.of(new LocalResponse(
                "Company Name S.A",
                "123 Main Street, Cityville",
                LocalTypeEnum.FOOD,
                StateEnum.MINAS_GERAIS,
                "Belo Horizonte"
        ));
    }

    public static LocalRequest buildMockLocalRequestByAscending() {
        return new LocalRequest(
                "Company Name S.A",
                "123 Main Street, Cityville",
                LocalTypeEnum.FOOD,
                StateEnum.MINAS_GERAIS,
                "Belo Horizonte",
                0,
                25,
                "id",
                OrderEnum.ASC
        );
    }

    public static LocalRequest buildMockLocalRequestByDescending() {
        return new LocalRequest(
                "Company Name S.A",
                "123 Main Street, Cityville",
                LocalTypeEnum.FOOD,
                StateEnum.MINAS_GERAIS,
                "Belo Horizonte",
                0,
                25,
                "id",
                OrderEnum.DESC
        );
    }

    public static LocalRequest buildMockEmptyLocalRequest() {
        return new LocalRequest(
                null,
                null,
                null,
                null,
                null,
                0,
                25,
                null,
                null
        );
    }

    public static Local buildMockLocal() {
        var mockLocalUUID = UUID.fromString("bcc4f117-94f3-4c75-a24d-18ce117ab5e7");
        return new Local(
                mockLocalUUID,
                "Company Name S.A",
                "123 Main Street, Cityville",
                LocalTypeEnum.FOOD,
                StateEnum.MINAS_GERAIS,
                "Belo Horizonte"
        );
    }

    public static Local buildMockEmptyLocal() {
        return new Local();
    }

    public static Local buildMockLocalWithoutConstructor() {
        var mockLocalUUID = UUID.fromString("bcc4f117-94f3-4c75-a24d-18ce117ab5e7");
        var mockLocal = new Local();
        mockLocal.setId(mockLocalUUID);
        mockLocal.setName("Company Name S.A");
        mockLocal.setAddress("123 Main Street, Cityville");
        mockLocal.setType(LocalTypeEnum.FOOD);
        mockLocal.setState(StateEnum.MINAS_GERAIS);
        mockLocal.setCity("Belo Horizonte");
        return mockLocal;
    }

    public static LocalDateTime buildMockLocalDateTime() {
        return LocalDateTime.of(2024, 1, 1, 1, 1);
    }

    public static FlowException buildMockFlowException() {
        var mockLocalDateTime = buildMockLocalDateTime();
        return new FlowException(
                HttpStatus.BAD_REQUEST,
                mockLocalDateTime,
                "Error message encountered while executing this method test."
        );
    }

    public static LocalRepositoryGateway buildMockLocalRepositoryGateway() {
        return new LocalRepositoryGateway();
    }
}
