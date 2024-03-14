package br.com.api.localhub.core.entities;

public record LocalRequest(
        String name,
        String address,
        LocalTypeEnum type,
        StateEnum state,
        String city,
        int page,
        int limit,
        String column,
        OrderEnum order
) {
}
