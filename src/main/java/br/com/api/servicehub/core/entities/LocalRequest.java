package br.com.api.servicehub.core.entities;

public record LocalRequest(
        LocalTypeEnum type,
        StateEnum state,
        String city,
        int page,
        int limit,
        String column,
        OrderEnum order
) {
}
