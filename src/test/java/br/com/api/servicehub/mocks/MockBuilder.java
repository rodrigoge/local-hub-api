package br.com.api.servicehub.mocks;

import br.com.api.servicehub.core.entities.LocalRequest;
import br.com.api.servicehub.core.entities.LocalResponse;
import br.com.api.servicehub.core.entities.LocalTypeEnum;
import br.com.api.servicehub.core.entities.OrderEnum;
import br.com.api.servicehub.core.entities.StateEnum;
import br.com.api.servicehub.core.exceptions.FlowException;
import br.com.api.servicehub.infra.persistence.Local;
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
}
